package za.co.jewellerysystem.service.Impl;

import org.springframework.stereotype.Service;
import za.co.jewellerysystem.domain.Customer;
import za.co.jewellerysystem.repository.CustomerRepository;
import za.co.jewellerysystem.service.CustomerService;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repo;

    public CustomerServiceImpl(CustomerRepository repo) {
        this.repo = repo;
    }

    @Override
    public Customer save(Customer customer) {
        return repo.save(customer);
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return repo.findById(id);
    }

    @Override
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }
}
