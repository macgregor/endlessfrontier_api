package com.macgregor.ef.dao;

import com.macgregor.ef.model.Translation;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class TranslationDAO extends AbstractDAO<Translation> {
    public TranslationDAO(SessionFactory factory) {
        super(factory);
    }

    public List<Translation> getAll() {
        return (List<Translation>) currentSession().createCriteria(Translation.class).list();
    }

    public Translation findById(String id) {
        return (Translation) currentSession().get(Translation.class, id);
    }

    public void delete(Translation taranslation) {
        currentSession().delete(taranslation);
    }

    public void update(Translation taranslation) {
        currentSession().saveOrUpdate(taranslation);
    }

    public Translation insert(Translation taranslation) {
        return persist(taranslation);
    }
}
