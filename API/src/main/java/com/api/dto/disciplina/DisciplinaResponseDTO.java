package com.api.dto.disciplina;

import com.api.model.Disciplina;

public class DisciplinaResponseDTO {
    private Long id;
    private String nome;
    private Long idProfessor;

    public DisciplinaResponseDTO(Disciplina disciplina) {
        this.id = disciplina.getId();
        this.nome = disciplina.getNome();
        this.idProfessor = disciplina.getIdProfessor();
    }

    public Long getId() {
        return id;
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public String getNome() {
        return nome;
    }
}
