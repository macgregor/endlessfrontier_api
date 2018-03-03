package com.macgregor.ef.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.logging.Logger;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.junit.Assert.assertEquals;

public class PetTest {
    private static final Logger logger = Logger.getLogger(PetTest.class.getName());
    private static final ObjectMapper XML_MAPPER = new XmlMapper();
    private static final ObjectMapper JSON_MAPPER = Jackson.newObjectMapper();

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void deserializesFromXml() throws Exception {
        Pet fromXml = XML_MAPPER.readValue(fixture("fixtures/pet.xml"), Pet.class);
        assertEquals(TestModels.getPet(), fromXml);
    }

    @Test
    public void deserializesFromJson() throws Exception {
        Pet fromJson = JSON_MAPPER.readValue(fixture("fixtures/pet.json"), Pet.class);
        assertEquals(TestModels.getPet(), fromJson);
    }

    @Test
    public void testValidation(){
        Pet pet = new Pet();
        Set<ConstraintViolation<Pet>> constraintViolations =
                validator.validate(pet);
        assertEquals(17, constraintViolations.size());
    }
}