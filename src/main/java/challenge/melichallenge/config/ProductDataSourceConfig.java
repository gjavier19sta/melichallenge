package challenge.melichallenge.config;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import challenge.melichallenge.datasource.ProductDataSource;
import challenge.melichallenge.exception.EnumIllegalArgumentException;
import challenge.melichallenge.factory.DataSourceFactory;


@Configuration
public class ProductDataSourceConfig {
    private static final Logger logger = LoggerFactory.getLogger(ProductDataSourceConfig.class);

    @Bean
    public ProductDataSource getDataSource(@Value("${datasource.type:JSON}") String type){
         
        String normalized = type.trim().toUpperCase();
        DataSourceFactory.DataSourceType dsType;

        try {
            logger.info("[INFO] Creando el data source del tipo '" + type + "'");
            dsType = DataSourceFactory.DataSourceType.valueOf(normalized);
        } catch (IllegalArgumentException e) {
            
            logger.error("[ERROR] Tipo de fuente de datos inválido: '" + type + "'");
            logger.error("Valores válidos: " + Arrays.toString(DataSourceFactory.DataSourceType.values()));

            throw new EnumIllegalArgumentException(
                "Tipo de datasource inválido: '" + type + "'. " +
                "Valores válidos: " + Arrays.toString(DataSourceFactory.DataSourceType.values())
            );
        }


        // Usamos la factory para obtener la fuente de datos correcta
        return DataSourceFactory.getDataSource(dsType);
            
        
    }
}
        
