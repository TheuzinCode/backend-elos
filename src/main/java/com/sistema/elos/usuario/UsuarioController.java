package com.sistema.elos.usuario;

import com.sistema.elos.usuario.dto.CriarUsuarioRequest;
import com.sistema.elos.usuario.dto.UsuarioResponse;
import com.sistema.elos.usuario.dto.ListarUsuarioResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping("/novo-usuario")
    public ResponseEntity<UsuarioResponse> criarNovoUsuario(@RequestBody @Valid CriarUsuarioRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criarNovoUsuario(request));
    }

    @GetMapping
    public ResponseEntity<List<ListarUsuarioResponse>> listarUsuarios(){
        return ResponseEntity.ok(usuarioService.listarTodosUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable UUID id){
        return ResponseEntity.ok(usuarioService.detalhesUsuario(id));
    }



}
