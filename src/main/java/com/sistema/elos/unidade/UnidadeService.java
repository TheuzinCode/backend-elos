package com.sistema.elos.unidade;

import com.sistema.elos.unidade.dto.NovaUnidadeRequest;
import com.sistema.elos.unidade.dto.NovaUnidadeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UnidadeService {

    private UnidadeMapper unidadeMapper;
    private UnidadeRepository unidadeRepository;


    public NovaUnidadeResponse criarNovaunidade(NovaUnidadeRequest unidade){

        Unidade novaUnidade = unidadeMapper.toEntity(unidade);

        Unidade unidadeSalva = unidadeRepository.save(novaUnidade);

        return unidadeMapper.toDto(unidadeSalva);
    }

    public List<NovaUnidadeResponse> listarUnidades(){

        List<Unidade> unidades = unidadeRepository.findAll();

        return unidades.stream().map(unidade -> new NovaUnidadeResponse(
                unidade.getId(),
                unidade.getNome(),
                unidade.getCnpj()
        )).toList();

    }
}
