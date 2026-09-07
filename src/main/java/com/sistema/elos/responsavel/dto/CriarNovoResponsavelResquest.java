package com.sistema.elos.responsavel.dto;

import com.sistema.elos.endereco.dto.CriarEnderecoRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CriarNovoResponsavelResquest(

        @NotBlank(message = "CAMPO NOME OBRIGATORIO")
        String nome,

        @NotBlank(message = "CAMPO CPF OBRIGATORIO")
        String cpf,

        @NotBlank(message = "CAMPO RG OBRIGATORIO")
        String registroGeral,

        @NotNull(message = "CAMPO DATA DE NASCIMENTO OBRIGATORIO")
        LocalDate dataNascimento,

        @NotBlank(message = "CAMPO GENERO OBRIGATORIO")
        String genero,

        @NotBlank(message = "CAMPO ESTADO CIVIL OBRIGATORIO")
        String estadoCivil,

        @NotBlank(message = "CAMPO EMAIL OBRIGATORIO")
        String email,

        @NotBlank(message = "CAMPO TELEFONE RESIDENCIAL OBRIGATORIO")
        String telefoneResidencial,

        @NotBlank(message = "CAMPO TELEFONE CELULAR OBRIGATORIO")
        String telefoneCelular,

        @NotBlank(message = "CAMPO TELEFONE CELULAR 2 OBRIGATORIO")
        String telefoneCelular2,

        @NotBlank(message = "CAMPO ESCOLARIDADE OBRIGATORIO")
        String escolaridade,

        CriarEnderecoRequest endereco
) {
}
