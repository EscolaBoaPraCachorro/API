package com.api.dto.nota;

import java.util.Date;

public class NotaRequestDTO {

    private Long idCachorro;
    private Long idProfessor;
    private Integer nota;
    private Date dataPublicacao;
    private Integer nova_nota;
    private Integer semestre;

    public Long getIdCachorro() {
        return idCachorro;
    }

    public void setIdCachorro(Long id_cachorro) {
        this.idCachorro = id_cachorro;
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Long id_professor) {
        this.idProfessor = id_professor;
    }

    public Integer getNota() {
        return nota;
    }

    public Integer getNova_nota() {
        return nova_nota;
    }

    public Integer getSemestre() {
        return semestre;
    }
}
