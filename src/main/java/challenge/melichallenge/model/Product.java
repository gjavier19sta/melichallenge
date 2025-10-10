package challenge.melichallenge.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {

    @Id
    private String id;
    private String title;
    private String description;
    private double price;
    private String currency;
    private String condition;
    private int availableQuantity;
    private String seller;
    private String warranty;
    private String imageUrl;

}