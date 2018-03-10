package com.macgregor.ef.model.ekkor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.macgregor.ef.dataload.annotations.*;
import com.macgregor.ef.model.canonical.ArtifactSet;

@JacksonXmlRootElement(localName = "treasureSet")
@CanonicalModel(type= ArtifactSet.class)
public class ArtifactSetXML extends AbstractXMLModel{

    @JacksonXmlProperty(localName = "kindNum")
    @CanonicalField
    private Integer id;

    @JacksonXmlProperty(localName = "title")
    @CanonicalField
    @Translate(key="RELIC_SET_NAME_{id}")
    private String title;

    @JacksonXmlProperty(localName = "itemList")
    @CanonicalField
    private String itemList;

    @JacksonXmlProperty(localName = "numSetList")
    @CanonicalField
    private String numSetList;

    @JacksonXmlProperty(localName = "skillList")
    @CanonicalField
    private String skillList;

    @JacksonXmlProperty(localName = "valueList")
    @CanonicalField
    private String valueList;

    @JacksonXmlProperty(localName = "valueList1")
    @CanonicalField
    private String valueList1;

    @JacksonXmlProperty(localName = "valueList2")
    @CanonicalField
    private String valueList2;

    @JacksonXmlProperty(localName = "desc")
    @CanonicalField
    @Translate(key="RELIC_SET_DESC_{id}")
    private String desc;

    @JsonProperty
    @JacksonXmlProperty(localName = "history")
    private String history;

    @JacksonXmlProperty(localName = "showDesc")
    @CanonicalField
    private String showDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getItemList() {
        return itemList;
    }

    public void setItemList(String itemList) {
        this.itemList = itemList;
    }

    public String getNumSetList() {
        return numSetList;
    }

    public void setNumSetList(String numSetList) {
        this.numSetList = numSetList;
    }

    public String getSkillList() {
        return skillList;
    }

    public void setSkillList(String skillList) {
        this.skillList = skillList;
    }

    public String getValueList() {
        return valueList;
    }

    public void setValueList(String valueList) {
        this.valueList = valueList;
    }

    public String getValueList1() {
        return valueList1;
    }

    public void setValueList1(String valueList1) {
        this.valueList1 = valueList1;
    }

    public String getValueList2() {
        return valueList2;
    }

    public void setValueList2(String valueList2) {
        this.valueList2 = valueList2;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getShowDesc() {
        return showDesc;
    }

    public void setShowDesc(String showDesc) {
        this.showDesc = showDesc;
    }

    @Override
    public String toString() {
        return "ArtifactSetXML{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", itemList='" + itemList + '\'' +
                ", numSetList=" + numSetList +
                ", skillList='" + skillList + '\'' +
                ", valueList='" + valueList + '\'' +
                ", valueList1='" + valueList1 + '\'' +
                ", valueList2='" + valueList2 + '\'' +
                ", desc='" + desc + '\'' +
                ", history='" + history + '\'' +
                ", showDesc='" + showDesc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtifactSetXML that = (ArtifactSetXML) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (itemList != null ? !itemList.equals(that.itemList) : that.itemList != null) return false;
        if (numSetList != null ? !numSetList.equals(that.numSetList) : that.numSetList != null) return false;
        if (skillList != null ? !skillList.equals(that.skillList) : that.skillList != null) return false;
        if (valueList != null ? !valueList.equals(that.valueList) : that.valueList != null) return false;
        if (valueList1 != null ? !valueList1.equals(that.valueList1) : that.valueList1 != null) return false;
        if (valueList2 != null ? !valueList2.equals(that.valueList2) : that.valueList2 != null) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (history != null ? !history.equals(that.history) : that.history != null) return false;
        return showDesc != null ? showDesc.equals(that.showDesc) : that.showDesc == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (itemList != null ? itemList.hashCode() : 0);
        result = 31 * result + (numSetList != null ? numSetList.hashCode() : 0);
        result = 31 * result + (skillList != null ? skillList.hashCode() : 0);
        result = 31 * result + (valueList != null ? valueList.hashCode() : 0);
        result = 31 * result + (valueList1 != null ? valueList1.hashCode() : 0);
        result = 31 * result + (valueList2 != null ? valueList2.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (history != null ? history.hashCode() : 0);
        result = 31 * result + (showDesc != null ? showDesc.hashCode() : 0);
        return result;
    }
}
