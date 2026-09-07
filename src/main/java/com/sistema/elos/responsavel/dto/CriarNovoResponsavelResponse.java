package com.sistema.elos.responsavel.dto;

import com.sistema.elos.endereco.dto.CriarEnderecoResponse;

import java.time.LocalDate;

public record CriarNovoResponsavelResponse(
        Long id,
        String nome,
        String cpf,
        String registroGeral,
        LocalDate dataNascimento,
        String genero,
        String estadoCivil,
        String email,
        String telefoneResidencial,
        String telefoneCelular,
        String telefoneCelular2,
        String escolaridade,
        CriarEnderecoResponse endereco
) {
}
