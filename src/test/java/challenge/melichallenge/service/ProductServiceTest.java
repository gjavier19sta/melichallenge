package challenge.melichallenge.service;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import challenge.melichallenge.datasource.ProductDataSource;
import challenge.melichallenge.dto.ProductDTO;
import challenge.melichallenge.model.Product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductDataSource productDataSource; // simulamos la fuente de datos

    @InjectMocks
    private ProductService productService;

    private Product mockProduct;

    @BeforeEach
    void setup() {
        mockProduct = new Product(
            "MLA12345", 
            "Auriculares Bluetooth Sony WH-CH520", 
            "Auriculares inalámbricos con cancelación de ruido y hasta 50 horas de batería.", 
            24999.99, 
            "ARS", 
            "",
            0,
            "",
            "",
            "https://example.com/img/sony-whch520.jpg");
    }

    @Test
    @DisplayName("Debe devolver un ProductDTO cuando el producto existe")
    void shouldReturnProductDTOWhenProductExists() {
        // given
        when(productDataSource.findById("MLA12345")).thenReturn(Optional.of(mockProduct));

        // when
        Optional<ProductDTO> result = productService.getProductById("MLA12345");

        // then
        assertTrue(result.isPresent());
        ProductDTO dto = result.get();
        assertEquals("MLA12345", dto.id());
        assertEquals("Auriculares Bluetooth Sony WH-CH520", dto.title());
        verify(productDataSource, times(1)).findById("MLA12345");
    }

    @Test
    @DisplayName("Debe devolver Optional vacío cuando el producto no existe")
    void shouldReturnEmptyWhenProductDoesNotExist() {
        when(productDataSource.findById("INVALID")).thenReturn(Optional.empty());

        Optional<ProductDTO> result = productService.getProductById("INVALID");

        assertTrue(result.isEmpty());
    }
}