package com.macgregor.ef.dao;

import com.macgregor.ef.model.Tribe;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class TribeDAO extends AbstractDAO<Tribe>  {
    public TribeDAO(SessionFactory factory) {
        super(factory);
    }

    public List<Tribe> getAll() {
        return (List<Tribe>) currentSession().createCriteria(Tribe.class).list();
    }

    public Tribe findById(int id) {
        return (Tribe) currentSession().get(Tribe.class, id);
    }

    public void delete(Tribe tribe) {
        currentSession().delete(tribe);
    }

    public void update(Tribe tribe) {
        currentSession().saveOrUpdate(tribe);
    }

    public Tribe insert(Tribe tribe) {
        return persist(tribe);
    }
}
