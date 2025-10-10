package challenge.melichallenge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Meli Challenge API")
                .version("1.0.0")
                .description("API para obtener detalles de productos, inspirada en MercadoLibre. " +
                             "Permite obtener información de un producto desde un archivo JSON, " +
                             "implementando buenas prácticas de diseño y patrones de arquitectura.")
                .contact(new Contact()
                    .name("Javier Aguilar")
                    .email("gjavier19sta@hotmail.com")
                    .url("https://github.com/gjavier19sta"))
                .license(new License()
                    .name("MercadoLibre")));
    }
}