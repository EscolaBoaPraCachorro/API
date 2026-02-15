package com.api.repository;

import com.api.model.Notas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryNotas extends JpaRepository<Notas, Long> {
    Notas findByIdCachorroAndIdProfessorAndNota(Long idCachorro, Long idProfessor, Integer nota);
}
