package com.api.dto.cachorro;

import com.api.model.Cachorro;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;

import java.util.Date;

@Schema(description = "Objeto de resposta com dados da tabela Cachorro")
public class CachorroResponseDTO {

    @Schema(description = "O Número identificador do Cachorro")
    private Long id;
    @Schema(description = "Nome do cachorro", example = "Orelha")
    private String nome;
    @Schema(description = "Data de nascimeno do cachorro", example = "2016-07-08")
    @Column(name = "dataNascimento")
    private Date dataNascimento;
    @Schema(description = "ID do tutor", example = "1")
    @Column(name = "tutor_id")
    private Long tutorId;
    @Schema(description = "Turma em que o cão está estudando", example = "1E")
    private String turma;
    @Schema(description = "Data de qunado o cão foi cadastrado no sistema", example = "2026-01-01")
    @JsonProperty("dataCadastro")
    private Date dataCadastro;
    @Schema(description = "Gênero do cão", example = "M")
    private String sexo;
    @Schema(description = "Raça do cão", example = "Sem raça definida")
    private String raca;
    @Schema(description = "Se a matrícula do cão foi aceita ou não", example = "false")
    private Boolean ativo;
    @Schema(description = "Se o cão tem pedigree ou não", example = "false")
    @Column(name = "temPedigree")
    private Boolean temPedigree;
    @Schema(description = "O RGA do cão", example = "RGA-123456")
    private String rga;
    @Schema(description = "", example = "sim")
    @Column(name = "sinPatinhas")
    private String sinPatinhas;
    @Schema(description = "", example = "true")
    private Boolean aceito;
    @Schema(description = "Uma foto do cão", example = "https://imagem.com")
    private String imagem;
    @Schema(description = "A alergias do cão ou não", example = "Nenhuma")
    private String alergias;
    @Schema(description = "A situação do cachorro no seu desempenho escolar", example = "...")
    private String situacao;

    public CachorroResponseDTO(Cachorro cao) {
        this.id = cao.getId();
        this.nome = cao.getNome();
        this.dataNascimento = cao.getDataNascimento();
        this.tutorId = cao.getTutorId();
        this.turma = cao.getTurma();
        this.dataCadastro = cao.getDataCadastro();
        this.sexo = cao.getSexo();
        this.rga = cao.getRga();
        this.ativo = cao.getAtivo();
        this.temPedigree = cao.getTemPedigree();
        this.rga = cao.getRga();
        this.sinPatinhas = cao.getSinPatinhas();
        this.aceito = cao.getAceito();
        this.imagem = cao.getImagem();
        this.alergias = cao.getAlergias();
        this.situacao = cao.getSituacao();
    }

    public CachorroResponseDTO() {}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public String getTurma() {
        return turma;
    }

    public Date getDataCadastro() {
        return dataCadastro;
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

    public Boolean getTemPedigree() {
        return temPedigree;
    }

    public String getRga() {
        return rga;
    }

    public String getSinPatinhas() {
        return sinPatinhas;
    }

    public Boolean getAceito() {
        return aceito;
    }

    public String getImagem() {
        return imagem;
    }

    public String getAlergias() {
        return alergias;
    }

    public String getSituacao() {
        return situacao;
    }

    @Override
    public String toString() {
        return "CachorroResponseDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", tutor_id=" + tutorId +
                ", turma='" + turma + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", sexo='" + sexo + '\'' +
                ", raca='" + raca + '\'' +
                ", ativo=" + ativo +
                ", temPedigree=" + temPedigree +
                ", rga='" + rga + '\'' +
                ", sinPatinhas='" + sinPatinhas + '\'' +
                ", aceito=" + aceito +
                ", imagem='" + imagem + '\'' +
                ", alergias='" + alergias + '\'' +
                '}';
    }
}
