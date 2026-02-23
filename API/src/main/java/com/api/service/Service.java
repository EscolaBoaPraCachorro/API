package com.api.service;

import com.api.dto.cachorro.CachorroRequestDTO;
import com.api.dto.cachorro.CachorroResponseDTO;
import com.api.dto.nota.NotaResponseDTO;
import com.api.dto.observacao.ObservacaoResponseDTO;
import com.api.dto.tutor.TutorRequestDTO;
import com.api.dto.tutor.TutorResponseDTO;
import com.api.model.Cachorro;
import com.api.model.Notas;
import com.api.model.Observacao;
import com.api.model.Tutor;
import com.api.repository.RepositoryCachorro;
import com.api.repository.RepositoryNotas;
import com.api.repository.RepositoryObservacao;
import com.api.repository.RepositoryTutor;
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
    private final RepositoryTutor repositoryTutor;
    private final ObjectMapper objectMapper;

    public Service(
            ObjectMapper objectMapper,
            RepositoryNotas repositoryNotas,
            RepositoryCachorro repositoryCachorro,
            RepositoryObservacao repositoryObservacao,
            RepositoryTutor repositoryTutor
    ) {
        this.objectMapper = objectMapper;
        this.repositoryNotas = repositoryNotas;
        this.repositoryCachorro = repositoryCachorro;
        this.repositoryObservacao = repositoryObservacao;
        this.repositoryTutor = repositoryTutor;
    }


}
