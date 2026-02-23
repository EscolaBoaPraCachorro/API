package com.api.service;

import com.api.dto.nota.NotaResponseDTO;
import com.api.model.Notas;
import com.api.repository.RepositoryNotas;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotasService {
    private final RepositoryNotas repository;
    private final ObjectMapper objectMapper;

    public NotasService(RepositoryNotas repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    public List<NotaResponseDTO> buscarNotaPorIdCachorro(Long idCachorro) {
        List<Notas> notas = repository.findByIdCachorro(idCachorro);
        List<NotaResponseDTO> listNotaDTO = new ArrayList<>();

        for (Notas nota : notas) {
            listNotaDTO.add(objectMapper.convertValue(nota, NotaResponseDTO.class));
        }

        return listNotaDTO;
    }

    public Integer buscarNotaDoPrimeiroSemestrePorDisciplina (Long idCachorro, Long idProfessor) {
        return repository.findNotaByIdCachorroAndIdProfessorAndMonthLessThan(idCachorro, idProfessor);
    }

    public Integer buscarNotaDoSegundoSemestrePorDisciplina (Long idCachorro, Long idProfessor) {
        return repository.findNotaByIdCachorroAndIdProfessorAndMonthGreaterThan(idCachorro, idProfessor);
    }

    public Integer calcularMedia(Long idCachorro, Long idProfessor) {
        Integer nota1 = buscarNotaDoPrimeiroSemestrePorDisciplina(idCachorro, idProfessor);
        Integer nota2 = buscarNotaDoSegundoSemestrePorDisciplina(idCachorro, idProfessor);
        return (nota1 + nota2) / 2;
    }

    public NotaResponseDTO lancarNotas(Long id_cachorro, Long id_professor, Integer nota) {
        LocalDate localDate = LocalDate.now();
        Date data_atual = Date.valueOf(localDate);
        Notas notas = new Notas(id_cachorro, id_professor, nota, data_atual);
        Notas notasEnviadas = repository.save(notas);
        return objectMapper.convertValue(notasEnviadas, NotaResponseDTO.class);
    }

    public NotaResponseDTO atualizarNota (Long id_cachorro, Long id_professor, Integer antiga_nota, Integer nova_nota) {
        Notas notaExistente = repository.findByIdCachorroAndIdProfessorAndNota(id_cachorro, id_professor, antiga_nota);
        notaExistente.setNota(nova_nota);
        return objectMapper.convertValue(repository.save(notaExistente), NotaResponseDTO.class);
    }
}
