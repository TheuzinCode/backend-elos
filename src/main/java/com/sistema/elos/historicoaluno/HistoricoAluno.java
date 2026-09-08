package com.sistema.elos.historicoaluno;

import com.sistema.elos.aluno.Aluno;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "historico_aluno")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoAluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Instant criadoEm;

    @Enumerated(EnumType.STRING)
    private CategoriaHistoricoAluno categoriaHistoricoAluno;

    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;



}
