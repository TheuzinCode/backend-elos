package com.sistema.elos.responsavel;

import com.sistema.elos.aluno.Aluno;
import com.sistema.elos.configuracao.BusinessException;
import com.sistema.elos.endereco.Endereco;
import com.sistema.elos.endereco.EnderecoMapper;
import com.sistema.elos.endereco.dto.CriarEnderecoResponse;
import com.sistema.elos.responsavel.dto.CriarNovoResponsavelResponse;
import com.sistema.elos.responsavel.dto.CriarNovoResponsavelResquest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@AllArgsConstructor
public class ResponsavelService {

    private ResponsavelRespository responsavelRespository;
    private ResponsavelMapper responsavelMapper;
    private EnderecoMapper enderecoMapper;

    //USANDO NA CLASSE ALUNO SERVICE PARA CRIAÇÃO DO ALUNO
    public Responsavel buscarPorIdClasseAluno(Long id){
        Responsavel responsavel = responsavelRespository.findById(id).orElseThrow(
                () -> new BusinessException("ERRO AO ENCONTRAR O RESPONSAVEL"));
        return responsavel;
    }


    public CriarNovoResponsavelResponse novoResponsavel(CriarNovoResponsavelResquest request){

        Endereco endereco = enderecoMapper.toEntity(request.endereco());

        Responsavel responsavel = responsavelMapper.toEntity(request);

        responsavel.setEndereco(endereco);
        responsavel.setEmail(request.email().toLowerCase(Locale.ROOT));

        Responsavel responsavelSalvo = responsavelRespository.save(responsavel);

        CriarEnderecoResponse criarEnderecoResponse = enderecoMapper.toCriarEnderecoResponseDTO(responsavelSalvo.getEndereco());

        return new CriarNovoResponsavelResponse(
                responsavelSalvo.getId(),
                responsavelSalvo.getNome(),
                responsavelSalvo.getCpf(),
                responsavelSalvo.getRegistroGeral(),
                responsavelSalvo.getDataNascimento(),
                responsavelSalvo.getGenero(),
                responsavelSalvo.getEstadoCivil(),
                responsavelSalvo.getEmail(),
                responsavelSalvo.getTelefoneResidencial(),
                responsavelSalvo.getTelefoneCelular(),
                responsavelSalvo.getTelefoneCelular2(),
                responsavelSalvo.getEscolaridade(),
                criarEnderecoResponse
        );
    }

}
