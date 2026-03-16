package com.api.dto.cachorro;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;

import java.util.Date;

@Schema(description = "Objeto para criação/atualização da tabela Cachorro")
public class CachorroRequestDTO {

    @Schema(description = "Nome do cachorro", example = "Orelha")
    private String nome;
    @Schema(description = "Data de nascimeno do cachorro", example = "2016-07-08")
    private Date data_nascimento;
    @Schema(description = "ID do tutor", example = "1")
    private Long tutorId;
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
    @Schema(description = "A alergias do cão ou não", example = "Nenhuma")
    private String alergias;
    @Schema(description = "", example = "...")
    private String situacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public String getTurma() {
        return turma;
    }

    public String getSexo() {
        return sexo;
    }

    public String getRaca() {
        return raca;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public Boolean getTem_pedigree() {
        return tem_pedigree;
    }

    public String getSin_patinhas() {
        return sin_patinhas;
    }

    public Boolean getAceito() {
        return aceito;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getAlergias() {
        return alergias;
    }

    public String getSituacao() {
        return situacao;
    }
}
