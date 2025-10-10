package challenge.melichallenge.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import challenge.melichallenge.datasource.ProductDataSource;
import challenge.melichallenge.dto.ProductDTO;

import challenge.melichallenge.model.Product;


@Service
public class ProductService {

    private final ProductDataSource productDataSource;

    public ProductService(ProductDataSource productDataSource) {
        this.productDataSource = productDataSource;
    }

    public Optional<ProductDTO> getProductById(String id) {
        return productDataSource.findById(id)
                .map(this::toDTO);
    }

    private ProductDTO toDTO(Product p) {
        return new ProductDTO(
                p.getId(),
                p.getTitle(),
                p.getDescription(),
                p.getPrice(),
                p.getCurrency(),
                p.getImageUrl()
        );
    }
}
