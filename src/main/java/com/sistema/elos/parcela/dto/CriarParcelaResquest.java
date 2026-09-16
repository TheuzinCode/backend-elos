package com.sistema.elos.parcela.dto;

import com.sistema.elos.parcela.parcelasEnuns.TipoParcela;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CriarParcelaResquest(
        Long alunoId,
        Integer quantidade,
        TipoParcela tipoParcela,
        LocalDate dataVencimento,
        BigDecimal valor
        ) {
}
