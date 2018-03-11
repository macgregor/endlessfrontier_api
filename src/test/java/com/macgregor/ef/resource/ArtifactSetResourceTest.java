package com.macgregor.ef.resource;

import com.macgregor.ef.dao.ArtifactSetDAO;
import com.macgregor.ef.exceptions.PageinationExceptionMapper;
import com.macgregor.ef.model.canonical.ArtifactSet;
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

public class ArtifactSetResourceTest extends ResourceTest {
    private static final ArtifactSetDAO artifactSetDAO = mock(ArtifactSetDAO.class);

    @ClassRule
    public static final ResourceTestRule resources =ResourceTestRule.builder()
            .setTestContainerFactory(new GrizzlyWebTestContainerFactory())
            .addResource(new ArtifactSetResource(artifactSetDAO))
            .addProvider(PageinationExceptionMapper.class)
            .build();

    public ArtifactSetResourceTest(){
        super(resources, ArtifactSetResource.BASE_URI, "artifactSet");
    }

    @After
    public void tearDown() {
        reset(artifactSetDAO);
    }

    @Before
    public void setUp(){
        List<ArtifactSet> artifactSets = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            ArtifactSet a = new ArtifactSet();
            a.setId(i);
            a.setName(String.format("%s%d", entityName, i));
            artifactSets.add(a);
        }

        when(artifactSetDAO.getAll()).thenReturn(artifactSets);
        when(artifactSetDAO.findById(1)).thenReturn(artifactSets.get(1));
        when(artifactSetDAO.count()).thenReturn(artifactSets.size());
        when(artifactSetDAO.page(any(), any())).thenReturn(artifactSets.subList(0,10));
    }

    @Test
    public void testFindAllUnits() throws Exception {
        List<ArtifactSet> result = resources.target(baseURI).request().get(new GenericType<List<ArtifactSet>>() {});

        assertEquals(10, result.size());
        assertEquals(String.format("%s%d", entityName, 0), result.get(0).getName());
    }

    @Test
    public void testFindUnitById() throws Exception {
        ArtifactSet artifact = resources.target(baseURI + "/1").request().get(ArtifactSet.class);
        assertThat(artifact.getId()).isEqualTo(1);
        assertThat(artifact.getName()).isEqualTo(String.format("%s%d", entityName, 1));
    }
}
