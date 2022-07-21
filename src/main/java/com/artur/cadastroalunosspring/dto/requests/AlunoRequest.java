package com.artur.cadastroalunosspring.dto.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AlunoRequest {

    private String nome;
    private String sobreNome;
    private Integer idade;
    private LocalDate dataCadastro;
    private String numeroSala;
    private String periodo;
    private String serieAno;
}
