package com.sistema.elos.aluno.dto;

import com.sistema.elos.status.Status;

import java.util.UUID;
import java.time.Instant;

public record ListarAlunosResponse(
        UUID id,
        String nome,
        String nomeResponsavel,
        String telefoneCelular,
        String email,
        Status status,
        Instant criadoEm,
        Long unidadeId

) {
}
