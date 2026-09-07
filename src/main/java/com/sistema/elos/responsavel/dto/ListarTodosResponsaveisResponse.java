package com.sistema.elos.responsavel.dto;

import com.sistema.elos.status.Status;

public record ListarTodosResponsaveisResponse(
        Long id,
        String nome,
        String cpf,
        String telefone,
        String email,
        Integer quantidade,
        Status status

) {


}
