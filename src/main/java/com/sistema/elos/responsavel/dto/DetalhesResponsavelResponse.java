package com.sistema.elos.responsavel.dto;

import com.sistema.elos.aluno.dto.AlunoResponseResponsavel;
import com.sistema.elos.endereco.dto.CriarEnderecoResponse;
import com.sistema.elos.status.Status;

import java.time.LocalDate;
import java.util.List;

public record DetalhesResponsavelResponse(
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
        List<AlunoResponseResponsavel> alunos,
        CriarEnderecoResponse endereco
) {
}
