package com.api.service;

import com.api.dto.cachorro.CachorroRequestDTO;
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
import java.util.ArrayList;
import java.util.List;
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

    public List<NotaResponseDTO> buscarNotaPorIdCachorro(Long idCachorro) {
        List<Notas> notas = repositoryNotas.findByIdCachorro(idCachorro);
        List<NotaResponseDTO> listNotaDTO = new ArrayList<>();

        for (Notas nota : notas) {
            listNotaDTO.add(objectMapper.convertValue(nota, NotaResponseDTO.class));
        }

        return listNotaDTO;
    }

    public List<ObservacaoResponseDTO> buscarObservacaoPorIdCachorro(Long idCachorro) {
        List<Observacao> obs = repositoryObservacao.findByIdCachorro(idCachorro);
        List<ObservacaoResponseDTO> listObservacaoDTO = new ArrayList<>();

        for (Observacao observacao : obs) {
            listObservacaoDTO.add(objectMapper.convertValue(observacao, ObservacaoResponseDTO.class));
        }

        return listObservacaoDTO;
    }

    public Integer buscarNotaDoPrimeiroSemestrePorDisciplina (Long idCachorro, Long idProfessor) {
        return repositoryNotas.findNotaByIdCachorroAndIdProfessorAndMonthLessThan(idCachorro, idProfessor);
    }

    public Integer buscarNotaDoSegundoSemestrePorDisciplina (Long idCachorro, Long idProfessor) {
        return repositoryNotas.findNotaByIdCachorroAndIdProfessorAndMonthGreaterThan(idCachorro, idProfessor);
    }

    public CachorroResponseDTO cadastrarCachorro(CachorroRequestDTO dto) {
        Cachorro cachorro = objectMapper.convertValue(dto, Cachorro.class);
        Cachorro cadastrado = repositoryCachorro.save(cachorro);
        return objectMapper.convertValue(cadastrado, CachorroResponseDTO.class);
    }

    public NotaResponseDTO lancarNotas(Long id_cachorro, Long id_professor, Integer nota) {
        LocalDate localDate = LocalDate.now();
        Date data_atual = Date.valueOf(localDate);
        Notas notas = new Notas(id_cachorro, id_professor, nota, data_atual);
        Notas notasEnviadas = repositoryNotas.save(notas);
        return objectMapper.convertValue(notasEnviadas, NotaResponseDTO.class);
    }

    public ObservacaoResponseDTO lancarObservacao(Long id_cachorro, Long id_professor, String descricao) {
        LocalDate localDate = LocalDate.now();
        Date data_atual = Date.valueOf(localDate);
        Observacao observacao = new Observacao(id_cachorro, id_professor, descricao, data_atual);

        Observacao resposta = repositoryObservacao.save(observacao);
        return objectMapper.convertValue(resposta, ObservacaoResponseDTO.class);
    }

    public NotaResponseDTO atualizarNota (Long id_cachorro, Long id_professor, Integer antiga_nota, Integer nova_nota) {
        Notas notaExistente = repositoryNotas.findByIdCachorroAndIdProfessorAndNota(id_cachorro, id_professor, antiga_nota);
        notaExistente.setNota(nova_nota);

        return objectMapper.convertValue(repositoryNotas.save(notaExistente), NotaResponseDTO.class);
    }

    public Integer calcularMedia(Long idCachorro, Long idProfessor) {
        Integer nota1 = buscarNotaDoPrimeiroSemestrePorDisciplina(idCachorro, idProfessor);
        Integer nota2 = buscarNotaDoSegundoSemestrePorDisciplina(idCachorro, idProfessor);
        return (nota1 + nota2) / 2;
    }
}
