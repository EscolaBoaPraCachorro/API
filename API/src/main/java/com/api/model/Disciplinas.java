package com.api.model;

import jakarta.persistence.*;

@Entity
public class Disciplinas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Long idProfessor;

    public Disciplinas(String nome, Long idProfessor) {
        this.nome = nome;
        this.idProfessor = idProfessor;
    }

    public Disciplinas() {}

    public Long getId() {
        return id;
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idProfessor=" + idProfessor +
                '}';
    }
}
