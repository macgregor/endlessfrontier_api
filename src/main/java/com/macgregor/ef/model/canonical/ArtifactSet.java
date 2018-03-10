package com.macgregor.ef.model.canonical;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.macgregor.ef.dataload.annotations.Translate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "artifact_set")
@ApiModel(value="ArtifactSetXML", description="ArtifactSetXML model describing sets of artifacts in Endless Frontier (e.g. Oath of Heaven Set, Bone Wyvern's Arms Set, etc.)")
public class ArtifactSet {

    @Id
    @Column(name="id", nullable = false)
    @NotNull
    @JsonProperty
    private Integer id;

    @Column(name = "title", nullable = false)
    @NotBlank
    @JsonProperty
    private String title;

    @ElementCollection
    @CollectionTable
    @Column(name = "item_list", nullable = false)
    @NotBlank
    @JsonProperty
    private List<Integer> itemList;

    @ElementCollection
    @CollectionTable
    @Column(name="num_set_list", nullable = false)
    @NotBlank
    @JsonProperty
    private List<Integer> numSetList;

    @ElementCollection
    @CollectionTable
    @Column(name = "skill_list", nullable = false)
    @NotBlank
    @JsonProperty
    private List<String> skillList;

    @ElementCollection
    @CollectionTable
    @Column(name = "value_list", nullable = false)
    @NotBlank
    @JsonProperty
    @ApiModelProperty(value="Im not sure how this data is encoded, it seems to be a list of list of int separated by | and #. e.g. 37#3440000|15#2410000|2410000#600")
    private List<List<Integer>> valueList;

    @ElementCollection
    @CollectionTable
    @Column(name = "value_list1", nullable = false)
    @NotBlank
    @JsonProperty
    @ApiModelProperty(value="Im not sure how this data is encoded, it seems to be a list of list of int separated by | and #. e.g. 37#3440000|15#2410000|2410000#600")
    private List<List<Integer>> valueList1;

    @ElementCollection
    @CollectionTable
    @Column(name = "value_list2", nullable = false)
    @NotBlank
    @JsonProperty
    @ApiModelProperty(value="Im not sure how this data is encoded, it seems to be a list of list of int separated by | and #. e.g. 37#3440000|15#2410000|2410000#600")
    private List<List<Integer>> valueList2;

    @Column(name = "desc", nullable = false)
    @NotBlank
    @JsonProperty
    @Translate(key="RELIC_SET_DESC_{id}")
    private String desc;

    @Column(name = "history")
    @JsonProperty
    private String history;

    @Column(name = "show_desc", nullable = false)
    @NotBlank
    @JsonProperty
    private Boolean showDesc;

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

    public List<Integer> getItemList() {
        return itemList;
    }

    public void setItemList(List<Integer> itemList) {
        this.itemList = itemList;
    }

    public List<Integer> getNumSetList() {
        return numSetList;
    }

    public void setNumSetList(List<Integer> numSetList) {
        this.numSetList = numSetList;
    }

    public List<String> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<String> skillList) {
        this.skillList = skillList;
    }

    public List<List<Integer>> getValueList() {
        return valueList;
    }

    public void setValueList(List<List<Integer>> valueList) {
        this.valueList = valueList;
    }

    public List<List<Integer>> getValueList1() {
        return valueList1;
    }

    public void setValueList1(List<List<Integer>> valueList1) {
        this.valueList1 = valueList1;
    }

    public List<List<Integer>> getValueList2() {
        return valueList2;
    }

    public void setValueList2(List<List<Integer>> valueList2) {
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

    public Boolean getShowDesc() {
        return showDesc;
    }

    public void setShowDesc(Boolean showDesc) {
        this.showDesc = showDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtifactSet that = (ArtifactSet) o;

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

    @Override
    public String toString() {
        return "ArtifactSet{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", itemList=" + itemList +
                ", numSetList=" + numSetList +
                ", skillList=" + skillList +
                ", valueList=" + valueList +
                ", valueList1=" + valueList1 +
                ", valueList2=" + valueList2 +
                ", desc='" + desc + '\'' +
                ", history='" + history + '\'' +
                ", showDesc=" + showDesc +
                '}';
    }
}
