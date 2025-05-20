package br.com.fiap.service;

import br.com.fiap.dao.IdiomaDAO;
import br.com.fiap.model.IdiomaModel;

import java.sql.SQLException;
import java.util.List;

public class IdiomaService {
    private final IdiomaDAO idiomaDAO = new IdiomaDAO();

    public List<IdiomaModel> listarIdiomas() throws SQLException {
        return idiomaDAO.findAll();
    }
}