package com.sistema.elos.contrato.dto;

import com.sistema.elos.status.Status;
import com.sistema.elos.utils.Campanha;
import com.sistema.elos.utils.TipoContrato;

import java.time.Instant;
import java.util.UUID;

public record ListarContratoResponse(
        UUID id,
        Integer numeroContrato,
        String nomeAluno,
        String nomeResponsavel,
        TipoContrato tipoContrato,
        Status status,
        Campanha campanha,
        Instant lancado
) {
}
