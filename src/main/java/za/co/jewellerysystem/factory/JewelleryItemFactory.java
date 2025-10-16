package za.co.jewellerysystem.factory;


import za.co.jewellerysystem.domain.Category;
import za.co.jewellerysystem.domain.JewelleryItem;

import java.util.UUID;

public class JewelleryItemFactory {

    public static JewelleryItem create(Category category) {
        return JewelleryItem.builder()
                .id(UUID.randomUUID())
                .name("Item " + UUID.randomUUID().toString().substring(0, 5))
                .description("Description for item")
                .price(100.0)
                .category(category)
                .build();
    }

    public static JewelleryItem create(String name, String description, double price, Category category) {
        return JewelleryItem.builder()
                .id(UUID.randomUUID())
                .name(name)
                .description(description)
                .price(price)
                .category(category)
                .build();
    }
}
