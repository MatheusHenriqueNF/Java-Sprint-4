package br.com.fiap.service;

import br.com.fiap.dao.EstacaoLinhaDAO;
import br.com.fiap.model.EstacaoLinhaModel;

import java.sql.SQLException;
import java.util.List;

public class EstacaoLinhaService {
    private final EstacaoLinhaDAO dao = new EstacaoLinhaDAO();

    public List<EstacaoLinhaModel> listarRelacionamentos() throws SQLException {
        return dao.findAll();
    }
}