package za.co.jewellerysystem.factory;

import za.co.jewellerysystem.domain.Customer;

import java.util.UUID;

public class CustomerFactory {

    public static Customer create() {
        return Customer.builder()
                .id(UUID.randomUUID())
                .name("Customer " + UUID.randomUUID().toString().substring(0, 5))
                .email("customer@example.com")
                .phone("1234567890")
                .build();
    }

    public static Customer create(String name, String email, String phone) {
        return Customer.builder()
                .id(UUID.randomUUID())
                .name(name)
                .email(email)
                .phone(phone)
                .build();
    }
}

