package com.ecomarket.services;

import com.ecomarket.models.Producto;
import com.ecomarket.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public List<Producto> listar() {
        return repository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Producto guardar(Producto obj) {
        return repository.save(obj);
    }

    public Producto actualizar(Long id, Producto nuevo) {
        return repository.findById(id).map(p -> {
            p.setNombre(nuevo.getNombre());
            p.setDescripcion(nuevo.getDescripcion());
            p.setPrecio(nuevo.getPrecio());
            p.setStockTotal(nuevo.getStockTotal());
            p.setActivo(nuevo.getActivo());
            return repository.save(p);
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
