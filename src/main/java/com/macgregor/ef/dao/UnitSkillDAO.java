package com.macgregor.ef.dao;

import com.macgregor.ef.model.UnitSkill;
import org.hibernate.SessionFactory;

public class UnitSkillDAO extends AbstractEFDAO<UnitSkill> {
    public UnitSkillDAO(SessionFactory factory) {
        super(factory);
    }
}