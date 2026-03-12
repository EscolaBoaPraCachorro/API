package com.api.controller;

import com.api.dto.cachorro.CachorroResponseDTO;
import com.api.dto.tutor.TutorRequestDTO;
import com.api.dto.tutor.TutorResponseDTO;
import com.api.service.TutorService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/tutor")
public class TutorController {
    private final TutorService service;

    public TutorController(TutorService service) {
        this.service = service;
    }

    @GetMapping("/buscarIdPorIdCachorro/{id}")
    public Long buscarIdPorIdCachorro(@PathVariable Long id) {
        return service.buscarIdPorIdCachorro(id);
    }

    @GetMapping("/buscarImagemPorId/{id}")
    public String buscarImagemPorIdTutor(@PathVariable Long id) {
        return service.buscarImagemPorIdTutor(id);
    }

    @GetMapping("/buscarNomeTutorPorId/{id}")
    public String buscarNomeTutorPorId(@PathVariable Long id) {
        return service.buscarNomeTutorPorId(id);
    }

    @GetMapping("/buscarDataNascimentoTutorPorId/{id}")
    public Date buscarDataNascimentoTutorPorId(@PathVariable Long id) {
        return service.buscarDataNascimentoTutorPorId(id);
    }

    @PostMapping("/cadastrar")
    public TutorResponseDTO cadastrarTutor(@RequestBody TutorRequestDTO dto) {
        return service.cadastrarTutor(dto);
    }

    @PatchMapping("/atualizarDescricao/{id}")
    public String atualizarDescricao(@RequestBody TutorRequestDTO req, @PathVariable Long id) {
        TutorResponseDTO res = service.atualizarDescricao(id, req.getDescricao());
        return "A imagem do cachoroo, com ID: " + res.getId() + ", foi atualizada com sucesso!";
    }
}
