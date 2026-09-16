package com.sistema.elos.usuario.dto;

import com.sistema.elos.endereco.Endereco;
import com.sistema.elos.utils.Cargo;
import com.sistema.elos.utils.Genero;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CriarUsuarioRequest(
        @NotBlank
        String nome,

        @NotBlank
        String cpf,

        String rg,

        @NotBlank
        String email,

        @NotNull
        Genero genero,

        @NotNull
        Cargo cargo,

        @NotBlank
        String escolaridade,

        LocalDate dataNascimento,

        LocalDate dataDemissao,

        LocalDate dataAdmissao,

        @NotBlank
        String telefone1,

        @NotBlank
        String telefone2,

        @NotBlank
        String senha,

        @Embedded
        Endereco endereco,

        Long unidadeId
) {
}
