package za.co.jewellerysystem.service;

import za.co.jewellerysystem.domain.OrderItem;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderItemService {
    OrderItem save(OrderItem orderItem);                  // create or update
    Optional<OrderItem> findById(UUID id);                // read
    List<OrderItem> findAll();                            // list all
    void deleteById(UUID id);                             // delete
}
