package com.api.dto.tutor;

import java.sql.Date;

public class TutorRequestDTO {

    private String nome;
    private Date dataNascimento;
    private String endereco;
    private String data_cadastro;
    private String genero;
    private String telefone;
    private String cpf;
    private String rg;
    private String email;
    private String imagem;

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getData_cadastro() {
        return data_cadastro;
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

    public String getImagem() {
        return imagem;
    }
}
