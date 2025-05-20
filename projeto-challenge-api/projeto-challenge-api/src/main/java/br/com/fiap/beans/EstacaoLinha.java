package br.com.fiap.beans;

public class EstacaoLinha {
    private Long idEstacaoLinha;
    private Long idEstacoes;
    private Long idLinha;


    public EstacaoLinha() {
        super();
    }

    public EstacaoLinha(Long idEstacaoLinha, Long idEstacoes, Long idLinha) {
        super();
        this.idEstacaoLinha = idEstacaoLinha;
        this.idEstacoes = idEstacoes;
        this.idLinha = idLinha;
    }

    public Long getIdEstacaoLinha() {
        return idEstacaoLinha;
    }

    public void setIdEstacaoLinha(Long idEstacaoLinha) {
        this.idEstacaoLinha = idEstacaoLinha;
    }

    public Long getIdEstacoes() {
        return idEstacoes;
    }

    public void setIdEstacoes(Long idEstacoes) {
        this.idEstacoes = idEstacoes;
    }

    public Long getIdLinha() {
        return idLinha;
    }

    public void setIdLinha(Long idLinha) {
        this.idLinha = idLinha;
    }

    @Override
    public String toString() {
        return "EstacaoLinha{" +
                "idEstacaoLinha=" + idEstacaoLinha +
                ", idEstacoes=" + idEstacoes +
                ", idLinha=" + idLinha +
                '}';
    }
}