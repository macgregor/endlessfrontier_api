package com.macgregor.ef.resource;

import com.macgregor.ef.dao.PetDAO;
import com.macgregor.ef.exceptions.PageinationExceptionMapper;
import com.macgregor.ef.model.canonical.Pet;
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

public class PetResourceTest extends ResourceTest {
    private static final PetDAO petDAO = mock(PetDAO.class);

    @ClassRule
    public static final ResourceTestRule resources =ResourceTestRule.builder()
            .setTestContainerFactory(new GrizzlyWebTestContainerFactory())
            .addResource(new PetResource(petDAO))
            .addProvider(PageinationExceptionMapper.class)
            .build();

    public PetResourceTest(){
        super(resources, PetResource.BASE_URI, "pet");
    }

    @After
    public void tearDown() {
        reset(petDAO);
    }

    @Before
    public void setUp(){
        List<Pet> pets = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            Pet p = new Pet();
            p.setId(i);
            p.setName(String.format("%s%d", entityName, i));
            pets.add(p);
        }

        when(petDAO.getAll()).thenReturn(pets);
        when(petDAO.findById(1)).thenReturn(pets.get(1));
        when(petDAO.count()).thenReturn(pets.size());
        when(petDAO.page(any(), any())).thenReturn(pets.subList(0,10));
    }

    @Test
    public void testFindAllUnits() throws Exception {
        List<Pet> result = resources.target(baseURI).request().get(new GenericType<List<Pet>>() {});

        assertEquals(10, result.size());
        assertEquals(String.format("%s%d", entityName, 0), result.get(0).getName());
    }

    @Test
    public void testFindUnitById() throws Exception {
        Pet pet = resources.target(baseURI + "/1").request().get(Pet.class);
        assertThat(pet.getId()).isEqualTo(1);
        assertThat(pet.getName()).isEqualTo(String.format("%s%d", entityName, 1));
    }
}
