package com.api.controller;

import com.api.model.GradeHoraria;
import com.api.service.GradeHorariaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/grade")
public class GradeHorariaController {

    private final GradeHorariaService service;

    public GradeHorariaController(GradeHorariaService gradeHorariaService) {
        this.service = gradeHorariaService;
    }

    @GetMapping("/listar")
    public List<GradeHoraria> listar() {
        return service.buscarHorario();
    }
}
