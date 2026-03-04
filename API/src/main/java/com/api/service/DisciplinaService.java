package com.api.service;

import com.api.dto.disciplina.DisciplinaResponseDTO;
import com.api.repository.RepositoryDisciplina;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {
    private final RepositoryDisciplina repository;

    public DisciplinaService(RepositoryDisciplina repositoryDisciplina) {
        this.repository = repositoryDisciplina;
    }

    public Long buscarIdProfessorPorDisciplina(Long disciplina) {
        return repository.findIdProfessorByNome(disciplina);
    }
}
