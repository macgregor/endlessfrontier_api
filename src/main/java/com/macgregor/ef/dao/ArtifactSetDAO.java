package com.macgregor.ef.dao;

import com.macgregor.ef.model.canonical.ArtifactSet;
import org.hibernate.SessionFactory;

public class ArtifactSetDAO extends AbstractEFDAO<ArtifactSet> {
    public ArtifactSetDAO(SessionFactory factory) {
        super(factory);
    }
}
