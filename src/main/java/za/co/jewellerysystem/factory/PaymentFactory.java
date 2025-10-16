package za.co.jewellerysystem.factory;


import za.co.jewellerysystem.domain.Order;
import za.co.jewellerysystem.domain.Payment;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentFactory {

    public static Payment create(Order order, double amount, String method) {
        return Payment.builder()
                .id(UUID.randomUUID())
                .order(order)
                .amount(amount)
                .method(method)
                .paidAt(LocalDateTime.now())
                .build();
    }
}
