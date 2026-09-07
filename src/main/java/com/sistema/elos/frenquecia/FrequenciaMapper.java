package com.sistema.elos.frenquecia;

import com.sistema.elos.frenquecia.dto.CadastrarFaltaRequest;
import com.sistema.elos.frenquecia.dto.CadastrarFaltaResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FrequenciaMapper {

    Frequencia toEntity(CadastrarFaltaRequest cadastrarFaltaRequest);

    CadastrarFaltaResponse toCadastrarFaltaResponse(Frequencia frequencia);
}
