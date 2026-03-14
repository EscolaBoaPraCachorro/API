package com.api.controller;

import com.api.dto.cachorro.CachorroResponseDTO;
import com.api.dto.professor.ProfessorRequestDTO;
import com.api.dto.professor.ProfessorResponseDTO;
import com.api.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @GetMapping("/buscarImagemProfessorPorId/{id}")
    public String buscarImagemPorId(@PathVariable Long id) {
        return professorService.buscarImagemPorId(id);
    }

    @GetMapping("/buscarNomeProfessorPorId/{id}")
    public String buscarNomeProfessorPorId(@PathVariable Long id) {
        return professorService.buscarNomePorId(id);
    }

    @GetMapping("/buscarDataNascimentoProfessorPorId/{id}")
    public Date buscarDataNascimentoProfessorPorId(@PathVariable Long id) {
        return professorService.buscarDataNascimentoProfessorPorId(id);
    }

    @PostMapping("/inserir")
    public String inserirProfessor(@RequestBody ProfessorRequestDTO req) {
        ProfessorResponseDTO res = professorService.inserirProfessor(req);
        return "O professor " + res.getNome() + " foi inserido com sucesso!";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        ProfessorResponseDTO res = professorService.deletarProfessor(id);
        return "O professor " + res.getNome() + " foi deletado!";
    }
}
