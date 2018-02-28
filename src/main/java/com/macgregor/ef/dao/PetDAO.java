package com.macgregor.ef.dao;

import com.macgregor.ef.model.Pet;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class PetDAO extends AbstractDAO<Pet> {
    public PetDAO(SessionFactory factory) {
        super(factory);
    }

    public List<Pet> getAll() {
        return (List<Pet>) currentSession().createCriteria(Pet.class).list();
    }

    public Pet findById(int id) {
        return (Pet) currentSession().get(Pet.class, id);
    }

    public void delete(Pet pet) {
        currentSession().delete(pet);
    }

    public void update(Pet pet) {
        currentSession().saveOrUpdate(pet);
    }

    public Pet insert(Pet pet) {
        return persist(pet);
    }
}
