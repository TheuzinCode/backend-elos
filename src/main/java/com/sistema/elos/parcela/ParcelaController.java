package com.sistema.elos.parcela;

import com.sistema.elos.parcela.dto.CriarParcelaResponse;
import com.sistema.elos.parcela.dto.CriarParcelaResquest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parcelas")
@AllArgsConstructor
public class ParcelaController {

    private ParcelaService parcelaService;

    @PostMapping("/nova-parcela")
    public ResponseEntity<CriarParcelaResponse> novaParcela(CriarParcelaResquest resquest){
        return ResponseEntity.status(HttpStatus.CREATED).body(parcelaService.criarParcela(resquest));
    }
}
