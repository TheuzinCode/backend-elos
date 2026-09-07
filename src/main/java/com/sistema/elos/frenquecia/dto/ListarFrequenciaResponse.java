package com.sistema.elos.frenquecia.dto;

import com.sistema.elos.aluno.Aluno;
import com.sistema.elos.frenquecia.TipoFrequencia;

import java.time.Instant;
import java.time.LocalDate;

public record ListarFrequenciaResponse(
        Long id,
        LocalDate data,
        TipoFrequencia tipoFrenquencia,
        String observacao,
        Instant registradoEm
) {
}
