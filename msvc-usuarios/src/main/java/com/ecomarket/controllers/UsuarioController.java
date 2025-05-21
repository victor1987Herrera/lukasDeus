package com.ecomarket.controllers;

import com.ecomarket.models.Usuario;
import com.ecomarket.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<Usuario> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario obj) {
        return service.guardar(obj);
    }

    @PutMapping("/<built-in function id>")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario obj) {
        return service.actualizar(id, obj);
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
