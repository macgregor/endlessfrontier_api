package com.macgregor.ef.dataload;

import com.macgregor.ef.exceptions.DataLoadException;
import com.macgregor.ef.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by mstratto on 3/2/18.
 */
public class EndlessFrontierDataLoader {
    private static final Logger logger = LoggerFactory.getLogger(EndlessFrontierDataLoader.class);
    private final SessionFactory sessionFactory;
    private final XmlPOJOExtractor extractor = new XmlPOJOExtractor();

    public EndlessFrontierDataLoader(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public <T> void loadData(String uri, String rawXPath, Class<T> type) throws DataLoadException {
        logger.debug(String.format("Initializing %s data", type.getSimpleName()));
        List<T> extracted = extractor.extract(uri, rawXPath, type);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        for(T t : extracted){
            session.save(t);
        }
        tx.commit();
        session.close();
    }

    public void loadAll() throws DataLoadException {
        loadUnits();
        loadUnitSkills();
        loadArtifacts();
        loadArtifactSets();
        loadPets();
        loadPetSkills();
        loadTranslations();
    }

    public void loadUnits() throws DataLoadException {
        loadData("src/main/resources/ef/unitbook.xml", "//unit", Unit.class);
    }

    public void loadUnitSkills() throws DataLoadException {
        loadData("src/main/resources/ef/unitbook.xml", "//unitSkill", UnitSkill.class);
    }

    public void loadArtifacts() throws DataLoadException {
        loadData("src/main/resources/ef/treasurebook.xml", "//treasure", Artifact.class);
    }

    public void loadArtifactSets() throws DataLoadException {
        loadData("src/main/resources/ef/treasurebook.xml", "//treasureSet", ArtifactSet.class);
    }

    public void loadPets() throws DataLoadException {
        loadData("src/main/resources/ef/petbook.xml", "//pet", Pet.class);
    }

    public void loadPetSkills() throws DataLoadException {
        loadData("src/main/resources/ef/petbook.xml", "//petSkill", PetSkill.class);
    }

    public void loadTranslations() throws DataLoadException {
        loadData("src/main/resources/ef/global.1.9.5-book.en.xml", "//text", Translation.class);
    }
}
