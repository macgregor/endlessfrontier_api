package com.macgregor.ef.dao;

import ch.qos.logback.classic.Level;
import com.macgregor.ef.dataload.XmlPOJOExtractor;
import com.macgregor.ef.util.AnotherTestEntity;
import com.macgregor.ef.util.AnotherTestEntityDAO;
import com.macgregor.ef.util.TestEntity;
import com.macgregor.ef.util.TestEntityDAO;
import io.dropwizard.logging.BootstrapLogging;
import io.dropwizard.testing.junit.DAOTestRule;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Note: the "anotherTestEntity" stuff was me trying to test a suspected session pollution
 * problem I was seeing in the application where a call to UnitDAO.count() was running a
 * count against all entities in the database. I was unable to reproduce here and believe
 * I was simply trying to get too clever with generics in AbstractResource. I've dumbed
 * down that code and now it seems fine. Leaving this here for posterity.
 */
public class AbstractEFDAOTest {
    private static final Logger logger = LoggerFactory.getLogger(XmlPOJOExtractor.class);
    static {
        BootstrapLogging.bootstrap(Level.ERROR);
    }

    @Rule
    public DAOTestRule database = DAOTestRule.newBuilder()
            .addEntityClass(TestEntity.class)
            .addEntityClass(AnotherTestEntity.class)
            .build();

    private TestEntityDAO testDAO;
    private AnotherTestEntityDAO anotherTestDAO;
    private List<TestEntity> testEntities;
    private List<AnotherTestEntity> anotherTestEntities;

    @Before
    public void setUp() {
        testDAO = new TestEntityDAO(database.getSessionFactory());
        anotherTestDAO = new AnotherTestEntityDAO(database.getSessionFactory());
        testEntities = new ArrayList<>();
        anotherTestEntities = new ArrayList<>();

        database.inTransaction(() -> {
            Session session = testDAO.currentSession();
            for(int i = 1; i < 10; i++){
                TestEntity t = new TestEntity();
                t.id = i;
                t.name = String.format("testentity%d", i);
                testEntities.add(t);
                session.save(t);
            }
        });

        database.inTransaction(() -> {
            Session session = anotherTestDAO.currentSession();
            for(int i = 1; i < 10; i++){
                AnotherTestEntity t = new AnotherTestEntity();
                t.id = i;
                t.name = String.format("testentity%d", i);
                anotherTestEntities.add(t);
                session.save(t);
            }
        });
    }

    @Test
    public void testGetAllReturnsAllTestEntities(){
        List<TestEntity> found = testDAO.getAll();
        assertEquals(testEntities, found);
    }

    @Test
    public void testFindByIdReturnsCorrectTestEntities(){
        TestEntity found = testDAO.findById(1);
        assertEquals(testEntities.get(0), found);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testFindByIdThrowsEntityNotFoundException(){
        TestEntity found = testDAO.findById(-1);
    }

    @Test
    public void testDeleteRemovesGivenEntity(){
        TestEntity removed = testEntities.get(0);
        testDAO.delete(removed);

        TestEntity found = database.inTransaction(() -> {
            Session session = testDAO.currentSession();
            return session.get(TestEntity.class, removed.id);
        });

        assertNull(found);
    }

    @Test
    public void testUpdateSavesGivenExistingEntity(){
        TestEntity updated = testEntities.get(0);
        updated.name = "updatedName";
        testDAO.update(updated);

        TestEntity found = database.inTransaction(() -> {
            Session session = testDAO.currentSession();
            return session.get(TestEntity.class, updated.id);
        });

        assertEquals(found, updated);
    }

    @Test
    public void testUpdateSavesGivenNewEntity(){
        TestEntity newEntity = new TestEntity();
        newEntity.id = 100;
        newEntity.name = "newEntity";
        testDAO.update(newEntity);

        TestEntity found = database.inTransaction(() -> {
            Session session = testDAO.currentSession();
            return session.get(TestEntity.class, newEntity.id);
        });

        assertEquals(found, newEntity);
    }

    @Test
    public void testInsertSavesGivenEntity(){
        TestEntity newEntity = new TestEntity();
        newEntity.id = 100;
        newEntity.name = "newEntity";
        testDAO.insert(newEntity);

        TestEntity found = database.inTransaction(() -> {
            Session session = testDAO.currentSession();
            return session.get(TestEntity.class, newEntity.id);
        });

        assertEquals(found, newEntity);
    }

    @Test
    public void testCountReturnsCorrectCountOfAllEntities(){
        assertEquals(testEntities.size(), testDAO.count());
    }

    @Test
    public void testPageReturnsCorrectRangeOfEntitiesLowerBoundPage(){
        List<TestEntity> found = testDAO.page(1, 2);
        List<TestEntity> expected = testEntities.subList(0, 2);
        assertEquals(expected, found);
        assertEquals(2, found.size());
    }

    @Test
    public void testPageReturnsCorrectRangeOfEntitiesUpperBoundPage(){
        List<TestEntity> found = testDAO.page(5, 2);
        List<TestEntity> expected = testEntities.subList(8, 9);
        assertEquals(expected, found);
        assertEquals(1, found.size());
    }

    @Test
    public void testPageReturnsCorrectRangeOfEntitiesNonsensePage(){
        List<TestEntity> found = testDAO.page(-1, 2);
        List<TestEntity> expected = testEntities.subList(0, 2);
        assertEquals(expected, found);
        assertEquals(2, found.size());
    }

    @Test
    public void testPageReturnsCorrectRangeOfEntitiesUpperBoundSize(){
        List<TestEntity> found = testDAO.page(1, 100);
        assertEquals(testEntities, found);
        assertEquals(testEntities.size(), found.size());
    }

    @Test
    public void testPageReturnsCorrectRangeOfEntitiesLowerBoundSize(){
        List<TestEntity> found = testDAO.page(1, 1);
        List<TestEntity> expected = testEntities.subList(0, 1);
        assertEquals(expected, found);
        assertEquals(1, found.size());
    }

    @Test
    public void testPageReturnsCorrectRangeOfEntitiesNonsenseSize(){
        List<TestEntity> found = testDAO.page(1, -1);
        assertEquals(testEntities, found);
        assertEquals(testEntities.size(), found.size());
    }
}
