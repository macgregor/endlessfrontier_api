package com.macgregor.ef.resource;

import com.macgregor.ef.dao.UnitSkillDAO;
import com.macgregor.ef.exceptions.PageinationExceptionMapper;
import com.macgregor.ef.model.canonical.UnitSkill;
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

public class UnitSkillResourceTest extends ResourceTest {
    private static final UnitSkillDAO unitSkillDAO = mock(UnitSkillDAO.class);

    @ClassRule
    public static final ResourceTestRule resources =ResourceTestRule.builder()
            .setTestContainerFactory(new GrizzlyWebTestContainerFactory())
            .addResource(new UnitSkillResource(unitSkillDAO))
            .addProvider(PageinationExceptionMapper.class)
            .build();

    public UnitSkillResourceTest(){
        super(resources, UnitSkillResource.BASE_URI, "unitSkill");
    }

    @After
    public void tearDown() {
        reset(unitSkillDAO);
    }

    @Before
    public void setUp(){
        List<UnitSkill> unitSkills = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            UnitSkill u = new UnitSkill();
            u.setId(i);
            u.setDesc(String.format("%s%d", entityName, i));
            unitSkills.add(u);
        }

        when(unitSkillDAO.getAll()).thenReturn(unitSkills);
        when(unitSkillDAO.findById(1)).thenReturn(unitSkills.get(1));
        when(unitSkillDAO.count()).thenReturn(unitSkills.size());
        when(unitSkillDAO.page(any(), any())).thenReturn(unitSkills.subList(0,10));
    }

    @Test
    public void testFindAllUnits() throws Exception {
        List<UnitSkill> result = resources.target(baseURI).request().get(new GenericType<List<UnitSkill>>() {});

        assertEquals(10, result.size());
        assertEquals(String.format("%s%d", entityName, 0), result.get(0).getDesc());
    }

    @Test
    public void testFindUnitById() throws Exception {
        UnitSkill unit = resources.target(baseURI + "/1").request().get(UnitSkill.class);
        assertThat(unit.getId()).isEqualTo(1);
        assertThat(unit.getDesc()).isEqualTo(String.format("%s%d", entityName, 1));
    }
}
