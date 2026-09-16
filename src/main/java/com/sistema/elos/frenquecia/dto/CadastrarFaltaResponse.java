package com.sistema.elos.frenquecia.dto;

import com.sistema.elos.frenquecia.TipoFrequencia;

import java.util.UUID;
import java.time.Instant;
import java.time.LocalDate;

public record CadastrarFaltaResponse(
        UUID id,
        LocalDate data,
        TipoFrequencia tipoFrenquencia,
        String observacao,
        Instant registradoEm
) {
}
