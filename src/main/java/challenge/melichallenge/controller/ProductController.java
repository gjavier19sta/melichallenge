package challenge.melichallenge.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import challenge.melichallenge.dto.ProductDTO;
import challenge.melichallenge.exception.ProductNotFoundException;
import challenge.melichallenge.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Obtiene un producto por su ID", description = "Devuelve los detalles de un producto dado su ID de MercadoLibre.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Producto encontrado"), @ApiResponse(responseCode = "404", description = "Producto no encontrado")})

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@Parameter(description = "Filtra por ID de producto", example = "MLA67890") @PathVariable String id) {
        logger.info("[INFO] Buscando producto por el id siguente: {}", id);
        Optional<ProductDTO> product = productService.getProductById(id);
        if (product.isPresent()){
            logger.info("[INFO] Producto encontrado, se resoponde al cliente con el producto: {}", product.get());
            return ResponseEntity.ok(product.get());

        }
        throw new ProductNotFoundException("No se encontró el producto de id: " + id);
    }
}
