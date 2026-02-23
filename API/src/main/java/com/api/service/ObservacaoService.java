package com.api.service;

import com.api.dto.observacao.ObservacaoResponseDTO;
import com.api.model.Observacao;
import com.api.repository.RepositoryObservacao;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ObservacaoService {
    private final RepositoryObservacao repository;
    private final ObjectMapper objectMapper;

    public ObservacaoService(RepositoryObservacao repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    public List<ObservacaoResponseDTO> buscarObservacaoPorIdCachorro(Long idCachorro) {
        List<Observacao> obs = repository.findByIdCachorro(idCachorro);
        List<ObservacaoResponseDTO> listObservacaoDTO = new ArrayList<>();

        for (Observacao observacao : obs) {
            listObservacaoDTO.add(objectMapper.convertValue(observacao, ObservacaoResponseDTO.class));
        }

        return listObservacaoDTO;
    }

    public ObservacaoResponseDTO lancarObservacao(Long id_cachorro, Long id_professor, String descricao) {
        LocalDate localDate = LocalDate.now();
        Date data_atual = Date.valueOf(localDate);
        Observacao observacao = new Observacao(id_cachorro, id_professor, descricao, data_atual);

        Observacao resposta = repository.save(observacao);
        return objectMapper.convertValue(resposta, ObservacaoResponseDTO.class);
    }
}
