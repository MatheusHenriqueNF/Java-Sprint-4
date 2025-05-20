package br.com.fiap.service;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.model.UsuarioModel;

import java.sql.SQLException;
import java.util.List;

public class UsuarioService {

    private final UsuarioDAO dao = new UsuarioDAO();

    public boolean fazerLogin(String login, String senha) throws SQLException {
        return dao.fazerLogin(login, senha);
    }

    public boolean cadastrarUsuario(String login, String senha, String cargo) throws SQLException {
        return dao.cadastrarUsuario(login, senha, cargo); // status fixo: "1"
    }

    public List<UsuarioModel> listarUsuarios() throws SQLException {
        return dao.findAll();
    }

    public boolean atualizarStatus(Long id, String novoStatus) throws SQLException {
        return dao.atualizarStatus(id, novoStatus);
    }
}
