package com.api.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Notas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_cachorro", nullable = false)
    private Long idCachorro;
    @Column(name = "id_professor", nullable = false)
    private Long idProfessor;
    private Integer nota;
    @Column(name = "data_publicacao", nullable = false)
    private Date dataPublicacao;
    private Integer semestre;

    public Notas(Long idCachorro, Long idProfessor, Integer nota, Date data_publicacao, Integer semestre) {
        this.idCachorro = idCachorro;
        this.idProfessor = idProfessor;
        this.nota = nota;
        this.dataPublicacao = data_publicacao;
        this.semestre = semestre;
    }

    public Notas() {}

    public Long getId() {
        return id;
    }

    public Long getIdCachorro() {
        return idCachorro;
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "Notas{" +
                "id=" + id +
                ", idCachorro=" + idCachorro +
                ", idProfessor=" + idProfessor +
                ", nota=" + nota +
                ", dataPublicacao=" + dataPublicacao +
                ", semestre=" + semestre +
                '}';
    }
}
