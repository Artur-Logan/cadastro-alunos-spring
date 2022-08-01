package com.artur.cadastroalunosspring.services;

import com.artur.cadastroalunosspring.dto.requests.SalaRequest;
import com.artur.cadastroalunosspring.dto.responses.SalaResponse;
import com.artur.cadastroalunosspring.entities.Sala;
import com.artur.cadastroalunosspring.exceptions.SalaNotFoundException;
import com.artur.cadastroalunosspring.mappers.MapperSala;
import com.artur.cadastroalunosspring.repositories.SalaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalaService {

    private final SalaRepository salaRepository;
    private final MapperSala mapperSala;

    public SalaResponse salvar(SalaRequest salaRequest){
        Sala sala = mapperSala.toEntity( salaRequest );

        salaRepository.save( sala );

        return mapperSala.toResponse( sala );
    }

    public SalaResponse obter(Long id){
        Sala sala = salaRepository.findById(id).orElseThrow(
                () -> new SalaNotFoundException("Sala não encontrada para o id " + id)
        );

        return mapperSala.toResponse(sala);
    }

    public List<SalaResponse> listarTodos(){
        List<Sala> salaList = salaRepository.findAll();

        //decorar linha abaixo
        return salaList.stream().map(mapperSala::toResponse).collect(Collectors.toList());
    }

    public void deletar(Long id){
        Sala sala =  salaRepository.findById(id).get();

        salaRepository.delete(sala);
    }

    public SalaResponse atualizar(Long id, SalaRequest salaRequest){
        Sala sala = salaRepository.findById(id).get();

        mapperSala.atualizar(salaRequest, sala);

        salaRepository.save(sala);

        return mapperSala.toResponse(sala);
    }

    public Sala obterEntitidade(Long id) {
        Sala sala = salaRepository.findById(id).get();

        return sala;
    }
}

//salaRequest.setId(sala.getId());

//sala.setDescricao( salaRequest.getDescricao() );
//sala.setNumero( salaRequest.getNumero() );

//sala.setId(id);