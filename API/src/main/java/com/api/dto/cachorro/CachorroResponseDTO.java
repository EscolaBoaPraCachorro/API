package com.api.dto.cachorro;

import com.api.model.Cachorro;

import java.util.Date;

public class CachorroResponseDTO {

    private Long id;
    private String nome;
    private Date data_nascimento;
    private Integer tutor_id;
    private String turma;
    private Date data_cadastro;
    private String sexo;
    private String raca;
    private Boolean ativo;
    private Boolean tem_pedigree;
    private String rga;
    private String sin_patinhas;
    private Boolean aceito;
    private String imagem;
    private String alergia;

    public CachorroResponseDTO(Cachorro cao) {
        this.id = cao.getId();
        this.nome = cao.getNome();
        this.data_nascimento = cao.getData_nascimento();
        this.tutor_id = cao.getTutor_id();
        this.turma = cao.getTurma();
        this.data_cadastro = cao.getData_cadastro();
        this.sexo = cao.getSexo();
        this.rga = cao.getRga();
        this.ativo = cao.getAtivo();
        this.tem_pedigree = cao.getTem_pedigree();
        this.rga = cao.getRga();
        this.sin_patinhas = cao.getSin_patinhas();
    }

    public CachorroResponseDTO() {}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public Integer getTutor_id() {
        return tutor_id;
    }

    public String getTurma() {
        return turma;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public String getSexo() {
        return sexo;
    }

    public String getRaca() {
        return raca;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public Boolean getTem_pedigree() {
        return tem_pedigree;
    }

    public String getRga() {
        return rga;
    }

    public String getSin_patinhas() {
        return sin_patinhas;
    }


}
