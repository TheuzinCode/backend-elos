package com.sistema.elos.formacao.dto;

import com.sistema.elos.formacao.StatusFormacao;
import com.sistema.elos.modulo.Modulo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CriarNovaFormacaoRequest(

        @NotBlank
        String nome,

        StatusFormacao status,

        @NotNull
        Integer aulasRealizada,

        @NotEmpty
        List<Modulo> modulos
) {
}
