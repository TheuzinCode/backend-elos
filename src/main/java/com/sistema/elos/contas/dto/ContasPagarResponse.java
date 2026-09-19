package com.sistema.elos.contas.dto;

import com.sistema.elos.contas.StatusConta;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ContasPagarResponse(
        Long id,
        String categoria,
        BigDecimal valorPagar,
        LocalDate dataVencimento,
        StatusConta statusConta,
        String confirmacao

) {
}
