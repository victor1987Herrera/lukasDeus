package com.ecomarket.controllers;

import com.ecomarket.models.Envio;
import com.ecomarket.services.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {

    @Autowired
    private EnvioService service;

    @GetMapping
    public List<Envio> listar() {
        return service.listar();
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<Envio> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Envio crear(@RequestBody Envio obj) {
        return service.guardar(obj);
    }

    @PutMapping("/<built-in function id>")
    public Envio actualizar(@PathVariable Long id, @RequestBody Envio obj) {
        return service.actualizar(id, obj);
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
