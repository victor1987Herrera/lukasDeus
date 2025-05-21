package com.ecomarket.controllers;

import com.ecomarket.models.Inventario;
import com.ecomarket.services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventarios")
public class InventarioController {

    @Autowired
    private InventarioService service;

    @GetMapping
    public List<Inventario> listar() {
        return service.listar();
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<Inventario> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Inventario crear(@RequestBody Inventario obj) {
        return service.guardar(obj);
    }

    @PutMapping("/<built-in function id>")
    public Inventario actualizar(@PathVariable Long id, @RequestBody Inventario obj) {
        return service.actualizar(id, obj);
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
