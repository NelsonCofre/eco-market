package com.eco_market.eco_market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eco_market.eco_market.model.RevocacionToken;
import com.eco_market.eco_market.repository.RevocacionTokenRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RevocacionTokenService {
    @Autowired
    private RevocacionTokenRepository revocacionTokenRepository;

    public List<RevocacionToken> findAll(){
        return revocacionTokenRepository.findAll();
    }

    public RevocacionToken findById(Long id){
        return revocacionTokenRepository.findById(id).get();
    }

    public RevocacionToken save(RevocacionToken revocacionToken){
        return revocacionTokenRepository.save(revocacionToken);
    }

    public void delete(Long id){
        revocacionTokenRepository.deleteById(id);
    }
}
