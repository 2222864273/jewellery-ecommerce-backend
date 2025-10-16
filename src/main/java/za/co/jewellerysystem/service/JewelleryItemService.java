package za.co.jewellerysystem.service;


import za.co.jewellerysystem.domain.JewelleryItem;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JewelleryItemService {
    List<JewelleryItem> findAll();
    Optional<JewelleryItem> findById(UUID id);
    JewelleryItem save(JewelleryItem item);
    void deleteById(UUID id);
}
