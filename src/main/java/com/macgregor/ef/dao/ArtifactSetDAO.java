package com.macgregor.ef.dao;

import com.macgregor.ef.model.ArtifactSet;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class ArtifactSetDAO extends AbstractDAO<ArtifactSet> {
    public ArtifactSetDAO(SessionFactory factory) {
        super(factory);
    }

    public List<ArtifactSet> getAll() {
        return (List<ArtifactSet>) currentSession().createCriteria(ArtifactSet.class).list();
    }

    public ArtifactSet findById(int id) {
        return (ArtifactSet) currentSession().get(ArtifactSet.class, id);
    }

    public void delete(ArtifactSet artifactSet) {
        currentSession().delete(artifactSet);
    }

    public void update(ArtifactSet artifactSet) {
        currentSession().saveOrUpdate(artifactSet);
    }

    public ArtifactSet insert(ArtifactSet artifactSet) {
        return persist(artifactSet);
    }
}
