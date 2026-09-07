package com.sistema.elos.endereco;

import com.sistema.elos.endereco.dto.CriarEnderecoRequest;
import com.sistema.elos.endereco.dto.CriarEnderecoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    Endereco toEntity(CriarEnderecoRequest criarEnderecoRequest);

    CriarEnderecoResponse toCriarEnderecoResponseDTO(Endereco endereco);
}
