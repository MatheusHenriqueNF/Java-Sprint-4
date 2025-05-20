package br.com.fiap.resource;

import br.com.fiap.service.RotaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/rota")
@Produces(MediaType.APPLICATION_JSON)
public class RotaResource {

    @GET
    public Response calcularRota(@QueryParam("origem") String origem, @QueryParam("destino") String destino) {
        try {
            if (origem == null || destino == null || origem.trim().isEmpty() || destino.trim().isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("{\"erro\": \"Origem e destino são obrigatórios.\"}")
                        .build();
            }

            RotaService service = new RotaService();
            List<String> caminho = service.calcularRota(origem, destino);

            if (caminho.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{\"erro\": \"Caminho não encontrado entre as estações.\"}")
                        .build();
            }

            return Response.ok(caminho).build(); // retorno automático como JSON
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError()
                    .entity("{\"erro\": \"Erro interno ao calcular a rota.\"}")
                    .build();
        }
    }
}
