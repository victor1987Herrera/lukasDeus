package com.ecomarket.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "INVENTARIOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventario;
    @Column(nullable = false)
    private Long idTienda;
    @Column(nullable = false)
    private Long idProducto;
    private Integer cantidad;
}
