package za.co.jewellerysystem.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import za.co.jewellerysystem.domain.Category;
import za.co.jewellerysystem.domain.JewelleryItem;
import za.co.jewellerysystem.repository.CategoryRepository;
import za.co.jewellerysystem.repository.JewelleryItemRepository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/jewellery-items")
public class JewelleryItemController {

    private final JewelleryItemRepository itemRepo;
    private final CategoryRepository categoryRepo;

    public JewelleryItemController(JewelleryItemRepository itemRepo, CategoryRepository categoryRepo) {
        this.itemRepo = itemRepo;
        this.categoryRepo = categoryRepo;
    }

    @GetMapping
    public List<JewelleryItem> list(@RequestParam Map<String, String> params) {
        System.out.println("Getting jewellery items...");
        List<JewelleryItem> items = itemRepo.findAll();
        System.out.println("Found " + items.size() + " items");
        
        // Create dummy data if empty
        if (items.isEmpty()) {
            System.out.println("No items found, creating dummy data...");
            createDummyData();
            items = itemRepo.findAll();
            System.out.println("After creating dummy data: " + items.size() + " items");
        }
        
        return items;
    }
    
    @Transactional
    private void createDummyData() {
        try {
            System.out.println("Creating dummy data...");
            
            // Create categories
            Category rings = new Category();
            rings.setName("Rings");
            
            Category necklaces = new Category();
            necklaces.setName("Necklaces");
            
            Category earrings = new Category();
            earrings.setName("Earrings");
            
            rings = categoryRepo.save(rings);
            necklaces = categoryRepo.save(necklaces);
            earrings = categoryRepo.save(earrings);
            
            System.out.println("Categories created");
            
            // Create jewellery items
            JewelleryItem item1 = new JewelleryItem();
            item1.setName("Diamond Engagement Ring");
            item1.setDescription("Beautiful 1 carat diamond ring");
            item1.setPrice(2500.00);
            item1.setCategory(rings);
            
            JewelleryItem item2 = new JewelleryItem();
            item2.setName("Gold Chain Necklace");
            item2.setDescription("18k gold chain necklace");
            item2.setPrice(850.00);
            item2.setCategory(necklaces);
            
            JewelleryItem item3 = new JewelleryItem();
            item3.setName("Pearl Earrings");
            item3.setDescription("Elegant pearl drop earrings");
            item3.setPrice(320.00);
            item3.setCategory(earrings);
            
            JewelleryItem item4 = new JewelleryItem();
            item4.setName("Silver Wedding Band");
            item4.setDescription("Classic silver wedding band");
            item4.setPrice(180.00);
            item4.setCategory(rings);
            
            itemRepo.save(item1);
            itemRepo.save(item2);
            itemRepo.save(item3);
            itemRepo.save(item4);
            
            System.out.println("Dummy data created successfully!");
        } catch (Exception e) {
            System.err.println("Error creating dummy data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<JewelleryItem> get(@PathVariable UUID id) {
        return itemRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public JewelleryItem create(@RequestBody JewelleryItem dto) {
        if (dto.getCategory() != null && dto.getCategory().getId() != null) {
            Category cat = categoryRepo.findById(dto.getCategory().getId()).orElse(null);
            dto.setCategory(cat);
        }
        return itemRepo.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JewelleryItem> update(@PathVariable UUID id, @RequestBody JewelleryItem dto) {
        return itemRepo.findById(id).map(item -> {
            item.setName(dto.getName());
            item.setDescription(dto.getDescription());
            item.setPrice(dto.getPrice());
            if (dto.getCategory() != null && dto.getCategory().getId() != null) {
                Category cat = categoryRepo.findById(dto.getCategory().getId()).orElse(null);
                item.setCategory(cat);
            } else {
                item.setCategory(null);
            }
            itemRepo.save(item);
            return ResponseEntity.ok(item);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable UUID id) {
        if (!itemRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        itemRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
