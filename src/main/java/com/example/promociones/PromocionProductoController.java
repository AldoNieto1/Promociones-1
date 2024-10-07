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

    // Métodos para Promociones

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

    // Métodos para Productos

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
}
