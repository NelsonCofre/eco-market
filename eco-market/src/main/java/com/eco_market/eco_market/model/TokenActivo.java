package com.eco_market.eco_market.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table (name = "token_activo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenActivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable=false)
    private Usuario idUsuario;

    @Column(nullable = false)
    private String token;

    @Column (nullable = false)
    private String userAgent;

    @Column (nullable = false)
    private String ipAddress;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    private Date fechaExpiracion;
}
