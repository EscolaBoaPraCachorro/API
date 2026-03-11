package com.api.service;

import com.api.dto.cachorro.CachorroRequestDTO;
import com.api.dto.cachorro.CachorroResponseDTO;
import com.api.model.Cachorro;
import com.api.repository.RepositoryCachorro;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CachorroService {

    private final RepositoryCachorro repositoryCachorro;
    private final ObjectMapper objectMapper;

    public CachorroService(RepositoryCachorro repositoryCachorro, ObjectMapper objectMapper) {
        this.repositoryCachorro = repositoryCachorro;
        this.objectMapper = objectMapper;
    }

    public List<CachorroResponseDTO> listarCaes() {
        List<Cachorro> cao = repositoryCachorro.findAll();
        List<CachorroResponseDTO> listCaoDTO = new ArrayList<>();

        for (Cachorro cachorro : cao) {
            listCaoDTO.add(objectMapper.convertValue(cachorro, CachorroResponseDTO.class));
        }

        return listCaoDTO;
    }

    public CachorroResponseDTO buscarCaoPorId(Long id) {
        Cachorro cao = objectMapper.convertValue(repositoryCachorro.findById(id), Cachorro.class);
        return objectMapper.convertValue(cao, CachorroResponseDTO.class);
    }

    public CachorroResponseDTO buscarCachorroPorTurma(String turma) {
        return repositoryCachorro.findCachorroByTurma(turma);
    }

    public List<CachorroResponseDTO> buscarTurma(String turma) {
        List<Cachorro> cao = repositoryCachorro.findByTurma(turma);
        List<CachorroResponseDTO> dto = new ArrayList<>();

        for (Cachorro cachorro : cao) {
            dto.add(objectMapper.convertValue(cachorro, CachorroResponseDTO.class));
        }
        return dto;
    }

    public String buscarImagemPorCachorro(Long id) {
        CachorroResponseDTO cao = objectMapper.convertValue(repositoryCachorro.findById(id), CachorroResponseDTO.class);
        return cao.getImagem();
    }

    public Date buscarDataNascimentoPorCachorro(Long id) {
        CachorroResponseDTO cao = objectMapper.convertValue(repositoryCachorro.findById(id), CachorroResponseDTO.class);
        return cao.getData_nascimento();
    }

    public String buscarNomePorCachorro(Long id) {
        CachorroResponseDTO cao = objectMapper.convertValue(repositoryCachorro.findById(id), CachorroResponseDTO.class);
        return cao.getNome();
    }

    public String buscarTurmaPorCachorro(Long id){
        CachorroResponseDTO cao = objectMapper.convertValue(repositoryCachorro.findById(id), CachorroResponseDTO.class);
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

    public CachorroResponseDTO atualizarImagem(Long id, String imagem) {
        Cachorro cachorroExistente = objectMapper.convertValue(buscarCaoPorId(id), Cachorro.class);
        cachorroExistente.setImagem(imagem);
        Cachorro cachorroAtualizado = repositoryCachorro.save(cachorroExistente);
        return objectMapper.convertValue(cachorroAtualizado, CachorroResponseDTO.class);
    }
}
