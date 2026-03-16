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

    @GetMapping("/buscarNotaPorIdCao/{id}")
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
        return notasService.buscarNotaDoPrimeiroSemestrePorDisciplina(req.getIdCachorro(), disciplina);
    }

    @GetMapping("/buscarNotaDoSegundoSemestre/{disciplina}")
    public Integer buscarNotaDoSegundoSemestre(@RequestBody NotaRequestDTO req, @PathVariable String disciplina) {
        return notasService.buscarNotaDoSegundoSemestrePorDisciplina(req.getIdCachorro(), disciplina);
    }

    @GetMapping("/calcularMedia/{disciplina}")
    public Integer calcularMedia(@RequestBody NotaRequestDTO req, @PathVariable String disciplina) {
        return notasService.calcularMedia(req.getIdCachorro(), disciplina);
    }

    @PostMapping("/inserirNota/{disciplina}")
    public String lancarNotas(@RequestBody NotaRequestDTO req, @PathVariable String disciplina) {
        NotaResponseDTO res = notasService.lancarNotas(req.getIdCachorro(), disciplina, req.getNota(), req.getSemestre());
        CachorroResponseDTO cao = cachorroService.buscarCaoPorId(res.getIdCachorro());
        return "As notas, do cachorro" + cao.getNome() + ", foram lançadas, pelo professor " + res.getIdProfessor() + ", com sucesso!";
    }

    @PutMapping("/atualizarNota")
    public String atualizarNota(@RequestBody NotaRequestDTO dto) {
        NotaResponseDTO res = notasService.atualizarNota(dto.getIdCachorro(), dto.getIdProfessor(), dto.getNota(), dto.getNova_nota());
        CachorroResponseDTO cao = cachorroService.buscarCaoPorId(res.getIdCachorro());
        return "A nota, do cão " + cao.getNome() + ", foi atualizada com sucesso!";
    }

    @DeleteMapping("/excluir/{id}")
    public String excluirNota(@PathVariable Long id) {
        NotaResponseDTO res = notasService.excluirNota(id);
        CachorroResponseDTO cao = cachorroService.buscarCaoPorId(res.getIdCachorro());
        return "A nota do cachorro " + cao.getNome() + " foi excluido com sucesso!!!";
    }

}
