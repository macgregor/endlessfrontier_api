package com.macgregor.ef.model.canonical;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.macgregor.ef.util.CanonicalTestModels;
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

public class TranslationTest {
    private static final Logger logger = Logger.getLogger(TranslationTest.class.getName());
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
        Translation fromXml = XML_MAPPER.readValue(fixture("fixtures/translation.xml"), Translation.class);
        logger.info(JSON_MAPPER.writeValueAsString(fromXml));
        assertEquals(CanonicalTestModels.getTranslation(), fromXml);
    }

    @Test
    public void deserializesFromJson() throws Exception {
        Translation fromJson = JSON_MAPPER.readValue(fixture("fixtures/translation.json"), Translation.class);
        assertEquals(CanonicalTestModels.getTranslation(), fromJson);
    }

    @Test
    public void testValidation(){
        Translation translation = new Translation();
        Set<ConstraintViolation<Translation>> constraintViolations =
                validator.validate(translation);
        assertEquals(1, constraintViolations.size());
    }
}
