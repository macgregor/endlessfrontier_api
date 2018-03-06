package com.macgregor.ef.model.canonical;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.macgregor.ef.util.TestModels;
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

public class TribeTest {
    private static final Logger logger = Logger.getLogger(TribeTest.class.getName());
    private static final ObjectMapper JSON_MAPPER = Jackson.newObjectMapper();

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void deserializesFromJson() throws Exception {
        Tribe fromJson = JSON_MAPPER.readValue(fixture("fixtures/tribe.json"), Tribe.class);
        assertEquals(TestModels.getTribe(), fromJson);
    }

    @Test
    public void testValidation(){
        Tribe tribe = new Tribe();
        Set<ConstraintViolation<Tribe>> constraintViolations =
                validator.validate(tribe);
        assertEquals(1, constraintViolations.size());
    }
}
