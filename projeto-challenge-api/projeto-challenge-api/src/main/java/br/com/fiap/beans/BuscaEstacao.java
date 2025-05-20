package br.com.fiap.beans;

public class BuscaEstacao {
    private Long idBusca;
    private String nomeEstacaoBusca;
    private Long idUsuario;

    public BuscaEstacao() {
        super();
    }

    public BuscaEstacao(Long idBusca, String nomeEstacaoBusca, Long idUsuario) {
        super();
        this.idBusca = idBusca;
        this.nomeEstacaoBusca = nomeEstacaoBusca;
        this.idUsuario = idUsuario;
    }

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

    @Override
    public String toString() {
        return "BuscaEstacao{" +
                "idBusca=" + idBusca +
                ", nomeEstacaoBusca='" + nomeEstacaoBusca + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}