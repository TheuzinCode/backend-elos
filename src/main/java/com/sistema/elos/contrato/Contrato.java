package com.sistema.elos.contrato;

import com.sistema.elos.aluno.Aluno;
import com.sistema.elos.responsavel.Responsavel;
import com.sistema.elos.status.Status;
import com.sistema.elos.usuario.Usuario;
import com.sistema.elos.utils.Campanha;
import com.sistema.elos.utils.Midia;
import com.sistema.elos.utils.TipoContrato;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "contratos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contrato {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    private Integer NumeroContrato;

    @CreationTimestamp
    private Instant criacao;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status = Status.ATIVO;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Responsavel responsavel;

    @ManyToOne
    @JoinColumn(name = "consulor_id")
    private Usuario consultor;

    @ManyToOne
    @JoinColumn(name = "geradorVisita_id")
    private Usuario geradorVisita;

    @ManyToOne
    @JoinColumn(name = "educador_id")
    private Usuario educador;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoContrato tipoContrato;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Midia midia;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Campanha campanha;



}
