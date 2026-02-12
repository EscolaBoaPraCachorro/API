package com.api.dto.observacao;

import com.api.model.Observacao;

import java.sql.Date;

public class ObservacaoResponseDTO {

    private Long id;
    private Long id_cachorro;
    private Long id_professor;
    private String descricao;
    private Date data_publicacao;

    public ObservacaoResponseDTO() {}

    public ObservacaoResponseDTO(Observacao observacao) {
        this.id = observacao.getId();
        this.id_cachorro = observacao.getId_cachorro();
        this.id_professor = observacao.getId_professor();
        this.descricao = observacao.getDescricao();
        this.data_publicacao = observacao.getData_publicacao();
    }

    public Long getId() {
        return id;
    }

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
