package com.sistema.elos.formacao;

import com.sistema.elos.aluno.Aluno;
import com.sistema.elos.aluno.AlunoRepository;
import com.sistema.elos.configuracao.BusinessException;
import com.sistema.elos.formacao.dto.CriarNovaFormacaoRequest;
import com.sistema.elos.formacao.dto.CriarNovaFormacaoResponse;
import com.sistema.elos.formacao.dto.ListaFormacoes;
import com.sistema.elos.modulo.Modulo;
import com.sistema.elos.modulo.ModuloRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FormacaoService {

    private ModuloRepository moduloRepository;
    private FormacaoRepository formacaoRepository;
    private FormacaoMapper mapper;
    private AlunoRepository alunoRepository;


    public CriarNovaFormacaoResponse criarNovaFormacao (CriarNovaFormacaoRequest request){

        Aluno aluno = alunoRepository.findById(request.alunoId())
                .orElseThrow(() -> new BusinessException(" ALUNO NÃO ENCONTRADO "));

        Formacao formacao = mapper.toEntity(request);


        List<Modulo> moduloList = new ArrayList<>();

        if (request.modulos() != null){
            for (Modulo moduloDoDto : request.modulos()){
                Modulo modulo = moduloRepository.findById(moduloDoDto.getId())
                        .orElseThrow(() -> new BusinessException("ERRO AO ENCONTRAR MODULO"));
                moduloList.add(modulo);
            }
        }

        formacao.setModulos(moduloList);

        formacao.setAluno(aluno);

        Formacao formacaoSalva = formacaoRepository.save(formacao);

        List<Formacao> formacoes = new ArrayList<>();

        formacoes.add(formacaoSalva);

        aluno.setFormacoes(formacoes);

        return mapper.toDTO(formacaoSalva);
    }


    public List<ListaFormacoes> listarFormacoesAluno(Long id){

        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new BusinessException("ALUNO NÃO ENCONTRADO"));

        List<Formacao> listaFormacao = aluno.getFormacoes();

        return listaFormacao.stream().map(formacao -> new ListaFormacoes(
                formacao.getId(),
                formacao.getNome(),
                formacao.getStatus(),
                formacao.getAulasRealizada(),
                formacao.getModulos()
        )).toList();
    }

}
