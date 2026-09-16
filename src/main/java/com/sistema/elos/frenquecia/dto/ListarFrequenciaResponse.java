package com.sistema.elos.frenquecia.dto;

import com.sistema.elos.aluno.Aluno;
import com.sistema.elos.frenquecia.TipoFrequencia;

import java.util.UUID;
import java.time.Instant;
import java.time.LocalDate;

public record ListarFrequenciaResponse(
        UUID id,
        LocalDate data,
        TipoFrequencia tipoFrenquencia,
        String observacao,
        Instant registradoEm
) {
}
