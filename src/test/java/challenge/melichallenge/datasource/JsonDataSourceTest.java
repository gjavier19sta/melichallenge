package challenge.melichallenge.datasource;


import org.junit.jupiter.api.Test;

import challenge.melichallenge.dto.ProductDTO;
import challenge.melichallenge.model.Product;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class JsonDataSourceTest {

    


    @Test
    void shouldReadProductsFromJsonFile() {
        JsonProductDataSource dataSource = new JsonProductDataSource();
        Optional<Product> products = dataSource.findById("MLA12345");

        assertNotNull(products);

        ProductDTO first = new ProductDTO(products.get().getId(),products.get().getTitle(),products.get().getDescription(),products.get().getPrice(),products.get().getCurrency(),products.get().getImageUrl());
        assertEquals("MLA12345", first.id());
        assertEquals("Auriculares Bluetooth Sony WH-CH520", first.title());
        assertEquals("Auriculares inalámbricos con cancelación de ruido y hasta 50 horas de batería.", first.description());
        assertEquals(24999.99, first.price());
        assertEquals("ARS", first.currency());
        assertEquals("https://example.com/img/sony-whch520.jpg", first.imageUrl());
    }
}
