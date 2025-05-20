package br.com.fiap.resource;

import br.com.fiap.model.DuvidaFrequenteModel;
import br.com.fiap.service.DuvidaFrequenteService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/duvidas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DuvidaFrequenteResource {

    DuvidaFrequenteService service = new DuvidaFrequenteService();

    @GET
    public List<DuvidaFrequenteModel> listar() {
        try {
            return service.listarDuvidas();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar dúvidas frequentes: " + e.getMessage());
        }
    }

    @PUT
    @Path("/{id}/status")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response atualizarStatus(@PathParam("id") Long id, String novoStatus) {
        try {
            boolean sucesso = service.atualizarStatus(id, novoStatus.trim());
            if (sucesso) {
                return Response.ok("✅ Status atualizado com sucesso").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("❌ Dúvida não encontrada").build();
            }
        } catch (Exception e) {
            return Response.serverError().entity("Erro ao atualizar status: " + e.getMessage()).build();
        }
    }

    @POST
    public Response cadastrarDuvida(DuvidaFrequenteModel duvida) {
        try {
            boolean sucesso = service.cadastrarDuvida(duvida);
            if (sucesso) {
                return Response.status(Response.Status.CREATED)
                        .entity("✅ Dúvida cadastrada com sucesso").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("❌ Falha ao cadastrar a dúvida").build();
            }
        } catch (Exception e) {
            return Response.serverError().entity("Erro interno: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarDuvida(@PathParam("id") Long id, DuvidaFrequenteModel duvida) {
        try {
            boolean sucesso = new DuvidaFrequenteService().atualizarDuvida(id, duvida);
            if (sucesso) {
                return Response.ok("✅ Dúvida atualizada com sucesso").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("❌ Dúvida não encontrada").build();
            }
        } catch (Exception e) {
            return Response.serverError().entity("❌ Erro ao atualizar: " + e.getMessage()).build();
        }
    }

}
