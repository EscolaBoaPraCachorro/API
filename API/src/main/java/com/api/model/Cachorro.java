package com.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Cachorro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    @Column(name = "tutor_id")
    private Long tutorId;
    private String turma;
    @JsonProperty("data_cadastro")
    private Date dataCadastro;
    private String sexo;
    private String raca;
    private Boolean ativo;
    @Column(name = "tem_pedigree")
    private Boolean temPedigree;
    private String rga;
    @Column(name = "sin_patinhas")
    private String sinPatinhas;
    private Boolean aceito;
    private String imagem;
    private String alergias;
    private String situacao;

    public Cachorro(
            Long id,
            String nome,
            Date dataNascimento,
            Long tutor_id,
            String turma,
            Date dataCadastro,
            String sexo,
            String raca,
            Boolean ativo,
            Boolean temPedigree,
            String rga,
            String sinPatinhas,
            Boolean aceito,
            String imagem,
            String alergia,
            String situacao
    ) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.tutorId = tutor_id;
        this.turma = turma;
        this.dataCadastro = dataCadastro;
        this.sexo = sexo;
        this.raca = raca;
        this.ativo = ativo;
        this.temPedigree = temPedigree;
        this.rga = rga;
        this.sinPatinhas = sinPatinhas;
        this.aceito = aceito;
        this.imagem = imagem;
        this.alergias = alergia;
        this.situacao = situacao;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId){
        this.tutorId = tutorId;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
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

    public Boolean getTemPedigree() {
        return temPedigree;
    }

    public void setTemPedigree(Boolean temPedigree) {
        this.temPedigree = temPedigree;
    }

    public String getRga() {
        return rga;
    }

    public void setRga(String rga) {
        this.rga = rga;
    }

    public String getSinPatinhas() {
        return sinPatinhas;
    }

    public void setSinPatinhas(String sinPatinhas) {
        this.sinPatinhas = sinPatinhas;
    }

    public Boolean getAceito() {
        return aceito;
    }

    public void setAceito(Boolean aceito) {
        this.aceito = aceito;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergia(String alergia) {
        this.alergias = alergia;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "Cachorro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", tutor_id=" + tutorId +
                ", turma='" + turma + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", sexo='" + sexo + '\'' +
                ", raca='" + raca + '\'' +
                ", ativo=" + ativo +
                ", temPedigree=" + temPedigree +
                ", rga='" + rga + '\'' +
                ", sinPatinhas='" + sinPatinhas + '\'' +
                ", aceito=" + aceito +
                ", imagem='" + imagem + '\'' +
                ", alergia='" + alergias + '\'' +
                ", situacao='" + situacao + '\'' +
                '}';
    }
}
