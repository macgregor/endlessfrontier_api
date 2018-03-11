package com.macgregor.ef.model.canonical;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "unit_skill")
@ApiModel(value="UnitSkill", description="Model describing unit skill in Endless Frontier. These skills will be referenced by id in the Unit model.")
public class UnitSkill {

    @Id
    @Column(name="id", nullable = false)
    @NotNull
    @JsonProperty
    private Integer id;

    @Column(name = "desc", nullable = false)
    @NotBlank
    @JsonProperty
    @ApiModelProperty(value="Display description translated from Korean. Not guaranteed to be in english, there are cases where no translation is provided.")
    private String desc;

    /***********************************************************
     *  Fields with unknown or unclear meaning below
     ***********************************************************/
    @Column(name = "skill_code", nullable = false)
    @NotBlank
    @JsonProperty
    @ApiModelProperty(value="Meaning unknown. Probably a key for a lookup table not currently available.")
    private String skillCode;

    @Column(name="img_index", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Images are not available through this API, I do not have the data.")
    private Integer imgIndex;

    @Column(name="base_value", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Meaning unknown. Appears to be 1 in all but one case (unit skill id 65, \"Mid-air units attack yourself\")", allowableValues = "1,-1")
    private Integer baseValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitSkill unitSkill = (UnitSkill) o;

        if (id != null ? !id.equals(unitSkill.id) : unitSkill.id != null) return false;
        if (desc != null ? !desc.equals(unitSkill.desc) : unitSkill.desc != null) return false;
        if (skillCode != null ? !skillCode.equals(unitSkill.skillCode) : unitSkill.skillCode != null) return false;
        if (imgIndex != null ? !imgIndex.equals(unitSkill.imgIndex) : unitSkill.imgIndex != null) return false;
        return baseValue != null ? baseValue.equals(unitSkill.baseValue) : unitSkill.baseValue == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (skillCode != null ? skillCode.hashCode() : 0);
        result = 31 * result + (imgIndex != null ? imgIndex.hashCode() : 0);
        result = 31 * result + (baseValue != null ? baseValue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UnitSkill{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", skillCode='" + skillCode + '\'' +
                ", imgIndex=" + imgIndex +
                ", baseValue=" + baseValue +
                '}';
    }
}
