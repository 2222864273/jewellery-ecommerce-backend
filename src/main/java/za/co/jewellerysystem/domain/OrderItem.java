package za.co.jewellerysystem.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.UUID;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JsonBackReference
    private Order order;

    @ManyToOne
    private JewelleryItem item;

    private int quantity;

    public OrderItem() {}

    public OrderItem(UUID id, Order order, JewelleryItem item, int quantity) {
        this.id = id;
        this.order = order;
        this.item = item;
        this.quantity = quantity;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
    
    public JewelleryItem getItem() { return item; }
    public void setItem(JewelleryItem item) { this.item = item; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public static OrderItemBuilder builder() { return new OrderItemBuilder(); }

    public static class OrderItemBuilder {
        private UUID id;
        private Order order;
        private JewelleryItem item;
        private int quantity;

        public OrderItemBuilder id(UUID id) { this.id = id; return this; }
        public OrderItemBuilder order(Order order) { this.order = order; return this; }
        public OrderItemBuilder item(JewelleryItem item) { this.item = item; return this; }
        public OrderItemBuilder quantity(int quantity) { this.quantity = quantity; return this; }
        
        public OrderItem build() {
            return new OrderItem(id, order, item, quantity);
        }
    }
}
