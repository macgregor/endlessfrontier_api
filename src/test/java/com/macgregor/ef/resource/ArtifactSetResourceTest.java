package com.macgregor.ef.resource;

import com.macgregor.ef.dao.ArtifactSetDAO;
import com.macgregor.ef.model.ArtifactSet;
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

public class ArtifactSetResourceTest {
    private static final ArtifactSetDAO artifactSetDAO = mock(ArtifactSetDAO.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new ArtifactSetResource(artifactSetDAO))
            .build();

    @After
    public void tearDown() {
        reset(artifactSetDAO);
    }

    @Test
    public void testFindAllArtifactSets() throws Exception {
        List<ArtifactSet> artifactSets = new ArrayList<>();
        ArtifactSet as1 = new ArtifactSet();
        as1.setId(1);
        as1.setTitle("artifactSet1");
        artifactSets.add(as1);

        ArtifactSet as2 = new ArtifactSet();
        as2.setId(2);
        as2.setTitle("artifactSet2");
        artifactSets.add(as2);

        when(artifactSetDAO.getAll()).thenReturn(artifactSets);

        List<ArtifactSet> result = resources.target("/artifact/set").request().get(new GenericType<List<ArtifactSet>>() {});

        assertEquals(2, result.size());
        assertEquals("artifactSet1", result.get(0).getTitle());
    }

    @Test
    public void testFindArtifactSetById() throws Exception {
        ArtifactSet as1 = new ArtifactSet();
        as1.setId(1);
        as1.setTitle("artifactSet1");
        when(artifactSetDAO.findById(1)).thenReturn(as1);

        ArtifactSet unit = resources.target("/artifact/set/1").request().get(ArtifactSet.class);
        assertThat(unit.getId()).isEqualTo(1);
        assertThat(unit.getTitle()).isEqualTo("artifactSet1");
    }
}
