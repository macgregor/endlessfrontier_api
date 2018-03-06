package com.macgregor.ef.dao;

import com.macgregor.ef.model.canonical.Unit;
import org.hibernate.SessionFactory;

public class UnitDAO extends AbstractEFDAO<Unit>  {
    public UnitDAO(SessionFactory factory) {
        super(factory);
    }
}
