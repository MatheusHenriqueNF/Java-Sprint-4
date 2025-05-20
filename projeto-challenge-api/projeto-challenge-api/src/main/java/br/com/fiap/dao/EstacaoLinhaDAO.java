package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoOracle;
import br.com.fiap.dto.LinhaEstacaoDTO;
import br.com.fiap.model.EstacaoLinhaModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstacaoLinhaDAO {

    public List<EstacaoLinhaModel> findAll() throws SQLException {
        List<EstacaoLinhaModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM C_Estacao_Linha";

        try (Connection conn = ConexaoOracle.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                EstacaoLinhaModel el = new EstacaoLinhaModel();
                el.setIdEstacaoLinha(rs.getLong("ID_Estacao_Linha"));
                el.setIdEstacoes(rs.getLong("ID_Estacoes"));
                el.setIdLinha(rs.getLong("ID_Linha"));
                lista.add(el);
            }
        }

        return lista;
    }
    public List<LinhaEstacaoDTO> listarEstacoesComLinhas() throws SQLException {
        List<LinhaEstacaoDTO> lista = new ArrayList<>();
        String sql = """
        SELECT 
            e.ID_Estacoes,
            l.Nome_linha,
            e.Nome_estacao,
            e.Status
        FROM 
            C_Estacao_Linha el
        JOIN 
            C_Estacoes e ON e.ID_Estacoes = el.ID_Estacoes
        JOIN 
            C_Linhas l ON l.ID_Linha = el.ID_Linha
        WHERE 
            e.Status = 'Ativa'
        ORDER BY 
            l.Nome_linha, e.Nome_estacao
        """;

        try (Connection conn = ConexaoOracle.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                LinhaEstacaoDTO dto = new LinhaEstacaoDTO(
                        rs.getLong("ID_Estacoes"),
                        rs.getString("Nome_linha"),
                        rs.getString("Nome_estacao"),
                        rs.getString("Status")
                );
                lista.add(dto);
            }
        }

        return lista;
    }


}