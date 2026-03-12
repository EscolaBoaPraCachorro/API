package com.api.repository;

import com.api.model.Disciplinas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryDisciplinas extends JpaRepository<Disciplinas, Long> {

    @Query("SELECT d.idProfessor FROM Disciplinas d WHERE d.nome= :nome")
    Long findIdProfessorByNome(@Param("nome") String nome);
}
