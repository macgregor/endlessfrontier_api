package com.macgregor.ef.resource;

import com.macgregor.ef.dao.TribeDAO;
import com.macgregor.ef.exceptions.PageinationExceptionMapper;
import com.macgregor.ef.model.Tribe;
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

public class TribeResourceTest extends ResourceTest {
    private static final TribeDAO tribeDAO = mock(TribeDAO.class);

    @ClassRule
    public static final ResourceTestRule resources =ResourceTestRule.builder()
            .setTestContainerFactory(new GrizzlyWebTestContainerFactory())
            .addResource(new TribeResource(tribeDAO))
            .addProvider(PageinationExceptionMapper.class)
            .build();

    public TribeResourceTest(){
        super(resources, TribeResource.BASE_URI, "tribe");
    }

    @After
    public void tearDown() {
        reset(tribeDAO);
    }

    @Before
    public void setUp(){
        List<Tribe> tribes = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            Tribe t = new Tribe();
            t.setId(i);
            t.setName(String.format("%s%d", entityName, i));
            tribes.add(t);
        }

        when(tribeDAO.getAll()).thenReturn(tribes);
        when(tribeDAO.findById(1)).thenReturn(tribes.get(1));
        when(tribeDAO.count()).thenReturn(tribes.size());
        when(tribeDAO.page(any(), any())).thenReturn(tribes.subList(0,10));
    }

    @Test
    public void testFindAllUnits() throws Exception {
        List<Tribe> result = resources.target(baseURI).request().get(new GenericType<List<Tribe>>() {});

        assertEquals(10, result.size());
        assertEquals(String.format("%s%d", entityName, 0), result.get(0).getName());
    }

    @Test
    public void testFindUnitById() throws Exception {
        Tribe tribe = resources.target(baseURI + "/1").request().get(Tribe.class);
        assertThat(tribe.getId()).isEqualTo(1);
        assertThat(tribe.getName()).isEqualTo(String.format("%s%d", entityName, 1));
    }
}
