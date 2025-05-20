package br.com.fiap.model;

public class UsuarioModel {
    private Long idUsuario;
    private String login;
    private String senha;
    private String cargo;
    private String status;


    // Getters e Setters
    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}
}
