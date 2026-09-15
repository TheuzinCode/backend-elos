package com.sistema.elos.modulo;

import com.sistema.elos.modulo.dto.CriarNovoModuloRequest;
import com.sistema.elos.modulo.dto.CriarNovoModuloResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuloMapper {


    Modulo toEntity (CriarNovoModuloRequest criarNovoModuloRequest);

    CriarNovoModuloResponse toDTO(Modulo modulo);
}
