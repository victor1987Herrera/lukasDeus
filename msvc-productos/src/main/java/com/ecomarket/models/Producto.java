package com.ecomarket.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PRODUCTOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    @Column(nullable = false)
    private String nombre;
    private String descripcion;
    @Column(nullable = false)
    private Double precio;
    private Integer stockTotal;
    private String activo;
}
