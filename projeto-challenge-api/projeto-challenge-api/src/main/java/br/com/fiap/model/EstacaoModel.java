package br.com.fiap.model;

public class EstacaoModel {
    private Long idEstacoes;
    private String nomeEstacao;
    private String status;
    private Long idUsuario;

    public Long getIdEstacoes() { return idEstacoes; }
    public void setIdEstacoes(Long idEstacoes) { this.idEstacoes = idEstacoes; }

    public String getNomeEstacao() { return nomeEstacao; }
    public void setNomeEstacao(String nomeEstacao) { this.nomeEstacao = nomeEstacao; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
}
