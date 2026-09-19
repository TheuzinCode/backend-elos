package com.sistema.elos.contas.dto;

import com.sistema.elos.contas.StatusConta;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ListarContaPagarResponse(
        Long id,
        String categoria,
        BigDecimal valorPagar,
        LocalDate dataVencimento,
        BigDecimal valorPago,
        LocalDate dataPagamento,
        StatusConta statusConta
) {
}
