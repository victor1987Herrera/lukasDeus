package com.ecomarket.controllers;

import com.ecomarket.models.Producto;
import com.ecomarket.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping
    public List<Producto> listar() {

        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtener(@PathVariable("id") Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Producto crear(
            @RequestBody Producto obj) {
        return service.guardar(obj);
    }


    @PutMapping("/{id}")
    public Producto actualizar(
            @PathVariable("id") Long id,
            @RequestBody Producto obj) {
        return service.actualizar(id, obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
