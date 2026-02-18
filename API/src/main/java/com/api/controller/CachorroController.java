package com.api.controller;

import com.api.dto.cachorro.CachorroResponseDTO;
import com.api.service.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cao")
public class CachorroController {

    private final Service service;

    public CachorroController(Service service) { this.service = service; }

    @GetMapping("/buscarCaoPorId/{id}")
    public CachorroResponseDTO buscarCaoPorId(@PathVariable Long id) {
        return service.buscarCaoPorId(id);
    }
}
