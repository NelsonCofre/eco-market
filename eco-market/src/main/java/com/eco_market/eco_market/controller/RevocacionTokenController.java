package com.eco_market.eco_market.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eco_market.eco_market.model.RevocacionToken;
import com.eco_market.eco_market.service.RevocacionTokenService;

@RestController
@RequestMapping("api/v1/revocacion_tokens")
public class RevocacionTokenController {

    @Autowired
    private RevocacionTokenService revocacionTokenService;

    @GetMapping
    public ResponseEntity<List<RevocacionToken>> listar(){
        List<RevocacionToken> revocaciones = revocacionTokenService.findAll();
        if (revocaciones.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(revocaciones);
    }

    @PostMapping
    public ResponseEntity<RevocacionToken> guardar (@RequestBody RevocacionToken revocacionToken){
        RevocacionToken revocacion = revocacionTokenService.save(revocacionToken);
        return ResponseEntity.status(HttpStatus.CREATED).body(revocacion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RevocacionToken> buscar (@PathVariable Long id){
        try{
            RevocacionToken revocacionToken = revocacionTokenService.findById(id);
            return ResponseEntity.ok(revocacionToken);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RevocacionToken> actualizar (@PathVariable Long id, @RequestBody RevocacionToken revocacionToken){
        try{
            RevocacionToken revocacion = revocacionTokenService.findById(id);
            revocacion.setId(id);
            revocacion.setIdTokenActivo(revocacionToken.getIdTokenActivo());
            revocacion.setRazon(revocacionToken.getRazon());
            revocacion.setFechaRevocacion(revocacionToken.getFechaRevocacion());

            revocacionTokenService.save(revocacion);
            return ResponseEntity.ok(revocacionToken);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }  
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> elminar(@PathVariable Long id){
        try{
            revocacionTokenService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
