package com.macgregor.ef.model.canonical;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "pet_skill")
@ApiModel(value="PetSkill", description="PetSkill model describing pet skills in Endless Frontier")
public class PetSkill {

    @Id
    @Column(name="id", nullable = false)
    @NotNull
    @JsonProperty
    private Integer id;

    @Column(name = "named_id", nullable = false)
    @NotBlank
    @JsonProperty
    private String namedId;

    @Column(name = "name")
    @JsonProperty
    @ApiModelProperty(value="This field seems to be rarely used and usually, but not always, in english with no provided translations. Would not rely on it.")
    private String name;

    @Column(name = "sub")
    @JsonProperty
    private Boolean sub;

    @Column(name = "type")
    @JsonProperty
    private String type;

    @Column(name = "desc", length = 1000)
    @JsonProperty
    private String desc;

    @ElementCollection
    @CollectionTable
    @Column(name = "misc")
    @JsonProperty
    private List<Integer> misc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamedId() {
        return namedId;
    }

    public void setNamedId(String namedId) {
        this.namedId = namedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSub() {
        return sub;
    }

    public void setSub(Boolean sub) {
        this.sub = sub;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Integer> getMisc() {
        return misc;
    }

    public void setMisc(List<Integer> misc) {
        this.misc = misc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PetSkill petSkill = (PetSkill) o;

        if (id != null ? !id.equals(petSkill.id) : petSkill.id != null) return false;
        if (namedId != null ? !namedId.equals(petSkill.namedId) : petSkill.namedId != null) return false;
        if (name != null ? !name.equals(petSkill.name) : petSkill.name != null) return false;
        if (sub != null ? !sub.equals(petSkill.sub) : petSkill.sub != null) return false;
        if (type != null ? !type.equals(petSkill.type) : petSkill.type != null) return false;
        if (desc != null ? !desc.equals(petSkill.desc) : petSkill.desc != null) return false;
        return misc != null ? misc.equals(petSkill.misc) : petSkill.misc == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (namedId != null ? namedId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sub != null ? sub.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (misc != null ? misc.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PetSkill{" +
                "id=" + id +
                ", namedId='" + namedId + '\'' +
                ", name='" + name + '\'' +
                ", sub=" + sub +
                ", type='" + type + '\'' +
                ", desc='" + desc + '\'' +
                ", misc=" + misc +
                '}';
    }
}
