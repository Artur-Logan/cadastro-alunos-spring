package com.artur.cadastroalunosspring.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobreNome;
    private Integer idade;
    private LocalDate dataCadastro;
    private String periodo;
    private String serieAno;

    @OneToOne
    private Sala sala;

    @OneToOne
    private Responsavel responsavel;
}
