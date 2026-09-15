package com.sistema.elos.modulo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "modulos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O CAMPO NOME OBRIGATORIO")
    private String nome;

    @NotNull(message = "O CAMPO AULAS OBRIGATORIO")
    private Integer aulas;

}
