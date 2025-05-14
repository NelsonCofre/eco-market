package com.eco_market.eco_market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eco_market.eco_market.model.TokenActivo;
import com.eco_market.eco_market.repository.TokenActivoRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class TokenActivoService {

    @Autowired
    private TokenActivoRepository tokenActivoRepository;

    public List<TokenActivo> findAll(){
        return tokenActivoRepository.findAll();
    }

    public TokenActivo findById(long id){
        return tokenActivoRepository.findById(id).get();
    }

    public TokenActivo save(TokenActivo token){
        return tokenActivoRepository.save(token);
    }

    public void delete (long id){
        tokenActivoRepository.deleteById(id);
    }

}
