package com.api.dto.cachorro;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description = "Objeto para criação/atualização da tabela Cachorro")
public class CachorroRequestDTO {

    @Schema(description = "Nome do cachorro", example = "Orelha")
    private String nome;
    @Schema(description = "Data de nascimeno do cachorro", example = "2016-07-08")
    private Date data_nascimento;
    @Schema(description = "ID do tutor", example = "1")
    private Integer tutor_id;
    @Schema(description = "Turma em que o cão está estudando", example = "1E")
    private String turma;
    @Schema(description = "Data de qunado o cão foi cadastrado no sistema", example = "2026-01-01")
    private Date data_cadastro;
    @Schema(description = "Gênero do cão", example = "M")
    private String sexo;
    @Schema(description = "Raça do cão", example = "Sem raça definida")
    private String raca;
    @Schema(description = "Se a matrícula do cão foi aceita ou não", example = "false")
    private Boolean ativo;
    @Schema(description = "Se o cão tem pedigree ou não", example = "false")
    private Boolean tem_pedigree;
    @Schema(description = "O RGA do cão", example = "RGA-123456")
    private String rga;
    @Schema(description = "", example = "sim")
    private String sin_patinhas;
    @Schema(description = "", example = "true")
    private Boolean aceito;
    @Schema(description = "Uma foto do cão", example = "https://imagem.com")
    private String imagem;
    @Schema(description = "A alergia do cão ou não", example = "Nenhuma")
    private String alergia;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Integer getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(Integer tutor_id) {
        this.tutor_id = tutor_id;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean getTem_pedigree() {
        return tem_pedigree;
    }

    public void setTem_pedigree(Boolean tem_pedigree) {
        this.tem_pedigree = tem_pedigree;
    }

    public String getRga() {
        return rga;
    }

    public String getSin_patinhas() {
        return sin_patinhas;
    }

    public void setSin_patinhas(String sin_patinhas) {
        this.sin_patinhas = sin_patinhas;
    }

    public Boolean getAceito() {
        return aceito;
    }

    public void setAceito(Boolean aceito) {
        this.aceito = aceito;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }
}
