package za.co.jewellerysystem.service.Impl;

import org.springframework.stereotype.Service;
import za.co.jewellerysystem.domain.OrderItem;
import za.co.jewellerysystem.repository.OrderItemRepository;
import za.co.jewellerysystem.service.OrderItemService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository repository;

    public OrderItemServiceImpl(OrderItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        return repository.save(orderItem);
    }

    @Override
    public Optional<OrderItem> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<OrderItem> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
