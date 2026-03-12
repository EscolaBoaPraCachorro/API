package com.api.controller;

import com.api.dto.cachorro.CachorroResponseDTO;
import com.api.dto.nota.NotaRequestDTO;
import com.api.dto.nota.NotaResponseDTO;
import com.api.service.CachorroService;
import com.api.service.NotasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @GetMapping("/buscarNotaPorIdCachorro/{idCachorro}/Disciplina/{idProfessor}")
    public List<NotaResponseDTO> buscarNotaPorIdCaoEIdProfessor(
            @PathVariable Long idCachorro, @PathVariable Long idProfessor
    ) {
        return notasService.buscarNotaPorIdCaoEIdProfessor(idCachorro, idProfessor);
    }

    @GetMapping("/buscarNotaPorDisciplina/{disciplina}")
    public List<NotaResponseDTO> buscarNotaPorIdCaoEDisciplina(@PathVariable String disciplina) {
        return notasService.buscarNotasPorDisciplina(disciplina);
    }

    @GetMapping("/buscarNotaDoPrimeiroSemestre/{disciplina}")
    public Integer buscarNotaDoPrimeiroSemestre(@RequestBody NotaRequestDTO req, @PathVariable String disciplina) {
        return notasService.buscarNotaDoPrimeiroSemestrePorDisciplina(req.getId_cachorro(), disciplina);
    }

    @GetMapping("/buscarNotaDoSegundoSemestre/{disciplina}")
    public Integer buscarNotaDoSegundoSemestre(@RequestBody NotaRequestDTO req, @PathVariable String disciplina) {
        return notasService.buscarNotaDoSegundoSemestrePorDisciplina(req.getId_cachorro(), disciplina);
    }

    @GetMapping("/calcularMedia/{disciplina}")
    public Integer calcularMedia(@RequestBody NotaRequestDTO req, @PathVariable String disciplina) {
        return notasService.calcularMedia(req.getId_cachorro(), disciplina);
    }

    @PostMapping("/inserirNota/{disciplina}")
    public String lancarNotas(@RequestBody NotaRequestDTO req, @PathVariable String disciplina) {
        NotaResponseDTO res = notasService.lancarNotas(req.getId_cachorro(), disciplina, req.getNota());
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
