package com.artur.cadastroalunosspring.services;

import com.artur.cadastroalunosspring.dto.requests.ResponsavelRequest;
import com.artur.cadastroalunosspring.dto.responses.ResponsavelResponse;
import com.artur.cadastroalunosspring.entities.Responsavel;
import com.artur.cadastroalunosspring.exceptions.ResponsavelNotFoundException;
import com.artur.cadastroalunosspring.mappers.MapperResponsavel;
import com.artur.cadastroalunosspring.repositories.ResponsavelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResponsavelService {

    private final ResponsavelRepository responsavelRepository;
    private final MapperResponsavel mapperResponsavel;

    public ResponsavelResponse salvar(ResponsavelRequest responsavelRequest){
        Responsavel responsavel = mapperResponsavel.toEntity(responsavelRequest);

       responsavel =  responsavelRepository.save(responsavel);

        return mapperResponsavel.toResponse(responsavel);
    }

    public ResponsavelResponse obter(Long id){
        Responsavel responsavel = responsavelRepository.findById(id).orElseThrow( () -> new ResponsavelNotFoundException("Responsavel não encontrado para o id: " + id));

        return mapperResponsavel.toResponse(responsavel);
    }

    public void deletar(Long id){
        //Se quiser fazer o delete dessa forma, veja só que tá tentando retornar valor do findById pra variavel response
        //dai precisa mockar o retorno do findById:
        Responsavel responsavel = responsavelRepository.findById(id).orElseThrow( () -> new ResponsavelNotFoundException("Responsavel não encontrado para o id: " + id));

        responsavelRepository.delete(responsavel);
    }

    public ResponsavelResponse atualizar(Long id, ResponsavelRequest responsavelRequest){
        Responsavel responsavel = responsavelRepository.findById(id).get();

        mapperResponsavel.atualizar(responsavelRequest,responsavel);

        responsavelRepository.save(responsavel);

        return mapperResponsavel.toResponse(responsavel);
    }

    public List<ResponsavelResponse> listarTodos(){
        List<Responsavel> responsavelList = responsavelRepository.findAll();

        return responsavelList.stream().map(mapperResponsavel::toResponse).collect(Collectors.toList());
    }
}
