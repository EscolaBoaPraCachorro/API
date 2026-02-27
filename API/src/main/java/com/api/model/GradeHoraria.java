package com.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Time;

@Entity
public class GradeHoraria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String turma;
    private Long idProfessor;
    private Time horario;
    private String dia_semana;

    public GradeHoraria(String turma, Long idProfessor, Time horario, String dia_semana) {
        this.turma = turma;
        this.idProfessor = idProfessor;
        this.horario = horario;
        this.dia_semana = dia_semana;
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

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    @Override
    public String toString() {
        return "GradeHoraria{" +
                "id=" + id +
                ", turma='" + turma + '\'' +
                ", idProfessor=" + idProfessor +
                ", horario=" + horario +
                ", dia_semana='" + dia_semana + '\'' +
                '}';
    }
}
