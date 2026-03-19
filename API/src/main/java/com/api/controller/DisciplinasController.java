package com.api.controller;

import com.api.service.DisciplinasService;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/disciplina")
public class DisciplinasController {
    private final DisciplinasService service;

    public DisciplinasController(DisciplinasService disciplinaService) {
        this.service = disciplinaService;
    }

    @GetMapping("/buscarIdProfessorPorDisciplina/{disciplina}")
    public Long buscarIdProfessorPorDisciplina(@PathVariable String disciplina) {
        String nomeDecodificado = URLDecoder.decode(disciplina, StandardCharsets.UTF_8);
        return service.buscarIdProfessorPorDisciplina(nomeDecodificado);
    }
}