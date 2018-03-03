package com.macgregor.ef.resource;


import com.codahale.metrics.annotation.Timed;
import com.macgregor.ef.dao.UnitDAO;
import com.macgregor.ef.exceptions.PageinationException;
import com.macgregor.ef.model.Unit;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.*;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("/unit")
@Path("/unit")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class UnitResource extends AbstractResource {
    UnitDAO unitDAO;

    public UnitResource(UnitDAO unitDAO) {
        this.unitDAO = unitDAO;
    }

    @GET
    @UnitOfWork
    @Timed
    @ApiOperation(value ="Get a list of all units",
            response = Unit.class,
            responseContainer = "List",
            responseHeaders = {
                @ResponseHeader(name=TOTAL_COUNT_HEADER, response=Integer.class, description = "Total count of entities in the database"),
                @ResponseHeader(name=LINK_HEADER, response = Link.class, responseContainer = "List", description = "List of links to help when paging data. Links include self, prev, next, first, last")

            }
    )
    @ApiResponses( value = {
            @ApiResponse(code = 400, message = "Pagination parameters out of bounds")
    })
    public List<Unit> getAll( @Context
                              HttpServletResponse response,
                              @ApiParam(value = "Page of data to retrieve.")
                              @QueryParam("page")
                              @DefaultValue("1")
                              Integer page,
                              @ApiParam(value = "Page size or number of entities to retrieve.")
                              @QueryParam("size")
                              @DefaultValue("10")
                              Integer size) throws PageinationException {
        int total = unitDAO.count();
        response.addHeader(TOTAL_COUNT_HEADER, Integer.toString(total));

        sanityCheckPagenationParameters(page, size, total);

        List<Link> links = getPagenationLinks("unit", page, size, total);
        response.addHeader(LINK_HEADER, links.toString());


        return unitDAO.find(page, size);
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
