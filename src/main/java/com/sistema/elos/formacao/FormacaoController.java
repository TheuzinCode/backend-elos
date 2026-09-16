package com.sistema.elos.formacao;

import com.sistema.elos.formacao.dto.CriarNovaFormacaoRequest;
import com.sistema.elos.formacao.dto.CriarNovaFormacaoResponse;
import com.sistema.elos.formacao.dto.ListaFormacoes;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("/formacoes")
@AllArgsConstructor
public class FormacaoController {

    private FormacaoService formacaoService;

    @PostMapping("/novo-formacao")
    public ResponseEntity<CriarNovaFormacaoResponse> criarNovaFormacao(@RequestBody @Valid CriarNovaFormacaoRequest request){
        return ResponseEntity.ok().body(formacaoService.criarNovaFormacao(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ListaFormacoes>> listarFormacoesAluno(@PathVariable UUID id){
        return ResponseEntity.ok(formacaoService.listarFormacoesAluno(id));
    }
}
