package com.macgregor.ef.resource;


import com.codahale.metrics.annotation.Timed;
import com.macgregor.ef.dao.UnitDAO;
import com.macgregor.ef.model.Unit;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
    @ApiOperation("Get a list of all units")
    public List<Unit> getAll(){
        return unitDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @Timed
    @ApiOperation("Find a single unit by id")
    public Unit get(@PathParam("id") Integer id){
        return unitDAO.findById(id);
    }

    @POST
    @UnitOfWork
    @Timed
    @ApiOperation("Add a new unit")
    public Unit add(@Valid Unit unit) {
        Unit newUnit = unitDAO.insert(unit);

        return newUnit;
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    @Timed
    @ApiOperation("Update an existing unit by id")
    public Unit update(@PathParam("id") Integer id, @Valid Unit unit) {
        unit.setId(id);
        unitDAO.update(unit);

        return unit;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    @Timed
    @ApiOperation("Delete a unit")
    public void delete(@PathParam("id") Integer id) {
        unitDAO.delete(unitDAO.findById(id));
    }
}
