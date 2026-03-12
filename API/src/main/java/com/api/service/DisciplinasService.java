package com.api.service;

import com.api.repository.RepositoryDisciplinas;
import org.springframework.stereotype.Service;

@Service
public class DisciplinasService {
    private final RepositoryDisciplinas repository;

    public DisciplinasService(RepositoryDisciplinas repositoryDisciplina) {
        this.repository = repositoryDisciplina;
    }

    public Long buscarIdProfessorPorDisciplina(String disciplina) {
        return repository.findIdProfessorByNome(disciplina);
    }
}
