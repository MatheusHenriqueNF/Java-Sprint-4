package br.com.fiap.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.WebApplicationException;

public class NotFoundException extends WebApplicationException {
    public NotFoundException(String message) {
        super(message, Response.Status.NOT_FOUND);
    }
}
