package com.macgregor.ef.resource;


import com.codahale.metrics.annotation.Timed;
import com.macgregor.ef.dao.UnitDAO;
import com.macgregor.ef.model.Unit;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("/unit")
@Path("/unit")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class UnitResource {
    UnitDAO unitDAO;

    public UnitResource(UnitDAO unitDAO) {
        this.unitDAO = unitDAO;
    }

    @GET
    @UnitOfWork
    @Timed
    @ApiOperation(value ="Get a list of all units",
            response = Unit.class,
            responseContainer = "List"
    )
    public List<Unit> getAll(){
        return unitDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @Timed
    @ApiOperation(value = "Find a single unit by id", response = Unit.class)
    @ApiResponses( value = {
        @ApiResponse(code = 204, message = "Unit not found")
    })
    public Unit get(@ApiParam(value = "id of unit to find", required = true) @PathParam("id") Integer id){
        return unitDAO.findById(id);
    }
}
