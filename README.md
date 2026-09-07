# Quiz Spring Boot y JPA — Productos

Aplicación básica en capas (Entidad, Repositorio, Servicio, Controlador) que administra productos.

## Estructura

```
src/main/java/com/example/productos/
 ├── model/Producto.java              -> Entidad JPA
 ├── repository/ProductoRepository.java -> JpaRepository + consulta JPQL
 ├── service/ProductoService.java     -> Lógica de negocio
 ├── controller/ProductoController.java -> Endpoints REST
 └── ProductosApplication.java        -> Clase principal
src/main/resources/application.properties -> Configuración (H2 en memoria)
```

## Cómo ejecutar

```bash
mvn spring-boot:run
```

La app arranca en `http://localhost:8080` con una base de datos H2 en memoria.

## Endpoints

### 1. Registrar un producto — `POST /productos`

```bash
curl -X POST http://localhost:8080/productos \
  -H "Content-Type: application/json" \
  -d '{
        "nombre": "Teclado mecánico",
        "categoria": "Periféricos",
        "precio": 150000,
        "activo": true
      }'
```

Respuesta `201 Created` con el producto guardado (incluyendo su `id` generado).

### 2. Consulta JPQL por categoría — `GET /productos/buscar/{categoria}`

```bash
curl http://localhost:8080/productos/buscar/Periféricos
```

Respuesta `200 OK` con la lista de productos que pertenecen a esa categoría.
Internamente usa la consulta definida en el repositorio:

```java
@Query("SELECT p FROM Producto p WHERE p.categoria = :categoria")
List<Producto> buscarPorCategoria(@Param("categoria") String categoria);
```

Nótese que es JPQL (opera sobre la entidad `Producto` y sus atributos, no sobre
la tabla ni columnas SQL directamente), tal como pide el enunciado.

## Notas

- No se implementan operaciones de actualización ni eliminación, según el enunciado.
- `ddl-auto=update` crea/actualiza automáticamente la tabla `productos` al arrancar.
- La consola H2 queda disponible en `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:productosdb`, usuario `sa`, sin contraseña) para inspeccionar los datos insertados.
