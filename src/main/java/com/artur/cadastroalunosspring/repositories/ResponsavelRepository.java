package com.artur.cadastroalunosspring.repositories;

import com.artur.cadastroalunosspring.entities.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {
}
