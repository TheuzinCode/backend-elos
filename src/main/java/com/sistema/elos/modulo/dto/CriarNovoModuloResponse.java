package com.sistema.elos.modulo.dto;

import java.util.UUID;

public record CriarNovoModuloResponse(
        UUID id,
        String nome,
        Integer aulas
) {
}
