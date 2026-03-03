package com.api.service;

import com.api.dto.professor.ProfessorResponseDTO;
import com.api.model.Professor;
import com.api.repository.RepositoryProfessor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    private final RepositoryProfessor repository;
    private final ObjectMapper objectMapper;

    public ProfessorService(
            RepositoryProfessor repository, ObjectMapper objectMapper
    ) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    public List<ProfessorResponseDTO> listarProfessores() {
        List<Professor> professor = repository.findAll();
        List<ProfessorResponseDTO> professorResponseDTO = new ArrayList<>();

        for (Professor professor1 : professor) {
            professorResponseDTO.add(objectMapper.convertValue(professor1, ProfessorResponseDTO.class));
        }

        return professorResponseDTO;
    }

    public ProfessorResponseDTO buscarProfessorPorId(Long id) {
        Optional<Professor> professor = repository.findById(id);
        return objectMapper.convertValue(professor.get(), ProfessorResponseDTO.class);
    }
}
