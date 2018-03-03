package com.macgregor.ef.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PageinationExceptionMapper implements ExceptionMapper<PageinationException>
{
    @Override
    public Response toResponse(PageinationException exception)
    {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(exception.getMessage())
                .type("text/plain")
                .build();
    }
}
