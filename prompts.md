# Prompt a ChatGPT

## Prompt enviado
como sería un json típico de mercadolibre para la descripción de sus productos?

# Prompts utilizados con GenAI (ChatGPT)

Durante el desarrollo de este proyecto se utilizó **ChatGPT** como asistente técnico y de documentación.  
A continuación se listan los principales prompts empleados:

---

### Diseño y arquitectura
> como sería un json típico de mercadolibre para la descripción de sus productos?
> “Quiero crear una API REST con Spring Boot para un desafío estilo MercadoLibre.  
> Debe devolver el detalle de un producto a partir de un archivo JSON.  
> Quiero usar Entity, DTO y una Factory para poder cambiar de fuente de datos fácilmente.”

---

### Implementación técnica
> “Creame la estructura de paquetes con Controller, Service, DataSource y Factory.  
> Usaré un `record` para el DTO y una clase normal para la Entity.”

---

### Testing
> “Generame casos de prueba unitarios

---

### Documentación
> “Creame los archivos run.md, project-plan.md y prompts.md en base al proyecto decrito”  

---

### Generacion Json
> “Tengo un json con 1 articulos de mercado libre. necesito que me lo agrandes a 25 articulos, [{ "id": "MLA12345", "title": "Auriculares Bluetooth Sony WH-CH520", "description": "Auriculares inalámbricos con cancelación de ruido y hasta 50 horas de batería.", "price": 24999.99, "currency": "ARS", "condition": "new", "availableQuantity": 45, "seller": "SonyStoreOficial", "warranty": "12 meses de garantía oficial", "imageUrl": "https://example.com/img/sony-whch520.jpg" }]"
> “Ahora solo pasame una listas de los ID que generaste solamente, corroborando que no se repitan, si algúno se repite, informarmelo."


---
En todos los casos, el uso de IA fue complementario:  
las decisiones de arquitectura, estructura de código y estilo de documentación fueron tomadas por mi, utilizando la IA como herramienta de apoyo para acelerar escritura y validación.
