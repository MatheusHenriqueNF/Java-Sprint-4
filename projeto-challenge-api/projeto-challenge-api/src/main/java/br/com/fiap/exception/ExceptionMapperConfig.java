package br.com.fiap.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ExceptionMapperConfig implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        e.printStackTrace(); // Loga no servidor

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Erro inesperado: " + e.getMessage())
                .build();
    }
}
