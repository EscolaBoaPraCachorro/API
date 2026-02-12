package com.api.dto.observacao;

import java.sql.Date;

public class ObservacaoRequestDTO {

    private Long id_cachorro;
    private Long id_professor;
    private String descricao;
    private Date data_publicacao;

    public Long getId_cachorro() {
        return id_cachorro;
    }

    public Long getId_professor() {
        return id_professor;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getData_publicacao() {
        return data_publicacao;
    }
}
