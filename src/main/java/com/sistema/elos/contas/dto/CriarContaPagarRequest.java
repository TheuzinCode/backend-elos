package com.sistema.elos.contas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CriarContaPagarRequest(

        @NotBlank
        String categoria,

        @NotNull
        BigDecimal valorPagar,

        @NotNull
        LocalDate dataVencimento
) {
}
