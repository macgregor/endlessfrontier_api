package com.macgregor.ef.model.ekkor;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.macgregor.ef.dataload.annotations.CanonicalField;
import com.macgregor.ef.dataload.annotations.CanonicalModel;
import com.macgregor.ef.dataload.annotations.Translate;
import com.macgregor.ef.model.canonical.PetSkill;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@JacksonXmlRootElement(localName = "petSkill")
@CanonicalModel(type= PetSkill.class)
public class PetSkillXML extends AbstractXMLModel {

    @NotNull
    @CanonicalField
    @JacksonXmlProperty(localName = "kindNum")
    private Integer id;

    @NotBlank
    @CanonicalField
    @JacksonXmlProperty(localName = "id")
    private String namedId;

    @CanonicalField
    @JacksonXmlProperty(localName = "name")
    private String name;

    @CanonicalField
    @JacksonXmlProperty(localName = "sub")
    private String sub; //TODO: convert to boolean

    @CanonicalField
    @JacksonXmlProperty(localName = "type")
    private String type;

    @CanonicalField
    @Translate(key="PET_SKILL_DESC_{id}")
    @JacksonXmlProperty(localName = "desc")
    private String desc;

    @CanonicalField
    @JacksonXmlProperty(localName = "misc")
    private String misc;

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

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
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

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    @Override
    public String toString() {
        return "PetSkillXML{" +
                "id=" + id +
                ", namedId='" + namedId + '\'' +
                ", name='" + name + '\'' +
                ", sub='" + sub + '\'' +
                ", type='" + type + '\'' +
                ", desc='" + desc + '\'' +
                ", misc='" + misc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PetSkillXML petSkillXML = (PetSkillXML) o;

        if (id != null ? !id.equals(petSkillXML.id) : petSkillXML.id != null) return false;
        if (namedId != null ? !namedId.equals(petSkillXML.namedId) : petSkillXML.namedId != null) return false;
        if (name != null ? !name.equals(petSkillXML.name) : petSkillXML.name != null) return false;
        if (sub != null ? !sub.equals(petSkillXML.sub) : petSkillXML.sub != null) return false;
        if (type != null ? !type.equals(petSkillXML.type) : petSkillXML.type != null) return false;
        if (desc != null ? !desc.equals(petSkillXML.desc) : petSkillXML.desc != null) return false;
        return misc != null ? misc.equals(petSkillXML.misc) : petSkillXML.misc == null;
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
}
