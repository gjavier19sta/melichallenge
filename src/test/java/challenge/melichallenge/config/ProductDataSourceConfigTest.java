package challenge.melichallenge.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import challenge.melichallenge.datasource.ProductDataSource;
import challenge.melichallenge.exception.EnumIllegalArgumentException;

class ProductDataSourceConfigTest {

    private final ProductDataSourceConfig config = new ProductDataSourceConfig();

    @Test
    @DisplayName("Debe crear un JsonProductDataSource cuando el tipo es JSON")
    void shouldCreateJsonDataSource() {
        ProductDataSource ds = config.getDataSource("JSON");
        assertNotNull(ds);
        assertEquals("JsonProductDataSource", ds.getClass().getSimpleName());
    }

    @Test
    @DisplayName("Debe lanzar UnsupportedOperationException para tipo CSV")
    void shouldThrowUnsupportedForCSV() {
        UnsupportedOperationException ex = assertThrows(
                UnsupportedOperationException.class,
                () -> config.getDataSource("CSV")
        );
        assertEquals("Archivo CSV no implementado aún", ex.getMessage());
    }

    @Test
    @DisplayName("Debe lanzar UnsupportedOperationException para tipo DATABASE")
    void shouldThrowUnsupportedForDatabase() {
        UnsupportedOperationException ex = assertThrows(
                UnsupportedOperationException.class,
                () -> config.getDataSource("DATABASE")
        );
        assertEquals("Base de datos no implementada aún", ex.getMessage());
    }

    @Test
    @DisplayName("Debe lanzar EnumIllegalArgumentException si el tipo es inválido")
    void shouldThrowEnumIllegalArgumentExceptionForInvalidType() {
        EnumIllegalArgumentException ex = assertThrows(
                EnumIllegalArgumentException.class,
                () -> config.getDataSource("INVALID")
        );

        assertTrue(ex.getMessage().contains("Tipo de datasource inválido"));
    }
}
