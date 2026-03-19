package com.api.dto.disciplina;

public class DisciplinasRequestDTO {
    private String nome;
    private Long idProfessor;

    public DisciplinasRequestDTO() {}

    public DisciplinasRequestDTO(String nome, Long idProfessor) {
        this.nome = nome;
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
    }
}