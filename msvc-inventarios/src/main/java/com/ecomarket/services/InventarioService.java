package com.ecomarket.services;

import com.ecomarket.models.Inventario;
import com.ecomarket.repositories.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository repository;

    public List<Inventario> listar() {
        return repository.findAll();
    }

    public Optional<Inventario> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Inventario guardar(Inventario obj) {
        return repository.save(obj);
    }

    public Inventario actualizar(Long id, Inventario nuevo) {
        return repository.findById(id).map(p -> {
            p.setIdtienda(nuevo.getIdtienda());
            p.setIdproducto(nuevo.getIdproducto());
            p.setCantidad(nuevo.getCantidad());
            return repository.save(p);
        }).orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
