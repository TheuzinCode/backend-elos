package com.sistema.elos.contrato.dto;

import com.sistema.elos.aluno.Aluno;
import com.sistema.elos.responsavel.Responsavel;
import com.sistema.elos.status.Status;
import com.sistema.elos.usuario.Usuario;
import com.sistema.elos.utils.Campanha;
import com.sistema.elos.utils.Midia;
import com.sistema.elos.utils.TipoContrato;

import java.time.Instant;
import java.util.UUID;

public record ContratoResponse(
        UUID id,
        Integer NumeroContrato,
        Instant criacao,
        Status status,
        String aluno,
        String responsavel,
        String consultor,
        String geradorVisita,
        String educador,
        TipoContrato tipoContrato,
        Midia midia,
        Campanha campanha
) {
}
