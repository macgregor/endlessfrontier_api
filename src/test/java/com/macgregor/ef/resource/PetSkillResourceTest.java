package com.macgregor.ef.resource;

import com.macgregor.ef.dao.PetSkillDAO;
import com.macgregor.ef.model.PetSkill;
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

public class PetSkillResourceTest {
    private static final PetSkillDAO petSkillDAO = mock(PetSkillDAO.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new PetSkillResource(petSkillDAO))
            .build();

    @After
    public void tearDown() {
        reset(petSkillDAO);
    }

    @Test
    public void testFindAllPetSkills() throws Exception {
        List<PetSkill> petSkills = new ArrayList<>();
        PetSkill p1 = new PetSkill();
        p1.setId(1);
        p1.setName("petskill1");
        petSkills.add(p1);

        PetSkill p2 = new PetSkill();
        p2.setId(2);
        p2.setName("petskill2");
        petSkills.add(p2);

        when(petSkillDAO.getAll()).thenReturn(petSkills);

        List<PetSkill> result = resources.target("/pet/skill").request().get(new GenericType<List<PetSkill>>() {});

        assertEquals(2, result.size());
        assertEquals("petskill1", result.get(0).getName());
    }

    @Test
    public void testFindPetSkillById() throws Exception {
        PetSkill p1 = new PetSkill();
        p1.setId(1);
        p1.setName("petskill1");
        when(petSkillDAO.findById(1)).thenReturn(p1);

        PetSkill unit = resources.target("/pet/skill/1").request().get(PetSkill.class);
        assertThat(unit.getId()).isEqualTo(1);
        assertThat(unit.getName()).isEqualTo("petskill1");
    }
}
