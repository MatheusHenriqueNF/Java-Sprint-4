package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoOracle;
import br.com.fiap.model.IdiomaModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IdiomaDAO {

    public List<IdiomaModel> findAll() throws SQLException {
        List<IdiomaModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM C_Idioma";

        try (Connection conn = ConexaoOracle.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                IdiomaModel i = new IdiomaModel();
                i.setIdIdioma(rs.getLong("ID_Idioma"));
                i.setIdioma(rs.getString("Idioma"));
                i.setIdUsuario(rs.getLong("ID_Usuario"));
                lista.add(i);
            }
        }

        return lista;
    }
}