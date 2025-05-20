package br.com.fiap.resource;


import br.com.fiap.dao.EstacaoDAO;
import br.com.fiap.model.EstacaoModel;
import br.com.fiap.service.EstacaoService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/estacoes")
public class EstacaoResource {
    EstacaoService service = new EstacaoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EstacaoModel> listar() {
        try {
            return service.listarEstacoes();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar estações: " + e.getMessage());
        }
    }

    @PUT
    @Path("/{id}/status")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response atualizarStatusEstacao(@PathParam("id") Long id, String novoStatus) {
        try {
            boolean atualizado = new EstacaoDAO().atualizarStatus(id, novoStatus);
            if (atualizado) {
                return Response.ok("✅ Status atualizado com sucesso").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("❌ Estação não encontrada").build();
            }
        } catch (Exception e) {
            return Response.serverError().entity("Erro ao atualizar: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/nomes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarSomenteNomes() {
        try {
            List<String> estacoes = new EstacaoService().listarNomesEstacoes();
            return Response.ok(estacoes).build();
        } catch (Exception e) {
            return Response.serverError().entity("Erro ao buscar estações: " + e.getMessage()).build();
        }
    }


}

