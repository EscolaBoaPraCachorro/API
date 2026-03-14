package com.api.service;

import com.api.dto.professor.ProfessorRequestDTO;
import com.api.dto.professor.ProfessorResponseDTO;
import com.api.model.Professor;
import com.api.repository.RepositoryProfessor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tools.jackson.databind.ObjectMapper;

import java.util.Date;
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

    public ProfessorResponseDTO buscarProfessorPorId(@PathVariable Long id) {
        Optional<Professor> professor = repository.findById(id);
        return objectMapper.convertValue(professor.get(), ProfessorResponseDTO.class);
    }

    public String buscarImagemPorId(@PathVariable Long id) {
        Professor professor = objectMapper.convertValue(repository.findById(id), Professor.class);
        return professor.getImagem();
    }

    public String buscarNomePorId(@PathVariable Long id) {
        Professor professor = objectMapper.convertValue(repository.findById(id), Professor.class);
        return professor.getNome();
    }

    public Date buscarDataNascimentoProfessorPorId(@PathVariable Long id) {
        Professor professor = objectMapper.convertValue(repository.findById(id), Professor.class);
        return professor.getData_nascimento();
    }

    public ProfessorResponseDTO inserirProfessor(@RequestBody ProfessorRequestDTO req){
        Professor inserido = repository.save(objectMapper.convertValue(req, Professor.class));
        return objectMapper.convertValue(inserido, ProfessorResponseDTO.class);
    }

    public ProfessorResponseDTO deletarProfessor(@PathVariable Long id){
        Professor professor = repository.findById(id).orElse(null);
        repository.delete(professor);
        return objectMapper.convertValue(professor, ProfessorResponseDTO.class);
    }
}
