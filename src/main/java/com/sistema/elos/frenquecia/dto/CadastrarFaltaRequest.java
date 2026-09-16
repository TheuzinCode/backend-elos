package com.sistema.elos.frenquecia.dto;

import com.sistema.elos.frenquecia.TipoFrequencia;

import java.util.UUID;
import java.time.LocalDate;

public record CadastrarFaltaRequest(
        UUID alunoId,
        LocalDate data,
        TipoFrequencia tipoFrenquencia,
        String observacao
) {
}
