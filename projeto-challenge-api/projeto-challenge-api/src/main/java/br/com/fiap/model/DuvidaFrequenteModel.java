package br.com.fiap.model;

public class DuvidaFrequenteModel {
    private Long idDuvida;
    private String pergunta;
    private String resposta;
    private String status;
    private Long idUsuario;
    private Long idIdioma;



    public Long getIdDuvida() { return idDuvida; }
    public void setIdDuvida(Long idDuvida) { this.idDuvida = idDuvida; }

    public String getPergunta() { return pergunta; }
    public void setPergunta(String pergunta) { this.pergunta = pergunta; }

    public String getResposta() { return resposta; }
    public void setResposta(String resposta) { this.resposta = resposta; }

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public Long getIdIdioma() { return idIdioma; }
    public void setIdIdioma(Long idIdioma) { this.idIdioma = idIdioma; }
}
