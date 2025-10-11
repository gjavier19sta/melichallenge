package challenge.melichallenge.datasource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import challenge.melichallenge.model.Product;
import challenge.melichallenge.repository.ProductRepository;

@Component
public class DatabaseProductDataSource implements ProductDataSource {
    private final ProductRepository repository;

    @Autowired
    public DatabaseProductDataSource(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Product> findById(String id) {
        return repository.findById(id);
    }    
/* 
    private ProductDTO toDTO(Product entity) {
        // conversión
    }
    @Override
    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }*/
}