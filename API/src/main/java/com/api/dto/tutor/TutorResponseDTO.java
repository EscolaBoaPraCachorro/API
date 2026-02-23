package com.api.dto.tutor;

import com.api.model.Tutor;

import java.sql.Date;

public class TutorResponseDTO {
    private Long id;
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

    public TutorResponseDTO() {}

    public TutorResponseDTO(Tutor tutor) {
        this.id = tutor.getId();
        this.nome = tutor.getNome();
        this.dataNascimento = tutor.getDataNascimento();
        this.endereco = tutor.getEndereco();
        this.data_cadastro = tutor.getData_cadastro();
        this.genero = tutor.getGenero();
        this.telefone = tutor.getTelefone();
        this.cpf = tutor.getCpf();
        this.rg = tutor.getRg();
        this.email = tutor.getEmail();
        this.imagem = tutor.getImagem();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
