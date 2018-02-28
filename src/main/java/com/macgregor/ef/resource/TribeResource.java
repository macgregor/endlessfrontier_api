package com.macgregor.ef.resource;


import com.codahale.metrics.annotation.Timed;
import com.macgregor.ef.dao.TribeDAO;
import com.macgregor.ef.model.Tribe;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("/tribe")
@Path("/tribe")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class TribeResource {
    TribeDAO tribeDAO;

    public TribeResource(TribeDAO tribeDAO) {
        this.tribeDAO = tribeDAO;
    }

    @GET
    @UnitOfWork
    @Timed
    @ApiOperation(value ="Get a list of all tribes",
            response = Tribe.class,
            responseContainer = "List"
    )
    public List<Tribe> getAll(){
        return tribeDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @Timed
    @ApiOperation(value = "Find a single tribe by id", response = Tribe.class)
    @ApiResponses( value = {
            @ApiResponse(code = 404, message = "Tribe not found")
    })
    public Tribe get(@ApiParam(value = "id of tribe to find", required = true) @PathParam("id") Integer id){
        return tribeDAO.findById(id);
    }
}
