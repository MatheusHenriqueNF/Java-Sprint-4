package br.com.fiap.resource;

import br.com.fiap.model.BuscaEstacaoModel;
import br.com.fiap.service.BuscaEstacaoService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/buscas-estacoes")
public class BuscaEstacaoResource {
    BuscaEstacaoService service = new BuscaEstacaoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BuscaEstacaoModel> listar() {
        try {
            return service.listarBuscas();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar buscas de estações: " + e.getMessage());
        }
    }
}