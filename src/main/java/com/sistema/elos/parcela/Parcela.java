package com.sistema.elos.parcela;

import com.sistema.elos.aluno.Aluno;
import com.sistema.elos.parcela.parcelasEnuns.FormaPagamento;
import com.sistema.elos.parcela.parcelasEnuns.TipoParcela;
import com.sistema.elos.unidade.Unidade;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "parcelas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parcela {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private TipoParcela tipoParcela;


    private LocalDate dataVencimento;

    @NotNull(message = "CAMPO VALOR PARCELA OBRIGATORIO")
    private BigDecimal valor;


    private LocalDate dataPagamento;


    private BigDecimal valorPago;

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;


}
