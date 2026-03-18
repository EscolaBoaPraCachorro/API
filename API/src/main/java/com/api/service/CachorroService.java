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
        List<CachorroResponseDTO> dto = new ArrayList<>();

        for (Cachorro cachorro : cao) {
            dto.add(objectMapper.convertValue(cachorro, CachorroResponseDTO.class));
        }

        return dto;
    }

    public CachorroResponseDTO buscarCachorroPorId(Long id) {
        Cachorro cao = objectMapper.convertValue(repositoryCachorro.findById(id), Cachorro.class);
        return objectMapper.convertValue(cao, CachorroResponseDTO.class);
    }

    public List<CachorroResponseDTO> buscarCachorroPorTurma(String turma) {
        List<Cachorro> cao = repositoryCachorro.findCachorroByTurma(turma);
        List<CachorroResponseDTO> dto = new ArrayList<>();

        for (Cachorro cachorro : cao) {
            dto.add(objectMapper.convertValue(cachorro, CachorroResponseDTO.class));
        }

        return dto;
    }

    public List<CachorroResponseDTO> buscarTurma(String turma) {
        List<Cachorro> cao = repositoryCachorro.findByTurma(turma);
        List<CachorroResponseDTO> dto = new ArrayList<>();

        for (Cachorro cachorro : cao) {
            dto.add(objectMapper.convertValue(cachorro, CachorroResponseDTO.class));
        }

        return dto;
    }

    public Long buscarTutorIdPorCachorro(Long id){
        Cachorro cao = objectMapper.convertValue(repositoryCachorro.findById(id), Cachorro.class);
        return cao.getTutorId();
    }

    public String buscarImagemPorId(Long id) {
        CachorroResponseDTO cao = objectMapper.convertValue(repositoryCachorro.findById(id), CachorroResponseDTO.class);
        return cao.getImagem();
    }

    public Date buscarDataNascimentoPorId(Long id) {
        CachorroResponseDTO cao = objectMapper.convertValue(repositoryCachorro.findById(id), CachorroResponseDTO.class);
        return cao.getDataNascimento();
    }

    public String buscarNomePorId(Long id) {
        CachorroResponseDTO cao = objectMapper.convertValue(repositoryCachorro.findById(id), CachorroResponseDTO.class);
        return cao.getNome();
    }

    public String buscarTurmaPorId(Long id){
        CachorroResponseDTO cao = objectMapper.convertValue(repositoryCachorro.findById(id), CachorroResponseDTO.class);
        return cao.getTurma();
    }

    public List<CachorroResponseDTO> buscarCachorroPorTutorId(Long id) {
        List<Cachorro> cachorro = repositoryCachorro.findByTutorId(id);
        List<CachorroResponseDTO> dto = new ArrayList<>();

        for (Cachorro cachorro1 : cachorro) {
            dto.add(objectMapper.convertValue(cachorro1, CachorroResponseDTO.class));
        }

        return dto;
    }

    public CachorroResponseDTO cadastrarCachorro(CachorroRequestDTO dto) {
        Cachorro cachorro = objectMapper.convertValue(dto, Cachorro.class);
        Cachorro cadastrado = repositoryCachorro.save(cachorro);
        return objectMapper.convertValue(cadastrado, CachorroResponseDTO.class);
    }

    public CachorroResponseDTO atualizarCachorro(Long id, CachorroRequestDTO req){
        Cachorro caoExistente = objectMapper.convertValue(repositoryCachorro.findById(id), Cachorro.class);

        caoExistente.setNome(req.getNome());
        caoExistente.setDataNascimento(req.getDataNascimento());
        caoExistente.setTurma(req.getTurma());
        caoExistente.setSexo(req.getSexo());
        caoExistente.setRaca(req.getRaca());
        caoExistente.setAtivo(req.getAtivo());
        caoExistente.setTemPedigree(req.getTemPedigree());
        caoExistente.setSinPatinhas(req.getSinPatinhas());
        caoExistente.setAceito(req.getAceito());
        caoExistente.setImagem(req.getImagem());
        caoExistente.setAlergia(req.getAlergias());
        caoExistente.setSituacao(req.getSituacao());

        Cachorro caoAtualizado = repositoryCachorro.save(caoExistente);

        return objectMapper.convertValue(caoAtualizado, CachorroResponseDTO.class);
    }

    public CachorroResponseDTO atualizarParcialmente(Long id, CachorroRequestDTO req){
        Cachorro caoExistente = objectMapper.convertValue(repositoryCachorro.findById(id), Cachorro.class);

        if (caoExistente.getNome() != null) {
            caoExistente.setNome(req.getNome());
        }

        if (caoExistente.getDataNascimento() != null) {
            caoExistente.setDataNascimento(req.getDataNascimento());
        }

        if (caoExistente.getTurma() != null) {
            caoExistente.setTurma(req.getTurma());
        }

        if (caoExistente.getSexo() != null) {
            caoExistente.setSexo(req.getSexo());
        }

        if (caoExistente.getRaca() != null) {
            caoExistente.setRaca(req.getRaca());
        }

        if (caoExistente.getAtivo() != null) {
            caoExistente.setAtivo(req.getAtivo());
        }

        if (caoExistente.getTemPedigree() != null) {
            caoExistente.setTemPedigree(req.getTemPedigree());
        }

        if (caoExistente.getSinPatinhas() != null) {
            caoExistente.setSinPatinhas(req.getSinPatinhas());
        }

        if (caoExistente.getAceito() != null) {
            caoExistente.setAceito(req.getAceito());
        }

        if (caoExistente.getImagem() != null) {
            caoExistente.setImagem(req.getImagem());
        }

        if (caoExistente.getAlergias() != null) {
            caoExistente.setAlergia(req.getAlergias());
        }

        Cachorro atualizado = repositoryCachorro.save(caoExistente);
        return objectMapper.convertValue(atualizado, CachorroResponseDTO.class);
    }

    public CachorroResponseDTO atualizarAtivo(Long id, Boolean ativo) {
        Cachorro cachorroExistente = objectMapper.convertValue(buscarCachorroPorId(id), Cachorro.class);
        cachorroExistente.setAtivo(ativo);
        Cachorro cachorroAtualizado = repositoryCachorro.save(cachorroExistente);
        return objectMapper.convertValue(cachorroAtualizado, CachorroResponseDTO.class);
    }

    public CachorroResponseDTO atualizarImagem(Long id, String imagem) {
        Cachorro cachorroExistente = objectMapper.convertValue(buscarCachorroPorId(id), Cachorro.class);
        cachorroExistente.setImagem(imagem);
        Cachorro cachorroAtualizado = repositoryCachorro.save(cachorroExistente);
        return objectMapper.convertValue(cachorroAtualizado, CachorroResponseDTO.class);
    }

    public CachorroResponseDTO excluirCachorro(Long id){
        Cachorro cachorro = objectMapper.convertValue(repositoryCachorro.findById(id), Cachorro.class);
        repositoryCachorro.delete(cachorro);
        return objectMapper.convertValue(cachorro, CachorroResponseDTO.class);
    }
}
