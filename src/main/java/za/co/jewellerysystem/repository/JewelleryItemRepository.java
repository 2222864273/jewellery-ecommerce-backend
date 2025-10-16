package za.co.jewellerysystem.repository;

import aj.org.objectweb.asm.commons.Remapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.jewellerysystem.domain.JewelleryItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
@Repository
public interface JewelleryItemRepository extends JpaRepository<JewelleryItem, UUID> {
    JewelleryItem findByName(String name);
    List<JewelleryItem> findByPriceLessThan(Double price);

}


