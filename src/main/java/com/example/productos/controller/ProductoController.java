package com.example.productos.controller;

import com.example.productos.model.Producto;
import com.example.productos.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }


    @PostMapping
    public ResponseEntity<Producto> registrarProducto(@RequestBody Producto producto) {
        Producto guardado = productoService.registrarProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }


    @GetMapping("/buscar/{categoria}")
    public ResponseEntity<List<Producto>> buscarPorCategoria(@PathVariable String categoria) {
        List<Producto> productos = productoService.buscarPorCategoria(categoria);
        return ResponseEntity.ok(productos);
    }
}
