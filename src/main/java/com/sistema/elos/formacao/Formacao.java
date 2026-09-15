package com.sistema.elos.formacao;

import com.sistema.elos.modulo.Modulo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "formacoes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Formacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private StatusFormacao status;

    private Integer aulasRealizada;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "formacao_e_modulo",
            joinColumns = @JoinColumn(name = "formacaoId"),
            inverseJoinColumns  = @JoinColumn(name = "moduloId")
    )
    private List<Modulo> modulos = new ArrayList<>();

}
