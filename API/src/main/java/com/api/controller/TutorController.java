package com.api.controller;

import com.api.dto.tutor.TutorRequestDTO;
import com.api.dto.tutor.TutorResponseDTO;
import com.api.service.TutorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tutor")
public class TutorController {
    private final TutorService service;

    public TutorController(TutorService service) {
        this.service = service;
    }

    @GetMapping("/buscarImagemPorIdCachorro/{id}")
    public String buscarImagemPorIdCachorro(@PathVariable Long id) {
        return service.buscarImagemPorIdCachorro(id);
    }

    @PostMapping("/cadastrar")
    public TutorResponseDTO cadastrarTutor(@RequestBody TutorRequestDTO dto) {
        return service.cadastrarTutor(dto);
    }
}
