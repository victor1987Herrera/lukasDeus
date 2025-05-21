package com.ecomarket.services;

import com.ecomarket.models.Tienda;
import com.ecomarket.repositories.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiendaService {

    @Autowired
    private TiendaRepository repository;

    public List<Tienda> listar() {
        return repository.findAll();
    }

    public Optional<Tienda> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Tienda guardar(Tienda obj) {
        return repository.save(obj);
    }

    public Tienda actualizar(Long id, Tienda nuevo) {
        return repository.findById(id).map(p -> {
            p.setNombre(nuevo.getNombre());
            p.setDireccion(nuevo.getDireccion());
            p.setCiudad(nuevo.getCiudad());
            p.setHorario(nuevo.getHorario());
            return repository.save(p);
        }).orElseThrow(() -> new RuntimeException("Tienda no encontrado"));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
