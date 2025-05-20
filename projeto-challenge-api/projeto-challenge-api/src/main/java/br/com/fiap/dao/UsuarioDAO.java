package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoOracle;
import br.com.fiap.model.UsuarioModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public boolean fazerLogin(String login, String senha) throws SQLException {
        String sql = "SELECT * FROM C_Usuario WHERE Login = ? AND Senha = ?";

        try (Connection conn = ConexaoOracle.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, login);
            ps.setString(2, senha);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public UsuarioModel autenticar(String login, String senha) throws SQLException {
        String sql = "SELECT * FROM C_Usuario WHERE Login = ? AND Senha = ?";

        try (Connection conn = ConexaoOracle.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, login);
            ps.setString(2, senha);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    UsuarioModel u = new UsuarioModel();
                    u.setIdUsuario(rs.getLong("ID_Usuario"));
                    u.setLogin(rs.getString("Login"));
                    u.setSenha(rs.getString("Senha"));
                    u.setCargo(rs.getString("Cargo"));
                    u.setStatus(rs.getString("Status"));
                    return u;
                } else {
                    return null;
                }
            }
        }
    }

    public boolean cadastrarUsuario(String login, String senha, String cargo) throws SQLException {
        String sql = "INSERT INTO C_Usuario (Login, Senha, Cargo, Status) VALUES (?, ?, ?, '1')";

        try (Connection conn = ConexaoOracle.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, login);
            ps.setString(2, senha);
            ps.setString(3, cargo);

            return ps.executeUpdate() > 0;
        }
    }

    public List<UsuarioModel> findAll() throws SQLException {
        List<UsuarioModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM C_Usuario";

        try (Connection conn = ConexaoOracle.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                UsuarioModel u = new UsuarioModel();
                u.setIdUsuario(rs.getLong("ID_Usuario"));
                u.setLogin(rs.getString("Login"));
                u.setSenha(rs.getString("Senha"));
                u.setCargo(rs.getString("Cargo"));
                u.setStatus(rs.getString("Status"));
                lista.add(u);
            }
        }

        return lista;
    }

    public boolean atualizarStatus(Long id, String novoStatus) throws SQLException {
        String sql = "UPDATE C_Usuario SET Status = ? WHERE ID_Usuario = ?";

        try (Connection conn = ConexaoOracle.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, novoStatus);
            ps.setLong(2, id);

            return ps.executeUpdate() > 0;
        }
    }

    public boolean atualizarSenha(Long idUsuario, String novaSenha) throws SQLException {
        String sql = "UPDATE C_Usuario SET Senha = ? WHERE ID_Usuario = ?";
        try (Connection conn = ConexaoOracle.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, novaSenha);
            ps.setLong(2, idUsuario);
            return ps.executeUpdate() > 0;
        }
    }

}
