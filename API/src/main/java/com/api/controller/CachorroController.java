package com.api.controller;

import com.api.dto.cachorro.CachorroRequestDTO;
import com.api.dto.cachorro.CachorroResponseDTO;
import com.api.service.CachorroService;
import com.api.service.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cao")
public class CachorroController {

    private final CachorroService service;

    public CachorroController(CachorroService service) { this.service = service; }

    @GetMapping("/buscarCaoPorId/{id}")
    public CachorroResponseDTO buscarCaoPorId(@PathVariable Long id) {
        return service.buscarCaoPorId(id);
    }

    @PostMapping("/inserir")
    public String inserir(@RequestBody CachorroRequestDTO req) {
        CachorroResponseDTO cao = service.cadastrarCachorro(req);
        return "O Cachorro " + cao.getNome() + ", foi cadastrado com sucesso! ID: " + cao.getId();
    }
}
