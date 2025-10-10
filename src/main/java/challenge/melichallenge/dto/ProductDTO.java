package challenge.melichallenge.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO que representa un producto del catálogo")
public record ProductDTO(
        @Schema(description = "Identificador único del producto", example = "MLA12345")
        String id,
        @Schema(description = "Título del producto", example = "Auriculares Bluetooth Sony WH-CH520")
        String title,
        @Schema(description = "Descripción del producto", example = "Auriculares inalámbricos con cancelación de ruido y hasta 50 horas de batería.")
        String description,
        @Schema(description = "Precio del producto", example = "24999.99")
        double price,
        @Schema(description = "Moneda del precio", example = "ARS")
        String currency,
        @Schema(description = "URL de la imagen del producto", example = "https://example.com/img/sony-whch520.jpg")
        String imageUrl
) {}
