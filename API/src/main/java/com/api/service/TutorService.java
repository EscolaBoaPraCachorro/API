package com.api.service;

import com.api.dto.cachorro.CachorroResponseDTO;
import com.api.dto.tutor.TutorRequestDTO;
import com.api.dto.tutor.TutorResponseDTO;
import com.api.model.Cachorro;
import com.api.model.Tutor;
import com.api.repository.RepositoryTutor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.sql.Date;

@Service
public class TutorService {
    private final RepositoryTutor repository;
    private final CachorroService service;
    private final ObjectMapper objectMapper;

    public TutorService(
            RepositoryTutor repositoryTutor,
            CachorroService cachorroService,
            ObjectMapper objectMapper
    ) {
        this.repository = repositoryTutor;
        this.service = cachorroService;
        this.objectMapper = objectMapper;
    }

    public Long buscarIdPorIdCachorro(Long idCachorro) {
        return service.buscarCaoPorId(idCachorro).getTutor_id();
    }

    public String buscarImagemPorIdTutor(Long idTutor) {
        Tutor tutor = objectMapper.convertValue(repository.findById(idTutor), Tutor.class);
        return tutor.getImagem();
    }

    public String buscarNomeTutorPorId(Long idTutor) {
        Tutor tutor = objectMapper.convertValue(repository.findById(idTutor), Tutor.class);
        return tutor.getNome();
    }

    public Date buscarDataNascimentoTutorPorId(Long idTutor) {
        Tutor tutor = objectMapper.convertValue(repository.findById(idTutor), Tutor.class);
        return tutor.getDataNascimento();
    }

    public TutorResponseDTO cadastrarTutor(TutorRequestDTO dto){
        Tutor tutor = objectMapper.convertValue(dto, Tutor.class);
        Tutor cadastrado = repository.save(tutor);
        return objectMapper.convertValue(cadastrado, TutorResponseDTO.class);
    }

    public TutorResponseDTO atualizarDescricao(Long id, String descricao) {
        Tutor tutorExistente = objectMapper.convertValue(repository.findById(id), Tutor.class);
        tutorExistente.setDescricao(descricao);
        Tutor tutorAtualizado = repository.save(tutorExistente);
        return objectMapper.convertValue(tutorAtualizado, TutorResponseDTO.class);
    }
}
