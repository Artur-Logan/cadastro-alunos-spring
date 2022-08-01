package com.artur.cadastroalunosspring.services;

import com.artur.cadastroalunosspring.dto.requests.AlunoRequest;
import com.artur.cadastroalunosspring.dto.responses.AlunoResponse;
import com.artur.cadastroalunosspring.dto.responses.ResponsavelResponse;
import com.artur.cadastroalunosspring.dto.responses.SalaResponse;
import com.artur.cadastroalunosspring.entities.Aluno;
import com.artur.cadastroalunosspring.entities.Sala;
import com.artur.cadastroalunosspring.exceptions.AlunoNotFoundException;
import com.artur.cadastroalunosspring.mappers.MapperAluno;
import com.artur.cadastroalunosspring.repositories.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final MapperAluno mapperAluno;
    private final SalaService salaService;
    private final ResponsavelService responsavelService;

    public AlunoResponse obter(Long id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new AlunoNotFoundException("Não foi encontrado o Aluno com o Id: " + id));

        return mapperAluno.toResponse(aluno);
    }

    public List<AlunoResponse> listarTodos(){
        List<Aluno> alunoList = alunoRepository.findAll();

        //decorar linha abaixo
        return alunoList.stream().map(mapperAluno::toResponse).collect(Collectors.toList());
    }

    public void deletar(Long id){
        Aluno aluno =  alunoRepository.findById(id).get();

        alunoRepository.delete(aluno);
    }

    public AlunoResponse salvar(AlunoRequest alunoRequest){
        Aluno aluno = mapperAluno.toEntity(alunoRequest);

        alunoRepository.save(aluno);

        SalaResponse salaResponse = salaService.obter(aluno.getSala().getId());
        ResponsavelResponse responsavelResponse = responsavelService.obter(aluno.getResponsavel().getId());

        AlunoResponse alunoResponse = mapperAluno.toResponse(aluno);
        alunoResponse.setSala(salaResponse);
        alunoResponse.setResponsavel(responsavelResponse);

        return alunoResponse;
    }

    public AlunoResponse atualizar(Long id, AlunoRequest alunoRequest){
        Aluno aluno = alunoRepository.findById(id).get();

        mapperAluno.atualizar(alunoRequest, aluno);

        alunoRepository.save(aluno);

        return mapperAluno.toResponse(aluno);
    }

    public AlunoResponse trocaDeSala(Long idAluno, Long idNovaSala) {
        Aluno aluno = alunoRepository.findById(idAluno).get();

        Sala sala = salaService.obterEntitidade( idNovaSala );

        aluno.setSala( sala );

        alunoRepository.save( aluno );

        return mapperAluno.toResponse(aluno);
    }
}
