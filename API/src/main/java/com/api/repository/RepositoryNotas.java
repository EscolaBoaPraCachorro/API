package com.api.repository;

import com.api.model.Notas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryNotas extends JpaRepository<Notas, Long> {
    Notas findById_cachorroAndId_professorAndNota(Long id_cachorro, Long id_professor, Integer nota);
}
