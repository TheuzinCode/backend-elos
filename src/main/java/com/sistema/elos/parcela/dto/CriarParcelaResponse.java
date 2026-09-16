package com.sistema.elos.parcela.dto;

import java.util.UUID;
import java.math.BigDecimal;
import java.time.LocalDate;

public record CriarParcelaResponse(
        UUID alunoId,
        Integer quantidadeParcelas,
        BigDecimal valorParcela,
        BigDecimal valorTotal,
        LocalDate primeiroVencimento,
        LocalDate ultimoVencimento,
        String mensagem
) {
}
