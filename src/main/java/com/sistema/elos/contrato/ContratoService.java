package com.sistema.elos.contrato;

import com.sistema.elos.aluno.Aluno;
import com.sistema.elos.aluno.AlunoRepository;
import com.sistema.elos.configuracao.BusinessException;
import com.sistema.elos.contrato.dto.ContratoResponse;
import com.sistema.elos.contrato.dto.CriarContratoRequest;
import com.sistema.elos.contrato.dto.ListarContratoResponse;
import com.sistema.elos.responsavel.Responsavel;
import com.sistema.elos.responsavel.ResponsavelRespository;
import com.sistema.elos.usuario.Usuario;
import com.sistema.elos.usuario.UsuarioRespositoy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class ContratoService {

    private ContratoRepository contratoRepository;
    private UsuarioRespositoy usuarioRespositoy;
    private ResponsavelRespository responsavelRespository;
    private AlunoRepository alunoRepository;


    public ContratoResponse criarNovoContrato(CriarContratoRequest request){

        Usuario consultor = usuarioRespositoy.findById(request.consultorId())
                .orElseThrow(() -> new BusinessException("CONSULTOR NÃO ENCONTRADO"));

        Usuario geradorVisita = usuarioRespositoy.findById(request.geradorVisitaId())
                .orElseThrow(() -> new BusinessException("GERADOR DE VISITA NÃO ENCONTRADO"));

        Usuario educador = usuarioRespositoy.findById(request.educadorId())
                .orElseThrow(() -> new BusinessException("EDUCADOR NÃO ENCONTRADO"));

        Responsavel responsavel = responsavelRespository.findById(request.responsavelId())
                .orElseThrow(() -> new BusinessException("RESPONSAVEL NÃO ENCONTRADO"));

        Aluno aluno = alunoRepository.findById(request.alunoId())
                .orElseThrow(() -> new BusinessException("ALUNO NÃO ENCONTRADO"));

        Integer numero = ThreadLocalRandom.current().nextInt(10000, 99999);

        Contrato contrato = new Contrato();

        contrato.setNumeroContrato(numero);
        contrato.setStatus(request.status());
        contrato.setAluno(aluno);
        contrato.setResponsavel(responsavel);
        contrato.setEducador(educador);
        contrato.setGeradorVisita(geradorVisita);
        contrato.setConsultor(consultor);
        contrato.setTipoContrato(request.tipoContrato());
        contrato.setMidia(request.midia());
        contrato.setCampanha(request.campanha());

        Contrato contratoSalvo = contratoRepository.save(contrato);

        return new ContratoResponse(
                contratoSalvo.getId(),
                contratoSalvo.getNumeroContrato(),
                contratoSalvo.getCriacao(),
                contratoSalvo.getStatus(),
                contratoSalvo.getAluno().getNome(),
                contratoSalvo.getResponsavel().getNome(),
                contratoSalvo.getConsultor().getNome(),
                contratoSalvo.getGeradorVisita().getNome(),
                contratoSalvo.getEducador().getNome(),
                contratoSalvo.getTipoContrato(),
                contratoSalvo.getMidia(),
                contratoSalvo.getCampanha()
        );
    }

    public List<ListarContratoResponse> listarContratos(){
        List<Contrato> contratos = contratoRepository.findAll();

        return contratos.stream().map(contrato -> new ListarContratoResponse(
                contrato.getId(),
                contrato.getNumeroContrato(),
                contrato.getAluno().getNome(),
                contrato.getResponsavel().getNome(),
                contrato.getTipoContrato(),
                contrato.getStatus(),
                contrato.getCampanha(),
                contrato.getCriacao()
        )).toList();
    }

}
