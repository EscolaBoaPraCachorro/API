package com.api.service;

import com.api.dto.cachorro.CachorroRequestDTO;
import com.api.dto.cachorro.CachorroResponseDTO;
import com.api.dto.nota.NotaResponseDTO;
import com.api.model.Cachorro;
import com.api.model.Notas;
import com.api.repository.RepositoryCachorro;
import com.api.repository.RepositoryNotas;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CachorroService {

    private RepositoryCachorro repositoryCachorro;
    private ObjectMapper objectMapper;

    public CachorroService(
            RepositoryCachorro repositoryCachorro,
            ObjectMapper objectMapper)
    {
        this.repositoryCachorro = repositoryCachorro;
        this.objectMapper = objectMapper;
    }

    public CachorroResponseDTO buscarCaoPorId(Long id) {
        Optional<Cachorro> cao = repositoryCachorro.findById(id);
        return objectMapper.convertValue(cao.get(), CachorroResponseDTO.class);
    }

    public CachorroResponseDTO cadastrarCachorro(CachorroRequestDTO dto) {
        Cachorro cachorro = objectMapper.convertValue(dto, Cachorro.class);
        Cachorro cadastrado = repositoryCachorro.save(cachorro);
        return objectMapper.convertValue(cadastrado, CachorroResponseDTO.class);
    }
}
