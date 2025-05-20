package br.com.fiap.service;

import br.com.fiap.dao.DuvidaFrequenteDAO;
import br.com.fiap.model.DuvidaFrequenteModel;

import java.sql.SQLException;
import java.util.List;

public class DuvidaFrequenteService {

    private final DuvidaFrequenteDAO dao = new DuvidaFrequenteDAO();

    public List<DuvidaFrequenteModel> listarDuvidas() throws SQLException {
        return dao.findAll();
    }

    public boolean atualizarStatus(Long id, String novoStatus) throws SQLException {
        return dao.atualizarStatus(id, novoStatus);
    }

    public boolean cadastrarDuvida(DuvidaFrequenteModel duvida) throws SQLException {
        if (duvida.getPergunta() == null || duvida.getPergunta().trim().isEmpty()) {
            throw new IllegalArgumentException("A pergunta não pode ser vazia.");
        }
        if (duvida.getResposta() == null || duvida.getResposta().trim().isEmpty()) {
            throw new IllegalArgumentException("A resposta não pode ser vazia.");
        }
        return dao.inserir(duvida);
    }

    public boolean atualizarDuvida(Long id, DuvidaFrequenteModel duvida) throws SQLException {
        return new DuvidaFrequenteDAO().atualizar(id, duvida);
    }

}
