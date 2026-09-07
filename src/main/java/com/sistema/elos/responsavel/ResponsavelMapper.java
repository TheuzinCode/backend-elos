package com.sistema.elos.responsavel;


import com.sistema.elos.responsavel.dto.CriarNovoResponsavelResponse;
import com.sistema.elos.responsavel.dto.CriarNovoResponsavelResquest;
import com.sistema.elos.responsavel.dto.DetalhesResponsavelResponse;
import com.sistema.elos.responsavel.dto.ResponsavelResponseAluno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResponsavelMapper {

    ResponsavelResponseAluno toResponsavelResponseAlunoDTO(Responsavel responsavel);

    @Mapping(target = "endereco", ignore = true)
    Responsavel toEntity(CriarNovoResponsavelResquest c);

    CriarNovoResponsavelResponse toCriarNovoResponsavelResponse(Responsavel responsavel);

    DetalhesResponsavelResponse toDetalhesResponsavelResponse(Responsavel responsavel);
}
