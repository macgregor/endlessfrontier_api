package com.macgregor.ef.dataload.converters;

import com.macgregor.ef.dataload.annotations.*;
import com.macgregor.ef.exceptions.CanonicalConversionException;
import com.macgregor.ef.util.MockTranslationFieldConverter;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CanonicalModelConverterTest {
    private static final Logger logger = LoggerFactory.getLogger(CanonicalModelConverter.class);

    private CanonicalModelConverter converter;
    private NonCanonicalTestModel unconverted;

    public static class CanonicalTestModel{
        public Integer id;
        private Integer p_id;
        public String canonicalName;
        public Boolean convertBool;
        public String translate;
        public List<String> convertList;

        public Integer getPrivateId(){ return p_id; }
        public void setPrivateId(Integer id) { this.p_id = id; }
    }

    @CanonicalModel(type=CanonicalTestModel.class)
    public static class NonCanonicalTestModel{

        @CanonicalField
        public Integer id;

        @CanonicalField
        private Integer p_id;

        @CanonicalField(mapsTo="canonicalName")
        public String name;

        public String canonicalName;

        @CanonicalField
        @ConvertBool
        public String convertBool;

        @CanonicalField
        @Translate(key="KEY")
        public String translate;

        @CanonicalField
        @ConvertList
        public String convertList;

        public Integer getPrivateId(){ return p_id; }
        public void setPrivateId(Integer id) { this.p_id = id; }
    }

    @Before
    public void setup(){
        List<AbstractFieldConverter> converters = new ArrayList<>();

        BoolFieldConverter boolConverter = new BoolFieldConverter();
        converters.add(boolConverter);

        ListFieldConverter listConverter = new ListFieldConverter();
        converters.add(listConverter);

        TranslationFieldConverter translationFieldConverter = new MockTranslationFieldConverter();
        converters.add(translationFieldConverter);

        this.converter = new CanonicalModelConverter(converters);

        unconverted = new NonCanonicalTestModel();
        unconverted.id = 1;
        unconverted.name = "foobar";
        unconverted.convertBool = "true";
        unconverted.translate = "untranslated";
        unconverted.setPrivateId(2);
        unconverted.convertList = "foo,bar,baz";
    }

    @Test
    public void testCanonicalModelConverterPublicFieldWithSameName() throws CanonicalConversionException {
        CanonicalTestModel converted = (CanonicalTestModel) converter.convert(unconverted);
        assertEquals(1, (int)converted.id);
    }

    @Test
    public void testCanonicalModelConverterPublicFieldWithMappedName() throws CanonicalConversionException {
        CanonicalTestModel converted = (CanonicalTestModel) converter.convert(unconverted);
        assertEquals("foobar", converted.canonicalName);
    }

    @Test
    public void testCanonicalModelConverterPublicFieldConvertBoolean() throws CanonicalConversionException {
        CanonicalTestModel converted = (CanonicalTestModel) converter.convert(unconverted);
        assertEquals(true, converted.convertBool);
    }

    @Test
    public void testCanonicalModelConverterPublicFieldTranslate() throws CanonicalConversionException {
        CanonicalTestModel converted = (CanonicalTestModel) converter.convert(unconverted);
        assertEquals("success", converted.translate);
    }

    @Test
    public void testCanonicalModelConverterPrivateFields() throws CanonicalConversionException {
        CanonicalTestModel converted = (CanonicalTestModel) converter.convert(unconverted);
        assertEquals(unconverted.getPrivateId(), converted.getPrivateId());
    }

    @Test
    public void testCanonicalModelConverterPublicFieldConvertList() throws CanonicalConversionException {
        CanonicalTestModel converted = (CanonicalTestModel) converter.convert(unconverted);
        assertEquals(3, converted.convertList.size());
        assertEquals("foo", converted.convertList.get(0));
        assertEquals("bar", converted.convertList.get(1));
        assertEquals("baz", converted.convertList.get(2));
    }

    @Test
    public void testCanonicalModelConverterHandlesFailedConversionsGracefully() throws CanonicalConversionException {
        unconverted.convertBool = null;
        unconverted.convertList = null;
        CanonicalTestModel converted = (CanonicalTestModel) converter.convert(unconverted);
        assertEquals(unconverted.getPrivateId(), converted.getPrivateId());
    }
}
