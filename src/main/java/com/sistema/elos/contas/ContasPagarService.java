package com.sistema.elos.contas;

import com.sistema.elos.contas.dto.ContasPagarResponse;
import com.sistema.elos.contas.dto.CriarContaPagarRequest;
import com.sistema.elos.contas.dto.ListarContaPagarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContasPagarService {

    private ContasPagarRepository contasPagarRepository;

    private ContasPagarMapper contasPagarMapper;


    public ContasPagarResponse criarNovaContaPagar(CriarContaPagarRequest request){

        ContasPagar contasPagar = contasPagarMapper.toEntity(request);

        ContasPagar contasPagarSalva = contasPagarRepository.save(contasPagar);

        return new ContasPagarResponse(contasPagarSalva.getId(),
                contasPagarSalva.getCategoria(),
                contasPagarSalva.getValorPagar(),
                contasPagarSalva.getDataVencimento(),
                contasPagarSalva.getStatusConta(),
                "CONTA CRIADA COM SUCESSO"
        );
    }

    public List<ListarContaPagarResponse> listarContaPagar(){
        List<ContasPagar> contas = contasPagarRepository.findAll();

        return contas.stream().map(conta -> new ListarContaPagarResponse(
                conta.getId(),
                conta.getCategoria(),
                conta.getValorPagar(),
                conta.getDataVencimento(),
                conta.getValorPago(),
                conta.getDataPagamento(),
                conta.getStatusConta()
        )).toList();
    }
}
