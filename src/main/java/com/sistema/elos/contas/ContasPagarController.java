package com.sistema.elos.contas;

import com.sistema.elos.contas.dto.ContasPagarResponse;
import com.sistema.elos.contas.dto.CriarContaPagarRequest;
import com.sistema.elos.contas.dto.ListarContaPagarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas-pagar")
@AllArgsConstructor
public class ContasPagarController {

    private ContasPagarService contasPagarService;

    @PostMapping("/nova-conta-pagar")
    public ResponseEntity<ContasPagarResponse> criarContaPagar(@RequestBody @Valid CriarContaPagarRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(contasPagarService.criarNovaContaPagar(request));
    }

    @GetMapping
    public ResponseEntity<List<ListarContaPagarResponse>> listarContasPagar(){
        return ResponseEntity.ok(contasPagarService.listarContaPagar());
    }
}
