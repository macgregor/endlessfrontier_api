package com.macgregor.ef.dataload.converters;

import com.macgregor.ef.dataload.annotations.ConvertList;
import com.macgregor.ef.exceptions.CanonicalConversionException;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListFieldConverterTest {
    private static final Logger logger = LoggerFactory.getLogger(ListFieldConverterTest.class);

    private ListFieldConverter listFieldConverter;
    private ListConverterTestModel testModel;

    public static class ListConverterTestModel {

        public Integer id;

        @ConvertList
        public String defaultList;

        @ConvertList
        public String whiteSpace;

        @ConvertList(sep="|")
        public String pipeList;

        @ConvertList(elementType = Integer.class)
        public String integerList;

        @ConvertList(elementType = Date.class)
        public String unknownElementType;

        @ConvertList
        private String privateList;

        @ConvertList
        public Integer notAString;

        public String getPrivateList(){ return privateList; }
        public void setPrivateList(String privateList){ this.privateList = privateList; }
    }

    @Before
    public void setup(){
        listFieldConverter = new ListFieldConverter();

        testModel = new ListConverterTestModel();
        testModel.defaultList = "foo,bar,baz";
        testModel.whiteSpace = "     foo, bar,    baz      ";
        testModel.integerList = "0,1,2";
        testModel.pipeList = "foo|bar|baz";
        testModel.unknownElementType = "foo,bar,baz";
        testModel.setPrivateList("foo,bar,baz");
    }

    @Test
    public void testListFieldConverterConvertDefaultToList() throws CanonicalConversionException {
        Field f = FieldUtils.getField(testModel.getClass(), "defaultList");

        List<Object> converted = (List<Object>)listFieldConverter.convertField(testModel, f);
        assertEquals(3, converted.size());
        assertEquals("foo", converted.get(0));
        assertEquals("bar", converted.get(1));
        assertEquals("baz", converted.get(2));
    }

    @Test
    public void testListFieldConverterStripsWhiteSpace() throws CanonicalConversionException {
        Field f = FieldUtils.getField(testModel.getClass(), "whiteSpace");

        List<Object> converted = (List<Object>)listFieldConverter.convertField(testModel, f);
        assertEquals(3, converted.size());
        assertEquals("foo", converted.get(0));
        assertEquals("bar", converted.get(1));
        assertEquals("baz", converted.get(2));
    }

    @Test
    public void testListFieldConverterConvertPipeList() throws CanonicalConversionException {
        Field f = FieldUtils.getField(testModel.getClass(), "pipeList");

        List<Object> converted = (List<Object>)listFieldConverter.convertField(testModel, f);
        assertEquals(3, converted.size());
        assertEquals("foo", converted.get(0));
        assertEquals("bar", converted.get(1));
        assertEquals("baz", converted.get(2));
    }

    @Test
    public void testListFieldConverterConvertIntList() throws CanonicalConversionException {
        Field f = FieldUtils.getField(testModel.getClass(), "integerList");

        List<Object> converted = (List<Object>)listFieldConverter.convertField(testModel, f);
        assertEquals(3, converted.size());
        assertEquals(0, converted.get(0));
        assertEquals(1, converted.get(1));
        assertEquals(2, converted.get(2));
    }

    @Test
    public void testListFieldConverterConvertListToListStringForUnknownElementType() throws CanonicalConversionException {
        Field f = FieldUtils.getField(testModel.getClass(), "unknownElementType");

        List<Object> converted = (List<Object>)listFieldConverter.convertField(testModel, f);
        assertEquals(3, converted.size());
        assertEquals("foo", converted.get(0));
        assertEquals("bar", converted.get(1));
        assertEquals("baz", converted.get(2));
    }

    @Test
    public void testListFieldConverterConvertPrivateFields() throws CanonicalConversionException {
        Field f = FieldUtils.getField(testModel.getClass(), "privateList", true);

        List<Object> converted = (List<Object>)listFieldConverter.convertField(testModel, f);
        assertEquals(3, converted.size());
        assertEquals("foo", converted.get(0));
        assertEquals("bar", converted.get(1));
        assertEquals("baz", converted.get(2));
    }

    @Test(expected = CanonicalConversionException.class)
    public void testListFieldConverterConvertListSizeOneWithOriginalStringForUnknownElementType() throws CanonicalConversionException {
        Field f = FieldUtils.getField(testModel.getClass(), "notAString");

        List<Object> converted = (List<Object>)listFieldConverter.convertField(testModel, f);
    }
}
