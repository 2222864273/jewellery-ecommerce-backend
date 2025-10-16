package za.co.jewellerysystem.factory;


import za.co.jewellerysystem.domain.JewelleryItem;
import za.co.jewellerysystem.domain.Order;
import za.co.jewellerysystem.domain.OrderItem;

import java.util.UUID;

public class OrderItemFactory {

    public static OrderItem create(Order order, JewelleryItem item, int quantity) {
        return OrderItem.builder()
                .id(UUID.randomUUID())
                .order(order)
                .item(item)
                .quantity(quantity)
                .build();
    }
}
