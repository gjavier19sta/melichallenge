
# Proyecto: API de Productos - Challenge MercadoLibre

## 1. Objetivo
Construir un backend API que proporcione los datos necesarios para una página de detalle de productos, simulando MercadoLibre, usando buenas prácticas de desarrollo backend.

## 2. Tecnología y stack elegido
- Lenguaje: Java 17
- Framework: Spring Boot 3
- Dependencias principales: spring-boot-starter-web, jackson-databind, lombok (opcional), spring-boot-starter-test
- Persistencia: JSON local
- Build: Maven
- IDE utlizado: VS Code

## 3. Arquitectura
Se utilizó un enfoque limpio y modular, con separación de responsabilidades:

- `controller/` → Expone los endpoints REST
- `service/` → Lógica de negocio
- `factory/` → Patrón Factory: decide la fuente de datos
- `datasource/` → Implementaciones concretas de la fuente de datos
- `model/` → Entidades de dominio 
- `exception/` → Excepciones propias y globales para el tratamiento de los errores
- `DTO/` → Para trasferir los datos de forma segura e inmutable 
- `repository/` → Ademas repository, Como no era necesario para el challenge, no integrará.

### Decisiones clave:
- DTO como record: inmutable, simplifica serialización JSON
- Factory Pattern: permite cambiar la fuente de datos sin modificar servicio ni controladores
- JSON como fuente de datos: suficiente para el challenge y fácilmente reemplazable por base de datos

## 4. Endpoints expuestos

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/products/{id}` | Obtener detalle de un producto por ID |

## 5. Pruebas
- Validar que todos los productos se cargan correctamente desde JSON
- Búsqueda por ID devuelve producto correcto
- Búsqueda por ID inexistente devuelve 404 Not Found

## 6. Extensibilidad
- Agregar nueva fuente de datos (DB, CSV, API externa):
  1. Crear clase que implemente `ProductDataSource`
  2. Agregar opción en `DataSourceFactory`
  3. Cambiar `DataSourceType` usado en el servicio

## 7. Ventajas
- Código desacoplado y modular
- DTO claro y serializable automáticamente
- Factory permite extensión futura sin tocar código existente
- JSON permite pruebas rápidas y portabilidad

## 8. Cómo correr
1. `mvn spring-boot:run`
2. Abrir navegador o Postman:
   - `GET http://localhost:8080/api/products/MLA12345`
    devolvera el producto con ID=MLA12345
    Se cargaron en el JSON los sigiuentes 24 ID para pruebas
    MLA12345  
    MLA67890  
    MLA11223  
    MLA12346  
    MLA67891  
    MLA11224  
    MLA12347  
    MLA67892  
    MLA11225  
    MLA12348  
    MLA67893  
    MLA11226  
    MLA12349  
    MLA67894  
    MLA11227  
    MLA12350  
    MLA67895  
    MLA11228  
    MLA12351  
    MLA67896  
    MLA11229  
    MLA12352  
    MLA67897  
    MLA11230
