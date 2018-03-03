package com.macgregor.ef.resource;

import com.codahale.metrics.annotation.Timed;
import com.macgregor.ef.dao.UnitSkillDAO;
import com.macgregor.ef.model.UnitSkill;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("/unit/skill")
@Path("/unit/skill")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class UnitSkillResource {
    UnitSkillDAO unitSkillDAO;

    public UnitSkillResource(UnitSkillDAO unitSkillDAO) {
        this.unitSkillDAO = unitSkillDAO;
    }

    @GET
    @UnitOfWork
    @Timed
    @ApiOperation(value ="Get a list of all unit skills",
            response = UnitSkill.class,
            responseContainer = "List"
    )
    public List<UnitSkill> getAll(){
        return unitSkillDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @Timed
    @ApiOperation(value = "Find a single unit skill by id", response = UnitSkill.class)
    @ApiResponses( value = {
            @ApiResponse(code = 204, message = "UnitSkill not found")
    })
    public UnitSkill get(@ApiParam(value = "id of unit skill to find", required = true) @PathParam("id") Integer id){
        return unitSkillDAO.findById(id);
    }


}
