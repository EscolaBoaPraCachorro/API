package com.api.controller;

import com.api.service.DisciplinasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/disciplina")
public class DisciplinasController {
    private final DisciplinasService service;

    public DisciplinasController(DisciplinasService disciplinaService) {
        this.service = disciplinaService;
    }

    @GetMapping("/buscarIdProfessorPorDisciplina/{disciplina}")
    public Long buscarIdProfessorPorDisciplina(@PathVariable String disciplina) {
        return service.buscarIdProfessorPorDisciplina(disciplina);
    }
}
