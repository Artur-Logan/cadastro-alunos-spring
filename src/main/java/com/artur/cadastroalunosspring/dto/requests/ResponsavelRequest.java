package com.artur.cadastroalunosspring.dto.requests;

import lombok.Data;

@Data
public class ResponsavelRequest {

    private Long id;
    private String nome;
    private String telefone;
}
