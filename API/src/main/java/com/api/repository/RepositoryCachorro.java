package com.api.repository;

import com.api.model.Cachorro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryCachorro extends JpaRepository<Cachorro, Long> {
    Cachorro findTurma(String turma);

    List<Cachorro> findByTurma(String turma);
}
