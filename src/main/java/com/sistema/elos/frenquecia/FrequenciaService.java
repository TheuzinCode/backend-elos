package com.sistema.elos.frenquecia;

import com.sistema.elos.aluno.Aluno;
import com.sistema.elos.aluno.AlunoRepository;
import com.sistema.elos.configuracao.BusinessException;
import com.sistema.elos.frenquecia.dto.CadastrarFaltaRequest;
import com.sistema.elos.frenquecia.dto.CadastrarFaltaResponse;
import com.sistema.elos.frenquecia.dto.ListarFrequenciaResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FrequenciaService {

    private FrequenciaMapper frequenciaMapper;
    private FrequenciaRepository repository;
    private AlunoRepository alunoRepository;

    public List<ListarFrequenciaResponse> listarFrequenciaPorAluno(Long alunoId){

        List<Frequencia> frequencias = repository.findByAlunoId(alunoId);

        return frequencias.stream().map(frequencia -> new ListarFrequenciaResponse(
                frequencia.getId(),
                frequencia.getData(),
                frequencia.getTipoFrenquencia(),
                frequencia.getObservacao(),
                frequencia.getRegistradoEm()
        )).toList();
    }

    public CadastrarFaltaResponse cadastrarFalta(CadastrarFaltaRequest request){

        Aluno aluno = alunoRepository.findById(request.alunoId())
                .orElseThrow(() -> new BusinessException("ALUNO NÃO ENCONTRADO"));

        Frequencia frequencia = frequenciaMapper.toEntity(request);

        frequencia.setAluno(aluno);

        Frequencia frequenciaSalva = repository.save(frequencia);

        return frequenciaMapper.toCadastrarFaltaResponse(frequenciaSalva);


    }


}
