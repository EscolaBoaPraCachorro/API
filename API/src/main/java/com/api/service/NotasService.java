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
    private final DisciplinasService disciplinaService;
    private final ObjectMapper objectMapper;

    public NotasService(
            RepositoryNotas repository,
            DisciplinasService disciplinaService,
            ObjectMapper objectMapper
    ) {
        this.repository = repository;
        this.disciplinaService = disciplinaService;
        this.objectMapper = objectMapper;
    }

    public List<NotaResponseDTO> buscarNotaPorIdCachorro(Long idCachorro) {
        List<Notas> notas = repository.findByIdCachorro(idCachorro);
        System.out.println(notas);
        List<NotaResponseDTO> listNotaDTO = new ArrayList<>();

        for (Notas nota : notas) {
            listNotaDTO.add(objectMapper.convertValue(nota, NotaResponseDTO.class));
        }

        return listNotaDTO;
    }

    public List<NotaResponseDTO> buscarNotaPorIdCaoEIdProfessor(Long idCachorro, Long idProfessor) {
        List<Notas> notas = repository.findByIdCachorroAndIdProfessor(idCachorro, idProfessor);
        List<NotaResponseDTO> listNotaDTO = new ArrayList<>();

        for (Notas nota : notas) {
            listNotaDTO.add(objectMapper.convertValue(nota, NotaResponseDTO.class));
        }

        return listNotaDTO;
    }

    public List<NotaResponseDTO> buscarNotasPorDisciplina(String disciplina) {
        Long idProfessor = disciplinaService.buscarIdProfessorPorDisciplina(disciplina);
        List<Notas> notas = repository.findByIdProfessor(idProfessor);
        List<NotaResponseDTO> listNotaDTO = new ArrayList<>();

        for (Notas nota : notas) {
            listNotaDTO.add(objectMapper.convertValue(nota, NotaResponseDTO.class));
        }

        return listNotaDTO;
    }

    public Integer buscarNotaDoPrimeiroSemestrePorDisciplina (Long idCachorro, String disciplina) {
        Long idProf = disciplinaService.buscarIdProfessorPorDisciplina(disciplina);
        return repository.findNotaByIdCachorroAndIdProfessorAndMonthLessThan(idCachorro, idProf);
    }

    public Integer buscarNotaDoSegundoSemestrePorDisciplina (Long idCachorro, String disciplina) {
        Long idProf = disciplinaService.buscarIdProfessorPorDisciplina(disciplina);
        return repository.findNotaByIdCachorroAndIdProfessorAndMonthGreaterThan(idCachorro, idProf);
    }

    public Integer calcularMedia(Long idCachorro, String disciplina) {
        Integer nota1 = buscarNotaDoPrimeiroSemestrePorDisciplina(idCachorro, disciplina);
        Integer nota2 = buscarNotaDoSegundoSemestrePorDisciplina(idCachorro, disciplina);
        return (nota1 + nota2) / 2;
    }

    public NotaResponseDTO lancarNotas(Long id_cachorro, String disciplina, Integer nota, Integer semestre) {
        LocalDate localDate = LocalDate.now();
        Date data_atual = Date.valueOf(localDate);

        Long idProf = disciplinaService.buscarIdProfessorPorDisciplina(disciplina);

        Notas notas = new Notas(id_cachorro, idProf, nota, data_atual, semestre);
        Notas notasEnviadas = repository.save(notas);
        return objectMapper.convertValue(notasEnviadas, NotaResponseDTO.class);
    }

    public NotaResponseDTO atualizarNota (Long id_cachorro, Long id_professor, Integer antiga_nota, Integer nova_nota) {
        Notas notaExistente = repository.findByIdCachorroAndIdProfessorAndNota(id_cachorro, id_professor, antiga_nota);
        notaExistente.setNota(nova_nota);
        return objectMapper.convertValue(repository.save(notaExistente), NotaResponseDTO.class);
    }
}
