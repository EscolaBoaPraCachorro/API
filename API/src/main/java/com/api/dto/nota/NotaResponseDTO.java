package com.api.dto.nota;

import com.api.model.Notas;

import java.util.Date;

public class NotaResponseDTO {
    private Long id;
    private Long id_cachorro;
    private Long id_professor;
    private Integer nota;
    private Date data_publicacao;

    public NotaResponseDTO(Notas notas) {
        this.id = notas.getId();
        this.id_cachorro = notas.getId_cachorro();
        this.id_professor = notas.getId_professor();
        this.nota = notas.getNota();
        this.data_publicacao = notas.getData_publicacao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
