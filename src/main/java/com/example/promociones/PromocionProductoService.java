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

    @Autowired
    private ProductoPromocionRepository productoPromocionRepository;

    // Métodos para gestionar productos
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

    // Métodos para gestionar promociones
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

    // Métodos para gestionar relaciones entre productos y promociones
    public ProductoPromocion saveRelacion(ProductoPromocion productoPromocion) {
        return productoPromocionRepository.save(productoPromocion);
    }

    public List<ProductoPromocion> findAllRelaciones() {
        return productoPromocionRepository.findAll();
    }

    public List<Promocion> findPromocionesByProductoId(Long productoId) {
        // Implementa lógica para obtener promociones basadas en el ID del producto
        return null; // Implementar lógica aquí
    }

    public void deleteRelacion(Long id) {
        productoPromocionRepository.deleteById(id);
    }
}
