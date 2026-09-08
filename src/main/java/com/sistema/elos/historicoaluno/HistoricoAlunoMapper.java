package com.sistema.elos.historicoaluno;

import com.sistema.elos.historicoaluno.dto.CadastrarHistoricoAlunoRequest;
import com.sistema.elos.historicoaluno.dto.CadastrarHistoricoAlunoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistoricoAlunoMapper {


    HistoricoAluno toEntity(CadastrarHistoricoAlunoRequest r);

    CadastrarHistoricoAlunoResponse toCadastrarHistoricoAlunoResponse(HistoricoAluno h);
}
