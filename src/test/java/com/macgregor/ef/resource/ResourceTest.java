package com.macgregor.ef.resource;

import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


public abstract class ResourceTest {
    protected static final HttpServletRequest request = Mockito.mock(HttpServletRequest.class);


    public final ResourceTestRule resources;
    protected final String baseURI;
    protected final String entityName;

    public ResourceTest(ResourceTestRule resources, String baseURI, String entityName){
        this.resources = resources;
        this.baseURI = baseURI;
        this.entityName = entityName;
    }

    @Test
    public void testPaginationShouldSetSelfLink(){
        WebTarget target = resources.target(baseURI).queryParam("page", 2).queryParam("size", 10);
        String expectedLinkUri = String.format("%s?page=2&size=10", baseURI);
        String expectedLinkRel = "self";
        testPagination(target, expectedLinkUri, expectedLinkRel);
    }

    @Test
    public void testPaginationShouldSetFirstLink(){
        WebTarget target = resources.target(baseURI).queryParam("page", 2).queryParam("size", 10);
        String expectedLinkUri = String.format("%s?page=1&size=10", baseURI);
        String expectedLinkRel = "first";
        testPagination(target, expectedLinkUri, expectedLinkRel);
    }

    @Test
    public void testPaginationShouldSetLastLink(){
        WebTarget target = resources.target(baseURI).queryParam("page", 2).queryParam("size", 10);
        String expectedLinkUri = String.format("%s?page=10&size=10", baseURI);
        String expectedLinkRel = "last";
        testPagination(target, expectedLinkUri, expectedLinkRel);
    }

    @Test
    public void testPaginationShouldSetNextLink(){
        WebTarget target = resources.target(baseURI).queryParam("page", 2).queryParam("size", 10);
        String expectedLinkUri = String.format("%s?page=3&size=10", baseURI);
        String expectedLinkRel = "next";
        testPagination(target, expectedLinkUri, expectedLinkRel);
    }

    @Test
    public void testPaginationShouldSetPreviousLink(){
        WebTarget target = resources.target(baseURI).queryParam("page", 2).queryParam("size", 10);
        String expectedLinkUri = String.format("%s?page=1&size=10", baseURI);
        String expectedLinkRel = "prev";
        testPagination(target, expectedLinkUri, expectedLinkRel);
    }

    @Test
    public void testPaginationShouldSetPreviousLinkOnFirstPage(){
        Response response = resources.target(baseURI)
                .queryParam("page", 1)
                .queryParam("size", 10)
                .request()
                .get();
        String links = response.getHeaderString(AbstractResource.LINK_HEADER);
        assertThat(links).doesNotContain("rel=\"prev\"");
    }

    @Test
    public void testPaginationShouldSetNextLinkOnLastPage(){
        Response response = resources.target(baseURI)
                .queryParam("page", 10)
                .queryParam("size", 10)
                .request()
                .get();
        String links = response.getHeaderString(AbstractResource.LINK_HEADER);
        assertThat(links).doesNotContain("rel=\"next\"");
    }

    @Test
    public void testPaginationShouldSetTotalEntityCount(){
        Response response = resources.target(baseURI)
                .queryParam("page", 10)
                .queryParam("size", 10)
                .request()
                .get();
        assertEquals(100, Integer.parseInt(response.getHeaderString(AbstractResource.TOTAL_COUNT_HEADER)));
    }

    @Test
    public void testPaginationShouldReturnBadRequestWhenPageLessThanOne(){
        Response response = resources.target(baseURI)
                .queryParam("page", 0)
                .queryParam("size", 10)
                .request()
                .get();
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    public void testPaginationShouldReturnBadRequestWhenPageGreaterThanMaxPage(){
        Response response = resources.target(baseURI)
                .queryParam("page", 11)
                .queryParam("size", 10)
                .request()
                .get();
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    public void testPaginationShouldReturnBadRequestWhenPageSizeGreaterThanMaxPageSize(){
        Response response = resources.target(baseURI)
                .queryParam("page", 1)
                .queryParam("size", AbstractResource.MAX_PAGE_SIZE+1)
                .request()
                .get();
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    private void testPagination(WebTarget target, String expectedLinkUri, String expectedLinkRel){
        Response response = target.request().get();
        String links = response.getHeaderString(AbstractResource.LINK_HEADER);
        Link link = Link.fromUri(expectedLinkUri)
                .rel(expectedLinkRel)
                .type("text/plain")
                .build();
        assertThat(links).contains(link.toString());
    }
}
