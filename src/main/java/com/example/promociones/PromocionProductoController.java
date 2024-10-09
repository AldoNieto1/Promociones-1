package com.example.promociones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PromocionProductoController {

    @Autowired
    private PromocionProductoService promocionProductoService;

    // Endpoints para gestionar productos
    @GetMapping("/productos")
    public List<Producto> getAllProductos() {
        return promocionProductoService.findAllProductos();
    }

    @PostMapping("/productos")
    public Producto createProducto(@RequestBody Producto producto) {
        return promocionProductoService.saveProducto(producto);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto productoDetails) {
        Producto updatedProducto = promocionProductoService.updateProducto(id, productoDetails);
        return ResponseEntity.ok(updatedProducto);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        promocionProductoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints para gestionar promociones
    @GetMapping("/promociones")
    public List<Promocion> getAllPromociones() {
        return promocionProductoService.findAllPromociones();
    }

    @PostMapping("/promociones")
    public Promocion createPromocion(@RequestBody Promocion promocion) {
        return promocionProductoService.savePromocion(promocion);
    }

    @PutMapping("/promociones/{id}")
    public ResponseEntity<Promocion> updatePromocion(@PathVariable Long id, @RequestBody Promocion promocionDetails) {
        Promocion updatedPromocion = promocionProductoService.updatePromocion(id, promocionDetails);
        return ResponseEntity.ok(updatedPromocion);
    }

    @DeleteMapping("/promociones/{id}")
    public ResponseEntity<Void> deletePromocion(@PathVariable Long id) {
        promocionProductoService.deletePromocion(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints para gestionar relaciones entre productos y promociones
    @PostMapping("/producto-promocion")
    public ProductoPromocion createRelacion(@RequestBody ProductoPromocion productoPromocion) {
        return promocionProductoService.saveRelacion(productoPromocion);
    }

    @GetMapping("/producto-promocion")
    public List<ProductoPromocion> getAllRelaciones() {
        return promocionProductoService.findAllRelaciones();
    }

    @GetMapping("/productos/{productoId}/promociones")
    public List<Promocion> getPromocionesPorProducto(@PathVariable Long productoId) {
        return promocionProductoService.findPromocionesByProductoId(productoId);
    }

    @PutMapping("/producto-promocion/{id}")
    public ResponseEntity<ProductoPromocion> updateRelacion(@PathVariable Long id, @RequestBody ProductoPromocion productoPromocionDetails) {
        ProductoPromocion updatedRelacion = promocionProductoService.actualizarRelacion(id, productoPromocionDetails);
        return ResponseEntity.ok(updatedRelacion);
    }

    @DeleteMapping("/producto-promocion/{id}")
    public ResponseEntity<Void> deleteRelacion(@PathVariable Long id) {
        promocionProductoService.deleteRelacion(id);
        return ResponseEntity.noContent().build();
    }
}

