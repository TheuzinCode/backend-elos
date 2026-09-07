package com.sistema.elos.aluno;

import com.sistema.elos.aluno.dto.CriarNovoAlunoRequest;
import com.sistema.elos.aluno.dto.CriarNovoAlunoResponse;
import com.sistema.elos.aluno.dto.DetalhesAlunosResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface AlunoMapper {

    @Mapping(target = "responsavel", ignore = true)
    @Mapping(target = "endereco", ignore = true)
    Aluno toEntity(CriarNovoAlunoRequest request);


    CriarNovoAlunoResponse toResponseDTO(Aluno aluno);

    DetalhesAlunosResponse toDetalhesAlunosResponseDTO(Aluno aluno);

}
