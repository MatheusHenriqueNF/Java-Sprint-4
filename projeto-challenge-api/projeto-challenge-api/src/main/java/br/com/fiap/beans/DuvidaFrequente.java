package br.com.fiap.beans;

public class DuvidaFrequente {
    private Long idDuvida;
    private String pergunta;
    private String resposta;
    private Long idUsuario;
    private Long idIdioma;
    private String status;


    public DuvidaFrequente() {
        super();
    }

    public DuvidaFrequente(Long idDuvida, String pergunta, String resposta, Long idUsuario, Long idIdioma, String status) {
        super();
        this.idDuvida = idDuvida;
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.idUsuario = idUsuario;
        this.idIdioma = idIdioma;
        this.status = status;
    }

    public Long getIdDuvida() {
        return idDuvida;
    }

    public void setIdDuvida(Long idDuvida) {
        this.idDuvida = idDuvida;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Long idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    @Override
    public String toString() {
        return "DuvidaFrequente{" +
                "idDuvida=" + idDuvida +
                ", pergunta='" + pergunta + '\'' +
                ", resposta='" + resposta + '\'' +
                ", idUsuario=" + idUsuario +
                ", idIdioma=" + idIdioma +
                ", status='" + status + '\'' +
                '}';
    }
}