package com.api.service;

import com.api.model.GradeHoraria;
import com.api.repository.RepositoryGradeHoraria;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
public class GradeHorariaService {
    private final RepositoryGradeHoraria repository;

    public GradeHorariaService(RepositoryGradeHoraria repositoryGradeHoraria) {
        this.repository = repositoryGradeHoraria;
    }

    public List<GradeHoraria> buscarHorario(){
        return repository.findAll();
    }
}
