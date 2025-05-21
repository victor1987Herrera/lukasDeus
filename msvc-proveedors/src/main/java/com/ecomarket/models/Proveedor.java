package com.ecomarket.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PROVEEDORS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;
    @Column(nullable = false)
    private String nombre;
    private String contacto;
    private String telefono;
    private String email;
}
