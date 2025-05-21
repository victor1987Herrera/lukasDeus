package com.ecomarket.services;

import com.ecomarket.models.Usuario;
import com.ecomarket.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Usuario guardar(Usuario obj) {
        return repository.save(obj);
    }

    public Usuario actualizar(Long id, Usuario nuevo) {
        return repository.findById(id).map(p -> {
            p.setNombre(nuevo.getNombre());
            p.setEmail(nuevo.getEmail());
            p.setPassword(nuevo.getPassword());
            p.setRol(nuevo.getRol());
            return repository.save(p);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
