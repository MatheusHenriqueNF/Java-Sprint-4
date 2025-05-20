package br.com.fiap.dto;

public class LinhaEstacaoDTO {
    private Long idEstacoes;
    private String nomeLinha;
    private String nomeEstacao;
    private String status;

    public LinhaEstacaoDTO() {
        super();
    }

    public LinhaEstacaoDTO(Long idEstacoes, String nomeLinha, String nomeEstacao, String status) {
        this.idEstacoes = idEstacoes;
        this.nomeLinha = nomeLinha;
        this.nomeEstacao = nomeEstacao;
        this.status = status;
    }

    public Long getIdEstacoes() {
        return idEstacoes;
    }

    public void setIdEstacoes(Long idEstacoes) {
        this.idEstacoes = idEstacoes;
    }

    public String getNomeLinha() {
        return nomeLinha;
    }

    public void setNomeLinha(String nomeLinha) {
        this.nomeLinha = nomeLinha;
    }

    public String getNomeEstacao() {
        return nomeEstacao;
    }

    public void setNomeEstacao(String nomeEstacao) {
        this.nomeEstacao = nomeEstacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
