package com.sistema.elos.formacao;

import com.sistema.elos.formacao.dto.CriarNovaFormacaoRequest;
import com.sistema.elos.formacao.dto.CriarNovaFormacaoResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formacoes")
@AllArgsConstructor
public class FormacaoController {

    private FormacaoService formacaoService;

    @PostMapping("/novo-formacao")
    public ResponseEntity<CriarNovaFormacaoResponse> criarNovaFormacao(@RequestBody @Valid CriarNovaFormacaoRequest request){
        return ResponseEntity.ok().body(formacaoService.criarNovaFormacao(request));
    }
}
