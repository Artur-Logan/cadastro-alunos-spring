package com.artur.cadastroalunosspring.mappers;

import com.artur.cadastroalunosspring.dto.requests.AlunoRequest;
import com.artur.cadastroalunosspring.dto.responses.AlunoResponse;
import com.artur.cadastroalunosspring.entities.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = { MapperSala.class, MapperResponsavel.class })
public interface MapperAluno {

    Aluno toEntity(AlunoRequest alunoRequest);
    AlunoResponse toResponse(Aluno aluno);
    Aluno atualizar(AlunoRequest alunoRequest, @MappingTarget Aluno aluno);
}
