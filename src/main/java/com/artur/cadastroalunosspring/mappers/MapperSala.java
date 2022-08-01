package com.artur.cadastroalunosspring.mappers;

import com.artur.cadastroalunosspring.dto.requests.SalaRequest;
import com.artur.cadastroalunosspring.dto.responses.SalaResponse;
import com.artur.cadastroalunosspring.entities.Sala;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapperSala {

    Sala toEntity(SalaRequest salaRequest);
    SalaResponse toResponse(Sala sala);

    @Mapping(target = "id", ignore = true)
    Sala atualizar(SalaRequest salaRequest, @MappingTarget Sala sala);
}
