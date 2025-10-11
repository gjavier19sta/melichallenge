package challenge.melichallenge.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import challenge.melichallenge.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {


}