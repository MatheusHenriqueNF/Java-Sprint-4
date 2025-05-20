package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoOracle;
import br.com.fiap.dto.LinhaEstacaoDTO;
import br.com.fiap.model.LinhaModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LinhaDAO {

    public List<LinhaModel> findAll() throws SQLException {
        List<LinhaModel> linhas = new ArrayList<>();
        String sql = "SELECT * FROM C_Linhas";

        try (Connection conn = ConexaoOracle.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                LinhaModel linha = new LinhaModel();
                linha.setIdLinha(rs.getLong("ID_Linha"));
                linha.setNomeLinha(rs.getString("Nome_linha"));
                linha.setStatus(rs.getString("Status"));
                linha.setIdUsuario(rs.getLong("ID_Usuario"));
                linhas.add(linha);
            }
        }

        return linhas;
    }
    public List<LinhaEstacaoDTO> listarEstacoesPorLinha() throws SQLException {
        List<LinhaEstacaoDTO> lista = new ArrayList<>();

        String sql = """
        SELECT 
            l.Nome_linha AS nomeLinha,
            e.Nome_estacao AS nomeEstacao,
            e.Status AS status
        FROM C_Estacao_Linha el
        JOIN C_Linhas l ON el.ID_Linha = l.ID_Linha
        JOIN C_Estacoes e ON el.ID_Estacoes = e.ID_Estacoes
        ORDER BY l.Nome_linha, e.Nome_estacao
    """;

        try (Connection conn = ConexaoOracle.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                LinhaEstacaoDTO dto = new LinhaEstacaoDTO();
                dto.setNomeLinha(rs.getString("nomeLinha"));
                dto.setNomeEstacao(rs.getString("nomeEstacao"));
                dto.setStatus(rs.getString("status"));
                lista.add(dto);
            }
        }

        return lista;
    }
}
