package za.co.jewellerysystem.service;


import za.co.jewellerysystem.domain.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    Customer save(Customer customer);
    Optional<Customer> findById(UUID id);
    void deleteById(UUID id);
}

