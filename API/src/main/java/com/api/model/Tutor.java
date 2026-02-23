package com.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Tutor(
            String nome,
            Date dataNascimento,
            String endereco,
            String data_cadastro,
            String genero,
            String telefone,
            String cpf,
            String rg,
            String email,
            String imagem
    ) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.data_cadastro = data_cadastro;
        this.genero = genero;
        this.telefone = telefone;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.imagem = imagem;
    }

    public Tutor() {}

    public Long getId() {return id;}

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

    public String getData_cadastro() {return data_cadastro;}

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

    public String getCpf() {return cpf;}

    public String getRg() {return rg;}

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

    @Override
    public String toString() {
        return "Tutor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", endereco='" + endereco + '\'' +
                ", data_cadastro='" + data_cadastro + '\'' +
                ", genero='" + genero + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", email='" + email + '\'' +
                ", imagem='" + imagem + '\'' +
                '}';
    }
}
