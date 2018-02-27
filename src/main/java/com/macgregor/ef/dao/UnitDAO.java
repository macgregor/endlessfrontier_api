package com.macgregor.ef.dao;

import com.macgregor.ef.model.Unit;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class UnitDAO extends AbstractDAO<Unit>  {
    public UnitDAO(SessionFactory factory) {
        super(factory);
    }

    public List<Unit> getAll() {
        return (List<Unit>) currentSession().createCriteria(Unit.class).list();
    }

    public Unit findById(int id) {
        return (Unit) currentSession().get(Unit.class, id);
    }

    public void delete(Unit unit) {
        currentSession().delete(unit);
    }

    public void update(Unit unit) {
        currentSession().saveOrUpdate(unit);
    }

    public Unit insert(Unit unit) {
        return persist(unit);
    }
}
