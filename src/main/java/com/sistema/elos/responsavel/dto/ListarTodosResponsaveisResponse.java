package com.sistema.elos.responsavel.dto;

import java.util.UUID;
import com.sistema.elos.status.Status;

public record ListarTodosResponsaveisResponse(
        UUID id,
        String nome,
        String cpf,
        String telefone,
        String email,
        Integer quantidade,
        Status status,
        Long unidadeId

) {


}
