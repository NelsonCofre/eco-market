package com.eco_market.eco_market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eco_market.eco_market.model.RevocacionToken;


public interface RevocacionTokenRepository extends JpaRepository<RevocacionToken, Long>{

}
