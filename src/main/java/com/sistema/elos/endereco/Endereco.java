package com.sistema.elos.endereco;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Column(length = 8)
    private String cep;

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;

    @Column(length = 2)
    private String estado;

    private String complemento;
}
