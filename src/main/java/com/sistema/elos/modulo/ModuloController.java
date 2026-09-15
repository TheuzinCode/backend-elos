package com.sistema.elos.modulo;

import com.sistema.elos.modulo.dto.CriarNovoModuloRequest;
import com.sistema.elos.modulo.dto.CriarNovoModuloResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modulos")
@AllArgsConstructor
public class ModuloController {


    private ModuloService moduloService;

    @PostMapping("/novo-modulo")
    public ResponseEntity<CriarNovoModuloResponse> criarNovoModulo(@RequestBody @Valid CriarNovoModuloRequest request){

        CriarNovoModuloResponse response = moduloService.criarNovoModulo(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CriarNovoModuloResponse>> listarTodosModulos(){
        return ResponseEntity.ok(moduloService.listarModulo());
    }
}
