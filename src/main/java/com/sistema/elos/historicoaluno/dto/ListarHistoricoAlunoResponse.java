package com.sistema.elos.historicoaluno.dto;

import com.sistema.elos.historicoaluno.CategoriaHistoricoAluno;

import java.util.UUID;
import java.time.Instant;

public record ListarHistoricoAlunoResponse(
        UUID id,
        Instant criadoEm,
        CategoriaHistoricoAluno categoriaHistoricoAluno,
        String descricao
) {
}
