package za.co.jewellerysystem.factory;

import org.junit.jupiter.api.Test;
import za.co.jewellerysystem.domain.Order;
import za.co.jewellerysystem.domain.Payment;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    @Test
    void createPayment() {
        Order order = OrderFactory.create(null);
        Payment payment = PaymentFactory.create(order, 150.0, "CREDIT_CARD");

        assertNotNull(payment);
        assertNotNull(payment.getId());
        assertEquals(order, payment.getOrder());
        assertEquals(150.0, payment.getAmount());
        assertEquals("CREDIT_CARD", payment.getMethod());
        assertNotNull(payment.getPaidAt());
    }
}
