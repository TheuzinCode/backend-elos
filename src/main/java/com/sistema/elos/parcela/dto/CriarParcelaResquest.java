package com.sistema.elos.parcela.dto;

import com.sistema.elos.parcela.parcelasEnuns.TipoParcela;

import java.util.UUID;
import java.math.BigDecimal;
import java.time.LocalDate;

public record CriarParcelaResquest(
        UUID alunoId,
        Integer quantidade,
        TipoParcela tipoParcela,
        LocalDate dataVencimento,
        BigDecimal valor
        ) {
}
