package com.macgregor.ef.resource.parameters;

import io.swagger.annotations.ApiParam;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class PageParameters {

    @ApiParam(value = "Page of data to retrieve.")
    @QueryParam("page")
    @DefaultValue("1")
    public Integer page;

    @ApiParam(value = "Page size or number of entities to retrieve.")
    @QueryParam("size")
    @DefaultValue("10")
    public Integer size;
}
