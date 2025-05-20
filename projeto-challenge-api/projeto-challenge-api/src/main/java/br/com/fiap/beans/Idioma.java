package br.com.fiap.beans;

public class Idioma {
    private Long idIdioma;
    private String idioma;
    private Long idUsuario;

    public Idioma() {
        super();
    }

    public Idioma(Long idIdioma, String idioma, Long idUsuario) {
        super();
        this.idIdioma = idIdioma;
        this.idioma = idioma;
        this.idUsuario = idUsuario;
    }

    public Long getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Long idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Idioma{" +
                "idIdioma=" + idIdioma +
                ", idioma='" + idioma + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}