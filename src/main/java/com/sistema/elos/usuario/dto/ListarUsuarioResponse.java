package com.sistema.elos.usuario.dto;

import com.sistema.elos.utils.Cargo;

import java.time.LocalDate;
import java.util.UUID;

public record ListarUsuarioResponse(
        UUID id,
        String nome,
        Cargo cargo,
        String telefone,
        String email,
        LocalDate dataAdmissao

) {
}
