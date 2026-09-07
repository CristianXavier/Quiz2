package com.example.productos.service;

import com.example.productos.model.Producto;
import com.example.productos.repository.ProductoRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }


    public Producto registrarProducto(@NonNull Producto producto) {
        return productoRepository.save(producto);
    }


    public List<Producto> buscarPorCategoria(String categoria) {
        return productoRepository.buscarPorCategoria(categoria);
    }
}
