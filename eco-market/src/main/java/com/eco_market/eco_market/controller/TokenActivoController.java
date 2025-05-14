package com.eco_market.eco_market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eco_market.eco_market.model.TokenActivo;
import com.eco_market.eco_market.service.TokenActivoService;

@RestController
@RequestMapping("api/v1/token_activos")
public class TokenActivoController {

    @Autowired
    private TokenActivoService tokenActivoService;

    @GetMapping
    public ResponseEntity<List<TokenActivo>> lsitar(){
        List <TokenActivo> tokensActivos = tokenActivoService.findAll();
        if (tokensActivos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tokensActivos)
    }

    @PostMapping
    public ResponseEntity<TokenActivo> guardar (@RequestBody TokenActivo token){
        TokenActivo tokenNuevo = tokenActivoService.save(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(tokenNuevo)
    }

    @GetMapping("/{id}")
    public ResponseEntity<TokenActivo> buscar (@PathVariable Integer id){
        try{
            TokenActivo token = tokenActivoService.findById(id);
            return ResponseEntity.ok(token);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TokenActivo> actualizar(@PathVariable Long id, @RequestBody TokenActivo token){
        try{
            TokenActivo tok = tokenActivoService.findById(id);
            tok.setId(id);
            tok.setIdUsuario(token.getIdUsuario());
            tok.setToken(token.getToken());
            tok.setIpAddress(token.getIpAddress());
            tok.setUserAgent(token.getUserAgent());
            tok.setFechaCreacion(token.getFechaCreacion());
            tok.setFechaExpiracion(token.getFechaExpiracion());
            tokenActivoService.save(tok);
            return ResponseEntity.ok(tok);

        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar (@PathVariable Long id){
        try{
            tokenActivoService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
