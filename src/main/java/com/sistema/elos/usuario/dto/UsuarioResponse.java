package com.sistema.elos.usuario.dto;

import com.sistema.elos.endereco.Endereco;
import com.sistema.elos.utils.Cargo;
import com.sistema.elos.utils.Genero;
import java.time.LocalDate;
import java.util.UUID;

public record UsuarioResponse(
        UUID id,
        String nome,
        String cpf,
        String rg,
        String email,
        Genero genero,
        Cargo cargo,
        String escolaridade,
        LocalDate dataNascimento,
        LocalDate dataDemissao,
        LocalDate dataAdmissao,
        String telefone1,
        String telefone2,
        String login,
        String senha,
        Endereco endereco
) {
}
