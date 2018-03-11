package com.macgregor.ef.model.canonical;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "translation")
@ApiModel(value="Translation", description="Table containing Korean to English translation data. All data is already translated so not sure what value this will provide.")
public class Translation {

    @Id
    @Column(name="id", nullable = false)
    @NotBlank
    @JsonProperty
    @ApiModelProperty(value="Lookup key generally in the form SOME_KEY_PREFIX_{id}, e.g. PET_SKILL_DESC_2.")
    private String id;

    @Column(name="value", nullable = true, length = 2000)
    @JsonProperty
    @ApiModelProperty(value="English translation provided by Ekkor.")
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

        Translation that = (Translation) o;

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
