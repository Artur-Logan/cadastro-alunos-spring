package com.artur.cadastroalunosspring.repositories;

import com.artur.cadastroalunosspring.entities.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {
}
