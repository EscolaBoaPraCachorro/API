package com.api.controller;

import com.api.dto.tutor.TutorRequestDTO;
import com.api.dto.tutor.TutorResponseDTO;
import com.api.service.TutorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tutor")
public class TutorController {
    private final TutorService service;

    public TutorController(TutorService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public TutorResponseDTO cadastrarTutor(@RequestBody TutorRequestDTO dto) {
        return service.cadastrarTutor(dto);
    }
}
