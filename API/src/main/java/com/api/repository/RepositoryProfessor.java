package com.api.repository;

import com.api.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProfessor extends JpaRepository<Professor, Long> {

}
