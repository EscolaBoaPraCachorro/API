package com.api.controller;

import com.api.dto.cachorro.CachorroResponseDTO;
import com.api.dto.nota.NotaRequestDTO;
import com.api.dto.nota.NotaResponseDTO;
import com.api.model.Notas;
import com.api.service.Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/notas")
public class NotaController {
    private final Service service;

    public NotaController(Service service) {
        this.service = service;
    }

    @GetMapping("buscarNotaPorIdCachorro/{id}")
    public List<NotaResponseDTO> buscarNotaPorIdCao(@PathVariable Long id) {
        return service.buscarNotaPorIdCachorro(id);
    }

    @GetMapping("buscarNotaDoPrimeiroSemestre")
    public Integer buscarNotaDoPrimeiroSemestre(@RequestBody NotaRequestDTO req) {
        return service.buscarNotaDoPrimeiroSemestrePorDisciplina(req.getId_cachorro(), req.getId_professor());
    }

    @GetMapping("buscarNotaDoSegundoSemestre")
    public Integer buscarNotaDoSegundoSemestre(@RequestBody NotaRequestDTO req) {
        return service.buscarNotaDoSegundoSemestrePorDisciplina(req.getId_cachorro(), req.getId_professor());
    }

    @PostMapping("/lançarNota")
    public String lancarNotas(@RequestBody Notas req) {
        NotaResponseDTO res = service.lancarNotas(req.getIdCachorro(), req.getIdProfessor(), req.getNota());
        CachorroResponseDTO cao = service.buscarCaoPorId(res.getId_cachorro());
        return "As notas, do cachorro" + cao.getNome() + ", foram lançadas, pelo professor " + res.getId_professor() + ", com sucesso!";
    }

    @PutMapping("/atualizarNota")
    public String atualizarNota(@RequestBody NotaRequestDTO dto) {
        NotaResponseDTO res = service.atualizarNota(dto.getId_cachorro(), dto.getId_professor(), dto.getNota(), dto.getNova_nota());
        CachorroResponseDTO cao = service.buscarCaoPorId(res.getId_cachorro());
        return "A nota, do cão " + cao.getNome() + ", foi atualizada com sucesso!";
    }
}
