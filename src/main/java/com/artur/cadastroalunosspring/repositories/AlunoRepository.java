package com.artur.cadastroalunosspring.repositories;

import com.artur.cadastroalunosspring.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
