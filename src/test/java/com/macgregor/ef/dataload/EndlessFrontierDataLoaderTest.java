package com.macgregor.ef.dataload;

import ch.qos.logback.classic.Level;
import com.macgregor.ef.dataload.converters.*;
import com.macgregor.ef.exceptions.DataLoadException;
import com.macgregor.ef.model.canonical.*;
import com.macgregor.ef.util.MockTranslationFieldConverter;
import io.dropwizard.logging.BootstrapLogging;
import io.dropwizard.testing.junit.DAOTestRule;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EndlessFrontierDataLoaderTest {
    static {
        BootstrapLogging.bootstrap(Level.ERROR);
    }

    @Rule
    public DAOTestRule database = DAOTestRule.newBuilder()
            .addEntityClass(Unit.class)
            .addEntityClass(UnitSkill.class)
            .addEntityClass(Artifact.class)
            .addEntityClass(ArtifactSet.class)
            .addEntityClass(Pet.class)
            .addEntityClass(PetSkill.class)
            .addEntityClass(Translation.class)
            .build();

    private EndlessFrontierDataLoader dataLoader;

    @Before
    public void setUp() {
        List<AbstractFieldConverter> converters = new ArrayList<>();

        BoolFieldConverter boolConverter = new BoolFieldConverter();
        converters.add(boolConverter);

        ListFieldConverter listConverter = new ListFieldConverter();
        converters.add(listConverter);

        TranslationFieldConverter translationFieldConverter = new MockTranslationFieldConverter();
        converters.add(translationFieldConverter);

        dataLoader = new EndlessFrontierDataLoader(database.getSessionFactory(), new CanonicalModelConverter(converters));
    }

    @Test
    public void testLoadDataExtractsUnits() throws DataLoadException {
        dataLoader.loadUnits();
        assertEquals(218, count(Unit.class));
    }

    @Test
    public void testLoadDataTranslatesUnits() throws DataLoadException {
        dataLoader.loadUnits();
        assertEquals(218, count(Unit.class));
        Unit u = find(Unit.class, 1);
        assertEquals("success", u.getName());
    }

    @Test
    public void testLoadDataExtractsUnitSkills() throws DataLoadException {
        dataLoader.loadUnitSkills();
        assertEquals(65, count(UnitSkill.class));
    }

    @Test
    public void testLoadDataTranslatesUnitSkills() throws DataLoadException {
        dataLoader.loadUnitSkills();
        assertEquals(65, count(UnitSkill.class));
        UnitSkill u = find(UnitSkill.class, 1);
        assertEquals("success", u.getDesc());
    }

    @Test
    public void testLoadDataExtractsArtifacts() throws DataLoadException {
        dataLoader.loadArtifacts();
        assertEquals(189, count(Artifact.class));
    }

    @Test
    public void testLoadDataTranslatesArtifacts() throws DataLoadException {
        dataLoader.loadArtifacts();
        assertEquals(189, count(Artifact.class));
        Artifact a = find(Artifact.class, 1);
        assertEquals("success", a.getDesc());
    }

    @Test
    public void testLoadDataExtractsArtifactSets() throws DataLoadException {
        dataLoader.loadArtifactSets();
        assertEquals(50, count(ArtifactSet.class));
    }

    @Test
    public void testLoadDataTranslatesArtifactSets() throws DataLoadException {
        dataLoader.loadArtifactSets();
        assertEquals(50, count(ArtifactSet.class));
        ArtifactSet a = find(ArtifactSet.class, 1);
        assertEquals("success", a.getDesc());
    }

    @Test
    public void testLoadDataExtractsPets() throws DataLoadException {
        dataLoader.loadPets();
        assertEquals(157, count(Pet.class));
    }

    @Test
    public void testLoadDataTranslatesPets() throws DataLoadException {
        dataLoader.loadPets();
        assertEquals(157, count(Pet.class));
        Pet p = find(Pet.class, 1);
        assertEquals("success", p.getName());
    }

    @Test
    public void testLoadDataExtractsPetSkills() throws DataLoadException {
        dataLoader.loadPetSkills();
        assertEquals(456, count(PetSkill.class));
    }

    @Test
    public void testLoadDataTranslatesPetSkills() throws DataLoadException {
        dataLoader.loadPetSkills();
        assertEquals(456, count(PetSkill.class));
        PetSkill p = find(PetSkill.class, 1);
        assertEquals("success", p.getDesc());
    }

    @Test
    public void testLoadDataExtractsTranslations() throws DataLoadException {
        dataLoader.loadTranslations();
        assertEquals(2044, count(Translation.class));
    }

    private <T> int count(Class<T> type){
        Session session = database.getSessionFactory().getCurrentSession();
        Query q = session.createQuery(String.format("select count(*) from %s", type.getSimpleName()));
        return ((Long)q.uniqueResult()).intValue();
    }

    private <T> T find(Class<T> type, Integer id){
        Session session = database.getSessionFactory().getCurrentSession();
        T t = session.get(type, id);
        return t;
    }
}
