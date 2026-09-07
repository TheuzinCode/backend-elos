package com.sistema.elos.aluno.dto;

import com.sistema.elos.endereco.dto.CriarEnderecoResponse;
import com.sistema.elos.responsavel.dto.ResponsavelResponseAluno;
import com.sistema.elos.status.Status;

import java.time.LocalDate;

public record CriarNovoAlunoResponse(
        Long id,
        Status status,
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
        ResponsavelResponseAluno responsavel,
        CriarEnderecoResponse endereco
) {
}
