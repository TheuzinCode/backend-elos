package com.sistema.elos.contas;

import com.sistema.elos.contas.dto.CriarContaPagarRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContasPagarMapper {

    ContasPagar toEntity(CriarContaPagarRequest r);

}
