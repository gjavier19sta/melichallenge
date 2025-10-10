package challenge.melichallenge.datasource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JsonParseException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import challenge.melichallenge.model.Product;

public class JsonProductDataSource implements ProductDataSource {

    private static final Logger logger = LoggerFactory.getLogger(JsonProductDataSource.class);

    private final List<Product> products;

    public JsonProductDataSource() {
        logger.debug("[DEBUG] Creando JsonProductDataSource...");
        this.products = loadProductsFromJson();
        logger.debug("[DEBUG] JsonProductDataSource inicializado con " + products.size() + " productos.");
    }

    private List<Product> loadProductsFromJson() {
        logger.debug("[DEBUG] Intentando cargar productos desde JSON...");
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("data/products.json")) { // solo para asegurarse que se cierre el recurso.

            if (inputStream == null) {
                logger.error("[ERROR] No se encontró el archivo products.json");
                return Collections.emptyList(); 
            }

            logger.debug("[DEBUG] Archivo JSON encontrado, creando ObjectMapper...");
            ObjectMapper mapper = new ObjectMapper();
            List<Product> listaDeProductsFromJson = mapper.readValue(inputStream, new TypeReference<List<Product>>() {});
            
            logger.debug("[DEBUG] Productos cargados desde JSON:");
            listaDeProductsFromJson.forEach(p -> logger.debug("[DEBUG]  - {}",  p));

            return listaDeProductsFromJson;

        } catch (JsonParseException ex){
            logger.error("[ERROR] Los datos leidos no corresponden a un json valido " + ex.getMessage());
            ex.printStackTrace();
            return Collections.emptyList();
        } catch (IOException e) {
            logger.error("[ERROR] Al leer Stream: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        } catch (Exception e) {
            logger.error("[ERROR] Al leer products.json: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<Product> findById(String id) {
        return products.stream()
                .filter(p -> p.getId().equalsIgnoreCase(id))
                .findFirst();
    }
}
