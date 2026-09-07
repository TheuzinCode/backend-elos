package com.sistema.elos.aluno;

import com.sistema.elos.aluno.dto.CriarNovoAlunoRequest;
import com.sistema.elos.aluno.dto.CriarNovoAlunoResponse;
import com.sistema.elos.aluno.dto.DetalhesAlunosResponse;
import com.sistema.elos.aluno.dto.ListarAlunosResponse;
import com.sistema.elos.configuracao.BusinessException;
import com.sistema.elos.endereco.Endereco;
import com.sistema.elos.endereco.EnderecoMapper;
import com.sistema.elos.endereco.dto.CriarEnderecoResponse;
import com.sistema.elos.responsavel.Responsavel;
import com.sistema.elos.responsavel.ResponsavelMapper;
import com.sistema.elos.responsavel.ResponsavelService;
import com.sistema.elos.responsavel.dto.ResponsavelResponseAluno;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@AllArgsConstructor
public class AlunoService {

    private AlunoRepository alunoRepository;
    private AlunoMapper alunoMapper;
    private EnderecoMapper enderecoMapper;
    private ResponsavelMapper responsavelMapper;
    private ResponsavelService responsavelService;


    public CriarNovoAlunoResponse criarNovoAluno(CriarNovoAlunoRequest request){

        Responsavel responsavel = responsavelService.buscarPorIdClasseAluno(request.responsavelId());
        Endereco endereco = enderecoMapper.toEntity(request.endereco());
        Aluno aluno = alunoMapper.toEntity(request);

        aluno.setEndereco(endereco);
        aluno.setEmail(request.email().toLowerCase(Locale.ROOT));

        responsavel.adicionarAluno(aluno);

        Aluno alunoSalvo = alunoRepository.save(aluno);

        ResponsavelResponseAluno responsavelResponseAluno = responsavelMapper.toResponsavelResponseAlunoDTO(alunoSalvo.getResponsavel());
        CriarEnderecoResponse criarEnderecoResponse = enderecoMapper.toCriarEnderecoResponseDTO(alunoSalvo.getEndereco());

        CriarNovoAlunoResponse alunoResponse = alunoMapper.toResponseDTO(alunoSalvo);

        return new CriarNovoAlunoResponse(
                alunoResponse.id(),
                alunoResponse.status(),
                alunoResponse.nome(),
                alunoResponse.cpf(),
                alunoResponse.registroGeral(),
                alunoResponse.dataNascimento(),
                alunoResponse.genero(),
                alunoResponse.estadoCivil(),
                alunoResponse.email(),
                alunoResponse.telefoneResidencial(),
                alunoResponse.telefoneCelular(),
                alunoResponse.telefoneCelular2(),
                alunoResponse.escolaridade(),
                responsavelResponseAluno,
                criarEnderecoResponse
        );
    }


    public List<ListarAlunosResponse> listarTodosAlunos(){

        List<Aluno> listarAlunos = alunoRepository.findAll();

        return listarAlunos.stream().map(aluno -> new ListarAlunosResponse(
                aluno.getId(),
                aluno.getNome(),
                aluno.getResponsavel().getNome(),
                aluno.getTelefoneCelular(),
                aluno.getEmail(),
                aluno.getStatus(),
                aluno.getCriadoEm()
        )).toList();
    }

    public DetalhesAlunosResponse buscarAlunoPorId(Long id){

        Aluno aluno = alunoRepository.findById(id).orElseThrow(
                () -> new BusinessException("ERRO AO ENCONTRAR O ALUNO"));

        DetalhesAlunosResponse alunoEntity = alunoMapper.toDetalhesAlunosResponseDTO(aluno);

        ResponsavelResponseAluno responsavelResponseAluno = responsavelMapper.toResponsavelResponseAlunoDTO(aluno.getResponsavel());
        CriarEnderecoResponse criarEnderecoResponse = enderecoMapper.toCriarEnderecoResponseDTO(aluno.getEndereco());

        return new DetalhesAlunosResponse(
                alunoEntity.id(),
                alunoEntity.status(),
                alunoEntity.nome(),
                alunoEntity.cpf(),
                alunoEntity.registroGeral(),
                alunoEntity.dataNascimento(),
                alunoEntity.genero(),
                alunoEntity.estadoCivil(),
                alunoEntity.email(),
                alunoEntity.telefoneResidencial(),
                alunoEntity.telefoneCelular(),
                alunoEntity.telefoneCelular2(),
                alunoEntity.escolaridade(),
                responsavelResponseAluno,
                criarEnderecoResponse
        );


    }
}
