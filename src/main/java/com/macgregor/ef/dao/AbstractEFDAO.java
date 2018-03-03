package com.macgregor.ef.dao;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class AbstractEFDAO<T> extends AbstractDAO<T> {
    public AbstractEFDAO(SessionFactory factory) {
        super(factory);
    }

    public List<T> getAll() {
        return (List<T>) currentSession().createCriteria(getEntityClass()).list();
    }

    public T findById(int id) {
        return (T) currentSession().get(getEntityClass(), id);
    }

    public void delete(T t) {
        currentSession().delete(t);
    }

    public void update(T t) {
        currentSession().saveOrUpdate(t);
    }

    public T insert(T t) {
        return persist(t);
    }

    public int count() {
        Query q = currentSession().createQuery(String.format("select count(*) from %s", getEntityClass().getSimpleName()));
        return ((Long)q.uniqueResult()).intValue();
    }

    public List<T> find(Integer page, Integer size){
        Query query = currentSession().createQuery(String.format("From %s", getEntityClass().getSimpleName()));
        query.setFirstResult((page-1)*size);
        query.setMaxResults(size);
        return query.list();
    }
}
