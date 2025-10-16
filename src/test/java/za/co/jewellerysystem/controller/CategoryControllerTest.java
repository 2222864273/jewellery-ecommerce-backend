package za.co.jewellerysystem.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.co.jewellerysystem.domain.Category;
import za.co.jewellerysystem.repository.CategoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Category testCategory;

    @BeforeEach
    void setUp() {
        categoryRepository.deleteAll();
        testCategory = new Category();
        testCategory.setName("Rings");
        testCategory = categoryRepository.save(testCategory); // save to DB
    }

    @Test
    void testGetAllCategories() throws Exception {
        mockMvc.perform(get("/api/categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Rings"));
    }

    @Test
    void testGetCategoryById() throws Exception {
        mockMvc.perform(get("/api/categories/" + testCategory.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Rings"));
    }

    @Test
    void testCreateCategory() throws Exception {
        Category newCategory = new Category();
        newCategory.setName("Bracelets");

        mockMvc.perform(post("/api/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newCategory)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Bracelets"));
    }

    @Test
    void testUpdateCategory() throws Exception {
        testCategory.setName("Updated Rings");

        mockMvc.perform(put("/api/categories/" + testCategory.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testCategory)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Rings"));
    }

    @Test
    void testDeleteCategory_Success() throws Exception {
        // delete the saved category
        mockMvc.perform(delete("/api/categories/{id}", testCategory.getId()))
                .andExpect(status().isNoContent()); // expect 204
    }

    @Test
    void testDeleteCategory_NotFound() throws Exception {
        UUID nonExistentId = UUID.randomUUID();

        mockMvc.perform(delete("/api/categories/{id}", nonExistentId))
                .andExpect(status().isNotFound()); // expect 404
    }
}
