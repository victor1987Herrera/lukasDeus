package com.ecomarket.repositories;

import com.ecomarket.models.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {}
