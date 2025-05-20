package br.com.fiap.beans;

public class Estacao {
    private Long idEstacoes;
    private String nomeEstacao;
    private String status;
    private Long idUsuario;

    public Estacao() {
        super();
    }

    public Estacao(Long idEstacoes, String nomeEstacao, String status, Long idUsuario) {
        super();
        this.idEstacoes = idEstacoes;
        this.nomeEstacao = nomeEstacao;
        this.status = status;
        this.idUsuario = idUsuario;
    }

    public Long getIdEstacoes() {
        return idEstacoes;
    }

    public void setIdEstacoes(Long idEstacoes) {
        this.idEstacoes = idEstacoes;
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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Estacao{" +
                "idEstacoes=" + idEstacoes +
                ", nomeEstacao='" + nomeEstacao + '\'' +
                ", status='" + status + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}