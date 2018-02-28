package com.macgregor.ef.dao;

import com.macgregor.ef.model.PetSkill;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class PetSkillDAO extends AbstractDAO<PetSkill> {
    public PetSkillDAO(SessionFactory factory) {
        super(factory);
    }

    public List<PetSkill> getAll() {
        return (List<PetSkill>) currentSession().createCriteria(PetSkill.class).list();
    }

    public PetSkill findById(int id) {
        return (PetSkill) currentSession().get(PetSkill.class, id);
    }

    public void delete(PetSkill petSkill) {
        currentSession().delete(petSkill);
    }

    public void update(PetSkill petSkill) {
        currentSession().saveOrUpdate(petSkill);
    }

    public PetSkill insert(PetSkill petSkill) {
        return persist(petSkill);
    }
}
