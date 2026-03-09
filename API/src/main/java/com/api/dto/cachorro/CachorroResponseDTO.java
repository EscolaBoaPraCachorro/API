package com.api.dto.cachorro;

import com.api.model.Cachorro;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description = "Objeto de resposta com dados da tabela Cachorro")
public class CachorroResponseDTO {

    @Schema(description = "O Número identificador do Cachorro")
    private Long id;
    @Schema(description = "Nome do cachorro", example = "Orelha")
    private String nome;
    @Schema(description = "Data de nascimeno do cachorro", example = "2016-07-08")
    private Date data_nascimento;
    @Schema(description = "ID do tutor", example = "1")
    private Long tutor_id;
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

    public CachorroResponseDTO(Cachorro cao) {
        this.id = cao.getId();
        this.nome = cao.getNome();
        this.data_nascimento = cao.getData_nascimento();
        this.tutor_id = cao.getTutor_id();
        this.turma = cao.getTurma();
        this.data_cadastro = cao.getData_cadastro();
        this.sexo = cao.getSexo();
        this.rga = cao.getRga();
        this.ativo = cao.getAtivo();
        this.tem_pedigree = cao.getTem_pedigree();
        this.rga = cao.getRga();
        this.sin_patinhas = cao.getSin_patinhas();
    }

    public CachorroResponseDTO() {}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public Long getTutor_id() {
        return tutor_id;
    }

    public String getTurma() {
        return turma;
    }

    public Date getData_cadastro() {
        return data_cadastro;
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

    public String getRga() {
        return rga;
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

    public String getAlergia() {
        return alergia;
    }

    @Override
    public String toString() {
        return "CachorroResponseDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", data_nascimento=" + data_nascimento +
                ", tutor_id=" + tutor_id +
                ", turma='" + turma + '\'' +
                ", data_cadastro=" + data_cadastro +
                ", sexo='" + sexo + '\'' +
                ", raca='" + raca + '\'' +
                ", ativo=" + ativo +
                ", tem_pedigree=" + tem_pedigree +
                ", rga='" + rga + '\'' +
                ", sin_patinhas='" + sin_patinhas + '\'' +
                ", aceito=" + aceito +
                ", imagem='" + imagem + '\'' +
                ", alergia='" + alergia + '\'' +
                '}';
    }
}
