package com.macgregor.ef.resource;

import com.codahale.metrics.annotation.Timed;
import com.macgregor.ef.dao.ArtifactDAO;
import com.macgregor.ef.model.Artifact;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("/artifact")
@Path("/artifact")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class ArtifactResource {
    ArtifactDAO artifactDAO;

    public ArtifactResource(ArtifactDAO artifactDAO) {
        this.artifactDAO = artifactDAO;
    }

    @GET
    @UnitOfWork
    @Timed
    @ApiOperation(value ="Get a list of all artifacts",
            response = Artifact.class,
            responseContainer = "List"
    )
    public List<Artifact> getAll(){
        return artifactDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @Timed
    @ApiOperation(value = "Find a single artifact by id", response = Artifact.class)
    @ApiResponses( value = {
            @ApiResponse(code = 404, message = "Artifact not found")
    })
    public Artifact get(@ApiParam(value = "id of artifact to find", required = true) @PathParam("id") Integer id){
        return artifactDAO.findById(id);
    }
}
