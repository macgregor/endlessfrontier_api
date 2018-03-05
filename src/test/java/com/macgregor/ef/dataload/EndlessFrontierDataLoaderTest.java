package com.macgregor.ef.dataload;

import ch.qos.logback.classic.Level;
import com.macgregor.ef.exceptions.DataLoadException;
import com.macgregor.ef.model.*;
import com.macgregor.ef.util.MockFieldTranslator;
import com.macgregor.ef.util.TestModels;
import io.dropwizard.logging.BootstrapLogging;
import io.dropwizard.testing.junit.DAOTestRule;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

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
        dataLoader = new EndlessFrontierDataLoader(database.getSessionFactory(), new MockFieldTranslator());
    }

    @Test
    public void testLoadDataExtractsAndPersistsPOJO() throws DataLoadException {
        Unit unit = TestModels.getUnit();
        dataLoader.loadData("src/test/resources/dataloader/units.xml", "//unit", Unit.class, false);
        assertEquals(unit, database.getSessionFactory().openSession().get(Unit.class, unit.getId()));
    }

    @Test
    public void testLoadDataExtractsUnits() throws DataLoadException {
        dataLoader.loadUnits(false);
        assertEquals(218, count(Unit.class));
    }

    @Test
    public void testLoadDataTranslatesUnits() throws DataLoadException {
        dataLoader.loadUnits(true);
        assertEquals(218, count(Unit.class));
        Unit u = find(Unit.class, 1);
        assertEquals("success", u.getName());
    }

    @Test
    public void testLoadDataExtractsUnitSkills() throws DataLoadException {
        dataLoader.loadUnitSkills(false);
        assertEquals(65, count(UnitSkill.class));
    }

    @Test
    public void testLoadDataTranslatesUnitSkills() throws DataLoadException {
        dataLoader.loadUnitSkills(true);
        assertEquals(65, count(UnitSkill.class));
        UnitSkill u = find(UnitSkill.class, 1);
        assertEquals("success", u.getDesc());
    }

    @Test
    public void testLoadDataExtractsArtifacts() throws DataLoadException {
        dataLoader.loadArtifacts(false);
        assertEquals(189, count(Artifact.class));
    }

    @Test
    public void testLoadDataTranslatesArtifacts() throws DataLoadException {
        dataLoader.loadArtifacts(true);
        assertEquals(189, count(Artifact.class));
        Artifact a = find(Artifact.class, 1);
        assertEquals("success", a.getDesc());
    }

    @Test
    public void testLoadDataExtractsArtifactSets() throws DataLoadException {
        dataLoader.loadArtifactSets(false);
        assertEquals(50, count(ArtifactSet.class));
    }

    @Test
    public void testLoadDataTranslatesArtifactSets() throws DataLoadException {
        dataLoader.loadArtifactSets(true);
        assertEquals(50, count(ArtifactSet.class));
        ArtifactSet a = find(ArtifactSet.class, 1);
        assertEquals("success", a.getDesc());
    }

    @Test
    public void testLoadDataExtractsPets() throws DataLoadException {
        dataLoader.loadPets(false);
        assertEquals(157, count(Pet.class));
    }

    @Test
    public void testLoadDataTranslatesPets() throws DataLoadException {
        dataLoader.loadPets(true);
        assertEquals(157, count(Pet.class));
        Pet p = find(Pet.class, 1);
        assertEquals("success", p.getName());
    }

    @Test
    public void testLoadDataExtractsPetSkills() throws DataLoadException {
        dataLoader.loadPetSkills(false);
        assertEquals(456, count(PetSkill.class));
    }

    @Test
    public void testLoadDataTranslatesPetSkills() throws DataLoadException {
        dataLoader.loadPetSkills(true);
        assertEquals(456, count(PetSkill.class));
        PetSkill p = find(PetSkill.class, 1);
        assertEquals("success", p.getDesc());
    }

    @Test
    public void testLoadDataExtractsTranslations() throws DataLoadException {
        dataLoader.loadTranslations(false);
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
