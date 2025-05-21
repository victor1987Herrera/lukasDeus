package com.ecomarket.services;

import com.ecomarket.models.Reabastecimiento;
import com.ecomarket.repositories.ReabastecimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReabastecimientoService {

    @Autowired
    private ReabastecimientoRepository repository;

    public List<Reabastecimiento> listar() {
        return repository.findAll();
    }

    public Optional<Reabastecimiento> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Reabastecimiento guardar(Reabastecimiento obj) {
        return repository.save(obj);
    }

    public Reabastecimiento actualizar(Long id, Reabastecimiento nuevo) {
        return repository.findById(id).map(p -> {
            p.setIdproveedor(nuevo.getIdproveedor());
            p.setIdproducto(nuevo.getIdproducto());
            p.setFecha(nuevo.getFecha());
            p.setCantidad(nuevo.getCantidad());
            return repository.save(p);
        }).orElseThrow(() -> new RuntimeException("Reabastecimiento no encontrado"));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
