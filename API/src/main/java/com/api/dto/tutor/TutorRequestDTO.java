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
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getImagem() {
        return imagem;
    }
    public String getDescricao() {return descricao;}
}
