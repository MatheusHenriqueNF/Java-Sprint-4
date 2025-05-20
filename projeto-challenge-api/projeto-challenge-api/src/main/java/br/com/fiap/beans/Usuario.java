package br.com.fiap.beans;

public class Usuario {
    private Long idUsuario;
    private String login;
    private String senha;
    private String cargo;
    private String status;

    public Usuario() {
        super();
    }

    public Usuario(Long idUsuario, String login, String senha, String cargo, String status) {
        super();
        this.idUsuario = idUsuario;
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;
        this.status = status;
    }


    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", cargo='" + cargo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}