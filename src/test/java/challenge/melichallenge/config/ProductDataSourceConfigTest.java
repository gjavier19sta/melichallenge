package challenge.melichallenge.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import challenge.melichallenge.datasource.CsvProductDataSource;
import challenge.melichallenge.datasource.DatabaseProductDataSource;
import challenge.melichallenge.datasource.JsonProductDataSource;
import challenge.melichallenge.datasource.ProductDataSource;
import challenge.melichallenge.exception.EnumIllegalArgumentException;

@SpringBootTest
class ProductDataSourceConfigTest {

    @Autowired
    private JsonProductDataSource jsonDs;
    @Autowired
    private CsvProductDataSource csvDs;
    @Autowired
    private DatabaseProductDataSource dbDs;
    
    @Test
    @DisplayName("Debe crear un JsonProductDataSource cuando el tipo es JSON")
    void shouldCreateJsonDataSource() {
        ProductDataSourceConfig config = new ProductDataSourceConfig("JSON", jsonDs, csvDs, dbDs);
        ProductDataSource ds = config.productDataSource();
        assertNotNull(ds);
        assertEquals("JsonProductDataSource", ds.getClass().getSimpleName());
    }


    @Test
    @DisplayName("Debe lanzar UnsupportedOperationException para tipo CSV")
    void shouldThrowUnsupportedForCSV() {
        ProductDataSourceConfig config = new ProductDataSourceConfig("CSV", jsonDs, csvDs, dbDs);
        ProductDataSource ds = config.productDataSource();
        assertNotNull(ds);
        assertEquals("CsvProductDataSource", ds.getClass().getSimpleName());
    }

    @Test
    @DisplayName("Debe lanzar UnsupportedOperationException para tipo DATABASE")
    void shouldThrowUnsupportedForDatabase() {
        ProductDataSourceConfig config = new ProductDataSourceConfig("DATABASE", jsonDs, csvDs, dbDs);
        ProductDataSource ds = config.productDataSource();
        assertNotNull(ds);
        assertEquals("DatabaseProductDataSource", ds.getClass().getSimpleName());
    }

}
