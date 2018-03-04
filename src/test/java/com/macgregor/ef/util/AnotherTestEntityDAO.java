package com.macgregor.ef.util;

import com.macgregor.ef.dao.AbstractEFDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AnotherTestEntityDAO extends AbstractEFDAO<AnotherTestEntity> {
    public AnotherTestEntityDAO(SessionFactory factory) {
        super(factory);
    }

    public Session currentSession(){
        return super.currentSession();
    }
}
