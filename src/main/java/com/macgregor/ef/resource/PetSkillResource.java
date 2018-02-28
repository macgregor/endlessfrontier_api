package com.macgregor.ef.resource;

import com.codahale.metrics.annotation.Timed;
import com.macgregor.ef.dao.PetSkillDAO;
import com.macgregor.ef.model.PetSkill;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("/pet/skill")
@Path("/pet/skill")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class PetSkillResource {
    PetSkillDAO petSkillDAO;

    public PetSkillResource(PetSkillDAO petSkillDAO) {
        this.petSkillDAO = petSkillDAO;
    }

    @GET
    @UnitOfWork
    @Timed
    @ApiOperation(value ="Get a list of all pet skills",
            response = PetSkill.class,
            responseContainer = "List"
    )
    public List<PetSkill> getAll(){
        return petSkillDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @Timed
    @ApiOperation(value = "Find a single pet skill by id", response = PetSkill.class)
    @ApiResponses( value = {
            @ApiResponse(code = 404, message = "PetSkill not found")
    })
    public PetSkill get(@ApiParam(value = "id of pet skill to find", required = true) @PathParam("id") Integer id){
        return petSkillDAO.findById(id);
    }
}
