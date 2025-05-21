package com.ecomarket.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ENVIOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnvio;
    @Column(nullable = false)
    private Long idPedido;
    private java.util.Date fechaEnvio;
    private java.util.Date fechaEntregaEstimada;
    private String estado;
    private String rutaEntrega;
}
