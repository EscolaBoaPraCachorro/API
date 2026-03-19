package com.api.controller;

import com.api.dto.disciplina.DisciplinasRequestDTO;
import com.api.service.DisciplinasService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

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
    public ResponseEntity<DisciplinasRequestDTO> buscarIdProfessorPorDisciplina(@PathVariable String disciplina) {
        String nomeDecodificado = URLDecoder.decode(disciplina, StandardCharsets.UTF_8);
        Long idProfessor = service.buscarIdProfessorPorDisciplina(nomeDecodificado);
        if (idProfessor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new DisciplinasRequestDTO(nomeDecodificado, idProfessor));
    }
}