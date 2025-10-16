package za.co.jewellerysystem.service.Impl;


import org.springframework.stereotype.Service;
import za.co.jewellerysystem.domain.Payment;
import za.co.jewellerysystem.repository.PaymentRepository;
import za.co.jewellerysystem.service.PaymentService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repo;

    public PaymentServiceImpl(PaymentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Payment save(Payment payment) {
        return repo.save(payment);
    }

    @Override
    public Optional<Payment> findById(UUID id) {
        return repo.findById(id);
    }

    @Override
    public List<Payment> findByOrderId(UUID orderId) {
        return repo.findByOrderId(orderId);
    }

    @Override
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }
}
