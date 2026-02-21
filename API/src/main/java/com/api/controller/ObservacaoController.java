package com.api.controller;

import com.api.dto.cachorro.CachorroResponseDTO;
import com.api.dto.observacao.ObservacaoRequestDTO;
import com.api.dto.observacao.ObservacaoResponseDTO;
import com.api.service.Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/observacao")
public class ObservacaoController {
    private final Service service;

    public ObservacaoController(Service service) {
        this.service = service;
    }

    @GetMapping("buscarObservacaoPorIdCachorro/{id}")
    public List<ObservacaoResponseDTO> buscarObservacaoPorIdCachorro(@PathVariable Long id) {
        return service.buscarObservacaoPorIdCachorro(id);
    }

    @PostMapping("/inserirObservacoes")
    public String enviarObservacoes(@RequestBody ObservacaoRequestDTO req) {
        ObservacaoResponseDTO res = service.lancarObservacao(req.getId_cachorro(), req.getId_professor(), req.getDescricao());
        CachorroResponseDTO cao = service.buscarCaoPorId(res.getId_cachorro());
        String s = "As observações, para o cão " + cao.getNome() + ", foram enviadas com sucesso com o Id: " + res.getId();
        return s;
    }
}
