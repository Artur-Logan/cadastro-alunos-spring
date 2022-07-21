package com.artur.cadastroalunosspring.controllers;

import com.artur.cadastroalunosspring.dto.requests.AlunoRequest;
import com.artur.cadastroalunosspring.dto.responses.AlunoResponse;
import com.artur.cadastroalunosspring.entities.Aluno;
import com.artur.cadastroalunosspring.services.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponse> obter(@PathVariable Long id){
        AlunoResponse alunoResponse = alunoService.obter(id);

        return ResponseEntity.ok().body(alunoResponse);
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponse>> listarTodos(){
        List<AlunoResponse> alunoResponses = alunoService.listarTodos();

        return ResponseEntity.ok().body(alunoResponses);
    }

    @PostMapping
    public ResponseEntity<AlunoResponse> salvar(@RequestBody AlunoRequest alunoRequest){
        AlunoResponse alunoResponse = alunoService.salvar(alunoRequest);

        return ResponseEntity.ok().body(alunoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        alunoService.deletar(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponse> atualizar(@PathVariable Long id, @RequestBody AlunoRequest alunoRequest){
        AlunoResponse alunoResponse = alunoService.atualizar(id, alunoRequest);

        return ResponseEntity.ok().body(alunoResponse);
    }
}
