package com.macgregor.ef.model.canonical;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.swagger.annotations.ApiModel;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "artifact")
@JacksonXmlRootElement(localName = "treasure")
@ApiModel(value="ArtifactXML", description="ArtifactXML model describing artifacts in Endless Frontier (e.g. Necromancer's Boots, Salim's Claw, etc.)")
public class Artifact {

    @Id
    @Column(name="id", nullable = false)
    @NotNull
    @JsonProperty
    private Integer id;

    @Column(name = "name", nullable = false)
    @NotBlank
    @JsonProperty
    private String name;

    @Column(name = "main_code", nullable = false)
    @NotBlank
    @JsonProperty
    private String mainCode;

    @Column(name="sub_code", nullable = false)
    @NotNull
    @JsonProperty
    private Integer subCode;

    @Column(name="grade", nullable = false)
    @NotNull
    @JsonProperty
    private Integer grade;

    @Column(name="max_lv", nullable = false)
    @NotNull
    @JsonProperty
    private Integer maxLv;

    @Column(name = "desc", nullable = false)
    @NotBlank
    @JsonProperty
    private String desc;

    @ElementCollection
    @CollectionTable
    @Column(name = "open_cost", nullable = false)
    @NotEmpty
    @JsonProperty
    private List<Long> openCost;

    @Column(name = "skill_code1", nullable = false)
    @NotBlank
    @JsonProperty
    private String skillCode1;

    @Column(name = "ability1", nullable = false)
    @NotNull
    @JsonProperty
    private Integer ability1;

    @Column(name = "ability11", nullable = false)
    @NotNull
    @JsonProperty
    private Integer ability11;

    @Column(name = "ability21", nullable = false)
    @NotNull
    @JsonProperty
    private Integer ability21;

    @Column(name = "skill_code2")
    @JsonProperty
    private String skillCode2;

    @Column(name = "ability2", nullable = false)
    @NotNull
    @JsonProperty
    private Integer ability2;

    @Column(name = "ability12", nullable = false)
    @NotNull
    @JsonProperty
    private Integer ability12;

    @Column(name = "ability22", nullable = false)
    @NotNull
    @JsonProperty
    private Integer ability22;

    @Column(name = "skill_code3")
    @JsonProperty
    private String skillCode3;

    @Column(name = "ability3", nullable = false)
    @NotNull
    @JsonProperty
    private Integer ability3;

    @Column(name = "upgrade_cost_type", nullable = false)
    @NotNull
    @JsonProperty
    private Integer upgradeCostType;

    @Column(name = "show_desc", nullable = false)
    @NotNull
    @JsonProperty
    private Boolean showDesc;

    @Column(name = "sort_id", nullable = false)
    @NotNull
    @JsonProperty
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

    public List<Long> getOpenCost() {
        return openCost;
    }

    public void setOpenCost(List<Long> openCost) {
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

    public Boolean getShowDesc() {
        return showDesc;
    }

    public void setShowDesc(Boolean showDesc) {
        this.showDesc = showDesc;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artifact artifact = (Artifact) o;

        if (id != null ? !id.equals(artifact.id) : artifact.id != null) return false;
        if (name != null ? !name.equals(artifact.name) : artifact.name != null) return false;
        if (mainCode != null ? !mainCode.equals(artifact.mainCode) : artifact.mainCode != null) return false;
        if (subCode != null ? !subCode.equals(artifact.subCode) : artifact.subCode != null) return false;
        if (grade != null ? !grade.equals(artifact.grade) : artifact.grade != null) return false;
        if (maxLv != null ? !maxLv.equals(artifact.maxLv) : artifact.maxLv != null) return false;
        if (desc != null ? !desc.equals(artifact.desc) : artifact.desc != null) return false;
        if (openCost != null ? !openCost.equals(artifact.openCost) : artifact.openCost != null) return false;
        if (skillCode1 != null ? !skillCode1.equals(artifact.skillCode1) : artifact.skillCode1 != null) return false;
        if (ability1 != null ? !ability1.equals(artifact.ability1) : artifact.ability1 != null) return false;
        if (ability11 != null ? !ability11.equals(artifact.ability11) : artifact.ability11 != null) return false;
        if (ability21 != null ? !ability21.equals(artifact.ability21) : artifact.ability21 != null) return false;
        if (skillCode2 != null ? !skillCode2.equals(artifact.skillCode2) : artifact.skillCode2 != null) return false;
        if (ability2 != null ? !ability2.equals(artifact.ability2) : artifact.ability2 != null) return false;
        if (ability12 != null ? !ability12.equals(artifact.ability12) : artifact.ability12 != null) return false;
        if (ability22 != null ? !ability22.equals(artifact.ability22) : artifact.ability22 != null) return false;
        if (skillCode3 != null ? !skillCode3.equals(artifact.skillCode3) : artifact.skillCode3 != null) return false;
        if (ability3 != null ? !ability3.equals(artifact.ability3) : artifact.ability3 != null) return false;
        if (upgradeCostType != null ? !upgradeCostType.equals(artifact.upgradeCostType) : artifact.upgradeCostType != null)
            return false;
        if (showDesc != null ? !showDesc.equals(artifact.showDesc) : artifact.showDesc != null) return false;
        return sortId != null ? sortId.equals(artifact.sortId) : artifact.sortId == null;
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

    @Override
    public String toString() {
        return "Artifact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mainCode=" + mainCode +
                ", subCode=" + subCode +
                ", grade=" + grade +
                ", maxLv=" + maxLv +
                ", desc='" + desc + '\'' +
                ", openCost=" + openCost +
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
                ", showDesc=" + showDesc +
                ", sortId=" + sortId +
                '}';
    }
}
