package com.artur.cadastroalunosspring.services;

import com.artur.cadastroalunosspring.dto.requests.AlunoRequest;
import com.artur.cadastroalunosspring.dto.responses.AlunoResponse;
import com.artur.cadastroalunosspring.entities.Aluno;
import com.artur.cadastroalunosspring.mappers.MappersAluno;
import com.artur.cadastroalunosspring.repositories.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final MappersAluno mappersAluno;

    public AlunoResponse obter(Long id){
        Aluno aluno = alunoRepository.findById(id).get();

        return mappersAluno.toResponse(aluno);
    }

    public List<AlunoResponse> listarTodos(){
        List<Aluno> alunoList = alunoRepository.findAll();

        //decorar linha abaixo
        return alunoList.stream().map(mappersAluno::toResponse).collect(Collectors.toList());
    }

    public void deletar(Long id){
        Aluno aluno =  alunoRepository.findById(id).get();

        alunoRepository.delete(aluno);
    }

    public AlunoResponse salvar(AlunoRequest alunoRequest){
        Aluno aluno = mappersAluno.toEntity(alunoRequest);

        alunoRepository.save(aluno);

        return mappersAluno.toResponse(aluno);
    }

    public AlunoResponse atualizar(Long id, AlunoRequest alunoRequest){
        Aluno aluno = alunoRepository.findById(id).get();

        mappersAluno.atualizar(alunoRequest, aluno);

        alunoRepository.save(aluno);

        return mappersAluno.toResponse(aluno);
    }
}
