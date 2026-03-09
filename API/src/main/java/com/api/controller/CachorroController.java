package com.api.controller;

import com.api.dto.cachorro.CachorroRequestDTO;
import com.api.dto.cachorro.CachorroResponseDTO;
import com.api.service.CachorroService;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/cao")
public class CachorroController {

    private final CachorroService service;

    public CachorroController(CachorroService service) { this.service = service; }

    @GetMapping("/listar")
    public List<CachorroResponseDTO> listarCaes() {
        return service.listarCaes();
    }

    @GetMapping("/buscarCaoPorId/{id}")
    public CachorroResponseDTO buscarCaoPorId(@PathVariable Long id) {
        return service.buscarCaoPorId(id);
    }

    @GetMapping("/buscarTurma/{turma}")
    public CachorroResponseDTO buscarCaoPorTurma(@PathVariable String turma) {
        return service.buscarCachorroPorTurma(URLDecoder.decode(turma, StandardCharsets.UTF_8));
    }

    @GetMapping("/buscarCaoPorTurma/{turma}")
    public List<CachorroResponseDTO> buscarTurma(@PathVariable String turma) {
        return service.buscarTurma(URLDecoder.decode(turma, StandardCharsets.UTF_8));
    }

    @GetMapping("/buscarImagemPorCachorro/{id}")
    public String buscarImagemPorCachorro(@PathVariable Long id) {
        return service. buscarImagemPorCachorro(id);
    }

    @GetMapping("/buscarDataNascimentoPorCachorro/{id}")
    public Date buscarDataNascimentoPorCachorro(@PathVariable Long id) {
        return service.buscarDataNascimentoPorCachorro(id);
    }

    @GetMapping("/buscarNomePorCachorro/{id}")
    public String buscarNomePorCachorro(@PathVariable Long id) {
        return service.buscarNomePorCachorro(id);
    }

    @GetMapping("/buscarTurmaPorCachorro/{id}")
    public String buscarTurmaPorCachorro(@PathVariable Long id) {
        return service.buscarTurmaPorCachorro(id);
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
