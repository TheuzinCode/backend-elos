package com.sistema.elos.responsavel;

import com.sistema.elos.aluno.Aluno;
import com.sistema.elos.aluno.AlunoMapper;
import com.sistema.elos.aluno.dto.AlunoResponseResponsavel;
import com.sistema.elos.configuracao.BusinessException;
import com.sistema.elos.endereco.Endereco;
import com.sistema.elos.endereco.EnderecoMapper;
import com.sistema.elos.endereco.dto.CriarEnderecoResponse;
import com.sistema.elos.responsavel.dto.CriarNovoResponsavelResponse;
import com.sistema.elos.responsavel.dto.CriarNovoResponsavelResquest;
import com.sistema.elos.responsavel.dto.DetalhesResponsavelResponse;
import com.sistema.elos.responsavel.dto.ListarTodosResponsaveisResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@AllArgsConstructor
public class ResponsavelService {

    private ResponsavelRespository responsavelRespository;
    private ResponsavelMapper responsavelMapper;
    private EnderecoMapper enderecoMapper;
    private AlunoMapper alunoMapper;

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

    @Transactional
    public List<ListarTodosResponsaveisResponse> listarTodosResponsaveis(){

        List<Responsavel> listaResponsaveis = responsavelRespository.findAll();

        return listaResponsaveis.stream().map(responsavel -> new ListarTodosResponsaveisResponse(
                responsavel.getId(),
                responsavel.getNome(),
                responsavel.getCpf(),
                responsavel.getTelefoneCelular(),
                responsavel.getEmail(),
                responsavel.getAlunos().size(),
                responsavel.getStatus()
        )).toList();
    }


    public DetalhesResponsavelResponse buscarResponsavelPorId(Long id){

        Responsavel responsavel = responsavelRespository.findById(id).orElseThrow(() -> new BusinessException("RESPONSAVEL NÃO ENCONTRADO"));

        DetalhesResponsavelResponse responsavelDTO = responsavelMapper.toDetalhesResponsavelResponse(responsavel);

        CriarEnderecoResponse criarEnderecoResponse = enderecoMapper.toCriarEnderecoResponseDTO(responsavel.getEndereco());

        List<AlunoResponseResponsavel> alunoDTO = alunoMapper.toAlunoResponseResponsavel(responsavel.getAlunos());

        return new DetalhesResponsavelResponse(
                responsavelDTO.id(),
                responsavelDTO.status(),
                responsavelDTO.nome(),
                responsavelDTO.cpf(),
                responsavelDTO.registroGeral(),
                responsavelDTO.dataNascimento(),
                responsavelDTO.genero(),
                responsavelDTO.estadoCivil(),
                responsavelDTO.escolaridade(),
                responsavelDTO.telefoneResidencial(),
                responsavelDTO.telefoneCelular(),
                responsavelDTO.telefoneCelular2(),
                responsavelDTO.escolaridade(),
                alunoDTO,
                criarEnderecoResponse
        );
    }

}
