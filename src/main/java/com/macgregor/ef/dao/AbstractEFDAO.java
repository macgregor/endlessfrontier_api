package com.macgregor.ef.dao;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class AbstractEFDAO<T> extends AbstractDAO<T> {
    public AbstractEFDAO(SessionFactory factory) {
        super(factory);
    }

    public List<T> getAll() {
        return (List<T>) currentSession().createCriteria(getEntityClass()).list();
    }

    public T findById(int id) {

        T found = (T) currentSession().get(getEntityClass(), id);
        if(found == null){
            throw new EntityNotFoundException(String.format("Could not find entity %s by id %d", getEntityClass().getName(), id));
        }
        return found;
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
        Criteria criteria = currentSession().createCriteria(getEntityClass()).setProjection(Projections.rowCount());
        return ((Long)criteria.uniqueResult()).intValue();
    }

    public List<T> page(Integer page, Integer size){
        Criteria criteria = currentSession().createCriteria(getEntityClass());
        criteria.setFirstResult((page-1)*size);
        criteria.setMaxResults(size);
        return criteria.list();
    }
}
