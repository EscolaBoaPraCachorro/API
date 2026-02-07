package com.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Notas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_cachorro;
    private Long id_professor;
    private Integer nota;
    private Date data_publicacao;

    public Notas(Long id_cachorro, Long id_professor, Integer nota, Date data_publicacao) {
        this.id_cachorro = id_cachorro;
        this.id_professor = id_professor;
        this.nota = nota;
        this.data_publicacao = data_publicacao;
    }

    public Notas() {}

    public Long getId() {
        return id;
    }

    public Long getId_cachorro() {
        return id_cachorro;
    }

    public Long getId_professor() {
        return id_professor;
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
                ", id_cachorro=" + id_cachorro +
                ", id_professor=" + id_professor +
                ", nota=" + nota +
                ", data_publicacao=" + data_publicacao +
                '}';
    }
}
