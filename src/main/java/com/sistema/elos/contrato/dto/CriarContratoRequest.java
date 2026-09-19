package com.sistema.elos.contrato.dto;

import com.sistema.elos.status.Status;
import com.sistema.elos.utils.Campanha;
import com.sistema.elos.utils.Midia;
import com.sistema.elos.utils.TipoContrato;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CriarContratoRequest(

        @NotNull
        UUID alunoId,

        @NotNull
        UUID responsavelId,

        @NotNull
        UUID consultorId,

        @NotNull
        UUID geradorVisitaId,

        @NotNull
        UUID educadorId,

        @NotNull
        TipoContrato tipoContrato,

        @NotNull
        Midia midia,

        @NotNull
        Campanha campanha
) {
}
