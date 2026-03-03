package com.api.dto.professor;

import com.api.model.Professor;

import java.util.Date;

public class ProfessorResponseDTO {

    private Long id;
    private String nome;
    private Date data_nascimento;
    private String endereco;
    private String genero;
    private String telefone;
    private String cpf;
    private String rg;
    private String email;
    private String disciplina;

    public ProfessorResponseDTO() {}

    public ProfessorResponseDTO(Professor professor) {
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.data_nascimento = professor.getData_nascimento();
        this.endereco = professor.getEndereco();
        this.genero = professor.getGenero();
        this.telefone = professor.getTelefone();
        this.cpf = professor.getCpf();
        this.rg = professor.getRg();
        this.email = professor.getEmail();
        this.disciplina = professor.getDisciplina();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getGenero() {
        return genero;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getEmail() {
        return email;
    }

    public String getDisciplina() {
        return disciplina;
    }
}
