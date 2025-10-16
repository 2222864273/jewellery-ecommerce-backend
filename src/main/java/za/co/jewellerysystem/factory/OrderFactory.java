package za.co.jewellerysystem.factory;


import za.co.jewellerysystem.domain.Customer;
import za.co.jewellerysystem.domain.Order;
import za.co.jewellerysystem.domain.OrderItem;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class OrderFactory {

    public static Order create(Customer customer, List<OrderItem> items) {
        return Order.builder()
                .id(UUID.randomUUID())
                .customer(customer)
                .status("PENDING")
                .createdAt(LocalDateTime.now())
                .items(items)
                .build();
    }

    public static Order create(Customer customer) {
        return Order.builder()
                .id(UUID.randomUUID())
                .customer(customer)
                .status("PENDING")
                .createdAt(LocalDateTime.now())
                .build();
    }
}
