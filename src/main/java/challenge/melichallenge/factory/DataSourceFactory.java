package challenge.melichallenge.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import challenge.melichallenge.datasource.JsonProductDataSource;
import challenge.melichallenge.datasource.ProductDataSource;


@Component
public class DataSourceFactory {
    private static final Logger logger = LoggerFactory.getLogger(DataSourceFactory.class);

    public enum DataSourceType {
        JSON, CSV, DATABASE
    }

    public static ProductDataSource getDataSource(DataSourceType type) {
        logger.debug("[DEBUG] DataSourceFactory: solicitando tipo " + type);
        ProductDataSource productDataSource = switch (type) {
            case JSON -> {
                            logger.debug("[DEBUG] Instanciando JSON");
                            yield new JsonProductDataSource(); // yield para devolver el valor en un switcho expression
                        }
            case CSV -> throw new UnsupportedOperationException("Archivo CSV no implementado aún");
            case DATABASE -> throw new UnsupportedOperationException("Base de datos no implementada aún");
        };
        logger.debug("[DEBUG] DataSourceFactory: instancia creada -> " + productDataSource.getClass().getSimpleName());
        return productDataSource;
    }
}