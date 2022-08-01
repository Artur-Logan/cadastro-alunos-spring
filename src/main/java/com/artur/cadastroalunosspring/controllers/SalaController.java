package com.artur.cadastroalunosspring.controllers;

import com.artur.cadastroalunosspring.dto.requests.SalaRequest;
import com.artur.cadastroalunosspring.dto.responses.SalaResponse;
import com.artur.cadastroalunosspring.services.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sala")
public class SalaController {

    private final SalaService salaService;

    @GetMapping("/{id}")
    public ResponseEntity<SalaResponse> obter(@PathVariable Long id){
        SalaResponse salaResponse = salaService.obter(id);

        return ResponseEntity.ok().body(salaResponse);
    }

    @GetMapping
    public ResponseEntity<List<SalaResponse>> listarTodos(){
        List<SalaResponse> salaResponses = salaService.listarTodos();

        return ResponseEntity.ok().body(salaResponses);
    }

    @PostMapping
    public ResponseEntity<SalaResponse> salvar(@RequestBody SalaRequest salaRequest){
        SalaResponse salaResponse = salaService.salvar(salaRequest);

        return ResponseEntity.ok().body(salaResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        salaService.deletar(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaResponse> atualizar(@PathVariable Long id, @RequestBody SalaRequest salaRequest){
        SalaResponse salaResponse = salaService.atualizar(id, salaRequest);

        return ResponseEntity.ok().body(salaResponse);
    }
}
