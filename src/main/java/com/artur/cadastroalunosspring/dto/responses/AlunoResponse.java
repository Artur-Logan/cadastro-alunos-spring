package com.artur.cadastroalunosspring.dto.responses;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AlunoResponse {

    private Long id;
    private String nome;
    private String sobreNome;
    private Integer idade;
    private LocalDate dataCadastro;
    private String numeroSala;
    private String periodo;
    private String serieAno;
}
