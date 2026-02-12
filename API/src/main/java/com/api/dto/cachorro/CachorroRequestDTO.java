package com.api.dto.cachorro;

import java.util.Date;

public class CachorroRequestDTO {

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Integer getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(Integer tutor_id) {
        this.tutor_id = tutor_id;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean getTem_pedigree() {
        return tem_pedigree;
    }

    public void setTem_pedigree(Boolean tem_pedigree) {
        this.tem_pedigree = tem_pedigree;
    }

    public String getRga() {
        return rga;
    }

    public void setRga(String rga) {
        this.rga = rga;
    }

    public String getSin_patinhas() {
        return sin_patinhas;
    }

    public void setSin_patinhas(String sin_patinhas) {
        this.sin_patinhas = sin_patinhas;
    }
}
