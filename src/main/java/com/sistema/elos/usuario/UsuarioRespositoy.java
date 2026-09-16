package com.sistema.elos.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRespositoy extends JpaRepository<Usuario, UUID> {
}
