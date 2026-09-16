package com.sistema.elos.formacao.dto;

import com.sistema.elos.formacao.StatusFormacao;
import com.sistema.elos.modulo.Modulo;

import java.util.UUID;
import java.util.List;

public record CriarNovaFormacaoResponse(

        UUID id,
        String nome,
        StatusFormacao status,
        Integer aulasRealizada,
        List<Modulo> modulos
) {
}
