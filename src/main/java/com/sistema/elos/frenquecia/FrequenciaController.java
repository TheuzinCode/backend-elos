package com.sistema.elos.frenquecia;

import com.sistema.elos.configuracao.BusinessException;
import com.sistema.elos.frenquecia.dto.CadastrarFaltaRequest;
import com.sistema.elos.frenquecia.dto.CadastrarFaltaResponse;
import com.sistema.elos.frenquecia.dto.ListarFrequenciaResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frequencia")
@AllArgsConstructor
public class FrequenciaController {

    private FrequenciaService frequenciaService;

    @GetMapping("/{alunoId}")
    public List<ListarFrequenciaResponse> listarFrenquencia(@PathVariable Long alunoId){
        return frequenciaService.listarFrequenciaPorAluno(alunoId);
    }

    @PostMapping("/lancar-falta")
    public ResponseEntity<CadastrarFaltaResponse> cadastrarFalta(@RequestBody CadastrarFaltaRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(frequenciaService.cadastrarFalta(request));
    }


}
