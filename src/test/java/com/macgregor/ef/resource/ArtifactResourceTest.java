package com.macgregor.ef.resource;

import com.macgregor.ef.dao.ArtifactDAO;
import com.macgregor.ef.model.Artifact;
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

public class ArtifactResourceTest {
    private static final ArtifactDAO artifactDAO = mock(ArtifactDAO.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new ArtifactResource(artifactDAO))
            .build();

    @After
    public void tearDown() {
        reset(artifactDAO);
    }

    @Test
    public void testFindAllArtifacts() throws Exception {
        List<Artifact> artifacts = new ArrayList<>();
        Artifact a1 = new Artifact();
        a1.setId(1);
        a1.setName("artifact1");
        artifacts.add(a1);

        Artifact a2 = new Artifact();
        a2.setId(2);
        a2.setName("artifact2");
        artifacts.add(a2);

        when(artifactDAO.getAll()).thenReturn(artifacts);

        List<Artifact> result = resources.target("/artifact").request().get(new GenericType<List<Artifact>>() {});

        assertEquals(2, result.size());
        assertEquals("artifact1", result.get(0).getName());
    }

    @Test
    public void testFindArtifactById() throws Exception {
        Artifact a1 = new Artifact();
        a1.setId(1);
        a1.setName("artifact1");
        when(artifactDAO.findById(1)).thenReturn(a1);

        Artifact unit = resources.target("/artifact/1").request().get(Artifact.class);
        assertThat(unit.getId()).isEqualTo(1);
        assertThat(unit.getName()).isEqualTo("artifact1");
    }
}
