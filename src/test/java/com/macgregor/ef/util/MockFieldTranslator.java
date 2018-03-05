package com.macgregor.ef.util;

import com.macgregor.ef.dataload.FieldTranslator;
import com.macgregor.ef.model.Translation;
import org.hibernate.SessionFactory;

import static org.mockito.Mockito.mock;

public class MockFieldTranslator extends FieldTranslator {
    private static final SessionFactory sessionFactory = mock(SessionFactory.class);

    private Translation translation;

    public MockFieldTranslator(){
        super(sessionFactory);

        translation = new Translation();
        translation.setId("1");
        translation.setValue("success");
    }

    public void setTranslation(Translation translation){
        this.translation = translation;
    }

    @Override
    public Translation findTranslation(String id){
        return translation;
    }
}
