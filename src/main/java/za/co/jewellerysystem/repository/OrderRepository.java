package za.co.jewellerysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.jewellerysystem.domain.Customer;
import za.co.jewellerysystem.domain.Order;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    List<Order> findByCustomer(Customer customer);
    List<Order> findByStatus(String status);
    Optional<Order> findById(UUID id);
}
