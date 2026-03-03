package com.api.controller;

import com.api.dto.professor.ProfessorResponseDTO;
import com.api.service.ProfessorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping("/listar")
    public List<ProfessorResponseDTO> listarProfessores() {
        return professorService.listarProfessores();
    }

    @GetMapping("/buscarProfessorPorId/{id}")
    public ProfessorResponseDTO buscarProfessorPorId(@PathVariable Long id) {
        return professorService.buscarProfessorPorId(id);
    }
}
