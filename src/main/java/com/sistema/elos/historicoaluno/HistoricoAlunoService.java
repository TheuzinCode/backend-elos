package com.sistema.elos.historicoaluno;


import com.sistema.elos.aluno.Aluno;
import com.sistema.elos.aluno.AlunoRepository;
import com.sistema.elos.configuracao.BusinessException;
import com.sistema.elos.historicoaluno.dto.CadastrarHistoricoAlunoRequest;
import com.sistema.elos.historicoaluno.dto.CadastrarHistoricoAlunoResponse;
import com.sistema.elos.historicoaluno.dto.ListarHistoricoAlunoResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HistoricoAlunoService {


    private HistoricoAlunoRepository historicoAlunoRepository;
    private HistoricoAlunoMapper historicoAlunoMapper;
    private AlunoRepository alunoRepository;


    public CadastrarHistoricoAlunoResponse cadastrarHistoricoAluno(CadastrarHistoricoAlunoRequest request){
        Aluno aluno =  alunoRepository.findById(request.alunoId())
                .orElseThrow(() -> new BusinessException("ALUNO NÃO ENCONTRADO"));

        HistoricoAluno historicoAluno = historicoAlunoMapper.toEntity(request);

        historicoAluno.setAluno(aluno);

        HistoricoAluno historicoAlunoSalvo = historicoAlunoRepository.save(historicoAluno);

        return historicoAlunoMapper.toCadastrarHistoricoAlunoResponse(historicoAlunoSalvo);
    }

    public List<ListarHistoricoAlunoResponse> listarHistoricoPorAluno(Long alunoId){

        List<HistoricoAluno> listaHistoricoAluno = historicoAlunoRepository.findByAlunoId(alunoId);

        return listaHistoricoAluno.stream().map(lista -> new ListarHistoricoAlunoResponse(
                lista.getId(),
                lista.getCriadoEm(),
                lista.getCategoriaHistoricoAluno(),
                lista.getDescricao()
        )).toList();


    }


}
