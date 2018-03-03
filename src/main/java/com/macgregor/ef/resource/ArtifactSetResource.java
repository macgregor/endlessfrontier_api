package com.macgregor.ef.resource;

import com.codahale.metrics.annotation.Timed;
import com.macgregor.ef.dao.ArtifactSetDAO;
import com.macgregor.ef.model.ArtifactSet;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("/artifact/set")
@Path("/artifact/set")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class ArtifactSetResource {
    ArtifactSetDAO artifactSetDAO;

    public ArtifactSetResource(ArtifactSetDAO artifactSetDAO) {
        this.artifactSetDAO = artifactSetDAO;
    }

    @GET
    @UnitOfWork
    @Timed
    @ApiOperation(value ="Get a list of all artifact sets",
            response = ArtifactSet.class,
            responseContainer = "List"
    )
    public List<ArtifactSet> getAll(){
        return artifactSetDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @Timed
    @ApiOperation(value = "Find a single artifact set by id", response = ArtifactSet.class)
    @ApiResponses( value = {
            @ApiResponse(code = 204, message = "ArtifactSet not found")
    })
    public ArtifactSet get(@ApiParam(value = "id of artifact set to find", required = true) @PathParam("id") Integer id){
        return artifactSetDAO.findById(id);
    }
}
