package com.api.controller;

import com.api.dto.cachorro.CachorroResponseDTO;
import com.api.dto.observacao.ObservacaoRequestDTO;
import com.api.dto.observacao.ObservacaoResponseDTO;
import com.api.service.CachorroService;
import com.api.service.ObservacaoService;
import com.api.service.Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/observacao")
public class ObservacaoController {
    private final ObservacaoService observacaoService;
    private final CachorroService cachorroService;

    public ObservacaoController(ObservacaoService observacaoService, CachorroService cachorroService) {
        this.observacaoService = observacaoService;
        this.cachorroService = cachorroService;
    }

    @GetMapping("buscarObservacaoPorIdCachorro/{id}")
    public List<ObservacaoResponseDTO> buscarObservacaoPorIdCachorro(@PathVariable Long id) {
        return observacaoService.buscarObservacaoPorIdCachorro(id);
    }

    @PostMapping("/inserirObservacoes")
    public String enviarObservacoes(@RequestBody ObservacaoRequestDTO req) {
        ObservacaoResponseDTO res = observacaoService.lancarObservacao(req.getId_cachorro(), req.getId_professor(), req.getDescricao());
        CachorroResponseDTO cao = cachorroService.buscarCaoPorId(res.getId_cachorro());
        return "As observações, para o cão " + cao.getNome() + ", foram enviadas com sucesso com o Id: " + res.getId();
    }
}
