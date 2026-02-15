package com.api.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Notas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_cachorro")
    private Long idCachorro;
    @Column(name = "id_professor")
    private Long idProfessor;
    private Integer nota;
    private Date data_publicacao;

    public Notas(Long idCachorro, Long idProfessor, Integer nota, Date data_publicacao) {
        this.idCachorro = idCachorro;
        this.idProfessor = idProfessor;
        this.nota = nota;
        this.data_publicacao = data_publicacao;
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

    public Date getData_publicacao() {
        return data_publicacao;
    }

    @Override
    public String toString() {
        return "Notas{" +
                "id=" + id +
                ", idCachorro=" + idCachorro +
                ", idProfessor=" + idProfessor +
                ", nota=" + nota +
                ", data_publicacao=" + data_publicacao +
                '}';
    }
}
