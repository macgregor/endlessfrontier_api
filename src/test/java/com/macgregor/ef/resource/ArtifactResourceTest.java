package com.macgregor.ef.resource;

import com.macgregor.ef.dao.ArtifactDAO;
import com.macgregor.ef.exceptions.PageinationExceptionMapper;
import com.macgregor.ef.model.Artifact;
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

public class ArtifactResourceTest extends ResourceTest {
    private static final ArtifactDAO artifactDAO = mock(ArtifactDAO.class);

    @ClassRule
    public static final ResourceTestRule resources =ResourceTestRule.builder()
            .setTestContainerFactory(new GrizzlyWebTestContainerFactory())
            .addResource(new ArtifactResource(artifactDAO))
            .addProvider(PageinationExceptionMapper.class)
            .build();

    public ArtifactResourceTest(){
        super(resources, ArtifactResource.BASE_URI, "artifact");
    }

    @After
    public void tearDown() {
        reset(artifactDAO);
    }

    @Before
    public void setUp(){
        List<Artifact> artifacts = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            Artifact a = new Artifact();
            a.setId(i);
            a.setName(String.format("%s%d", entityName, i));
            artifacts.add(a);
        }

        when(artifactDAO.getAll()).thenReturn(artifacts);
        when(artifactDAO.findById(1)).thenReturn(artifacts.get(1));
        when(artifactDAO.count()).thenReturn(artifacts.size());
        when(artifactDAO.page(any(), any())).thenReturn(artifacts.subList(0,10));
    }

    @Test
    public void testFindAllArtifacts() throws Exception {
        List<Artifact> result = resources.target(baseURI).request().get(new GenericType<List<Artifact>>() {});

        assertEquals(10, result.size());
        assertEquals(String.format("%s%d", entityName, 0), result.get(0).getName());
    }

    @Test
    public void testFindArtifactById() throws Exception {
        Artifact unit = resources.target(baseURI + "/1").request().get(Artifact.class);
        assertThat(unit.getId()).isEqualTo(1);
        assertThat(unit.getName()).isEqualTo(String.format("%s%d", entityName, 1));
    }
}
