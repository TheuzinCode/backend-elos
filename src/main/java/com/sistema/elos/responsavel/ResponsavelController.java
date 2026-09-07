package com.sistema.elos.responsavel;

import com.sistema.elos.responsavel.dto.CriarNovoResponsavelResponse;
import com.sistema.elos.responsavel.dto.CriarNovoResponsavelResquest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/responsavel")
@AllArgsConstructor
public class ResponsavelController {


    private ResponsavelService responsavelService;


    @PostMapping("/novoresponsavel")
    public ResponseEntity<CriarNovoResponsavelResponse> criarNovaResponsavel(@RequestBody @Valid CriarNovoResponsavelResquest responsavelResquest){

        CriarNovoResponsavelResponse entity = responsavelService.novoResponsavel(responsavelResquest);
        URI location = URI.create("/responsavel" + entity.id());

        return ResponseEntity.created(location).body(entity);

    }
}
