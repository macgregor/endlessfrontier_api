package com.macgregor.ef.resource;

import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("hello-world")
@Api("hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    @GET
    @Timed
    @ApiOperation("Sample endpoint with query param")
    public String sayHello(@QueryParam("name") Optional<String> name) {
        return String.format("Hello world %s", name.orElse("macgregor"));
    }

}
