package com.macgregor.ef.resource;


import com.macgregor.ef.dao.UnitDAO;
import com.macgregor.ef.model.Unit;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.After;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.GenericType;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UnitResourceTest {
    private static final UnitDAO unitDAO = mock(UnitDAO.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new UnitResource(unitDAO))
            .build();

    @After
    public void tearDown() {
        reset(unitDAO);
    }

    @Test
    public void testFindAllUnits() throws Exception {
        List<Unit> units = new ArrayList<>();
        Unit u1 = new Unit();
        u1.setId(1);
        u1.setName("unit1");
        units.add(u1);

        Unit u2 = new Unit();
        u2.setId(2);
        u2.setName("unit2");
        units.add(u2);

        when(unitDAO.getAll()).thenReturn(units);

        List<Unit> result = resources.target("/unit").request().get(new GenericType<List<Unit>>() {});

        assertEquals(2, result.size());
        assertEquals("unit1", result.get(0).getName());
    }

    @Test
    public void testFindUnitById() throws Exception {
        Unit u1 = new Unit();
        u1.setId(1);
        u1.setName("unit1");
        when(unitDAO.findById(1)).thenReturn(u1);

        Unit unit = resources.target("/unit/1").request().get(Unit.class);
        assertThat(unit.getId()).isEqualTo(1);
        assertThat(unit.getName()).isEqualTo("unit1");
    }
}
