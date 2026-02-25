package com.api.service;

import com.api.dto.cachorro.CachorroRequestDTO;
import com.api.dto.cachorro.CachorroResponseDTO;
import com.api.model.Cachorro;
import com.api.repository.RepositoryCachorro;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.Optional;

@Service
public class CachorroService {

    private RepositoryCachorro repositoryCachorro;
    private ObjectMapper objectMapper;

    public CachorroService(RepositoryCachorro repositoryCachorro, ObjectMapper objectMapper) {
        this.repositoryCachorro = repositoryCachorro;
        this.objectMapper = objectMapper;
    }

    public CachorroResponseDTO buscarCaoPorId(Long id) {
        Optional<Cachorro> cao = repositoryCachorro.findById(id);
        return objectMapper.convertValue(cao.get(), CachorroResponseDTO.class);
    }

    public String buscarTurma(String turma) {
        Cachorro cao = repositoryCachorro.findByTurma(turma);
        return cao.getTurma();
    }

    public CachorroResponseDTO cadastrarCachorro(CachorroRequestDTO dto) {
        Cachorro cachorro = objectMapper.convertValue(dto, Cachorro.class);
        Cachorro cadastrado = repositoryCachorro.save(cachorro);
        return objectMapper.convertValue(cadastrado, CachorroResponseDTO.class);
    }

    public CachorroResponseDTO atualizarAtivo(Long id, Boolean ativo) {
        Cachorro cachorroExistente = objectMapper.convertValue(buscarCaoPorId(id), Cachorro.class);
        cachorroExistente.setAtivo(ativo);
        Cachorro cachorroAtualizado = repositoryCachorro.save(cachorroExistente);
        return objectMapper.convertValue(cachorroAtualizado, CachorroResponseDTO.class);
    }
}
