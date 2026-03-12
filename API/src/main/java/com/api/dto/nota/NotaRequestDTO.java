package com.api.dto.nota;

import java.util.Date;

public class NotaRequestDTO {

    private Long idCachorro;
    private Long idProfessor;
    private Integer nota;
    private Date data_publicacao;
    private Integer nova_nota;

    public Long getId_cachorro() {
        return idCachorro;
    }

    public void setId_cachorro(Long id_cachorro) {
        this.idCachorro = id_cachorro;
    }

    public Long getId_professor() {
        return idProfessor;
    }

    public void setId_professor(Long id_professor) {
        this.idProfessor = id_professor;
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
