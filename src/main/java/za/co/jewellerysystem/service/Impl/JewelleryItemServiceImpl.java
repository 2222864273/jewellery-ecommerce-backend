package za.co.jewellerysystem.service.Impl;

import org.springframework.stereotype.Service;
import za.co.jewellerysystem.domain.JewelleryItem;
import za.co.jewellerysystem.repository.JewelleryItemRepository;
import za.co.jewellerysystem.service.JewelleryItemService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JewelleryItemServiceImpl implements JewelleryItemService {

    private final JewelleryItemRepository repo;

    public JewelleryItemServiceImpl(JewelleryItemRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<JewelleryItem> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<JewelleryItem> findById(UUID id) {
        return repo.findById(id);
    }

    @Override
    public JewelleryItem save(JewelleryItem item) {
        return repo.save(item);
    }

    @Override
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }
}
