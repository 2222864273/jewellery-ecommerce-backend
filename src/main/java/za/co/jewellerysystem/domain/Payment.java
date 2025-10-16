package za.co.jewellerysystem.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Payment {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    private Order order;

    private Double amount;

    private String method;

    private LocalDateTime paidAt;

    public Payment() {}

    public Payment(UUID id, Order order, Double amount, String method, LocalDateTime paidAt) {
        this.id = id;
        this.order = order;
        this.amount = amount;
        this.method = method;
        this.paidAt = paidAt;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
    
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    
    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }
    
    public LocalDateTime getPaidAt() { return paidAt; }
    public void setPaidAt(LocalDateTime paidAt) { this.paidAt = paidAt; }

    public static PaymentBuilder builder() { return new PaymentBuilder(); }

    public static class PaymentBuilder {
        private UUID id;
        private Order order;
        private Double amount;
        private String method;
        private LocalDateTime paidAt;

        public PaymentBuilder id(UUID id) { this.id = id; return this; }
        public PaymentBuilder order(Order order) { this.order = order; return this; }
        public PaymentBuilder amount(Double amount) { this.amount = amount; return this; }
        public PaymentBuilder method(String method) { this.method = method; return this; }
        public PaymentBuilder paidAt(LocalDateTime paidAt) { this.paidAt = paidAt; return this; }
        
        public Payment build() {
            return new Payment(id, order, amount, method, paidAt);
        }
    }
}
