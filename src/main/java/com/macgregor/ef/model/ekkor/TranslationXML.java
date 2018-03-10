package com.macgregor.ef.model.ekkor;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.macgregor.ef.dataload.annotations.CanonicalField;
import com.macgregor.ef.dataload.annotations.CanonicalModel;
import com.macgregor.ef.model.canonical.Translation;

@JacksonXmlRootElement(localName = "text")
@CanonicalModel(type= Translation.class)
public class TranslationXML extends AbstractXMLModel {

    @JacksonXmlProperty(localName = "id")
    @CanonicalField
    private String id;

    @JacksonXmlProperty(localName = "value")
    @CanonicalField
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TranslationXML{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TranslationXML that = (TranslationXML) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
