package com.api.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Observacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_cachorro")
    private Long idCachorro;
    @Column(name = "id_professor")
    private Long idProfessor;
    private String descricao;
    private Date data_publicacao;

    public Observacao(
            Long id_cachorro,
            Long id_professor,
            String descricao,
            Date data_publicacao
    ) {
        this.idCachorro = id_cachorro;
        this.idProfessor = id_professor;
        this.descricao = descricao;
        this.data_publicacao = data_publicacao;
    }

    public Observacao() {}

    public Long getId() {
        return id;
    }

    public Long getId_cachorro() {
        return idCachorro;
    }

    public Long getId_professor() {
        return idProfessor;
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
                ", id_cachorro=" + idCachorro +
                ", id_professor=" + idProfessor +
                ", descricao='" + descricao + '\'' +
                ", data_publicacao=" + data_publicacao +
                '}';
    }
}
