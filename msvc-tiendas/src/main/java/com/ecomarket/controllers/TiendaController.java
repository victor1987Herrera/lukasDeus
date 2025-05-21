package com.ecomarket.controllers;

import com.ecomarket.models.Tienda;
import com.ecomarket.services.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiendas")
public class TiendaController {

    @Autowired
    private TiendaService service;

    @GetMapping
    public List<Tienda> listar() {
        return service.listar();
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<Tienda> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tienda crear(@RequestBody Tienda obj) {
        return service.guardar(obj);
    }

    @PutMapping("/<built-in function id>")
    public Tienda actualizar(@PathVariable Long id, @RequestBody Tienda obj) {
        return service.actualizar(id, obj);
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
