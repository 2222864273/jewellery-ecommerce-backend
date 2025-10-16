package za.co.jewellerysystem.factory;

import org.junit.jupiter.api.Test;
import za.co.jewellerysystem.domain.Category;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CategoryFactoryTest {

    @Test
    void createDefaultCategory() {
        Category category = CategoryFactory.create();
        assertNotNull(category);
        assertNotNull(category.getId());
        assertTrue(category.getId() instanceof UUID);
        assertNotNull(category.getName());
    }

    @Test
    void createCategoryWithName() {
        Category category = CategoryFactory.create("Necklaces");
        assertNotNull(category);
        assertEquals("Necklaces", category.getName());
    }
}


