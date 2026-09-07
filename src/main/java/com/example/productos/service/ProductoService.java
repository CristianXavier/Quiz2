package com.example.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.productos.model.Producto;
import com.example.productos.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
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
