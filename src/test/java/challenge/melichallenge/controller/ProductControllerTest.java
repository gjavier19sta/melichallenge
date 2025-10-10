package challenge.melichallenge.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

import challenge.melichallenge.dto.ProductDTO;
import challenge.melichallenge.service.ProductService;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    private ProductDTO productDTO;

    private Optional<ProductDTO> product;
    private final Optional<ProductDTO> emptyProduct = Optional.empty();

    @BeforeEach
    void setup() {
        productDTO = new ProductDTO("MLA12345", "Auriculares Bluetooth Sony WH-CH520", "Auriculares inalámbricos con cancelación de ruido y hasta 50 horas de batería.", 24999.99, "ARS", "https://example.com/img/sony-whch520.jpg");
        product = Optional.of(productDTO) ;

    }

    @Test
    @DisplayName("Debe devolver el producto correcto por ID (status 200)")
    void shouldReturnProductById() throws Exception {
        when(productService.getProductById("MLA12345")).thenReturn(product);

        mockMvc.perform(get("/api/products/MLA12345"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value("MLA12345"))
                .andExpect(jsonPath("$.title").value("Auriculares Bluetooth Sony WH-CH520"));
    }

    @Test
    @DisplayName("Debe devolver 404 si el producto no existe")
    void shouldReturn404WhenProductNotFound() throws Exception {
        when(productService.getProductById("INVALID")).thenReturn(emptyProduct);

        mockMvc.perform(get("/api/products/INVALID"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.error").value("Product not found"));
    }    
}