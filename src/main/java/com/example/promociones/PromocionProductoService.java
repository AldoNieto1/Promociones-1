package com.example.promociones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromocionProductoService {
    @Autowired
    private PromocionRepository promocionRepository;

    @Autowired
    private ProductoRepository productoRepository;

    // Métodos para Promociones
    public List<Promocion> findAllPromociones() {
        return promocionRepository.findAll();
    }

    public Promocion savePromocion(Promocion promocion) {
        return promocionRepository.save(promocion);
    }

    public Promocion updatePromocion(Long id, Promocion promocion) {
        promocion.setId(id);
        return promocionRepository.save(promocion);
    }

    public void deletePromocion(Long id) {
        promocionRepository.deleteById(id);
    }

    public Promocion findPromocionById(Long id) {
        return promocionRepository.findById(id).orElse(null);
    }

    // Métodos para Productos
    public List<Producto> findAllProductos() {
        return productoRepository.findAll();
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto updateProducto(Long id, Producto producto) {
        producto.setId(id);
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    public Producto findProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }
}
