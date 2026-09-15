package com.sistema.elos.formacao;

import com.sistema.elos.configuracao.BusinessException;
import com.sistema.elos.formacao.dto.CriarNovaFormacaoRequest;
import com.sistema.elos.formacao.dto.CriarNovaFormacaoResponse;
import com.sistema.elos.modulo.Modulo;
import com.sistema.elos.modulo.ModuloRepository;
import com.sistema.elos.modulo.dto.CriarNovoModuloResponse;
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


    public CriarNovaFormacaoResponse criarNovaFormacao (CriarNovaFormacaoRequest request){

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

        Formacao formacaoSalva = formacaoRepository.save(formacao);


        return mapper.toDTO(formacaoSalva);
    }

}
