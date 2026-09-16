package com.sistema.elos.usuario;

import com.sistema.elos.endereco.Endereco;
import com.sistema.elos.unidade.Unidade;
import com.sistema.elos.utils.Cargo;
import com.sistema.elos.utils.Genero;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "CAMPO NOME OBRIGATORIO")
    private String nome;

    @NotBlank(message = "CAMPO CPF OBRIGATORIO")
    private String cpf;

    private String rg;

    @NotBlank(message = "CAMPO EMAIL OBRIGATORIO")
    private String email;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @NotBlank(message = "CAMPO ESCOLARIDADE OBRIGATORIO")
    private String escolaridade;

    private LocalDate dataNascimento;

    private LocalDate dataDemissao;

    private LocalDate dataAdmissao;

    @NotBlank(message = "CAMPO TELEFONE 1 OBRIGATORIO")
    private String telefone1;

    @NotBlank(message = "CAMPO TELEFONE 2 OBRIGATORIO")
    private String telefone2;

    private String login;

    @NotBlank(message = "CAMPO SENHA OBRIGATORIO")
    private String senha;

    @Embedded
    private Endereco endereco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;



}
