package com.api.controller;

import com.api.dto.nota.NotaRequestDTO;
import com.api.dto.nota.NotaResponseDTO;
import com.api.model.Cachorro;
import com.api.model.Notas;
import com.api.model.Observacao;
import com.api.service.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/professor")
public class Controller {

    private final Service service;

    public Controller(Service service) { this.service = service; }

    @GetMapping("/buscarCaoPorId/{id}")
    public Cachorro buscarCaoPorId(@PathVariable Long id) {
        return service.buscarCaoPorId(id);
    }

    @PostMapping("/lançarNota")
    public String lancarNotas(@RequestBody Notas req) {
        Notas res = service.lancarNotas(req.getId_cachorro(), req.getId_professor(), req.getNota());
        Cachorro cao = service.buscarCaoPorId(res.getId_cachorro());
        return "As notas, do cachorro" + cao.getNome() + ", foram lançadas, pelo professor " + res.getId_professor() + ", com sucesso!";
    }

    @PutMapping("/atualizarNota")
    public String atualizarNota(@RequestBody NotaRequestDTO dto) {
        NotaResponseDTO res = service.atualizarNota(dto.getId_cachorro(), dto.getId_professor(), dto.getNota(), dto.getNova_nota());
        Cachorro cao = service.buscarCaoPorId(res.getId_cachorro());
        return "A nota, do cão " + cao.getNome() + ", foi atualizada com sucesso!";
    }

    @PostMapping("/enviarObservacoes")
    public String enviarObservacoes(@RequestBody Observacao req) {
        Observacao res = service.enviarObservacao(req.getId_cachorro(), req.getId_professor(), req.getDescricao());
        Cachorro cao = service.buscarCaoPorId(res.getId_cachorro());
        return "As observações, para o cão " + cao.getNome() + ", foram enviadas com sucesso!";
    }
}
