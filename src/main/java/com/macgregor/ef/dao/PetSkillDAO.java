package com.macgregor.ef.dao;

import com.macgregor.ef.model.PetSkill;
import org.hibernate.SessionFactory;

public class PetSkillDAO extends AbstractEFDAO<PetSkill> {
    public PetSkillDAO(SessionFactory factory) {
        super(factory);
    }
}
