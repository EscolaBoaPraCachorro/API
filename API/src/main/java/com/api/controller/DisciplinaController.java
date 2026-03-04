package com.api.controller;

import com.api.service.DisciplinaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/disciplina")
public class DisciplinaController {
    private final DisciplinaService service;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.service = disciplinaService;
    }

    @GetMapping("/buscarIdProfessorPorDisciplina/{disciplina}")
    public Long buscarIdProfessorPorDisciplina(@PathVariable Long disciplina) {
        return service.buscarIdProfessorPorDisciplina(disciplina);
    }
}
