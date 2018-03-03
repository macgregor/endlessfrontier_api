package com.macgregor.ef.dao;

import com.macgregor.ef.model.Translation;
import org.hibernate.SessionFactory;

public class TranslationDAO extends AbstractEFDAO<Translation> {
    public TranslationDAO(SessionFactory factory) {
        super(factory);
    }

    public Translation findById(String id) {
        return (Translation) currentSession().get(getEntityClass(), id);
    }
}
