package challenge.melichallenge.datasource;

import java.util.Optional;

import challenge.melichallenge.model.Product;

public interface ProductDataSource {
 
    Optional<Product> findById(String id);
}
