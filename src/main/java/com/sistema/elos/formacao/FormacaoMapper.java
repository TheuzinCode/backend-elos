package com.sistema.elos.formacao;

import com.sistema.elos.formacao.dto.CriarNovaFormacaoRequest;
import com.sistema.elos.formacao.dto.CriarNovaFormacaoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FormacaoMapper {

    Formacao toEntity (CriarNovaFormacaoRequest request);

    CriarNovaFormacaoResponse toDTO (Formacao formacao);
}
