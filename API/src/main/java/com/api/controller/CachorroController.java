package com.api.controller;

import com.api.dto.cachorro.CachorroRequestDTO;
import com.api.dto.cachorro.CachorroResponseDTO;
import com.api.model.Cachorro;
import com.api.service.CachorroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cao")
public class CachorroController {

    private final CachorroService service;

    public CachorroController(CachorroService service) { this.service = service; }

    @GetMapping("/listar")
    public List<Cachorro> listarCaes() {
        return service.listarCaes();
    }

    @GetMapping("/buscarCaoPorId/{id}")
    public CachorroResponseDTO buscarCaoPorId(@PathVariable Long id) {
        return service.buscarCaoPorId(id);
    }

    @GetMapping("buscarTurma/{turma}")
    public String buscarTurma(@PathVariable String turma) {
        return service.buscarTurma(turma);
    }

    @PostMapping("/inserir")
    public String inserir(@RequestBody CachorroRequestDTO req) {
        CachorroResponseDTO res = service.cadastrarCachorro(req);
        return "O cachorro " + res.getNome() + ", foi cadastrado com sucesso! ID: " + res.getId();
    }

    @PatchMapping("/atualizarMatricula/{id}")
    public String atualizarMatricula(@RequestBody CachorroRequestDTO req, @PathVariable Long id) {
        CachorroResponseDTO res = service.atualizarAtivo(id, req.getAtivo());
        return "A matricula do cachorro, com ID: " + res.getId() + ", foi atualizado com sucesso!";
    }
}
