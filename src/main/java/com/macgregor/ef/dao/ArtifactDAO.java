package com.macgregor.ef.dao;

import com.macgregor.ef.model.canonical.Artifact;
import org.hibernate.SessionFactory;

public class ArtifactDAO extends AbstractEFDAO<Artifact> {
    public ArtifactDAO(SessionFactory factory) {
        super(factory);
    }
}
