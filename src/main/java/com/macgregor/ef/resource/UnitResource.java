package com.macgregor.ef.resource;


import com.codahale.metrics.annotation.Timed;
import com.macgregor.ef.dao.UnitDAO;
import com.macgregor.ef.model.Unit;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.*;

import javax.validation.Valid;
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
        @ApiResponse(code = 404, message = "Unit not found")
    })
    public Unit get(@ApiParam(value = "id of unit to be updated", required = true) @PathParam("id") Integer id){
        return unitDAO.findById(id);
    }

    @POST
    @UnitOfWork
    @Timed
    @ApiOperation(value = "Add a new unit", response = Unit.class)
    @ApiResponses(value ={
            @ApiResponse(code = 422, message = "invalid unit") //TODO: ensure validation results are added to response
    })
    public Unit add(@ApiParam(value = "valid unit object to update", required = true) @Valid Unit unit) {
        Unit newUnit = unitDAO.insert(unit);

        return newUnit;
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    @Timed
    @ApiOperation(value = "Update an existing unit by id", response = Unit.class)
    @ApiResponses(value ={
            @ApiResponse(code = 422, message = "invalid unit") //TODO: ensure validation results are added to response
    })
    public Unit update(@ApiParam(value = "id of unit to be updated", required = true) @PathParam("id") Integer id,
                       @ApiParam(value = "valid unit object to update", required = true) @Valid Unit unit) {
        unit.setId(id);
        unitDAO.update(unit);

        return unit;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    @Timed
    @ApiOperation("Delete a unit")
    @ApiResponses(value ={
            @ApiResponse(code = 204, message = "delete operation successful")
    })
    public void delete(@ApiParam(value = "id of unit to be updated", required = true) @PathParam("id") Integer id) {
        unitDAO.delete(unitDAO.findById(id));
    }
}
