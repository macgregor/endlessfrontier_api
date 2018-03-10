package com.macgregor.ef.model.ekkor;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.macgregor.ef.dataload.annotations.*;
import com.macgregor.ef.model.canonical.Pet;

@JacksonXmlRootElement(localName = "pet")
@CanonicalModel(type= Pet.class)
public class PetXML extends AbstractXMLModel {

    @JacksonXmlProperty(localName = "kindNum")
    @CanonicalField
    private Integer id;

    @JacksonXmlProperty(localName = "className")
    @CanonicalField
    private String className;

    @JacksonXmlProperty(localName = "name")
    @CanonicalField
    @Translate(key="PET_NAME_{id}")
    private String name;

    @JacksonXmlProperty(localName = "tribe")
    @CanonicalField
    private Integer tribe;

    @JacksonXmlProperty(localName = "type")
    @CanonicalField
    private String type;

    @JacksonXmlProperty(localName = "rank")
    @CanonicalField
    private Integer rank;

    @JacksonXmlProperty(localName = "skill1")
    @CanonicalField
    private Integer skill1;

    @JacksonXmlProperty(localName = "value1")
    @CanonicalField
    private String value1;

    @JacksonXmlProperty(localName = "skill2")
    @CanonicalField
    private Integer skill2;

    @JacksonXmlProperty(localName = "value2")
    @CanonicalField
    private String value2;

    @JacksonXmlProperty(localName = "value3")
    @CanonicalField
    private String value3;

    @JacksonXmlProperty(localName = "masterSkill")
    @CanonicalField
    private Integer masterSkill;

    @JacksonXmlProperty(localName = "couple")
    @CanonicalField
    private Integer couple;

    @JacksonXmlProperty(localName = "incGoldLevel")
    @CanonicalField
    private String incGoldLevel;

    @JacksonXmlProperty(localName = "treasure")
    @CanonicalField
    private Integer treasure;

    @JacksonXmlProperty(localName = "isPercent")
    @CanonicalField
    private String isPercent;

    @JacksonXmlProperty(localName = "isAlpha")
    @CanonicalField
    private String isAlpha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTribe() {
        return tribe;
    }

    public void setTribe(Integer tribe) {
        this.tribe = tribe;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getSkill1() {
        return skill1;
    }

    public void setSkill1(Integer skill1) {
        this.skill1 = skill1;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public Integer getSkill2() {
        return skill2;
    }

    public void setSkill2(Integer skill2) {
        this.skill2 = skill2;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    public Integer getMasterSkill() {
        return masterSkill;
    }

    public void setMasterSkill(Integer masterSkill) {
        this.masterSkill = masterSkill;
    }

    public Integer getCouple() {
        return couple;
    }

    public void setCouple(Integer couple) {
        this.couple = couple;
    }

    public String getIncGoldLevel() {
        return incGoldLevel;
    }

    public void setIncGoldLevel(String incGoldLevel) {
        this.incGoldLevel = incGoldLevel;
    }

    public Integer getTreasure() {
        return treasure;
    }

    public void setTreasure(Integer treasure) {
        this.treasure = treasure;
    }

    public String getIsPercent() {
        return isPercent;
    }

    public void setIsPercent(String isPercent) {
        this.isPercent = isPercent;
    }

    public String getIsAlpha() {
        return isAlpha;
    }

    public void setIsAlpha(String isAlpha) {
        this.isAlpha = isAlpha;
    }

    @Override
    public String toString() {
        return "PetXML{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", name='" + name + '\'' +
                ", tribe=" + tribe +
                ", type='" + type + '\'' +
                ", rank=" + rank +
                ", skill1=" + skill1 +
                ", value1='" + value1 + '\'' +
                ", skill2=" + skill2 +
                ", value2='" + value2 + '\'' +
                ", value3='" + value3 + '\'' +
                ", masterSkill=" + masterSkill +
                ", couple=" + couple +
                ", incGoldLevel='" + incGoldLevel + '\'' +
                ", treasure=" + treasure +
                ", isPercent='" + isPercent + '\'' +
                ", isAlpha='" + isAlpha + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PetXML petXML = (PetXML) o;

        if (id != null ? !id.equals(petXML.id) : petXML.id != null) return false;
        if (className != null ? !className.equals(petXML.className) : petXML.className != null) return false;
        if (name != null ? !name.equals(petXML.name) : petXML.name != null) return false;
        if (tribe != null ? !tribe.equals(petXML.tribe) : petXML.tribe != null) return false;
        if (type != null ? !type.equals(petXML.type) : petXML.type != null) return false;
        if (rank != null ? !rank.equals(petXML.rank) : petXML.rank != null) return false;
        if (skill1 != null ? !skill1.equals(petXML.skill1) : petXML.skill1 != null) return false;
        if (value1 != null ? !value1.equals(petXML.value1) : petXML.value1 != null) return false;
        if (skill2 != null ? !skill2.equals(petXML.skill2) : petXML.skill2 != null) return false;
        if (value2 != null ? !value2.equals(petXML.value2) : petXML.value2 != null) return false;
        if (value3 != null ? !value3.equals(petXML.value3) : petXML.value3 != null) return false;
        if (masterSkill != null ? !masterSkill.equals(petXML.masterSkill) : petXML.masterSkill != null) return false;
        if (couple != null ? !couple.equals(petXML.couple) : petXML.couple != null) return false;
        if (incGoldLevel != null ? !incGoldLevel.equals(petXML.incGoldLevel) : petXML.incGoldLevel != null) return false;
        if (treasure != null ? !treasure.equals(petXML.treasure) : petXML.treasure != null) return false;
        if (isPercent != null ? !isPercent.equals(petXML.isPercent) : petXML.isPercent != null) return false;
        return isAlpha != null ? isAlpha.equals(petXML.isAlpha) : petXML.isAlpha == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (tribe != null ? tribe.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (skill1 != null ? skill1.hashCode() : 0);
        result = 31 * result + (value1 != null ? value1.hashCode() : 0);
        result = 31 * result + (skill2 != null ? skill2.hashCode() : 0);
        result = 31 * result + (value2 != null ? value2.hashCode() : 0);
        result = 31 * result + (value3 != null ? value3.hashCode() : 0);
        result = 31 * result + (masterSkill != null ? masterSkill.hashCode() : 0);
        result = 31 * result + (couple != null ? couple.hashCode() : 0);
        result = 31 * result + (incGoldLevel != null ? incGoldLevel.hashCode() : 0);
        result = 31 * result + (treasure != null ? treasure.hashCode() : 0);
        result = 31 * result + (isPercent != null ? isPercent.hashCode() : 0);
        result = 31 * result + (isAlpha != null ? isAlpha.hashCode() : 0);
        return result;
    }
}
