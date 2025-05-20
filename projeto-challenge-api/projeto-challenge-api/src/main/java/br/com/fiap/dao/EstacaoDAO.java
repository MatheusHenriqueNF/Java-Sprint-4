package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoOracle;
import br.com.fiap.model.EstacaoModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstacaoDAO {

    public List<EstacaoModel> findAll() throws SQLException {
        List<EstacaoModel> estacoes = new ArrayList<>();
        String sql = "SELECT * FROM C_Estacoes";

        try (Connection conn = ConexaoOracle.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                EstacaoModel e = new EstacaoModel();
                e.setIdEstacoes(rs.getLong("ID_Estacoes"));
                e.setNomeEstacao(rs.getString("Nome_estacao"));
                e.setStatus(rs.getString("Status"));
                e.setIdUsuario(rs.getLong("ID_Usuario"));
                estacoes.add(e);
            }
        }

        return estacoes;
    }
    public boolean atualizarStatus(Long idEstacao, String novoStatus) throws SQLException {
        String sql = "UPDATE C_Estacoes SET Status = ? WHERE ID_Estacoes = ?";
        try (Connection conn = ConexaoOracle.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, novoStatus);
            ps.setLong(2, idEstacao);
            return ps.executeUpdate() > 0;
        }
    }

    public List<String> listarNomesEstacoes() throws SQLException {
        List<String> estacoes = new ArrayList<>();
        String sql = "SELECT Nome_estacao FROM C_Estacoes";

        try (Connection conn = ConexaoOracle.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                estacoes.add(rs.getString("Nome_Estacao"));
            }
        }
        return estacoes;
    }


}
