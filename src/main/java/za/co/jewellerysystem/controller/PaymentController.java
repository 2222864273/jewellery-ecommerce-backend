package za.co.jewellerysystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.jewellerysystem.domain.Order;
import za.co.jewellerysystem.domain.Payment;
import za.co.jewellerysystem.repository.OrderRepository;
import za.co.jewellerysystem.repository.PaymentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentRepository paymentRepo;
    private final OrderRepository orderRepo;

    public PaymentController(PaymentRepository paymentRepo, OrderRepository orderRepo) {
        this.paymentRepo = paymentRepo;
        this.orderRepo = orderRepo;
    }

    @PostMapping
    public ResponseEntity<Payment> create(@RequestBody Payment payment) {
        if (payment.getOrder() != null && payment.getOrder().getId() != null) {
            Optional<Order> order = orderRepo.findById(payment.getOrder().getId());
            payment.setOrder(order.orElse(null));
        }
        payment.setPaidAt(LocalDateTime.now());
        Payment saved = paymentRepo.save(payment);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/orders/{orderId}/payments")
    public List<Payment> listByOrder(@PathVariable UUID orderId) {
        return paymentRepo.findByOrderId(orderId);
    }
}

