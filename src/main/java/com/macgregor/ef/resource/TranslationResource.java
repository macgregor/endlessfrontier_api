package com.macgregor.ef.resource;

import com.codahale.metrics.annotation.Timed;
import com.macgregor.ef.dao.AbstractEFDAO;
import com.macgregor.ef.dao.TranslationDAO;
import com.macgregor.ef.exceptions.PageinationException;
import com.macgregor.ef.model.canonical.Translation;
import com.macgregor.ef.resource.parameters.PageParameters;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.*;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static com.macgregor.ef.resource.TranslationResource.BASE_URI;

@Api(BASE_URI)
@Path(BASE_URI)
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class TranslationResource extends AbstractResource<Translation>{
    public static final String BASE_URI = "/translation";

    public TranslationResource(AbstractEFDAO resourceDAO) {
        super(resourceDAO);
    }

    public String getPageLinkBaseURI(){
        return BASE_URI;
    }

    @GET
    @UnitOfWork
    @Timed
    @ApiOperation(value ="API for paging through all Translation entities.",
            response = Translation.class,
            responseContainer = "List",
            responseHeaders = {
                    @ResponseHeader(name=TOTAL_COUNT_HEADER, response=Integer.class, description = "Total count of Translation entities in the database"),
                    @ResponseHeader(name=LINK_HEADER, response = Link.class, responseContainer = "List", description = "List of links to help when paging data. Links include self, prev, next, first, last. The first page will not have a prev link and the last page will not have a next link")
            }
    )
    @ApiResponses( value = {
            @ApiResponse(code = 400, message = "Pagination parameters out of bounds")
    })
    public List<Translation> getPage(@Context HttpServletResponse response, @BeanParam PageParameters pageParameters) throws PageinationException {
        return getPage(response, pageParameters.page, pageParameters.size);
    }

    @GET
    @UnitOfWork
    @Timed
    @Path("/{id}")
    @ApiOperation(value = "Find a single Translation entity by id")
    @ApiResponses( value = {
            @ApiResponse(code = 204, message = "Translation Entity not found")
    })
    public Translation get(@ApiParam(value = "id of Translation entity to find", required = true) @PathParam("id") String id){
        return ((TranslationDAO)super.resourceDAO).findById(id);
    }
}
