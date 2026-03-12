package com.api.dto.disciplina;

import com.api.model.Disciplinas;

public class DisciplinasResponseDTO {
    private Long id;
    private String nome;
    private Long idProfessor;

    public DisciplinasResponseDTO(Disciplinas disciplinas) {
        this.id = disciplinas.getId();
        this.nome = disciplinas.getNome();
        this.idProfessor = disciplinas.getIdProfessor();
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
