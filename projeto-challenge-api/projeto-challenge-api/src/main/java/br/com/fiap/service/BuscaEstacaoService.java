package br.com.fiap.service;

import br.com.fiap.dao.BuscaEstacaoDAO;
import br.com.fiap.model.BuscaEstacaoModel;

import java.sql.SQLException;
import java.util.List;

public class BuscaEstacaoService {
    private final BuscaEstacaoDAO dao = new BuscaEstacaoDAO();

    public List<BuscaEstacaoModel> listarBuscas() throws SQLException {
        return dao.findAll();
    }
}