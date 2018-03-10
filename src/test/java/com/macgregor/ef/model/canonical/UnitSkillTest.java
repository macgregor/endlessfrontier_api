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

public class UnitSkillTest {
    private static final Logger logger = Logger.getLogger(UnitSkillTest.class.getName());
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
        UnitSkill fromXml = XML_MAPPER.readValue(fixture("fixtures/unit_skill.xml"), UnitSkill.class);
        logger.info(JSON_MAPPER.writeValueAsString(fromXml));
        assertEquals(CanonicalTestModels.getUnitSkill(), fromXml);
    }

    @Test
    public void deserializesFromJson() throws Exception {
        UnitSkill fromJson = JSON_MAPPER.readValue(fixture("fixtures/unit_skill.json"), UnitSkill.class);
        assertEquals(CanonicalTestModels.getUnitSkill(), fromJson);
    }

    @Test
    public void testValidation(){
        UnitSkill unitSkill = new UnitSkill();
        Set<ConstraintViolation<UnitSkill>> constraintViolations =
                validator.validate(unitSkill);
        assertEquals(5, constraintViolations.size());
    }
}
