package com.sistema.elos.historicoaluno.dto;

import com.sistema.elos.historicoaluno.CategoriaHistoricoAluno;

import java.time.Instant;

public record ListarHistoricoAlunoResponse(
        Long id,
        Instant criadoEm,
        CategoriaHistoricoAluno categoriaHistoricoAluno,
        String descricao
) {
}
