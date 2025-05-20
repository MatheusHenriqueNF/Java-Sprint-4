package br.com.fiap.resource;

import br.com.fiap.model.LinhaModel;
import br.com.fiap.service.LinhaService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/linhas")
public class LinhaResource {
    LinhaService service = new LinhaService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LinhaModel> listar() {
        try {
            return service.listarLinhas();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar linhas: " + e.getMessage());
        }
    }
}