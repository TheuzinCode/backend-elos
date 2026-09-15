package com.sistema.elos.modulo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarNovoModuloRequest(

        @NotBlank
        String nome,

        @NotNull
        Integer aulas
) {
}
