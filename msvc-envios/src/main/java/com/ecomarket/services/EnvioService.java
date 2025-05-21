package com.ecomarket.services;

import com.ecomarket.models.Envio;
import com.ecomarket.repositories.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepository repository;

    public List<Envio> listar() {
        return repository.findAll();
    }

    public Optional<Envio> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Envio guardar(Envio obj) {
        return repository.save(obj);
    }

    public Envio actualizar(Long id, Envio nuevo) {
        return repository.findById(id).map(p -> {
            p.setIdpedido(nuevo.getIdpedido());
            p.setFechaenvio(nuevo.getFechaenvio());
            p.setFechaentregaestimada(nuevo.getFechaentregaestimada());
            p.setEstado(nuevo.getEstado());
            p.setRutaentrega(nuevo.getRutaentrega());
            return repository.save(p);
        }).orElseThrow(() -> new RuntimeException("Envio no encontrado"));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
