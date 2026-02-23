package com.api.service;

import com.api.dto.tutor.TutorRequestDTO;
import com.api.dto.tutor.TutorResponseDTO;
import com.api.model.Tutor;
import com.api.repository.RepositoryTutor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class TutorService {
    private final RepositoryTutor repository;
    private final ObjectMapper objectMapper;

    public TutorService(RepositoryTutor repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    public TutorResponseDTO cadastrarTutor(TutorRequestDTO dto){
        Tutor tutor = objectMapper.convertValue(dto, Tutor.class);
        Tutor cadastrado = repository.save(tutor);
        return objectMapper.convertValue(cadastrado, TutorResponseDTO.class);
    }
}
