package com.sistema.elos.contrato;

import com.sistema.elos.contrato.dto.ContratoResponse;
import com.sistema.elos.contrato.dto.CriarContratoRequest;
import com.sistema.elos.contrato.dto.ListarContratoResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contratos")
@AllArgsConstructor
public class ContratoController {


    private ContratoService contratoService;


    @PostMapping("/novo-contrato")
    public ResponseEntity<ContratoResponse> criarNovoContrato(@RequestBody @Valid CriarContratoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(contratoService.criarNovoContrato(request));
    }

    @GetMapping
    public ResponseEntity<List<ListarContratoResponse>> listarContratos (){
        return ResponseEntity.ok(contratoService.listarContratos());
    }

}
