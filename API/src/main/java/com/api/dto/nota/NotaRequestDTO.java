package com.api.dto.nota;

import java.util.Date;

public class NotaRequestDTO {

    private Long id_cachorro;
    private Long id_professor;
    private Integer nota;
    private Date data_publicacao;
    private Integer nova_nota;

    public Long getId_cachorro() {
        return id_cachorro;
    }

    public void setId_cachorro(Long id_cachorro) {
        this.id_cachorro = id_cachorro;
    }

    public Long getId_professor() {
        return id_professor;
    }

    public void setId_professor(Long id_professor) {
        this.id_professor = id_professor;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Date getData_publicacao() {
        return data_publicacao;
    }

    public void setData_publicacao(Date data_publicacao) {
        this.data_publicacao = data_publicacao;
    }

    public Integer getNova_nota() {
        return nova_nota;
    }

    public void setNova_nota(Integer nova_nota) {
        this.nova_nota = nova_nota;
    }
}
