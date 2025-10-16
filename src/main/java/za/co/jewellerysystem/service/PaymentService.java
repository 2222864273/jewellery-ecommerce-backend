package za.co.jewellerysystem.service;


import za.co.jewellerysystem.domain.Payment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentService {
    Payment save(Payment payment);
    Optional<Payment> findById(UUID id);
    List<Payment> findByOrderId(UUID orderId);
    void deleteById(UUID id);
}
