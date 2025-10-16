package za.co.jewellerysystem.service;


import za.co.jewellerysystem.domain.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    List<Order> findAll();
    Optional<Order> findById(UUID id);
    Order save(Order order);
    void deleteById(UUID id);
}
