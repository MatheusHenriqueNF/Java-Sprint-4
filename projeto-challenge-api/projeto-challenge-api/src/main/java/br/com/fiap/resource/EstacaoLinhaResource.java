package br.com.fiap.resource;

import br.com.fiap.dao.EstacaoLinhaDAO;
import br.com.fiap.dao.LinhaDAO;
import br.com.fiap.dto.LinhaEstacaoDTO;
import br.com.fiap.model.EstacaoLinhaModel;
import br.com.fiap.service.EstacaoLinhaService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;

import java.sql.SQLException;
import java.util.List;
@Path("/estacoes-linhas")
@Produces(MediaType.APPLICATION_JSON)
public class EstacaoLinhaResource {

    private EstacaoLinhaDAO dao = new EstacaoLinhaDAO();

    @GET
    public List<LinhaEstacaoDTO> listar() {
        try {
            return dao.listarEstacoesComLinhas();
        } catch (SQLException e) {
            throw new WebApplicationException("Erro ao buscar estações", 500);
        }
    }
}

