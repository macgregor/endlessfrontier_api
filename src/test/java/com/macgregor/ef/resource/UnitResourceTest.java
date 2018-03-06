package com.macgregor.ef.resource;


import com.macgregor.ef.dao.UnitDAO;
import com.macgregor.ef.exceptions.PageinationExceptionMapper;
import com.macgregor.ef.model.canonical.Unit;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.GenericType;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UnitResourceTest extends ResourceTest {
    private static final UnitDAO unitDAO = mock(UnitDAO.class);

    @ClassRule
    public static final ResourceTestRule resources =ResourceTestRule.builder()
            .setTestContainerFactory(new GrizzlyWebTestContainerFactory())
            .addResource(new UnitResource(unitDAO))
            .addProvider(PageinationExceptionMapper.class)
            .build();

    public UnitResourceTest(){
        super(resources, UnitResource.BASE_URI, "unit");
    }

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
            u.setName(String.format("%s%d", entityName, i));
            units.add(u);
        }

        when(unitDAO.getAll()).thenReturn(units);
        when(unitDAO.findById(1)).thenReturn(units.get(1));
        when(unitDAO.count()).thenReturn(units.size());
        when(unitDAO.page(any(), any())).thenReturn(units.subList(0,10));
    }

    @Test
    public void testFindAllUnits() throws Exception {
        List<Unit> result = resources.target(baseURI).request().get(new GenericType<List<Unit>>() {});

        assertEquals(10, result.size());
        assertEquals(String.format("%s%d", entityName, 0), result.get(0).getName());
    }

    @Test
    public void testFindUnitById() throws Exception {
        Unit unit = resources.target(baseURI + "/1").request().get(Unit.class);
        assertThat(unit.getId()).isEqualTo(1);
        assertThat(unit.getName()).isEqualTo(String.format("%s%d", entityName, 1));
    }
}
