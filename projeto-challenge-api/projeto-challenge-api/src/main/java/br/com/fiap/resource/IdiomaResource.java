package br.com.fiap.resource;

import br.com.fiap.model.IdiomaModel;
import br.com.fiap.service.IdiomaService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/idiomas")
public class IdiomaResource {
    IdiomaService service = new IdiomaService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<IdiomaModel> listar() {
        try {
            return service.listarIdiomas();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar idiomas: " + e.getMessage());
        }
    }
}