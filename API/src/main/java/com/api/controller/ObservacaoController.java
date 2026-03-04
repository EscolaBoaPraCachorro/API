package com.api.controller;

import com.api.dto.cachorro.CachorroResponseDTO;
import com.api.dto.observacao.ObservacaoRequestDTO;
import com.api.dto.observacao.ObservacaoResponseDTO;
import com.api.service.CachorroService;
import com.api.service.ObservacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/observacao")
public class ObservacaoController {
    private final ObservacaoService observacaoService;
    private final CachorroService cachorroService;

    public ObservacaoController(ObservacaoService observacaoService, CachorroService cachorroService) {
        this.observacaoService = observacaoService;
        this.cachorroService = cachorroService;
    }

    @GetMapping("/buscarObservacaoPorIdCachorro/{idCachorro}/Disciplina/{idProfessor}")
    public List<ObservacaoResponseDTO> buscarObservacaoPorIdCachorroEDisciplina(
            @PathVariable Long idCachorro, @PathVariable Long idProfessor
    ) {
        return observacaoService.buscarObservacaoPorIdCachorroEDisciplina(idCachorro, idProfessor);
    }

    @PostMapping("/inserirObservacoes")
    public String enviarObservacoes(@RequestBody ObservacaoRequestDTO req) {
        ObservacaoResponseDTO res = observacaoService.lancarObservacao(req.getId_cachorro(), req.getId_professor(), req.getDescricao());
        CachorroResponseDTO cao = cachorroService.buscarCaoPorId(res.getId_cachorro());
        return "As observações, para o cão " + cao.getNome() + ", foram enviadas com sucesso com o Id: " + res.getId();
    }
}
