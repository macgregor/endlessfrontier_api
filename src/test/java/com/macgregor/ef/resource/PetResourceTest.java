package com.macgregor.ef.resource;

import com.macgregor.ef.dao.PetDAO;
import com.macgregor.ef.model.Pet;
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

public class PetResourceTest {
    private static final PetDAO petDAO = mock(PetDAO.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new PetResource(petDAO))
            .build();

    @After
    public void tearDown() {
        reset(petDAO);
    }

    @Test
    public void testFindAllPets() throws Exception {
        List<Pet> pets = new ArrayList<>();
        Pet t1 = new Pet();
        t1.setId(1);
        t1.setName("pet1");
        pets.add(t1);

        Pet t2 = new Pet();
        t2.setId(2);
        t2.setName("pet2");
        pets.add(t2);

        when(petDAO.getAll()).thenReturn(pets);

        List<Pet> result = resources.target("/pet").request().get(new GenericType<List<Pet>>() {});

        assertEquals(2, result.size());
        assertEquals("pet1", result.get(0).getName());
    }

    @Test
    public void testFindPetById() throws Exception {
        Pet t1 = new Pet();
        t1.setId(1);
        t1.setName("pet1");
        when(petDAO.findById(1)).thenReturn(t1);

        Pet unit = resources.target("/pet/1").request().get(Pet.class);
        assertThat(unit.getId()).isEqualTo(1);
        assertThat(unit.getName()).isEqualTo("pet1");
    }
}
