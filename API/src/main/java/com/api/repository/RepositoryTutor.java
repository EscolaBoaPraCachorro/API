package com.api.repository;

import com.api.dto.tutor.TutorResponseDTO;
import com.api.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTutor extends JpaRepository<Tutor, Long> {
    TutorResponseDTO findImagemById(Long id);
}
