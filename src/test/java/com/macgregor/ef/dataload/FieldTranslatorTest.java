package com.macgregor.ef.dataload;

import com.macgregor.ef.dataload.annotations.Translate;
import com.macgregor.ef.exceptions.DataLoadException;
import com.macgregor.ef.exceptions.TranslationException;
import com.macgregor.ef.model.Translation;
import com.macgregor.ef.util.MockFieldTranslator;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class FieldTranslatorTest {

    private static final Logger logger = LoggerFactory.getLogger(FieldTranslatorTest.class);

    private FieldTranslatorTestModel testModel;
    private FieldTranslator fieldTranslator;

    public static class FieldTranslatorTestModel{
        public Integer id;

        public Integer id2;

        public Object none;

        private Integer privateId;

        @Translate(key="KEY_{id}")
        public String keyWithFieldReference;

        @Translate(key="KEY_{id}_{id2}")
        public String keyWithMultipleFieldReference;

        @Translate(key="KEY")
        public String simpleKey;

        @Translate(key="KEY_{doesntexist}")
        public String invalidFieldReference;

        @Translate(key="KEY_{id}_{id}")
        public String repeatedFieldReference;

        @Translate(key="KEY_{none}")
        public String nullFieldReference;

        @Translate(key="KEY_{privateId}")
        private String privateFieldReference;

        public Integer getPrivateId(){ return this.privateId; }

        public void setPrivateId(Integer privateId){ this.privateId = privateId; }

        public void setPrivateFieldReference(String privateFieldReference){
            this.privateFieldReference = privateFieldReference;
        }

        public String getPrivateFieldReference(){
            return privateFieldReference;
        }
    }

    @Before
    public void setup(){
        fieldTranslator = new MockFieldTranslator();
        testModel = new FieldTranslatorTestModel();
        testModel.id = 1;
        testModel.id2 = 2;
        testModel.keyWithFieldReference = "untranslated";
        testModel.keyWithMultipleFieldReference = "untranslated";
        testModel.simpleKey = "untranslated";
        testModel.invalidFieldReference = "untranslated";
        testModel.repeatedFieldReference = "untranslated";
        testModel.setPrivateFieldReference("untranslated");
        testModel.setPrivateId(3);
    }

    @Test
    public void testGetFieldKeyExtractsSimpleKey() throws DataLoadException{
        String extracted = fieldTranslator.getFieldKey(testModel, "KEY");
        assertEquals("KEY", extracted);
    }

    @Test
    public void testGetFieldKeyExtractsKeyWithFieldReference() throws DataLoadException{
        String extracted = fieldTranslator.getFieldKey(testModel, "KEY_{id}");
        assertEquals("KEY_1", extracted);
    }

    @Test
    public void testGetFieldKeyExtractsKeyWithMultipleFieldReferences() throws DataLoadException {
        String extracted = fieldTranslator.getFieldKey(testModel, "KEY_{id}_{id2}");
        assertEquals("KEY_1_2", extracted);
    }

    @Test
    public void testGetFieldKeyExtractsKeyWithRepeatedFieldReferences() throws DataLoadException {
        String extracted = fieldTranslator.getFieldKey(testModel, "KEY_{id}_{id}");
        assertEquals("KEY_1_1", extracted);
    }

    @Test
    public void testGetFieldKeyExtractsKeysFromPrivateFields() throws DataLoadException {
        String extracted = fieldTranslator.getFieldKey(testModel, "KEY_{privateId}");
        assertEquals("KEY_3", extracted);
    }

    @Test(expected = TranslationException.class)
    public void testGetFieldKeyThrowsDataLoadExceptionWithInvalidKey() throws DataLoadException {
        String extracted = fieldTranslator.getFieldKey(testModel, "KEY_{doesntexist}");
    }

    @Test(expected = TranslationException.class)
    public void testGetFieldKeyThrowsDataLoadExceptionWithNullKey() throws DataLoadException {
        String extracted = fieldTranslator.getFieldKey(testModel, "KEY_{none}");
    }

    @Test
    public void testTranslateDoesntThrowNPEWhenTranslationEntityNotFound() throws TranslationException {
        ((MockFieldTranslator)fieldTranslator).setTranslation(null);
        fieldTranslator.translate(testModel);
    }

    @Test
    public void testTranslateDoesntOverrideWithBlankTranslationValue() throws TranslationException {
        Translation t = new Translation();
        t.setId("1");
        t.setValue("");
        ((MockFieldTranslator)fieldTranslator).setTranslation(t);
        fieldTranslator.translate(testModel);
        assertEquals("untranslated", testModel.simpleKey);
    }

    @Test
    public void testTranslatesAllFields() throws DataLoadException {
        fieldTranslator.translate(testModel);
        assertEquals("success", testModel.keyWithFieldReference);
        assertEquals("success", testModel.keyWithMultipleFieldReference);
        assertEquals("success", testModel.simpleKey);
        assertEquals("success", testModel.repeatedFieldReference);
        assertEquals("untranslated", testModel.invalidFieldReference);
        assertEquals(null, testModel.nullFieldReference);
    }
}
