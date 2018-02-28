package com.macgregor.ef.dao;

import com.macgregor.ef.model.UnitSkill;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class UnitSkillDAO extends AbstractDAO<UnitSkill> {
    public UnitSkillDAO(SessionFactory factory) {
        super(factory);
    }

    public List<UnitSkill> getAll() {
        return (List<UnitSkill>) currentSession().createCriteria(UnitSkill.class).list();
    }

    public UnitSkill findById(int id) {
        return (UnitSkill) currentSession().get(UnitSkill.class, id);
    }

    public void delete(UnitSkill unitSkill) {
        currentSession().delete(unitSkill);
    }

    public void update(UnitSkill unitSkill) {
        currentSession().saveOrUpdate(unitSkill);
    }

    public UnitSkill insert(UnitSkill unitSkill) {
        return persist(unitSkill);
    }
}