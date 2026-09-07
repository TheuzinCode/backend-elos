package com.sistema.elos.responsavel;

import com.sistema.elos.configuracao.BusinessException;
import com.sistema.elos.responsavel.dto.CriarNovoResponsavelResponse;
import com.sistema.elos.responsavel.dto.CriarNovoResponsavelResquest;
import com.sistema.elos.responsavel.dto.DetalhesResponsavelResponse;
import com.sistema.elos.responsavel.dto.ListarTodosResponsaveisResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<ListarTodosResponsaveisResponse>> listarTodosResponsaveis(){
        return ResponseEntity.ok(responsavelService.listarTodosResponsaveis());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarResponsavelPorId(@PathVariable Long id){
        try{
            DetalhesResponsavelResponse responsavelDTO = responsavelService.buscarResponsavelPorId(id);
            return ResponseEntity.ok(responsavelDTO);

        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(new BusinessException(e.getMessage()));
        }
    }
}
