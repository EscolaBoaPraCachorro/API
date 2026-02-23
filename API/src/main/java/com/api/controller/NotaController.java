package com.api.controller;

import com.api.dto.cachorro.CachorroResponseDTO;
import com.api.dto.nota.NotaRequestDTO;
import com.api.dto.nota.NotaResponseDTO;
import com.api.model.Notas;
import com.api.service.CachorroService;
import com.api.service.NotasService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/notas")
public class NotaController {
    private final NotasService notasService;
    private final CachorroService cachorroService;

    public NotaController(NotasService service, CachorroService cachorroService) {
        this.notasService = service;
        this.cachorroService = cachorroService;
    }

    @GetMapping("/buscarNotaPorIdCachorro/{id}")
    public List<NotaResponseDTO> buscarNotaPorIdCao(@PathVariable Long id) {
        return notasService.buscarNotaPorIdCachorro(id);
    }

    @GetMapping("/buscarNotaDoPrimeiroSemestre")
    public Integer buscarNotaDoPrimeiroSemestre(@RequestBody NotaRequestDTO req) {
        return notasService.buscarNotaDoPrimeiroSemestrePorDisciplina(req.getId_cachorro(), req.getId_professor());
    }

    @GetMapping("/buscarNotaDoSegundoSemestre")
    public Integer buscarNotaDoSegundoSemestre(@RequestBody NotaRequestDTO req) {
        return notasService.buscarNotaDoSegundoSemestrePorDisciplina(req.getId_cachorro(), req.getId_professor());
    }

    @PostMapping("/inserirNota")
    public String lancarNotas(@RequestBody Notas req) {
        NotaResponseDTO res = notasService.lancarNotas(req.getIdCachorro(), req.getIdProfessor(), req.getNota());
        CachorroResponseDTO cao = cachorroService.buscarCaoPorId(res.getId_cachorro());
        return "As notas, do cachorro" + cao.getNome() + ", foram lançadas, pelo professor " + res.getId_professor() + ", com sucesso!";
    }

    @PutMapping("/atualizarNota")
    public String atualizarNota(@RequestBody NotaRequestDTO dto) {
        NotaResponseDTO res = notasService.atualizarNota(dto.getId_cachorro(), dto.getId_professor(), dto.getNota(), dto.getNova_nota());
        CachorroResponseDTO cao = cachorroService.buscarCaoPorId(res.getId_cachorro());
        return "A nota, do cão " + cao.getNome() + ", foi atualizada com sucesso!";
    }
}
