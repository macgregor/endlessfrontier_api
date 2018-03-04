package com.macgregor.ef.util;

import com.macgregor.ef.dao.AbstractEFDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestEntityDAO extends AbstractEFDAO<TestEntity> {
    public TestEntityDAO(SessionFactory factory) {
        super(factory);
    }

    public Session currentSession(){
        return super.currentSession();
    }
}
