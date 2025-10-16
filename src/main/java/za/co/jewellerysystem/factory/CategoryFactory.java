package za.co.jewellerysystem.factory;


import za.co.jewellerysystem.domain.Category;

import java.util.UUID;

public class CategoryFactory {

    public static Category create() {
        return Category.builder()
                .id(UUID.randomUUID())
                .name("Category " + UUID.randomUUID().toString().substring(0, 5))
                .build();
    }

    public static Category create(String name) {
        return Category.builder()
                .id(UUID.randomUUID())
                .name(name)
                .build();
    }
}


