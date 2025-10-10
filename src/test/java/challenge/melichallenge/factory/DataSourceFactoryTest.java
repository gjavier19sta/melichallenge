package challenge.melichallenge.factory;

import org.junit.jupiter.api.Test;

import challenge.melichallenge.datasource.JsonProductDataSource;
import challenge.melichallenge.datasource.ProductDataSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertThrows;



class DataSourceFactoryTest {

    @Test
    @DisplayName("Debe crear un JsonProductDataSource cuando se solicita JSON")
    void shouldCreateJsonDataSource() {
        ProductDataSource ds = DataSourceFactory.getDataSource(DataSourceFactory.DataSourceType.JSON);
        assertTrue(ds instanceof JsonProductDataSource);
    }

    @Test
    @DisplayName("Debe lanzar UnsupportedOperationException cuando se solicita CSV")
    void shouldThrowUnsupportedOperationForCSV() {
        assertThrows(UnsupportedOperationException.class, () ->
                DataSourceFactory.getDataSource(DataSourceFactory.DataSourceType.CSV));
    }

    @Test
    @DisplayName("Debe lanzar UnsupportedOperationException cuando se solicita DATABASE")
    void shouldThrowUnsupportedOperationForDatabase() {
        assertThrows(UnsupportedOperationException.class, () ->
                DataSourceFactory.getDataSource(DataSourceFactory.DataSourceType.DATABASE));
    }

}
