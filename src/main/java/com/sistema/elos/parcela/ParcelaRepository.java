package com.sistema.elos.parcela;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParcelaRepository extends JpaRepository<Parcela, UUID> {
}
