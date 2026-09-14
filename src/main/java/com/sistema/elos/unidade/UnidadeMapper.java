package com.sistema.elos.unidade;

import com.sistema.elos.unidade.dto.NovaUnidadeRequest;
import com.sistema.elos.unidade.dto.NovaUnidadeResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UnidadeMapper {

    Unidade toEntity (NovaUnidadeRequest unidade);

    NovaUnidadeResponse toDto(Unidade unidade);
}
