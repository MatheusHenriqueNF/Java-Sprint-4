package br.com.fiap.service;

import br.com.fiap.dao.LinhaDAO;
import br.com.fiap.model.LinhaModel;

import java.sql.SQLException;
import java.util.List;

public class LinhaService {
    private final LinhaDAO linhaDAO = new LinhaDAO();

    public List<LinhaModel> listarLinhas() throws SQLException {
        return linhaDAO.findAll();
    }
}