package com.macgregor.ef.resource;

import com.codahale.metrics.annotation.Timed;
import com.macgregor.ef.dao.PetDAO;
import com.macgregor.ef.model.Pet;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("/pet")
@Path("/pet")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class PetResource {
    PetDAO petDAO;

    public PetResource(PetDAO petDAO) {
        this.petDAO = petDAO;
    }

    @GET
    @UnitOfWork
    @Timed
    @ApiOperation(value ="Get a list of all pets",
            response = Pet.class,
            responseContainer = "List"
    )
    public List<Pet> getAll(){
        return petDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @Timed
    @ApiOperation(value = "Find a single pet by id", response = Pet.class)
    @ApiResponses( value = {
            @ApiResponse(code = 404, message = "Pet not found")
    })
    public Pet get(@ApiParam(value = "id of pet to find", required = true) @PathParam("id") Integer id){
        return petDAO.findById(id);
    }
}
