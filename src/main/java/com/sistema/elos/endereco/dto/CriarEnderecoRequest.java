package com.sistema.elos.endereco.dto;

import jakarta.validation.constraints.NotBlank;

public record CriarEnderecoRequest(
        @NotBlank
        String cep,

        @NotBlank
        String rua,

        @NotBlank
        String numero,

        @NotBlank
        String bairro,

        @NotBlank
        String estado,

        @NotBlank
        String cidade,

        String complemento

) {
}
