package com.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Observacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_cachorro;
    private Long id_professor;
    private String descricao;
    private Date data_publicacao;

    public Observacao(
            Long id_cachorro,
            Long id_professor,
            String descricao,
            Date data_publicacao
    ) {
        this.id_cachorro = id_cachorro;
        this.id_professor = id_professor;
        this.descricao = descricao;
        this.data_publicacao = data_publicacao;
    }

    public Observacao() {}

    public Long getId() {
        return id;
    }

    public Long getId_cachorro() {
        return id_cachorro;
    }

    public Long getId_professor() {
        return id_professor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_publicacao() {
        return data_publicacao;
    }

    @Override
    public String toString() {
        return "Observacao{" +
                "id=" + id +
                ", id_cachorro=" + id_cachorro +
                ", id_professor=" + id_professor +
                ", descricao='" + descricao + '\'' +
                ", data_publicacao=" + data_publicacao +
                '}';
    }
}
