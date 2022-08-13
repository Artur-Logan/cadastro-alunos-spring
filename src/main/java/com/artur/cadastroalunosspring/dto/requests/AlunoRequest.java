package com.artur.cadastroalunosspring.dto.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AlunoRequest {

    private String nome;
    private String sobreNome;
    private Integer idade;
    private LocalDate dataCadastro;
    private String periodo;
    private String serieAno;
    private SalaRequest sala;
    private ResponsavelRequest responsavel;
}
