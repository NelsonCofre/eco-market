package com.eco_market.eco_market.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table (name = "revocacion_tokens")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevocacionToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_token", nullable=false)
    private TokenActivo idTokenActivo;

    @Column (nullable = false)
    private String razon;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRevocacion;
}
