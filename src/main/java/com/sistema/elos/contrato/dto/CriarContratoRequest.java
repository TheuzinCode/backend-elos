package com.sistema.elos.contrato.dto;

import com.sistema.elos.status.Status;
import com.sistema.elos.utils.Campanha;
import com.sistema.elos.utils.Midia;
import com.sistema.elos.utils.TipoContrato;

import java.util.UUID;

public record CriarContratoRequest(
        Status status,
        UUID alunoId,
        UUID responsavelId,
        UUID consultorId,
        UUID geradorVisitaId,
        UUID educadorId,
        TipoContrato tipoContrato,
        Midia midia,
        Campanha campanha
) {
}
