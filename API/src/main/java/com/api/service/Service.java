package com.api.service;

import com.api.dto.cachorro.CachorroResponseDTO;
import com.api.dto.nota.NotaResponseDTO;
import com.api.dto.observacao.ObservacaoResponseDTO;
import com.api.model.Cachorro;
import com.api.model.Notas;
import com.api.model.Observacao;
import com.api.repository.RepositoryCachorro;
import com.api.repository.RepositoryNotas;
import com.api.repository.RepositoryObservacao;
import tools.jackson.databind.ObjectMapper;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    private final RepositoryNotas repositoryNotas;
    private final RepositoryCachorro repositoryCachorro;
    private final RepositoryObservacao repositoryObservacao;
    private final ObjectMapper objectMapper;

    public Service(
            ObjectMapper objectMapper,
            RepositoryNotas repositoryNotas,
            RepositoryCachorro repositoryCachorro,
            RepositoryObservacao repositoryObservacao
    ) {
        this.objectMapper = objectMapper;
        this.repositoryNotas = repositoryNotas;
        this.repositoryCachorro = repositoryCachorro;
        this.repositoryObservacao = repositoryObservacao;
    }

    public CachorroResponseDTO buscarCaoPorId(Long id) {
        Optional<Cachorro> cao = repositoryCachorro.findById(id);
        return objectMapper.convertValue(cao.get(), CachorroResponseDTO.class);
    }

    public NotaResponseDTO lancarNotas(Long id_cachorro, Long id_professor, Integer nota) {
        LocalDate localDate = LocalDate.now();
        Date data_atual = Date.valueOf(localDate);
        Notas notas = new Notas(id_cachorro, id_professor, nota, data_atual);
        Notas notasEnviadas = repositoryNotas.save(notas);
        return objectMapper.convertValue(notasEnviadas, NotaResponseDTO.class);
    }

    public NotaResponseDTO atualizarNota (Long id_cachorro, Long id_professor, Integer antiga_nota, Integer nova_nota) {
        Notas notaExistente = repositoryNotas.findByIdCachorroAndIdProfessorAndNota(id_cachorro, id_professor, antiga_nota);
        notaExistente.setNota(nova_nota);

        return objectMapper.convertValue(repositoryNotas.save(notaExistente), NotaResponseDTO.class);
    }

    public ObservacaoResponseDTO enviarObservacao(Long id_cachorro, Long id_professor, String descricao) {
        LocalDate localDate = LocalDate.now();
        Date data_atual = Date.valueOf(localDate);
        Observacao observacao = new Observacao(id_cachorro, id_professor, descricao, data_atual);

        Observacao resposta = repositoryObservacao.save(observacao);
        return objectMapper.convertValue(resposta, ObservacaoResponseDTO.class);
    }
}
