package br.com.fiap.beans;

public class Linha {
    private Long idLinha;
    private String nomeLinha;
    private String status;
    private Long idUsuario;


    public Linha() {
        super();
    }
    public Linha(Long idLinha, String nomeLinha, String status, Long idUsuario) {
        super();
        this.idLinha = idLinha;
        this.nomeLinha = nomeLinha;
        this.status = status;
        this.idUsuario = idUsuario;
    }

    public Long getIdLinha() {
        return idLinha;
    }

    public void setIdLinha(Long idLinha) {
        this.idLinha = idLinha;
    }

    public String getNomeLinha() {
        return nomeLinha;
    }

    public void setNomeLinha(String nomeLinha) {
        this.nomeLinha = nomeLinha;
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
        return "Linha{" +
                "idLinha=" + idLinha +
                ", nomeLinha='" + nomeLinha + '\'' +
                ", status='" + status + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}