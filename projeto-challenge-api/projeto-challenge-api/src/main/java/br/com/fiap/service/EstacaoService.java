package br.com.fiap.service;

import br.com.fiap.conexoes.ConexaoOracle;
import br.com.fiap.dao.EstacaoDAO;
import br.com.fiap.model.EstacaoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EstacaoService {
    private final EstacaoDAO dao = new EstacaoDAO();

    public List<EstacaoModel> listarEstacoes() throws SQLException {
        return dao.findAll();
    }
    public boolean atualizarStatus(Long id, String novoStatus) throws SQLException {
        String sql = "UPDATE C_Estacoes SET Status = ? WHERE ID_Estacoes = ?";
        try (Connection conn = ConexaoOracle.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, novoStatus);
            ps.setLong(2, id);
            return ps.executeUpdate() > 0;
        }
    }

    public List<String> listarNomesEstacoes() throws SQLException {
        return new EstacaoDAO().listarNomesEstacoes();
    }


}
