package com.api.service;

import com.api.repository.RepositoryProfessor;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    private final RepositoryProfessor repository;

    public ProfessorService(RepositoryProfessor repository) {
        this.repository = repository;
    }


}
