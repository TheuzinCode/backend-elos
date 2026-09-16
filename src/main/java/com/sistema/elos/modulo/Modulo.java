package com.sistema.elos.modulo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema.elos.formacao.Formacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "modulos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O CAMPO NOME OBRIGATORIO")
    private String nome;

    @NotNull(message = "O CAMPO AULAS OBRIGATORIO")
    private Integer aulas;

    @ManyToMany(mappedBy = "modulos")
    @JsonIgnore
    private List<Formacao> formacao = new ArrayList<>();

}
