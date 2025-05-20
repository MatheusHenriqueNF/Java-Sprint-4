package br.com.fiap.resource;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.model.LoginResponse;
import br.com.fiap.model.UsuarioModel;
import br.com.fiap.service.UsuarioService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.List;

@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    UsuarioService service = new UsuarioService();

    @GET
    public List<UsuarioModel> listar() {
        try {
            return service.listarUsuarios();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar usuários: " + e.getMessage());
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(UsuarioModel loginRequest) {
        try {
            UsuarioModel usuario = new UsuarioDAO().autenticar(
                    loginRequest.getLogin(), loginRequest.getSenha());

            if (usuario == null) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("❌ Login ou senha inválidos.").build();
            }

            if (!"1".equals(usuario.getStatus())) {
                return Response.status(Response.Status.FORBIDDEN)
                        .entity("❌ Seu acesso está pausado. Contate o administrador.").build();
            }

            return Response.ok(usuario).build();

        } catch (Exception e) {
            return Response.serverError().entity("Erro ao processar login: " + e.getMessage()).build();
        }
    }


    @POST
    @Path("/cadastrar")
    public Response cadastrarUsuario(UsuarioModel usuario) {
        try {
            boolean sucesso = service.cadastrarUsuario(
                    usuario.getLogin(),
                    usuario.getSenha(),
                    usuario.getCargo()
            );

            if (sucesso) {
                return Response.status(Response.Status.CREATED)
                        .entity("✅ Usuário cadastrado com sucesso!").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("❌ Falha ao cadastrar o usuário.").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao cadastrar: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}/status")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response atualizarStatus(@PathParam("id") Long id, String novoStatus) {
        try {
            boolean atualizado = service.atualizarStatus(id, novoStatus);

            if (atualizado) {
                return Response.ok("Status atualizado com sucesso.").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Usuário não encontrado.").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao atualizar status: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}/senha")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response redefinirSenha(@PathParam("id") Long id, String novaSenha) {
        try {
            boolean atualizado = new UsuarioDAO().atualizarSenha(id, novaSenha.trim());
            if (atualizado) {
                return Response.ok("✅ Senha atualizada com sucesso").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("❌ Usuário não encontrado").build();
            }
        } catch (Exception e) {
            return Response.serverError().entity("Erro ao atualizar senha: " + e.getMessage()).build();
        }
    }

}
