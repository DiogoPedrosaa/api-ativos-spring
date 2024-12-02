package com.estudos.api_ativos.service;

import com.estudos.api_ativos.entity.Ativo;
import com.estudos.api_ativos.exception.ResourceNotFoundException;
import com.estudos.api_ativos.repositories.AtivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AtivoService {

    @Autowired
    private AtivoRepository ativoRepository;


    public List<Ativo> listAll(){
        return ativoRepository.findAll();
    }

    public Ativo findById(UUID id) {
        return ativoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ativo with ID: " + id + " not found"));
    }


    @Transactional
    public Ativo createAtivo(Ativo ativo){
        return ativoRepository.save(ativo);
    }

    @Transactional
    public Ativo updateAtivo(UUID id, Ativo ativo){
        Ativo existingAtivo = ativoRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Ativo with the ID :"  + id + " not found."));

        existingAtivo.setManufacturer(ativo.getManufacturer());
        existingAtivo.setDateUpdate(ativo.getDateUpdate());
        existingAtivo.setDepartment(ativo.getDepartment());
        existingAtivo.setSerialNumber(ativo.getSerialNumber());
        existingAtivo.setAssetNumber(ativo.getAssetNumber());

        return ativoRepository.save(existingAtivo);
    }

    @Transactional
    public Ativo deleteAtivo(UUID id) {
        return ativoRepository.findById(id)
                .map(ativo -> {
                    ativoRepository.deleteById(id);
                    return ativo;
                })
                .orElseThrow(() -> new IllegalArgumentException("Ativo with the ID: " + id + " not found."));
    }
}

