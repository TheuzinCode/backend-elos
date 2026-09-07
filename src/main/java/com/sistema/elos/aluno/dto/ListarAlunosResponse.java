package com.sistema.elos.aluno.dto;

import com.sistema.elos.status.Status;

import java.time.Instant;

public record ListarAlunosResponse(
        Long id,
        String nome,
        String nomeResponsavel,
        String telefoneCelular,
        String email,
        Status status,
        Instant criadoEm

) {
}
