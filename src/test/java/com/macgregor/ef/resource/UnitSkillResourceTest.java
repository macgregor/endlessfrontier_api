package com.macgregor.ef.resource;

import com.macgregor.ef.dao.UnitSkillDAO;
import com.macgregor.ef.model.UnitSkill;
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

public class UnitSkillResourceTest {
    private static final UnitSkillDAO unitSkillDAO = mock(UnitSkillDAO.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new UnitSkillResource(unitSkillDAO))
            .build();

    @After
    public void tearDown() {
        reset(unitSkillDAO);
    }

    @Test
    public void testFindAllUnitSkills() throws Exception {
        List<UnitSkill> unitSkills = new ArrayList<>();
        UnitSkill u1 = new UnitSkill();
        u1.setId(1);
        u1.setDesc("unitskill1");
        unitSkills.add(u1);

        UnitSkill u2 = new UnitSkill();
        u2.setId(2);
        u2.setDesc("unitskill2");
        unitSkills.add(u2);

        when(unitSkillDAO.getAll()).thenReturn(unitSkills);

        List<UnitSkill> result = resources.target("/unit/skill").request().get(new GenericType<List<UnitSkill>>() {});

        assertEquals(2, result.size());
        assertEquals("unitskill1", result.get(0).getDesc());
    }

    @Test
    public void testFindUnitSkillById() throws Exception {
        UnitSkill u1 = new UnitSkill();
        u1.setId(1);
        u1.setDesc("unitskill1");
        when(unitSkillDAO.findById(1)).thenReturn(u1);

        UnitSkill unit = resources.target("/unit/skill/1").request().get(UnitSkill.class);
        assertThat(unit.getId()).isEqualTo(1);
        assertThat(unit.getDesc()).isEqualTo("unitskill1");
    }
}
