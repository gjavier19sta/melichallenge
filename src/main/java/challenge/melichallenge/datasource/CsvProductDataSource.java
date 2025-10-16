package challenge.melichallenge.datasource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import challenge.melichallenge.model.Product;

@Component
public class CsvProductDataSource implements ProductDataSource{

    private static final Logger logger = LoggerFactory.getLogger(CsvProductDataSource.class);
    private static final String CSV_PATH = "/data/products.csv";
    private final List<Product> products;

    public CsvProductDataSource(){
        this.products = loadProductsFromCsv();
    }

    private List<Product> loadProductsFromCsv(){
        logger.debug("[INFO] Iniciaando servicio por csv");
        List<Product> productsList = new ArrayList<Product>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(CSV_PATH)))) {
            logger.debug("[INFO] Iniciando carga de lista csv");
            // Saltar encabezado si existe
            reader.readLine();
            logger.debug("[INFO] Linea {}");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";", -1);
                if (fields.length < 10) continue;
                Product product = Product.builder()
                            .id(fields[0].trim())
                            .title(fields[1].trim())
                            .description(fields[2].trim())
                            .price(Double.parseDouble(fields[3].trim()))
                            .currency(fields[4].trim())
                            .condition(fields[5].trim())
                            .availableQuantity(Integer.parseInt(fields[6].trim()))
                            .seller(fields[7].trim())
                            .warranty(fields[8].trim())
                            .imageUrl(fields[9].trim())
                            .build();
                productsList.add(product); 
                logger.debug("{}",product);
                }
            
        } catch (NullPointerException e) {
            logger.error("[ERROR] NullPointerException Error leyendo el archivo CSV de productos: {}", e.getMessage());
        } catch (IOException  e) {
            logger.error("[ERROR] IOException Error leyendo el archivo CSV de productos: {}", e.getMessage());
        } 
        return productsList; 
    }

    @Override
    public Optional<Product> findById(String id) {
        return products.stream()
                .filter(p -> p.getId().equalsIgnoreCase(id))
                .findFirst();
    }
}

