package za.co.jewellerysystem.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
public class JewelleryItem {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String name;
    private String description;
    private Double price;

    @ManyToOne
    private Category category;

    public JewelleryItem() {}

    public JewelleryItem(UUID id, String name, String description, Double price, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public static JewelleryItemBuilder builder() { return new JewelleryItemBuilder(); }

    public static class JewelleryItemBuilder {
        private UUID id;
        private String name;
        private String description;
        private Double price;
        private Category category;

        public JewelleryItemBuilder id(UUID id) { this.id = id; return this; }
        public JewelleryItemBuilder name(String name) { this.name = name; return this; }
        public JewelleryItemBuilder description(String description) { this.description = description; return this; }
        public JewelleryItemBuilder price(Double price) { this.price = price; return this; }
        public JewelleryItemBuilder category(Category category) { this.category = category; return this; }
        
        public JewelleryItem build() {
            return new JewelleryItem(id, name, description, price, category);
        }
    }
}
