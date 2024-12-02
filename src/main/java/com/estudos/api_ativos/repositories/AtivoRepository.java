package com.estudos.api_ativos.repositories;

import com.estudos.api_ativos.entity.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AtivoRepository extends JpaRepository<Ativo, UUID> {
    Optional<Ativo> findBySerialNumber(String serialNumber);
    Optional<Ativo> findByAssetNumber(String assetNumber);
}
