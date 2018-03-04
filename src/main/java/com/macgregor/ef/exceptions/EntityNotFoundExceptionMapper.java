package com.macgregor.ef.exceptions;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class EntityNotFoundExceptionMapper implements ExceptionMapper<EntityNotFoundException>
{
    @Override
    public Response toResponse(EntityNotFoundException exception)
    {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(exception.getMessage())
                .type("text/plain")
                .build();
    }
}
