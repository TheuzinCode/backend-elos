package com.sistema.elos.aluno;


import com.sistema.elos.aluno.dto.CriarNovoAlunoRequest;
import com.sistema.elos.aluno.dto.CriarNovoAlunoResponse;
import com.sistema.elos.aluno.dto.DetalhesAlunosResponse;
import com.sistema.elos.aluno.dto.ListarAlunosResponse;
import com.sistema.elos.configuracao.BusinessException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/alunos")
@AllArgsConstructor
public class AlunoController {

    private AlunoService alunoService;


    @PostMapping("/novoaluno")
    public ResponseEntity<CriarNovoAlunoResponse> criarNovoAluno(@RequestBody @Valid CriarNovoAlunoRequest request){

        CriarNovoAlunoResponse entity = alunoService.criarNovoAluno(request);
        URI location = URI.create("/aluno/" + entity.id());

        return ResponseEntity.created(location).body(entity);
    }

    @GetMapping
    public ResponseEntity<List<ListarAlunosResponse>> listarTodosAlunos(){

        List<ListarAlunosResponse> listaAlunos = alunoService.listarTodosAlunos();

        return ResponseEntity.ok(listaAlunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){

        try{
            DetalhesAlunosResponse entity = alunoService.buscarAlunoPorId(id);
            return ResponseEntity.ok(entity);
        } catch (BusinessException e) {
                return ResponseEntity.badRequest().body(new BusinessException(e.getMessage()));
        }
    }

}
