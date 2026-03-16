package com.api.service;

import com.api.dto.professor.ProfessorRequestDTO;
import com.api.dto.professor.ProfessorResponseDTO;
import com.api.model.Professor;
import com.api.repository.RepositoryProfessor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

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
        List<ProfessorResponseDTO> dto = new ArrayList<>();

        for (Professor professor1 : professor) {
            dto.add(objectMapper.convertValue(professor1, ProfessorResponseDTO.class));
        }

        return dto;
    }

    public ProfessorResponseDTO buscarProfessorPorId(Long id) {
        Professor professor = objectMapper.convertValue(repository.findById(id), Professor.class);
        return objectMapper.convertValue(professor, ProfessorResponseDTO.class);
    }

    public String buscarImagemPorId(Long id) {
        Professor professor = objectMapper.convertValue(repository.findById(id), Professor.class);
        return professor.getImagem();
    }

    public String buscarNomePorId(Long id) {
        Professor professor = objectMapper.convertValue(repository.findById(id), Professor.class);
        return professor.getNome();
    }

    public Date buscarDataNascimentoProfessorPorId(Long id) {
        Professor professor = objectMapper.convertValue(repository.findById(id), Professor.class);
        return professor.getDataNascimento();
    }

    public ProfessorResponseDTO inserirProfessor(ProfessorRequestDTO req){
        Professor inserido = repository.save(objectMapper.convertValue(req, Professor.class));
        return objectMapper.convertValue(inserido, ProfessorResponseDTO.class);
    }

    public ProfessorResponseDTO excluirProfessor(Long id){
        Professor professor = objectMapper.convertValue(repository.findById(id), Professor.class);
        repository.delete(professor);
        return objectMapper.convertValue(professor, ProfessorResponseDTO.class);
    }
}
