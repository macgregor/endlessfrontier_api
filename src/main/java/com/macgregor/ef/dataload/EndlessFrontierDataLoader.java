package com.macgregor.ef.dataload;

import com.macgregor.ef.exceptions.DataLoadException;
import com.macgregor.ef.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EndlessFrontierDataLoader {
    private static final Logger logger = LoggerFactory.getLogger(EndlessFrontierDataLoader.class);
    private final SessionFactory sessionFactory;
    private final FieldTranslator fieldTranslator;
    private final XmlPOJOExtractor extractor = new XmlPOJOExtractor();

    public EndlessFrontierDataLoader(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        this.fieldTranslator = new FieldTranslator(sessionFactory);
    }

    public EndlessFrontierDataLoader(SessionFactory sessionFactory, FieldTranslator fieldTranslator){
        this.sessionFactory = sessionFactory;
        this.fieldTranslator = fieldTranslator;
    }

    public <T> void loadData(String uri, String rawXPath, Class<T> type, boolean translate) throws DataLoadException {
        logger.info(String.format("[%s Data Load] - Initializing data from %s using XPath %s", type.getSimpleName(), uri, rawXPath));

        List<T> extracted = extractor.extract(uri, rawXPath, type);

        logger.info(String.format("[%s Data Load] - Loaded %d entities", type.getSimpleName(), extracted.size()));

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        for(T t : extracted){
            if(translate){
                t = (T)fieldTranslator.translate(t);
            }
            session.save(t);
        }
        tx.commit();
        session.close();

        logger.info(String.format("[%s Data Load] - Complete", type.getSimpleName()));
    }

    public void loadAll() throws DataLoadException {
        logger.info("==============================================");
        logger.info("=              Data Load Beginning           =");
        logger.info("==============================================");
        loadTranslations(false);
        loadUnitSkills(true);
        loadPetSkills(true);
        loadPets(true);
        loadUnits(true);
        loadArtifacts(true);
        loadArtifactSets(true);
        logger.info("==============================================");
        logger.info("=             Data Load Complete             =");
        logger.info("==============================================");
    }

    public void loadUnits(boolean translate) throws DataLoadException {
        loadData("src/main/resources/ef/unitbook.xml", "//unit", Unit.class, translate);
    }

    public void loadUnitSkills(boolean translate) throws DataLoadException {
        loadData("src/main/resources/ef/unitbook.xml", "//unitSkill", UnitSkill.class, translate);
    }

    public void loadArtifacts(boolean translate) throws DataLoadException {
        loadData("src/main/resources/ef/treasurebook.xml", "//treasure", Artifact.class, translate);
    }

    public void loadArtifactSets(boolean translate) throws DataLoadException {
        loadData("src/main/resources/ef/treasurebook.xml", "//treasureSet", ArtifactSet.class, translate);
    }

    public void loadPets(boolean translate) throws DataLoadException {
        loadData("src/main/resources/ef/petbook.xml", "//pet", Pet.class, translate);
    }

    public void loadPetSkills(boolean translate) throws DataLoadException {
        loadData("src/main/resources/ef/petbook.xml", "//petSkill", PetSkill.class, translate);
    }

    public void loadTranslations(boolean translate) throws DataLoadException {
        loadData("src/main/resources/ef/global.1.9.5-book.en.xml", "//text", Translation.class, translate);
    }
}
