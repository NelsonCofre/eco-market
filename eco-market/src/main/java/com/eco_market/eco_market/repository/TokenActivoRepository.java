package com.eco_market.eco_market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eco_market.eco_market.model.RevocacionToken;
import com.eco_market.eco_market.model.TokenActivo;

public interface TokenActivoRepository extends JpaRepository<TokenActivo, Long>{

}
