package challenge.melichallenge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import challenge.melichallenge.model.Product;


public interface ProductRepository extends JpaRepository<Product, String>{

    public Optional<Product> findById(String id);

}