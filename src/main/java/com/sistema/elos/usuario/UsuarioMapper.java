package com.sistema.elos.usuario;

import com.sistema.elos.usuario.dto.CriarUsuarioRequest;
import com.sistema.elos.usuario.dto.UsuarioResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(CriarUsuarioRequest request);

    UsuarioResponse toUsuarioResponse(Usuario usuario);
}
