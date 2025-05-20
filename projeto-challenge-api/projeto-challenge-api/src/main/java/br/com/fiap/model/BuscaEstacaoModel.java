package br.com.fiap.model;

public class BuscaEstacaoModel {
    private Long idBusca;
    private String nomeEstacaoBusca;
    private Long idUsuario;

    public Long getIdBusca() {
        return idBusca;
    }

    public void setIdBusca(Long idBusca) {
        this.idBusca = idBusca;
    }

    public String getNomeEstacaoBusca() {
        return nomeEstacaoBusca;
    }

    public void setNomeEstacaoBusca(String nomeEstacaoBusca) {
        this.nomeEstacaoBusca = nomeEstacaoBusca;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
