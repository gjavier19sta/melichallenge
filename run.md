#  Cómo ejecutar el proyecto

Este proyecto es una API REST desarrollada con **Spring Boot 3** y **Java 17**, que simula el backend de un detalle de producto al estilo MercadoLibre.  
Los datos se obtienen desde un archivo local `products.json`, sin utilizar una base de datos real.

---

## Requisitos previos

- Tener instalado **Java 17 o superior**

---

## Pasos para ejecutar

Ejecutar el .jar generado ![jar](/target/melichallenge-0.0.1-SNAPSHOT.jar) utilzando el siguiente comando

java -jar target/melichallenge-0.0.1-SNAPSHOT.jar

Una vez iniciado, la API estará disponible en:

http://localhost:8080

### Endpoints disponibles
Método	Endpoint	Descripción
GET	/api/products/{id}	Devuelve el detalle del producto con el ID indicado.

Ejemplo:

curl http://localhost:8080/api/products/MLA12345 

## Swagger UI
Una vez iniciado el proyecto, puede accederse a la documentación interactiva en:

- http://localhost:8080/swagger-ui/index.html
- Documentación en formato JSON: http://localhost:8080/v3/api-docs

La documentación se genera automáticamente mediante **springdoc-openapi**, siguiendo el estándar OpenAPI 3.

### Ejecución de tests

El proyecto incluye pruebas unitarias que pueden ejecutarse con:

mvn test


Los tests verifican:

Que el servicio lea correctamente el archivo products.json

Que la API devuelva un producto válido si el ID existe

Que devuelva vacío si el producto no existe

Que maneje correctamente errores de lectura

### Notas adicionales

La fuente de datos está abstraída mediante un patrón Factory, para poder reemplazar fácilmente el origen (por ejemplo, por una base de datos o CSV).

Se usa un DTO basado en record para simplificar la transferencia de datos y asegurar inmutabilidad. 

Si bien para el proyecto no se pedía la persistencia en base de datos, se puede ver con esas funcionalidades en el repositorio de git
https://github.com/gjavier19sta/melichallenge.git

