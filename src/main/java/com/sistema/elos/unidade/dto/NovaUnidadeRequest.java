package com.sistema.elos.unidade.dto;

import jakarta.validation.constraints.NotBlank;

public record NovaUnidadeRequest(

        @NotBlank
        String nome,
        @NotBlank
        String cnpj
) {
}
