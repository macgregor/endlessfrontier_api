package com.macgregor.ef.resource;

import com.macgregor.ef.dao.PersonDAO;
import com.macgregor.ef.model.Person;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonResourceTest {

    private static final PersonDAO personDAO = mock(PersonDAO.class);

    static {
        Logger.getLogger("com.sun.jersey").setLevel(Level.OFF);
    }

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new PersonResource(personDAO))
            .build();

    private Person person;

    @Before
    public void setUp() {
        person = new Person()
                .setId(10)
                .setName("person10");
    }

    @After
    public void tearDown() {
        reset(personDAO);
    }

    @Test
    public void getAll() throws Exception {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person().setId(1).setName("person1"));
        persons.add(new Person().setId(2).setName("person2"));
        when(personDAO.getAll()).thenReturn(persons);

        List<Person> result = resources.target("/person").request().get(new GenericType<List<Person>>() {});

        assertEquals(2, result.size());
        assertEquals("person1", result.get(0).getName());
    }

    @Test
    public void get() throws Exception {
        when(personDAO.findById(1)).thenReturn(
                new Person()
                        .setId(1)
                        .setName("person1")
        );

        Person person = resources.target("/person/1").request().get(Person.class);
        assertThat(person.getId()).isEqualTo(1);
        assertThat(person.getName()).isEqualTo("person1");
    }

    @Test
    public void update() throws Exception {
        final Response response = resources.client()
                .target("/person/10")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(person, MediaType.APPLICATION_JSON_TYPE));

        assertThat(response.getStatusInfo()).isEqualTo(Response.Status.OK);
    }

    @Test
    public void update_invalid_person() throws Exception {
        person.setName(null);

        final Response response = resources.client()
                .target("/person/10")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(person, MediaType.APPLICATION_JSON_TYPE));
        assertThat(response.getStatusInfo().getStatusCode()).isEqualTo(422);
    }

    @Test
    public void add() throws Exception {
        when(personDAO.insert(any(Person.class))).thenReturn(person);

        final Response response = resources.client()
                .target("/person")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(person, MediaType.APPLICATION_JSON_TYPE));

        assertThat(response.getStatusInfo()).isEqualTo(Response.Status.OK);
    }

    @Test
    public void add_invalid_person() throws Exception {
        person.setName(null);

        final Response response = resources.client()
                .target("/person")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(person, MediaType.APPLICATION_JSON_TYPE));
        assertThat(response.getStatusInfo().getStatusCode()).isEqualTo(422);
    }

    @Test
    public void delete() throws Exception {
        final Response response = resources.client()
                .target("/person/1")
                .request(MediaType.APPLICATION_JSON)
                .delete();

        assertThat(response.getStatusInfo()).isEqualTo(Response.Status.NO_CONTENT);
    }
}

