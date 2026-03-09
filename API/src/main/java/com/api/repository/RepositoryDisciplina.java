package com.api.repository;

import com.api.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryDisciplina extends JpaRepository<Disciplina, Long> {

    @Query("SELECT d.idProfessor FROM Disciplina d WHERE d.nome= :nome")
    Long findIdProfessorByNome(@Param("nome") String nome);
}
