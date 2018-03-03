package com.macgregor.ef.resource;

import com.codahale.metrics.annotation.Timed;
import com.macgregor.ef.dao.TranslationDAO;
import com.macgregor.ef.model.Translation;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("/translation")
@Path("/translation")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class TranslationResource {
    TranslationDAO translationDAO;

    public TranslationResource(TranslationDAO translationDAO) {
        this.translationDAO = translationDAO;
    }

    @GET
    @UnitOfWork
    @Timed
    @ApiOperation(value ="Get a list of all translations",
            response = Translation.class,
            responseContainer = "List"
    )
    public List<Translation> getAll(){
        return translationDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @Timed
    @ApiOperation(value = "Find a single translation by id.", response = Translation.class)
    @ApiResponses( value = {
            @ApiResponse(code = 204, message = "Translation not found")
    })
    public Translation get(@ApiParam(value = "id of translation to find", required = true) @PathParam("id") String id){
        return translationDAO.findById(id);
    }
}
