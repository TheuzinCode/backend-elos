package com.sistema.elos.historicoaluno.dto;

import java.util.UUID;
import com.sistema.elos.historicoaluno.CategoriaHistoricoAluno;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastrarHistoricoAlunoRequest(

        @NotNull
        UUID alunoId,

        CategoriaHistoricoAluno categoriaHistoricoAluno,

        @NotBlank
        String descricao
) {
}
