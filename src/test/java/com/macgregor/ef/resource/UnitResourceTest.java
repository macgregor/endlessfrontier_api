package com.macgregor.ef.resource;


import com.macgregor.ef.dao.UnitDAO;
import com.macgregor.ef.exceptions.PageinationExceptionMapper;
import com.macgregor.ef.model.Unit;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UnitResourceTest {
    private static final UnitDAO unitDAO = mock(UnitDAO.class);
    private static final HttpServletRequest request = Mockito.mock(HttpServletRequest.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .setTestContainerFactory(new GrizzlyWebTestContainerFactory())
            .addResource(new UnitResource(unitDAO))
            .addProvider(PageinationExceptionMapper.class)
            .build();

    @After
    public void tearDown() {
        reset(unitDAO);
    }

    @Before
    public void setUp(){
        List<Unit> units = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            Unit u = new Unit();
            u.setId(i);
            u.setName(String.format("unit%d", i));
            units.add(u);
        }

        when(unitDAO.getAll()).thenReturn(units);
        when(unitDAO.findById(1)).thenReturn(units.get(1));
        when(unitDAO.count()).thenReturn(units.size());
        when(unitDAO.page(any(), any())).thenReturn(units.subList(0,10));
    }

    @Test
    public void testFindAllUnits() throws Exception {
        List<Unit> result = resources.target("/unit").request().get(new GenericType<List<Unit>>() {});

        assertEquals(10, result.size());
        assertEquals("unit0", result.get(0).getName());
    }

    @Test
    public void testFindUnitById() throws Exception {
        Unit unit = resources.target("/unit/1").request().get(Unit.class);
        assertThat(unit.getId()).isEqualTo(1);
        assertThat(unit.getName()).isEqualTo("unit1");
    }

    @Test
    public void testPaginationShouldSetSelfLink(){
        WebTarget target = resources.target("/unit").queryParam("page", 2).queryParam("size", 10);
        String expectedLinkUri = "/unit?page=2&size=10";
        String expectedLinkRel = "self";
        testPagination(target, expectedLinkUri, expectedLinkRel);
    }

    @Test
    public void testPaginationShouldSetFirstLink(){
        WebTarget target = resources.target("/unit").queryParam("page", 2).queryParam("size", 10);
        String expectedLinkUri = "/unit?page=1&size=10";
        String expectedLinkRel = "first";
        testPagination(target, expectedLinkUri, expectedLinkRel);
    }

    @Test
    public void testPaginationShouldSetLastLink(){
        WebTarget target = resources.target("/unit").queryParam("page", 2).queryParam("size", 10);
        String expectedLinkUri = "/unit?page=10&size=10";
        String expectedLinkRel = "last";
        testPagination(target, expectedLinkUri, expectedLinkRel);
    }

    @Test
    public void testPaginationShouldSetNextLink(){
        WebTarget target = resources.target("/unit").queryParam("page", 2).queryParam("size", 10);
        String expectedLinkUri = "/unit?page=3&size=10";
        String expectedLinkRel = "next";
        testPagination(target, expectedLinkUri, expectedLinkRel);
    }

    @Test
    public void testPaginationShouldSetPreviousLink(){
        WebTarget target = resources.target("/unit").queryParam("page", 2).queryParam("size", 10);
        String expectedLinkUri = "/unit?page=1&size=10";
        String expectedLinkRel = "prev";
        testPagination(target, expectedLinkUri, expectedLinkRel);
    }

    @Test
    public void testPaginationShouldSetPreviousLinkOnFirstPage(){
        Response response = resources.target("/unit")
                .queryParam("page", 1)
                .queryParam("size", 10)
                .request()
                .get();
        String links = response.getHeaderString(AbstractResource.LINK_HEADER);
        assertThat(links).doesNotContain("rel=\"prev\"");
    }

    @Test
    public void testPaginationShouldSetNextLinkOnLastPage(){
        Response response = resources.target("/unit")
                .queryParam("page", 10)
                .queryParam("size", 10)
                .request()
                .get();
        String links = response.getHeaderString(AbstractResource.LINK_HEADER);
        assertThat(links).doesNotContain("rel=\"next\"");
    }

    @Test
    public void testPaginationShouldSetTotalEntityCount(){
        Response response = resources.target("/unit")
                .queryParam("page", 10)
                .queryParam("size", 10)
                .request()
                .get();
        assertEquals(100, Integer.parseInt(response.getHeaderString(AbstractResource.TOTAL_COUNT_HEADER)));
    }

    @Test
    public void testPaginationShouldReturnBadRequestWhenPageLessThanOne(){
        Response response = resources.target("/unit")
                .queryParam("page", 0)
                .queryParam("size", 10)
                .request()
                .get();
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    public void testPaginationShouldReturnBadRequestWhenPageGreaterThanMaxPage(){
        Response response = resources.target("/unit")
                .queryParam("page", 11)
                .queryParam("size", 10)
                .request()
                .get();
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    public void testPaginationShouldReturnBadRequestWhenPageSizeGreaterThanMaxPageSize(){
        Response response = resources.target("/unit")
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
