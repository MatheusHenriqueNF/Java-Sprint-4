package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoOracle;
import br.com.fiap.model.BuscaEstacaoModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuscaEstacaoDAO {

    public List<BuscaEstacaoModel> findAll() throws SQLException {
        List<BuscaEstacaoModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM C_Busca_Estacoes";

        try (Connection conn = ConexaoOracle.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                BuscaEstacaoModel b = new BuscaEstacaoModel();
                b.setIdBusca(rs.getLong("ID_Busca"));
                b.setNomeEstacaoBusca(rs.getString("Nome_Estacao_Busca"));
                b.setIdUsuario(rs.getLong("ID_Usuario"));
                lista.add(b);
            }
        }

        return lista;
    }
}
