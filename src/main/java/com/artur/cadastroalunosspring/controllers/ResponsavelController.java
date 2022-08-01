package com.artur.cadastroalunosspring.controllers;

import com.artur.cadastroalunosspring.dto.requests.ResponsavelRequest;
import com.artur.cadastroalunosspring.dto.responses.ResponsavelResponse;
import com.artur.cadastroalunosspring.services.ResponsavelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("responsavel")
@RequiredArgsConstructor
public class ResponsavelController {

    private final ResponsavelService responsavelService;

    @GetMapping
    public ResponseEntity<List<ResponsavelResponse>> listarTodos(){
        List<ResponsavelResponse> responseList = responsavelService.listarTodos();

        return ResponseEntity.ok().body(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsavelResponse> obter(@PathVariable Long id){
        ResponsavelResponse responsavelResponse = responsavelService.obter(id);
        return ResponseEntity.ok().body(responsavelResponse);
    }

    @PostMapping
    public ResponseEntity<ResponsavelResponse> salvar(@RequestBody ResponsavelRequest responsavelRequest){
        ResponsavelResponse responsavelResponse = responsavelService.salvar(responsavelRequest);

        return ResponseEntity.ok().body(responsavelResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        responsavelService.deletar(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponsavelResponse> atualizar(@PathVariable Long id, @RequestBody ResponsavelRequest responsavelRequest){
        ResponsavelResponse responsavelResponse = responsavelService.atualizar(id, responsavelRequest);

        return ResponseEntity.ok().body(responsavelResponse);
    }
}