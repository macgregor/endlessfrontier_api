package com.macgregor.ef.resource;

import com.macgregor.ef.dao.PetSkillDAO;
import com.macgregor.ef.exceptions.PageinationExceptionMapper;
import com.macgregor.ef.model.PetSkill;
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

public class PetSkillResourceTest extends ResourceTest {
    private static final PetSkillDAO petSkillDAO = mock(PetSkillDAO.class);

    @ClassRule
    public static final ResourceTestRule resources =ResourceTestRule.builder()
            .setTestContainerFactory(new GrizzlyWebTestContainerFactory())
            .addResource(new PetSkillResource(petSkillDAO))
            .addProvider(PageinationExceptionMapper.class)
            .build();

    public PetSkillResourceTest(){
        super(resources, PetSkillResource.BASE_URI, "petSkill");
    }

    @After
    public void tearDown() {
        reset(petSkillDAO);
    }

    @Before
    public void setUp(){
        List<PetSkill> petSkills = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            PetSkill p = new PetSkill();
            p.setId(i);
            p.setName(String.format("%s%d", entityName, i));
            petSkills.add(p);
        }

        when(petSkillDAO.getAll()).thenReturn(petSkills);
        when(petSkillDAO.findById(1)).thenReturn(petSkills.get(1));
        when(petSkillDAO.count()).thenReturn(petSkills.size());
        when(petSkillDAO.page(any(), any())).thenReturn(petSkills.subList(0,10));
    }

    @Test
    public void testFindAllUnits() throws Exception {
        List<PetSkill> result = resources.target(baseURI).request().get(new GenericType<List<PetSkill>>() {});

        assertEquals(10, result.size());
        assertEquals(String.format("%s%d", entityName, 0), result.get(0).getName());
    }

    @Test
    public void testFindUnitById() throws Exception {
        PetSkill petSkill = resources.target(baseURI + "/1").request().get(PetSkill.class);
        assertThat(petSkill.getId()).isEqualTo(1);
        assertThat(petSkill.getName()).isEqualTo(String.format("%s%d", entityName, 1));
    }
}
