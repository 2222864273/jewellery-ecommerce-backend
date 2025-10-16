package za.co.jewellerysystem.service;


import za.co.jewellerysystem.domain.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
    List<Category> findAll();
    Optional<Category> findById(UUID id);
    Category save(Category category);
    void deleteById(UUID id);
}

