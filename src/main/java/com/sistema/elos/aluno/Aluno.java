package com.sistema.elos.aluno;

import com.sistema.elos.endereco.Endereco;
import com.sistema.elos.frenquecia.Frequencia;
import com.sistema.elos.responsavel.Responsavel;
import com.sistema.elos.status.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "alunos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "CAMPO STATUS OBRIGATORIO")
    @Enumerated(EnumType.STRING)
    private Status status;

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

    @Email
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsavel_id")
    private Responsavel responsavel;

    @CreationTimestamp
    private Instant criadoEm;

    @UpdateTimestamp
    private Instant atualizadoEm;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
    private List<Frequencia> frequencias = new ArrayList<>();

}

