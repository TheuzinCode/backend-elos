package com.sistema.elos.unidade;

import com.sistema.elos.unidade.dto.NovaUnidadeRequest;
import com.sistema.elos.unidade.dto.NovaUnidadeResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidades")
@AllArgsConstructor
public class UnidadeController {


    private UnidadeService unidadeService;

    @PostMapping("/nova-unidade")
    public ResponseEntity<NovaUnidadeResponse> criarUnidade(@RequestBody @Valid NovaUnidadeRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(unidadeService.criarNovaunidade(request));
    }


    @GetMapping
    public ResponseEntity<List<NovaUnidadeResponse>> listarUnidades(){
        return ResponseEntity.ok(unidadeService.listarUnidades());
    }
}
