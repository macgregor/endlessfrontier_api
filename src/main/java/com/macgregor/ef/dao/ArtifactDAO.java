package com.macgregor.ef.dao;

import com.macgregor.ef.model.Artifact;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class ArtifactDAO extends AbstractDAO<Artifact> {
    public ArtifactDAO(SessionFactory factory) {
        super(factory);
    }

    public List<Artifact> getAll() {
        return (List<Artifact>) currentSession().createCriteria(Artifact.class).list();
    }

    public Artifact findById(int id) {
        return (Artifact) currentSession().get(Artifact.class, id);
    }

    public void delete(Artifact artifact) {
        currentSession().delete(artifact);
    }

    public void update(Artifact artifact) {
        currentSession().saveOrUpdate(artifact);
    }

    public Artifact insert(Artifact artifact) {
        return persist(artifact);
    }
}
