package com.ecomarket.controllers;

import com.ecomarket.models.Reabastecimiento;
import com.ecomarket.services.ReabastecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reabastecimientos")
public class ReabastecimientoController {

    @Autowired
    private ReabastecimientoService service;

    @GetMapping
    public List<Reabastecimiento> listar() {
        return service.listar();
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<Reabastecimiento> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reabastecimiento crear(@RequestBody Reabastecimiento obj) {
        return service.guardar(obj);
    }

    @PutMapping("/<built-in function id>")
    public Reabastecimiento actualizar(@PathVariable Long id, @RequestBody Reabastecimiento obj) {
        return service.actualizar(id, obj);
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
