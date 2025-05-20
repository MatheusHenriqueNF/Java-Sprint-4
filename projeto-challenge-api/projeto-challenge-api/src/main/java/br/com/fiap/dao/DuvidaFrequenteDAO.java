package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoOracle;
import br.com.fiap.model.DuvidaFrequenteModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class DuvidaFrequenteDAO {

    public List<DuvidaFrequenteModel> findAll() throws SQLException {
        List<DuvidaFrequenteModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM C_duvidas_frequentes";

        try (Connection conn = ConexaoOracle.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DuvidaFrequenteModel d = new DuvidaFrequenteModel();
                d.setIdDuvida(rs.getLong("ID_duvida"));
                d.setPergunta(rs.getString("Pergunta"));
                d.setResposta(rs.getString("Resposta"));
                d.setStatus(rs.getString("Status"));
                lista.add(d);
            }
        }

        return lista;
    }

    public boolean atualizarStatus(Long id, String novoStatus) throws SQLException {
        String sql = "UPDATE C_duvidas_frequentes SET Status = ? WHERE ID_duvida = ?";

        try (Connection conn = ConexaoOracle.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, novoStatus);
            ps.setLong(2, id);

            return ps.executeUpdate() > 0;
        }
    }

    public boolean inserir(DuvidaFrequenteModel duvida) throws SQLException {
        String sql = "INSERT INTO C_duvidas_frequentes (Pergunta, Resposta, Status) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoOracle.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, duvida.getPergunta());
            ps.setString(2, duvida.getResposta());
            ps.setString(3, "1"); // Status padrão como "Ativo"

            return ps.executeUpdate() > 0;
        }
    }
    public boolean atualizar(Long id, DuvidaFrequenteModel duvida) throws SQLException {
        String sql = "UPDATE C_Duvidas_Frequentes SET Pergunta = ?, Resposta = ? WHERE ID_Duvida = ?";
        try (Connection conn = ConexaoOracle.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, duvida.getPergunta());
            ps.setString(2, duvida.getResposta());
            ps.setLong(3, id);
            return ps.executeUpdate() > 0;
        }
    }

}
