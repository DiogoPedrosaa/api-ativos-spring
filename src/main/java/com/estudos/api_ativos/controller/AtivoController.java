package com.estudos.api_ativos.controller;


import com.estudos.api_ativos.dto.AtivoDTO;
import com.estudos.api_ativos.entity.Ativo;
import com.estudos.api_ativos.service.AtivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ativos")
public class AtivoController {

    @Autowired
    private AtivoService ativoService;

    @GetMapping
    public ResponseEntity<List<Ativo>> getAllAtivos(){
        List<Ativo> ativos = ativoService.listAll();
        return new ResponseEntity<>(ativos, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Ativo> getAtivoById(@PathVariable UUID id){
        Ativo ativo = ativoService.findById(id);
        return new ResponseEntity<>(ativo, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Ativo> createAtivo(@RequestBody Ativo ativo){
        Ativo createdAtivo = ativoService.createAtivo(ativo);
        return new ResponseEntity<>(createdAtivo, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Ativo> updateAtivo(@PathVariable UUID id, @RequestBody Ativo ativo){
        Ativo updatedAtivo = ativoService.updateAtivo(id, ativo);
        return new ResponseEntity<>(updatedAtivo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtivo(@PathVariable UUID id) {
        ativoService.deleteAtivo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
