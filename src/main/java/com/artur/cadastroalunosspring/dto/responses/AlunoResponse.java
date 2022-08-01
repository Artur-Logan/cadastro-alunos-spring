package com.artur.cadastroalunosspring.dto.responses;

import com.artur.cadastroalunosspring.entities.Responsavel;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AlunoResponse {

    private Long id;
    private String nome;
    private String sobreNome;
    private Integer idade;
    private LocalDate dataCadastro;
    private String periodo;
    private String serieAno;
    private SalaResponse sala;
    private ResponsavelResponse responsavel;
}
