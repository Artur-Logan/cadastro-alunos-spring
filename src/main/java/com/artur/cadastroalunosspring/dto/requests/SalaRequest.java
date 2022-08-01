package com.artur.cadastroalunosspring.dto.requests;

import lombok.Data;

@Data
public class SalaRequest {
    private Long id;
    private String descricao;
    private Integer numero;
}
