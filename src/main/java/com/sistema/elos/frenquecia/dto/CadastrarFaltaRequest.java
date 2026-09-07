package com.sistema.elos.frenquecia.dto;

import com.sistema.elos.frenquecia.TipoFrequencia;

import java.time.LocalDate;

public record CadastrarFaltaRequest(
        Long alunoId,
        LocalDate data,
        TipoFrequencia tipoFrenquencia,
        String observacao
) {
}
