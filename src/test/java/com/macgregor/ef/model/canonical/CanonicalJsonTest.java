package com.macgregor.ef.model.canonical;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.macgregor.ef.util.CanonicalTestModels;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import java.util.logging.Logger;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.junit.Assert.assertEquals;

public class CanonicalJsonTest {
    private static final Logger logger = Logger.getLogger(ArtifactSet.class.getName());
    private static final ObjectMapper JSON_MAPPER = Jackson.newObjectMapper();

    @Test
    public void testArtifactSetDeserializesFromJson() throws Exception {
        ArtifactSet fromJson = JSON_MAPPER.readValue(fixture("fixtures/artifact_set.json"), ArtifactSet.class);
        assertEquals(CanonicalTestModels.getArtifactSet(), fromJson);
    }

    @Test
    public void testArtifactDeserializesFromJson() throws Exception {
        Artifact fromJson = JSON_MAPPER.readValue(fixture("fixtures/artifact.json"), Artifact.class);
        assertEquals(CanonicalTestModels.getArtifact(), fromJson);
    }

    @Test
    public void testPetSkillDeserializesFromJson() throws Exception {
        PetSkill fromJson = JSON_MAPPER.readValue(fixture("fixtures/pet_skill.json"), PetSkill.class);
        assertEquals(CanonicalTestModels.getPetSkill(), fromJson);
    }

    @Test
    public void testPetDeserializesFromJson() throws Exception {
        Pet fromJson = JSON_MAPPER.readValue(fixture("fixtures/pet.json"), Pet.class);
        assertEquals(CanonicalTestModels.getPet(), fromJson);
    }

    @Test
    public void testTranslationDeserializesFromJson() throws Exception {
        Translation fromJson = JSON_MAPPER.readValue(fixture("fixtures/translation.json"), Translation.class);
        assertEquals(CanonicalTestModels.getTranslation(), fromJson);
    }

    @Test
    public void testTribeDeserializesFromJson() throws Exception {
        Tribe fromJson = JSON_MAPPER.readValue(fixture("fixtures/tribe.json"), Tribe.class);
        assertEquals(CanonicalTestModels.getTribe(), fromJson);
    }

    @Test
    public void testUnitSkillDeserializesFromJson() throws Exception {
        UnitSkill fromJson = JSON_MAPPER.readValue(fixture("fixtures/unit_skill.json"), UnitSkill.class);
        assertEquals(CanonicalTestModels.getUnitSkill(), fromJson);
    }

    @Test
    public void testUnitDeserializesFromJson() throws Exception {
        Unit fromJson = JSON_MAPPER.readValue(fixture("fixtures/unit.json"), Unit.class);
        assertEquals(CanonicalTestModels.getUnit(), fromJson);
    }
}
