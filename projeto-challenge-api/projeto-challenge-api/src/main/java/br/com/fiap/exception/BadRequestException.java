package br.com.fiap.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class BadRequestException extends WebApplicationException {
    public BadRequestException(String message) {
        super(message, Response.status(Response.Status.BAD_REQUEST).entity(message).build());
    }
}
