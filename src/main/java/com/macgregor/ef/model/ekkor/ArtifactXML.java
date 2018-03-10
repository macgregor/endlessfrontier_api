package com.macgregor.ef.model.ekkor;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.macgregor.ef.dataload.annotations.*;
import com.macgregor.ef.model.canonical.Artifact;

@JacksonXmlRootElement(localName = "treasure")
@CanonicalModel(type= Artifact.class)
public class ArtifactXML extends AbstractXMLModel{

    @JacksonXmlProperty(localName = "kindNum")
    @CanonicalField
    private Integer id;

    @JacksonXmlProperty(localName = "name")
    @Translate(key="RELIC_NAME_{id}")
    @CanonicalField
    private String name;

    @JacksonXmlProperty(localName = "mainCode")
    @CanonicalField
    private String mainCode;

    @JacksonXmlProperty(localName = "subCode")
    @CanonicalField
    private Integer subCode;

    @JacksonXmlProperty(localName = "grade")
    @CanonicalField
    private Integer grade;

    @JacksonXmlProperty(localName = "maxLv")
    @CanonicalField
    private Integer maxLv;

    @JacksonXmlProperty(localName = "desc")
    @CanonicalField
    @Translate(key="RELIC_DESC_{id}")
    private String desc;

    @JacksonXmlProperty(localName = "openCost")
    @CanonicalField
    private String openCost;

    @JacksonXmlProperty(localName = "skillCode1")
    @CanonicalField
    private String skillCode1;

    @JacksonXmlProperty(localName = "ability1")
    @CanonicalField
    private Integer ability1;

    @JacksonXmlProperty(localName = "ability11")
    @CanonicalField
    private Integer ability11;

    @JacksonXmlProperty(localName = "ability21")
    @CanonicalField
    private Integer ability21;

    @JacksonXmlProperty(localName = "skillCode2")
    @CanonicalField
    private String skillCode2;

    @JacksonXmlProperty(localName = "ability2")
    @CanonicalField
    private Integer ability2;

    @JacksonXmlProperty(localName = "ability12")
    @CanonicalField
    private Integer ability12;

    @JacksonXmlProperty(localName = "ability22")
    @CanonicalField
    private Integer ability22;

    @JacksonXmlProperty(localName = "skillCode3")
    @CanonicalField
    private String skillCode3;

    @JacksonXmlProperty(localName = "ability3")
    @CanonicalField
    private Integer ability3;

    @JacksonXmlProperty(localName = "upgradeCostType")
    @CanonicalField
    private Integer upgradeCostType;

    @JacksonXmlProperty(localName = "showDesc")
    @CanonicalField
    private String showDesc;

    @JacksonXmlProperty(localName = "sortId")
    @CanonicalField
    private Integer sortId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainCode() {
        return mainCode;
    }

    public void setMainCode(String mainCode) {
        this.mainCode = mainCode;
    }

    public Integer getSubCode() {
        return subCode;
    }

    public void setSubCode(Integer subCode) {
        this.subCode = subCode;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getMaxLv() {
        return maxLv;
    }

    public void setMaxLv(Integer maxLv) {
        this.maxLv = maxLv;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getOpenCost() {
        return openCost;
    }

    public void setOpenCost(String openCost) {
        this.openCost = openCost;
    }

    public String getSkillCode1() {
        return skillCode1;
    }

    public void setSkillCode1(String skillCode1) {
        this.skillCode1 = skillCode1;
    }

    public Integer getAbility1() {
        return ability1;
    }

    public void setAbility1(Integer ability1) {
        this.ability1 = ability1;
    }

    public Integer getAbility11() {
        return ability11;
    }

    public void setAbility11(Integer ability11) {
        this.ability11 = ability11;
    }

    public Integer getAbility21() {
        return ability21;
    }

    public void setAbility21(Integer ability21) {
        this.ability21 = ability21;
    }

    public String getSkillCode2() {
        return skillCode2;
    }

    public void setSkillCode2(String skillCode2) {
        this.skillCode2 = skillCode2;
    }

    public Integer getAbility2() {
        return ability2;
    }

    public void setAbility2(Integer ability2) {
        this.ability2 = ability2;
    }

    public Integer getAbility12() {
        return ability12;
    }

    public void setAbility12(Integer ability12) {
        this.ability12 = ability12;
    }

    public Integer getAbility22() {
        return ability22;
    }

    public void setAbility22(Integer ability22) {
        this.ability22 = ability22;
    }

    public String getSkillCode3() {
        return skillCode3;
    }

    public void setSkillCode3(String skillCode3) {
        this.skillCode3 = skillCode3;
    }

    public Integer getAbility3() {
        return ability3;
    }

    public void setAbility3(Integer ability3) {
        this.ability3 = ability3;
    }

    public Integer getUpgradeCostType() {
        return upgradeCostType;
    }

    public void setUpgradeCostType(Integer upgradeCostType) {
        this.upgradeCostType = upgradeCostType;
    }

    public String getShowDesc() {
        return showDesc;
    }

    public void setShowDesc(String showDesc) {
        this.showDesc = showDesc;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    @Override
    public String toString() {
        return "ArtifactXML{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mainCode='" + mainCode + '\'' +
                ", subCode=" + subCode +
                ", grade=" + grade +
                ", maxLv=" + maxLv +
                ", desc='" + desc + '\'' +
                ", openCost='" + openCost + '\'' +
                ", skillCode1='" + skillCode1 + '\'' +
                ", ability1=" + ability1 +
                ", ability11=" + ability11 +
                ", ability21=" + ability21 +
                ", skillCode2='" + skillCode2 + '\'' +
                ", ability2=" + ability2 +
                ", ability12=" + ability12 +
                ", ability22=" + ability22 +
                ", skillCode3='" + skillCode3 + '\'' +
                ", ability3=" + ability3 +
                ", upgradeCostType=" + upgradeCostType +
                ", showDesc='" + showDesc + '\'' +
                ", sortId=" + sortId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtifactXML artifactXML = (ArtifactXML) o;

        if (id != null ? !id.equals(artifactXML.id) : artifactXML.id != null) return false;
        if (name != null ? !name.equals(artifactXML.name) : artifactXML.name != null) return false;
        if (mainCode != null ? !mainCode.equals(artifactXML.mainCode) : artifactXML.mainCode != null) return false;
        if (subCode != null ? !subCode.equals(artifactXML.subCode) : artifactXML.subCode != null) return false;
        if (grade != null ? !grade.equals(artifactXML.grade) : artifactXML.grade != null) return false;
        if (maxLv != null ? !maxLv.equals(artifactXML.maxLv) : artifactXML.maxLv != null) return false;
        if (desc != null ? !desc.equals(artifactXML.desc) : artifactXML.desc != null) return false;
        if (openCost != null ? !openCost.equals(artifactXML.openCost) : artifactXML.openCost != null) return false;
        if (skillCode1 != null ? !skillCode1.equals(artifactXML.skillCode1) : artifactXML.skillCode1 != null) return false;
        if (ability1 != null ? !ability1.equals(artifactXML.ability1) : artifactXML.ability1 != null) return false;
        if (ability11 != null ? !ability11.equals(artifactXML.ability11) : artifactXML.ability11 != null) return false;
        if (ability21 != null ? !ability21.equals(artifactXML.ability21) : artifactXML.ability21 != null) return false;
        if (skillCode2 != null ? !skillCode2.equals(artifactXML.skillCode2) : artifactXML.skillCode2 != null) return false;
        if (ability2 != null ? !ability2.equals(artifactXML.ability2) : artifactXML.ability2 != null) return false;
        if (ability12 != null ? !ability12.equals(artifactXML.ability12) : artifactXML.ability12 != null) return false;
        if (ability22 != null ? !ability22.equals(artifactXML.ability22) : artifactXML.ability22 != null) return false;
        if (skillCode3 != null ? !skillCode3.equals(artifactXML.skillCode3) : artifactXML.skillCode3 != null) return false;
        if (ability3 != null ? !ability3.equals(artifactXML.ability3) : artifactXML.ability3 != null) return false;
        if (upgradeCostType != null ? !upgradeCostType.equals(artifactXML.upgradeCostType) : artifactXML.upgradeCostType != null)
            return false;
        if (showDesc != null ? !showDesc.equals(artifactXML.showDesc) : artifactXML.showDesc != null) return false;
        return sortId != null ? sortId.equals(artifactXML.sortId) : artifactXML.sortId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (mainCode != null ? mainCode.hashCode() : 0);
        result = 31 * result + (subCode != null ? subCode.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (maxLv != null ? maxLv.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (openCost != null ? openCost.hashCode() : 0);
        result = 31 * result + (skillCode1 != null ? skillCode1.hashCode() : 0);
        result = 31 * result + (ability1 != null ? ability1.hashCode() : 0);
        result = 31 * result + (ability11 != null ? ability11.hashCode() : 0);
        result = 31 * result + (ability21 != null ? ability21.hashCode() : 0);
        result = 31 * result + (skillCode2 != null ? skillCode2.hashCode() : 0);
        result = 31 * result + (ability2 != null ? ability2.hashCode() : 0);
        result = 31 * result + (ability12 != null ? ability12.hashCode() : 0);
        result = 31 * result + (ability22 != null ? ability22.hashCode() : 0);
        result = 31 * result + (skillCode3 != null ? skillCode3.hashCode() : 0);
        result = 31 * result + (ability3 != null ? ability3.hashCode() : 0);
        result = 31 * result + (upgradeCostType != null ? upgradeCostType.hashCode() : 0);
        result = 31 * result + (showDesc != null ? showDesc.hashCode() : 0);
        result = 31 * result + (sortId != null ? sortId.hashCode() : 0);
        return result;
    }
}
