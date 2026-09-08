package com.sistema.elos.historicoaluno.dto;

import com.sistema.elos.historicoaluno.CategoriaHistoricoAluno;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastrarHistoricoAlunoRequest(

        @NotNull
        Long alunoId,

        CategoriaHistoricoAluno categoriaHistoricoAluno,

        @NotBlank
        String descricao
) {
}
