# PriceService
### Proyecto de prueba tecnica que ayuda a validar y consultar precios en la base de datos en memoria
## Requisitos para iniciar el servicio:
# Configuracion de la base de datos:
`Base de datos implementada: H2 `
`Archivo de creacion SQL: Schema.sql`

### Modificación del archivo de propiedades:
* El servicio cuenta con una base de datos en memoria H2 donde automaticamente se configura la tabla local con el archivo **schema.sql** el cual contiene la siguiente estructura:
```
DROP TABLE IF EXISTS PRICES;

CREATE TABLE PRICES (
    ID integer AUTO_INCREMENT PRIMARY KEY,
    brand_id integer NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    price_list integer NOT NULL,
    product_id integer NOT NULL,
    priority integer NOT NULL,
    price DOUBLE  NOT NULL,
    curr VARCHAR(4) NOT NULL
);
```
* Para ingresar los datos de prueba en el servicio (poblar tabla) se necesita iniciar el servicio, se debe ingresar a la consola de H2(que se puede deshabilitar por seguridad) a la siguiente ruta: <http://localhost:8080/h2-console/login.jsp?jsessionid=336867b80a93f0c74837f70fe93d12e7> y en el valor de **JDBC URL:** poner: *jdbc:h2:mem:testdb*
* Ingresar al portal y ejecutar el siguiente script para las pruebas 
```
INSERT INTO PRICES (brand_id,start_date,end_date,price_list,product_id,priority,price,curr) VALUES
(1,'2020-06-14 00.00.00','2020-12-31 23.59.59',1,35455,0,35.50,'EUR'),
(1,'2020-06-14 15.00.00','2020-06-14 18.30.00',2,35455,1,25.45,'EUR'),
(1,'2020-06-15 00.00.00','2020-06-15 11.00.00',3,35455,1,30.50,'EUR'),
(1,'2020-06-15 00.00.00','2020-12-31 23.59.59',4,35455,1,38.95,'EUR');
```
## Documentación de los servicios (APIS):
### Swagger:
una vez iniciado el proyecto de manera exitosa entrar a la siguiente ruta:<http://localhost:8080/swagger-ui/index.html>.
El proyecto cuenta con Swagger para la ejecución y documentación de los servicios para pruebas
* para el ejemplo práctico se dáran los siguientes datos:
* Caso found
  * **Fecha:** *2020-06-15T15:55:33.900Z*
  * **productId:** *35455*
  * **brandId:** *1*
* Caso not found: 
  * **Fecha:** *2023-06-15T15:55:33.900Z*
  * **productId:** *35455*
  * **brandId:** *1*

## Reglas de negocio:
* El servicio determina el producto con la prioridad mas alta para las mismas fechas.







cualquier duda o comentario: **ramses12master@gmail.com**