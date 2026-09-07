package com.sistema.elos.endereco.dto;

public record CriarEnderecoResponse(
        String cep,
        String rua,
        String numero,
        String bairro,
        String estado,
        String cidade,
        String complemento
) {
}
