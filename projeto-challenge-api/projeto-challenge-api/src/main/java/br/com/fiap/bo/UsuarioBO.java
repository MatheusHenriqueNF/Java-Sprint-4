package br.com.fiap.bo;

import br.com.fiap.model.UsuarioModel;

public class UsuarioBO {
    private UsuarioModel usuario;

    public UsuarioBO(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public boolean isAdmin() {
        return "admin".equalsIgnoreCase(usuario.getCargo());
    }

    public String getPrimeiraLetraLogin() {
        return usuario.getLogin() != null && !usuario.getLogin().isEmpty()
                ? String.valueOf(usuario.getLogin().charAt(0))
                : "";
    }
}