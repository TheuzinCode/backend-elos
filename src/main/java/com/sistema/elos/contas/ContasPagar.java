package com.sistema.elos.contas;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "contas_a_pagar")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContasPagar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "CAMPO CATEGORIA OBRIGATORIO")
    private String categoria;

    @NotNull(message = "CAMPO VALOR A PAGAR OBRIGATORIO")
    private BigDecimal valorPagar;

    @NotNull(message = "CAMPO DATA VENCIMENTO OBRIGATORIO")
    private LocalDate dataVencimento;


    private BigDecimal valorPago;


    private LocalDate dataPagamento;


    private StatusConta statusConta = StatusConta.PENDENTE;

}
