package com.api.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;

import java.sql.Time;

@Enabled
public class GradeHoraria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String turma;
    private Long idProfessor;
    private Time horario;

    public GradeHoraria(String turma, Long idProfessor, Time horario) {
        this.turma = turma;
        this.idProfessor = idProfessor;
        this.horario = horario;
    }

    public GradeHoraria() {}

    public Long getId() {
        return id;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "GradeHoraria{" +
                "id=" + id +
                ", turma='" + turma + '\'' +
                ", idProfessor=" + idProfessor +
                ", horario=" + horario +
                '}';
    }
}
