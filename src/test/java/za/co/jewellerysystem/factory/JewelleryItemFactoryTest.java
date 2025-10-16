package za.co.jewellerysystem.factory;

import org.junit.jupiter.api.Test;
import za.co.jewellerysystem.domain.Category;
import za.co.jewellerysystem.domain.JewelleryItem;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class JewelleryItemFactoryTest {

    @Test
    void createWithCategory() {
        Category category = CategoryFactory.create("Bracelets");
        JewelleryItem item = JewelleryItemFactory.create(category);
        assertNotNull(item);
        assertNotNull(item.getId());
        assertEquals(category, item.getCategory());
        assertNotNull(item.getName());
        assertNotNull(item.getDescription());
        assertTrue(item.getPrice() > 0);
    }

    @Test
    void createWithParams() {
        Category category = CategoryFactory.create("Earrings");
        JewelleryItem item = JewelleryItemFactory.create("Gold Earrings", "Shiny gold earrings", 250.0, category);
        assertEquals("Gold Earrings", item.getName());
        assertEquals("Shiny gold earrings", item.getDescription());
        assertEquals(250.0, item.getPrice());
        assertEquals(category, item.getCategory());
    }
}
