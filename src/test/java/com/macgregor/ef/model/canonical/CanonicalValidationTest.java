package com.macgregor.ef.model.canonical;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class CanonicalValidationTest {
    private static final Logger logger = Logger.getLogger(CanonicalValidationTest.class.getName());

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testArtifactSetValidation(){
        ArtifactSet artifactSet = new ArtifactSet();
        Set<ConstraintViolation<ArtifactSet>> constraintViolations =
                validator.validate(artifactSet);
        assertEquals(10, constraintViolations.size());
    }

    @Test
    public void testArtifactValidation(){
        Artifact artifact = new Artifact();
        Set<ConstraintViolation<Artifact>> constraintViolations =
                validator.validate(artifact);
        assertEquals(19, constraintViolations.size());
    }

    @Test
    public void testPetSkillValidation(){
        PetSkill petSkill = new PetSkill();
        Set<ConstraintViolation<PetSkill>> constraintViolations =
                validator.validate(petSkill);
        assertEquals(2, constraintViolations.size());
    }

    @Test
    public void testPetValidation(){
        Pet pet = new Pet();
        Set<ConstraintViolation<Pet>> constraintViolations =
                validator.validate(pet);
        assertEquals(17, constraintViolations.size());
    }

    @Test
    public void testTranslationValidation(){
        Translation translation = new Translation();
        Set<ConstraintViolation<Translation>> constraintViolations =
                validator.validate(translation);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void testTribeValidation(){
        Tribe tribe = new Tribe();
        Set<ConstraintViolation<Tribe>> constraintViolations =
                validator.validate(tribe);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void testUnitSkillValidation(){
        UnitSkill unitSkill = new UnitSkill();
        Set<ConstraintViolation<UnitSkill>> constraintViolations =
                validator.validate(unitSkill);
        assertEquals(5, constraintViolations.size());
    }

    @Test
    public void testUnitValidation(){
        Unit unit = new Unit();
        Set<ConstraintViolation<Unit>> constraintViolations =
                validator.validate(unit);
        assertEquals(67, constraintViolations.size());
    }
}
