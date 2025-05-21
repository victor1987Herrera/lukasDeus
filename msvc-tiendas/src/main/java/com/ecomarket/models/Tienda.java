package com.ecomarket.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TIENDAS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTienda;
    @Column(nullable = false)
    private String nombre;
    private String direccion;
    private String ciudad;
    private String horario;
}
