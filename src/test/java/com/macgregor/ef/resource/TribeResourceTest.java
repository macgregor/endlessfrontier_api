package com.macgregor.ef.resource;

import com.macgregor.ef.dao.TribeDAO;
import com.macgregor.ef.model.Tribe;
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

public class TribeResourceTest {
    private static final TribeDAO tribeDAO = mock(TribeDAO.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new TribeResource(tribeDAO))
            .build();

    @After
    public void tearDown() {
        reset(tribeDAO);
    }

    @Test
    public void testFindAllTribes() throws Exception {
        List<Tribe> tribes = new ArrayList<>();
        Tribe t1 = new Tribe();
        t1.setId(1);
        t1.setName("tribe1");
        tribes.add(t1);

        Tribe t2 = new Tribe();
        t2.setId(2);
        t2.setName("tribe2");
        tribes.add(t2);

        when(tribeDAO.getAll()).thenReturn(tribes);

        List<Tribe> result = resources.target("/tribe").request().get(new GenericType<List<Tribe>>() {});

        assertEquals(2, result.size());
        assertEquals("tribe1", result.get(0).getName());
    }

    @Test
    public void testFindTribeById() throws Exception {
        Tribe t1 = new Tribe();
        t1.setId(1);
        t1.setName("tribe1");
        when(tribeDAO.findById(1)).thenReturn(t1);

        Tribe unit = resources.target("/tribe/1").request().get(Tribe.class);
        assertThat(unit.getId()).isEqualTo(1);
        assertThat(unit.getName()).isEqualTo("tribe1");
    }
}
