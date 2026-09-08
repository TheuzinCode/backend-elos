package com.sistema.elos.historicoaluno;

import com.sistema.elos.historicoaluno.dto.CadastrarHistoricoAlunoRequest;
import com.sistema.elos.historicoaluno.dto.CadastrarHistoricoAlunoResponse;
import com.sistema.elos.historicoaluno.dto.ListarHistoricoAlunoResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historicoaluno")
@AllArgsConstructor
public class HistoricoAlunoController {

    private HistoricoAlunoService historicoAlunoService;


    @PostMapping("/novohistorico")
    public ResponseEntity<CadastrarHistoricoAlunoResponse> cadastrarHistoricoAluno(@RequestBody @Valid CadastrarHistoricoAlunoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(historicoAlunoService.cadastrarHistoricoAluno(request));
    }

    @GetMapping("/{alunoId}")
    public List<ListarHistoricoAlunoResponse> listarHistoricoPorAluno(@PathVariable Long alunoId){
        return historicoAlunoService.listarHistoricoPorAluno(alunoId);
    }


}
