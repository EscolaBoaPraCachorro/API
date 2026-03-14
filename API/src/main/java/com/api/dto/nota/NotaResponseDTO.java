package com.api.dto.nota;

import com.api.model.Notas;

import java.util.Date;

public class NotaResponseDTO {
    private Long id;
    private Long idCachorro;
    private Long idProfessor;
    private Integer nota;
    private Date dataPublicacao;
    public Integer semestre;

    public NotaResponseDTO(Notas notas) {
        this.id = notas.getId();
        this.idCachorro = notas.getIdCachorro();
        this.idProfessor = notas.getIdProfessor();
        this.nota = notas.getNota();
        this.dataPublicacao = notas.getDataPublicacao();
        this.semestre = notas.getSemestre();
    }

    public NotaResponseDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Integer getSemestre() {
        return semestre;
    }
}
