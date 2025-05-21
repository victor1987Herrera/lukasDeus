package com.ecomarket.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "REABASTECIMIENTOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reabastecimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReabastecimiento;
    @Column(nullable = false)
    private Long idProveedor;
    @Column(nullable = false)
    private Long idProducto;
    private java.util.Date fecha;
    private Integer cantidad;
}
