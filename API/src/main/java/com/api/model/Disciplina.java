package com.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Long idProfessor;

    public Disciplina(String nome, Long idProfessor) {
        this.nome = nome;
        this.idProfessor = idProfessor;
    }

    public Disciplina() {}

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
