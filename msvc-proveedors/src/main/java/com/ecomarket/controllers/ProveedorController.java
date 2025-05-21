package com.ecomarket.controllers;

import com.ecomarket.models.Proveedor;
import com.ecomarket.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedors")
public class ProveedorController {

    @Autowired
    private ProveedorService service;

    @GetMapping
    public List<Proveedor> listar() {
        return service.listar();
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<Proveedor> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Proveedor crear(@RequestBody Proveedor obj) {
        return service.guardar(obj);
    }

    @PutMapping("/<built-in function id>")
    public Proveedor actualizar(@PathVariable Long id, @RequestBody Proveedor obj) {
        return service.actualizar(id, obj);
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
