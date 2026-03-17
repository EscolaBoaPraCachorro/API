package com.api.repository;

import com.api.model.Cachorro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryCachorro extends JpaRepository<Cachorro, Long> {
    List<Cachorro> findCachorroByTurma(String turma);

    List<Cachorro> findByTurma(String turma);

    @Query("SELECT c FROM Cachorro c WHERE c.tutorId = :id")
    List<Cachorro> findByTutorId(Long id);
}
