package com.macgregor.ef.dataload;

import ch.qos.logback.classic.Level;
import com.macgregor.ef.exceptions.DataLoadException;
import com.macgregor.ef.model.*;
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
            .build();

    private EndlessFrontierDataLoader dataLoader;

    @Before
    public void setUp() {
        dataLoader = new EndlessFrontierDataLoader(database.getSessionFactory());
    }

    @Test
    public void testLoadDataExtractsAndPersistsPOJO() throws DataLoadException {
        Unit unit = TestModels.getUnit();
        dataLoader.loadData("src/test/resources/dataloader/units.xml", "//unit", Unit.class);
        assertEquals(unit, database.getSessionFactory().openSession().get(Unit.class, unit.getId()));
    }

    @Test
    public void testLoadDataExtractsUnits() throws DataLoadException {
        dataLoader.loadUnits();
        assertEquals(218, count(Unit.class));
    }

    @Test
    public void testLoadDataExtractsUnitSkills() throws DataLoadException {
        dataLoader.loadUnitSkills();
        assertEquals(65, count(UnitSkill.class));
    }

    @Test
    public void testLoadDataExtractsArtifacts() throws DataLoadException {
        dataLoader.loadArtifacts();
        assertEquals(189, count(Artifact.class));
    }

    @Test
    public void testLoadDataExtractsArtifactSets() throws DataLoadException {
        dataLoader.loadArtifactSets();
        assertEquals(50, count(ArtifactSet.class));
    }

    @Test
    public void testLoadDataExtractsPets() throws DataLoadException {
        dataLoader.loadPets();
        assertEquals(157, count(Pet.class));
    }

    @Test
    public void testLoadDataExtractsPetSkills() throws DataLoadException {
        dataLoader.loadPetSkills();
        assertEquals(456, count(PetSkill.class));
    }

    private <T> int count(Class<T> type){
        Session session = database.getSessionFactory().openSession();
        Query q = session.createQuery(String.format("select count(*) from %s", type.getSimpleName()));
        return ((Long)q.uniqueResult()).intValue();
    }
}
