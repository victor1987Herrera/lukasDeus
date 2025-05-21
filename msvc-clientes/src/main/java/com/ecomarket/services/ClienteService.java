package com.ecomarket.services;

import com.ecomarket.models.Cliente;
import com.ecomarket.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Optional<Cliente> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Cliente guardar(Cliente obj) {
        return repository.save(obj);
    }

    public Cliente actualizar(Long id, Cliente nuevo) {
        return repository.findById(id).map(p -> {
            p.setNombre(nuevo.getNombre());
            p.setEmail(nuevo.getEmail());
            p.setPassword(nuevo.getPassword());
            p.setDireccion(nuevo.getDireccion());
            p.setTelefono(nuevo.getTelefono());
            return repository.save(p);
        }).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
