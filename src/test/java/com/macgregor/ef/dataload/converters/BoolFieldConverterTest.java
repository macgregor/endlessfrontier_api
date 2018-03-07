package com.macgregor.ef.dataload.converters;

import com.macgregor.ef.dataload.annotations.ConvertBool;
import com.macgregor.ef.exceptions.CanonicalConversionException;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoolFieldConverterTest {
    private static final Logger logger = LoggerFactory.getLogger(TranslationFieldConverterTest.class);

    private BoolFieldConverter boolFieldConverter;
    private BoolConverterTestModel testModel;

    public static class BoolConverterTestModel {

        public Integer id;

        @ConvertBool
        public String defaultBool;

        @ConvertBool(kind= ConvertBool.Kind.BINARY)
        public String binaryBool;

        @ConvertBool(kind= ConvertBool.Kind.TRUE_FALSE)
        public String trueFalseBool;

        @ConvertBool(kind= ConvertBool.Kind.T_F)
        public String tFBool;

        @ConvertBool(kind= ConvertBool.Kind.YES_NO)
        public String yesNoBool;

        @ConvertBool(kind= ConvertBool.Kind.Y_N)
        public String yNBool;

        @ConvertBool
        public Long notAString;
    }

    @Before
    public void setup(){
        boolFieldConverter = new BoolFieldConverter();

        testModel = new BoolConverterTestModel();
    }

    @Test
    public void testCanConvertAnnotatedFields(){
        Field f = FieldUtils.getField(testModel.getClass(), "defaultBool");
        assertTrue(boolFieldConverter.canConvert(f));
    }

    @Test
    public void testCanConvertNonAnnotatedFields(){
        Field f = FieldUtils.getField(testModel.getClass(), "id");
        assertFalse(boolFieldConverter.canConvert(f));
    }

    @Test
    public void testDefaultUsesTrueFalse() throws CanonicalConversionException {
        Field f = FieldUtils.getField(testModel.getClass(), "defaultBool");

        testModel.defaultBool = "true";
        assertTrue((Boolean)boolFieldConverter.convertField(testModel, f));

        testModel.defaultBool = "false";
        assertFalse((Boolean)boolFieldConverter.convertField(testModel, f));
    }

    @Test
    public void testConverterSholdIgnoreCase() throws CanonicalConversionException {
        Field f = FieldUtils.getField(testModel.getClass(), "defaultBool");

        testModel.defaultBool = "TrUe";
        assertTrue((Boolean)boolFieldConverter.convertField(testModel, f));

        testModel.defaultBool = "fAlSe";
        assertFalse((Boolean)boolFieldConverter.convertField(testModel, f));
    }

    @Test
    public void testDefaultUsesTrueFalseWhenExplicit() throws CanonicalConversionException {
        Field f = FieldUtils.getField(testModel.getClass(), "trueFalseBool");

        testModel.trueFalseBool = "true";
        assertTrue((Boolean)boolFieldConverter.convertField(testModel, f));

        testModel.trueFalseBool = "false";
        assertFalse((Boolean)boolFieldConverter.convertField(testModel, f));
    }

    @Test
    public void testDefaultUsesTFWhenExplicit() throws CanonicalConversionException {
        Field f = FieldUtils.getField(testModel.getClass(), "tFBool");

        testModel.tFBool = "t";
        assertTrue((Boolean)boolFieldConverter.convertField(testModel, f));

        testModel.tFBool = "f";
        assertFalse((Boolean)boolFieldConverter.convertField(testModel, f));
    }

    @Test
    public void testDefaultUsesBinaryWhenExplicit() throws CanonicalConversionException {
        Field f = FieldUtils.getField(testModel.getClass(), "binaryBool");

        testModel.binaryBool = "1";
        assertTrue((Boolean)boolFieldConverter.convertField(testModel, f));

        testModel.binaryBool = "0";
        assertFalse((Boolean)boolFieldConverter.convertField(testModel, f));
    }

    @Test
    public void testDefaultUsesYesNoWhenExplicit() throws CanonicalConversionException {
        Field f = FieldUtils.getField(testModel.getClass(), "yesNoBool");

        testModel.yesNoBool = "Yes";
        assertTrue((Boolean)boolFieldConverter.convertField(testModel, f));

        testModel.yesNoBool = "No";
        assertFalse((Boolean)boolFieldConverter.convertField(testModel, f));
    }

    @Test
    public void testDefaultUsesYNWhenExplicit() throws CanonicalConversionException {
        Field f = FieldUtils.getField(testModel.getClass(), "yNBool");

        testModel.yNBool = "Y";
        assertTrue((Boolean)boolFieldConverter.convertField(testModel, f));

        testModel.yNBool = "N";
        assertFalse((Boolean)boolFieldConverter.convertField(testModel, f));
    }

    @Test(expected = CanonicalConversionException.class)
    public void testConverterThrowsCanonicalConversionExceptionOnNonStringValue() throws CanonicalConversionException {
        Field f = FieldUtils.getField(testModel.getClass(), "notAString");

        testModel.notAString = new Long(0);
        boolFieldConverter.convertField(testModel, f);
    }

    @Test(expected = CanonicalConversionException.class)
    public void testConverterThrowsCanonicalConversionExceptionOnNullValue() throws CanonicalConversionException {
        Field f = FieldUtils.getField(testModel.getClass(), "notAString");
        boolFieldConverter.convertField(testModel, f);
    }
}
