package com.macgregor.ef.model.ekkor;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.macgregor.ef.dataload.annotations.Translate;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@JacksonXmlRootElement(localName = "unitSkill")
public class UnitSkillXML extends AbstractXMLModel {

    @NotNull
    @JacksonXmlProperty(localName = "id")
    private Integer id;

    @NotBlank
    @JacksonXmlProperty(localName = "skillCode")
    private String skillCode;

    @NotNull
    @JacksonXmlProperty(localName = "imgIndex")
    private Integer imgIndex;

    @NotNull
    @JacksonXmlProperty(localName = "baseValue")
    private Integer baseValue;

    @NotBlank
    @JacksonXmlProperty(localName = "desc")
    @Translate(key="UNITSKILL_DESC_{id}")
    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkillCode() {
        return skillCode;
    }

    public void setSkillCode(String skillCode) {
        this.skillCode = skillCode;
    }

    public Integer getImgIndex() {
        return imgIndex;
    }

    public void setImgIndex(Integer imgIndex) {
        this.imgIndex = imgIndex;
    }

    public Integer getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(Integer baseValue) {
        this.baseValue = baseValue;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "UnitSkillXML{" +
                "id=" + id +
                ", skillCode='" + skillCode + '\'' +
                ", imgIndex=" + imgIndex +
                ", baseValue=" + baseValue +
                ", desc='" + desc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitSkillXML unitSkillXML = (UnitSkillXML) o;

        if (id != null ? !id.equals(unitSkillXML.id) : unitSkillXML.id != null) return false;
        if (skillCode != null ? !skillCode.equals(unitSkillXML.skillCode) : unitSkillXML.skillCode != null) return false;
        if (imgIndex != null ? !imgIndex.equals(unitSkillXML.imgIndex) : unitSkillXML.imgIndex != null) return false;
        if (baseValue != null ? !baseValue.equals(unitSkillXML.baseValue) : unitSkillXML.baseValue != null) return false;
        return desc != null ? desc.equals(unitSkillXML.desc) : unitSkillXML.desc == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (skillCode != null ? skillCode.hashCode() : 0);
        result = 31 * result + (imgIndex != null ? imgIndex.hashCode() : 0);
        result = 31 * result + (baseValue != null ? baseValue.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        return result;
    }
}
