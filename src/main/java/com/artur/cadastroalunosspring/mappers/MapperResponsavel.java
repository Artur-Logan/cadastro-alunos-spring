package com.artur.cadastroalunosspring.mappers;

import com.artur.cadastroalunosspring.dto.requests.ResponsavelRequest;
import com.artur.cadastroalunosspring.dto.responses.ResponsavelResponse;
import com.artur.cadastroalunosspring.entities.Responsavel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapperResponsavel {

    Responsavel toEntity(ResponsavelRequest responsavelRequest);
    ResponsavelResponse toResponse(Responsavel responsavel);
    @Mapping(target = "id", ignore = true)
    Responsavel atualizar(ResponsavelRequest responsavelRequest, @MappingTarget Responsavel responsavel);
}
