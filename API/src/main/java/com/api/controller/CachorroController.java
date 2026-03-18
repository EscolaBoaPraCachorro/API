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
        return service.buscarCachorroPorId(id);
    }

    @GetMapping("/buscarCaoPorTurma/{turma}")
    public List<CachorroResponseDTO> buscarCaoPorTurma(@PathVariable String turma) {
        return service.buscarCachorroPorTurma(URLDecoder.decode(turma, StandardCharsets.UTF_8));
    }

    @GetMapping("/buscarTurma/{turma}")
    public List<CachorroResponseDTO> buscarTurma(@PathVariable String turma) {
        return service.buscarTurma(URLDecoder.decode(turma, StandardCharsets.UTF_8));
    }

    @GetMapping("/buscarImagemPorCachorro/{id}")
    public String buscarImagemPorCachorro(@PathVariable Long id) {
        return service.buscarImagemPorId(id);
    }

    @GetMapping("/buscarDataNascimentoPorCachorro/{id}")
    public Date buscarDataNascimentoPorCachorro(@PathVariable Long id) {
        return service.buscarDataNascimentoPorId(id);
    }

    @GetMapping("/buscarNomePorCachorro/{id}")
    public String buscarNomePorCachorro(@PathVariable Long id) {
        return service.buscarNomePorId(id);
    }

    @GetMapping("/buscarTurmaPorCachorro/{id}")
    public String buscarTurmaPorCachorro(@PathVariable Long id) {
        return service.buscarTurmaPorId(id);
    }

    @GetMapping("/buscarCachorroPorIdTutor/{id}")
    public List<CachorroResponseDTO> buscarCachorroPorIdTutor(@PathVariable Long id) {
        return service.buscarCachorroPorTutorId(id);
    }

    @GetMapping("/buscarTutorIdPorCachorro/{id}")
    public Long buscarTutorIdPorCachorro(@PathVariable Long id){
        return service.buscarTutorIdPorCachorro(id);
    }

    @PostMapping("/inserir")
    public String inserir(@RequestBody CachorroRequestDTO req) {
        CachorroResponseDTO res = service.cadastrarCachorro(req);
        return "O cachorro " + res.getNome() + ", foi cadastrado com sucesso! ID: " + res.getId();
    }

    @PutMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id, @RequestBody CachorroRequestDTO req) {
        CachorroResponseDTO res = service.atualizarCachorro(id, req);
        return "O cachorro " + res.getNome() + ", foi modificado com sucesso! ID: " + res.getId();
    }

    @PatchMapping("/atualizarParcialmente/{id}")
    public String atualizarParcialmente(@PathVariable Long id, @RequestBody CachorroRequestDTO req){
        CachorroResponseDTO res = service.atualizarParcialmente(id, req);
        return "Atualização do cachorro " + res.getNome() + " feita com sucesso!";
    }

    @PatchMapping("/atualizarMatricula/{id}")
    public String atualizarMatricula(@RequestBody CachorroRequestDTO req, @PathVariable Long id) {
        CachorroResponseDTO res = service.atualizarAtivo(id, req.getAtivo());
        return "A matricula do cachorro, com ID: " + res.getId() + ", foi atualizado com sucesso!";
    }

    @PatchMapping("/atualizarImagem/{id}")
    public String atualizarImagem(@RequestBody CachorroRequestDTO req, @PathVariable Long id) {
        CachorroResponseDTO res = service.atualizarImagem(id, req.getImagem());
        return "A imagem do cachoroo, com ID: " + res.getId() + ", foi atualizada com sucesso!";
    }

    @DeleteMapping("/excluir/{id}")
    public String deletar(@PathVariable Long id) {
        CachorroResponseDTO res = service.excluirCachorro(id);
        return "O cachorro " + res.getNome() + " foi excluido com sucesso!";
    }
}
