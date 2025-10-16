package za.co.jewellerysystem.factory;

import org.junit.jupiter.api.Test;
import za.co.jewellerysystem.domain.Customer;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    @Test
    void createDefaultCustomer() {
        Customer customer = CustomerFactory.create();
        assertNotNull(customer);
        assertNotNull(customer.getId());
        assertNotNull(customer.getName());
        assertNotNull(customer.getEmail());
        assertNotNull(customer.getPhone());
    }

    @Test
    void createWithParams() {
        Customer customer = CustomerFactory.create("Bob", "bob@example.com", "123456789");
        assertEquals("Bob", customer.getName());
        assertEquals("bob@example.com", customer.getEmail());
        assertEquals("123456789", customer.getPhone());
    }
}
