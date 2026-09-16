package com.sistema.elos.parcela;

import com.sistema.elos.aluno.Aluno;
import com.sistema.elos.aluno.AlunoRepository;
import com.sistema.elos.configuracao.BusinessException;
import com.sistema.elos.parcela.dto.CriarParcelaResponse;
import com.sistema.elos.parcela.dto.CriarParcelaResquest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ParcelaService {

    private ParcelaRepository parcelaRepository;
    private AlunoRepository alunoRepository;

    @Transactional
    public CriarParcelaResponse criarParcela(CriarParcelaResquest request){

        Aluno aluno = alunoRepository.findById(request.alunoId())
                .orElseThrow(() -> new BusinessException("ALUNO NÃO ENCONTRADO"));

        List<Parcela> parcelas = new ArrayList<>();

        for (int i = 0; i < request.quantidade(); i++){

            Parcela parcela = new Parcela();

            parcela.setAluno(aluno);
            parcela.setTipoParcela(request.tipoParcela());
            parcela.setValor(request.valor());
            parcela.setDataVencimento(request.dataVencimento().plusMonths(i));
            parcelas.add(parcela);
            aluno.getParcelas().add(parcela);
            parcela.setUnidade(aluno.getUnidade());
        }

        parcelaRepository.saveAll(parcelas);

        return new CriarParcelaResponse(
                aluno.getId(),
                parcelas.size(),
                request.valor(),
                request.valor().multiply(BigDecimal.valueOf(parcelas.size())),
                parcelas.getFirst().getDataVencimento(),
                parcelas.getLast().getDataVencimento(),
                "Parcelas criadas com sucesso."
        );
    }

}
