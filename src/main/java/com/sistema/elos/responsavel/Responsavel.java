package com.sistema.elos.responsavel;

import com.sistema.elos.aluno.Aluno;
import com.sistema.elos.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "responsaveis")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "CAMPO NOME OBRIGATORIO")
    private String nome;

    @NotBlank(message = "CAMPO CPF OBRIGATORIO")
    @Column(unique = true)
    private String cpf;

    @NotBlank(message = "CAMPO RG OBRIGATORIO")
    private String registroGeral;

    @NotNull(message = "CAMPO DATA DE NASCIMENTO OBRIGATORIO")
    private LocalDate dataNascimento;

    @NotBlank(message = "CAMPO GENERO OBRIGATORIO")
    private String genero;

    @NotBlank(message = "CAMPO ESTADO CIVIL OBRIGATORIO")
    private String estadoCivil;

    @NotBlank(message = "CAMPO EMAIL OBRIGATORIO")
    private String email;

    @NotBlank(message = "CAMPO TELEFONE RESIDENCIAL OBRIGATORIO")
    private String telefoneResidencial;

    @NotBlank(message = "CAMPO TELEFONE CELULAR OBRIGATORIO")
    private String telefoneCelular;

    @NotBlank(message = "CAMPO TELEFONE CELULAR 2 OBRIGATORIO")
    private String telefoneCelular2;

    @NotBlank(message = "CAMPO ESCOLARIDADE OBRIGATORIO")
    private String escolaridade;

    @Embedded
    private Endereco endereco;

    // Responsavel — lado inverso
    @OneToMany(mappedBy = "responsavel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aluno> alunos = new ArrayList<>();

    @CreationTimestamp
    private Instant criadoEm;

    @UpdateTimestamp
    private Instant atualizadoEm;


    public void adicionarAluno(Aluno aluno){
        alunos.add(aluno);
        aluno.setResponsavel(this);
    }

    public void removerAluno(Aluno aluno){
        alunos.remove(aluno);
        aluno.setResponsavel(null);
    }

}
