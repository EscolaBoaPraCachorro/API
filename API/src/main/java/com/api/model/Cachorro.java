package com.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Cachorro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Cachorro(
            String nome,
            Date data_nascimento,
            Integer tutor_id,
            String turma,
            Date data_cadastro,
            String sexo,
            String raca,
            Boolean ativo,
            Boolean tem_pedigree,
            String rga,
            String sin_patinhas
    ) {
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.tutor_id = tutor_id;
        this.turma = turma;
        this.data_cadastro = data_cadastro;
        this.sexo = sexo;
        this.raca = raca;
        this.ativo = ativo;
        this.tem_pedigree = tem_pedigree;
        this.rga = rga;
        this.sin_patinhas = sin_patinhas;
    }

    public Cachorro() {}

    public Long getId() {
        return id;
    }

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

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Date getData_cadastro() {
        return data_cadastro;
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

    public String getSin_patinhas() {
        return sin_patinhas;
    }

    public void setSin_patinhas(String sin_patinhas) {
        this.sin_patinhas = sin_patinhas;
    }

    @Override
    public String toString() {
        return "Cachorro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", data_nascimento=" + data_nascimento +
                ", tutor_id=" + tutor_id +
                ", turma='" + turma + '\'' +
                ", data_cadastro=" + data_cadastro +
                ", sexo='" + sexo + '\'' +
                ", raca='" + raca + '\'' +
                ", ativo=" + ativo +
                ", tem_pedigree=" + tem_pedigree +
                ", rga='" + rga + '\'' +
                ", sin_patinhas='" + sin_patinhas + '\'' +
                '}';
    }
}
