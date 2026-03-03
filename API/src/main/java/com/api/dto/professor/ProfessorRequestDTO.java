package com.api.dto.professor;

import java.util.Date;

public class ProfessorRequestDTO {
    private String nome;
    private Date data_nascimento;
    private String endereco;
    private String genero;
    private String telefone;
    private String cpf;
    private String rg;
    private String email;
    private String disciplina;

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
