package com.ecomarket.services;

import com.ecomarket.models.Proveedor;
import com.ecomarket.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository repository;

    public List<Proveedor> listar() {
        return repository.findAll();
    }

    public Optional<Proveedor> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Proveedor guardar(Proveedor obj) {
        return repository.save(obj);
    }

    public Proveedor actualizar(Long id, Proveedor nuevo) {
        return repository.findById(id).map(p -> {
            p.setNombre(nuevo.getNombre());
            p.setContacto(nuevo.getContacto());
            p.setTelefono(nuevo.getTelefono());
            p.setEmail(nuevo.getEmail());
            return repository.save(p);
        }).orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
