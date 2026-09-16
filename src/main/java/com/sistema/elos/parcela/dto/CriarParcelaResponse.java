package com.sistema.elos.parcela.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CriarParcelaResponse(
        Long alunoId,
        Integer quantidadeParcelas,
        BigDecimal valorParcela,
        BigDecimal valorTotal,
        LocalDate primeiroVencimento,
        LocalDate ultimoVencimento,
        String mensagem
) {
}
