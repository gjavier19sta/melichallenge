package challenge.melichallenge.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import challenge.melichallenge.datasource.CsvProductDataSource;
import challenge.melichallenge.datasource.DatabaseProductDataSource;
import challenge.melichallenge.datasource.JsonProductDataSource;
import challenge.melichallenge.datasource.ProductDataSource;

@Configuration
public class ProductDataSourceConfig {
    private static final Logger logger = LoggerFactory.getLogger(ProductDataSourceConfig.class);

    private final String datasourceType;
    private final JsonProductDataSource jsonDataSource;
    private final CsvProductDataSource csvDataSource;
    private final DatabaseProductDataSource databaseDataSource;

    public ProductDataSourceConfig(
            @Value("${datasource.type:JSON}") String datasourceType,
            JsonProductDataSource jsonDataSource,
            CsvProductDataSource csvDataSource,
            DatabaseProductDataSource databaseDataSource
    ) {
        this.datasourceType = datasourceType;
        this.jsonDataSource = jsonDataSource;
        this.csvDataSource = csvDataSource;
        this.databaseDataSource = databaseDataSource;
    }

    @Bean
    public ProductDataSource productDataSource() {
        String normalized = datasourceType.trim().toUpperCase();
        logger.info("[INFO] Creando datasource tipo '{}'", normalized);

        return switch (normalized) {
            case "CSV" -> {
                            logger.info("[INFO] Datasource tipo CSV creada" );
                            yield csvDataSource;
                        }
            case "DATABASE" -> {
                            logger.info("[INFO] Datasource tipo DATABASE creada" );
                            yield databaseDataSource;
                        }
            case "JSON" -> {
                            logger.info("[INFO] Datasource tipo JSON creada" );
                            yield jsonDataSource;
                            }
            default ->  jsonDataSource;
  /*           { 
                logger.error("[ERROR] opcion no valida" );
                throw new EnumIllegalArgumentException(
                "Tipo de datasource invalido: '" + datasourceType + "'. " +
                "Valores válidos: [JSON, CSV, DATABASE]");    
            }*/
            
        };
    }
}
        
 