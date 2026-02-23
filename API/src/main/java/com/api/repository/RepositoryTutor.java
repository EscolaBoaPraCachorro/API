package com.api.repository;

import com.api.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTutor extends JpaRepository<Tutor, Long> {
}
