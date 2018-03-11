package com.macgregor.ef.model.canonical;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "artifact_set")
@ApiModel(value="ArtifactSet", description="Model describing sets of artifacts in Endless Frontier (e.g. Oath of Heaven Set, Bone Wyvern's Arms Set, etc.). Artifacts that make up the set will be references by id in the itemList field.")
public class ArtifactSet {

    @Id
    @Column(name="id", nullable = false)
    @NotNull
    @JsonProperty
    private Integer id;

    @Column(name = "name", nullable = false)
    @NotBlank
    @JsonProperty
    @ApiModelProperty(value="Display name translated from Korean. Not guaranteed to be in english, there are cases where no translation is provided.")
    private String name;

    @Column(name = "desc", nullable = false)
    @NotBlank
    @JsonProperty
    @ApiModelProperty(value="Display name translated from Korean. Not guaranteed to be in english, there are cases where no translation is provided.")
    private String desc;

    @ElementCollection
    @CollectionTable
    @Column(name = "item_list", nullable = false)
    @NotEmpty
    @JsonProperty
    @ApiModelProperty(value="List of Artifact.id listing the artifacts that make up the set.")
    private List<Integer> itemList;

    @ElementCollection
    @CollectionTable
    @Column(name="num_pieces_requied_for_set_bonus_tiers", nullable = false)
    @NotEmpty
    @JsonProperty
    @ApiModelProperty(value="List containing number of pieces required to get bonus. e.g. Dark Knight's Arms set gets bouses as 2, 4 and 6 pieces so this field would contain [2,4,6].")
    private List<Integer> numPiecesRequiedForSetBonusTiers;

    @ElementCollection
    @CollectionTable
    @Column(name = "ability_codes", nullable = false)
    @NotEmpty
    @JsonProperty
    @ApiModelProperty(value="Lookup keys for abilities associated with an artifact set. Lookup table not currently available.")
    private List<String> abilityCodes;

    @Column(name = "show_desc", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Whether to hide the artifact description by default, e.g. Winged Boots of Hermes abilities are hidden until you unlock it in game.")
    private Boolean showDesc;

    /***********************************************************
     *  Fields with unknown or unclear meaning below
     ***********************************************************/
    @ElementCollection
    @CollectionTable
    @Column(name = "value_list", nullable = false)
    @NotEmpty
    @JsonProperty
    @ApiModelProperty(value="Meaning unknown. Probably modifieds for skillList. I havent found an elegant way or parsing/storing/connecting the data yet, it seems to be a list of list of int separated by | and #. e.g. 37#3440000|15#2410000|2410000#600")
    private List<String> valueList;

    @ElementCollection
    @CollectionTable
    @Column(name = "value_list1", nullable = false)
    @NotEmpty
    @JsonProperty
    @ApiModelProperty(value="Meaning unknown. Probably modifieds for skillList. I havent found an elegant way or parsing/storing/connecting the data yet, it seems to be a list of list of int separated by | and #. e.g. 37#3440000|15#2410000|2410000#600")
    private List<String> valueList1;

    @ElementCollection
    @CollectionTable
    @Column(name = "value_list2", nullable = false)
    @NotEmpty
    @JsonProperty
    @ApiModelProperty(value="Meaning unknown. Probably modifieds for skillList. I havent found an elegant way or parsing/storing/connecting the data yet, it seems to be a list of list of int separated by | and #. e.g. 37#3440000|15#2410000|2410000#600")
    private List<String> valueList2;

    @Column(name = "history")
    @JsonProperty
    @ApiModelProperty(value="No idea what this is used for, it is always blank.", allowEmptyValue = true)
    private String history;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Integer> getItemList() {
        return itemList;
    }

    public void setItemList(List<Integer> itemList) {
        this.itemList = itemList;
    }

    public List<Integer> getNumPiecesRequiedForSetBonusTiers() {
        return numPiecesRequiedForSetBonusTiers;
    }

    public void setNumPiecesRequiedForSetBonusTiers(List<Integer> numPiecesRequiedForSetBonusTiers) {
        this.numPiecesRequiedForSetBonusTiers = numPiecesRequiedForSetBonusTiers;
    }

    public List<String> getAbilityCodes() {
        return abilityCodes;
    }

    public void setAbilityCodes(List<String> abilityCodes) {
        this.abilityCodes = abilityCodes;
    }

    public Boolean getShowDesc() {
        return showDesc;
    }

    public void setShowDesc(Boolean showDesc) {
        this.showDesc = showDesc;
    }

    public List<String> getValueList() {
        return valueList;
    }

    public void setValueList(List<String> valueList) {
        this.valueList = valueList;
    }

    public List<String> getValueList1() {
        return valueList1;
    }

    public void setValueList1(List<String> valueList1) {
        this.valueList1 = valueList1;
    }

    public List<String> getValueList2() {
        return valueList2;
    }

    public void setValueList2(List<String> valueList2) {
        this.valueList2 = valueList2;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtifactSet that = (ArtifactSet) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (itemList != null ? !itemList.equals(that.itemList) : that.itemList != null) return false;
        if (numPiecesRequiedForSetBonusTiers != null ? !numPiecesRequiedForSetBonusTiers.equals(that.numPiecesRequiedForSetBonusTiers) : that.numPiecesRequiedForSetBonusTiers != null)
            return false;
        if (abilityCodes != null ? !abilityCodes.equals(that.abilityCodes) : that.abilityCodes != null) return false;
        if (showDesc != null ? !showDesc.equals(that.showDesc) : that.showDesc != null) return false;
        if (valueList != null ? !valueList.equals(that.valueList) : that.valueList != null) return false;
        if (valueList1 != null ? !valueList1.equals(that.valueList1) : that.valueList1 != null) return false;
        if (valueList2 != null ? !valueList2.equals(that.valueList2) : that.valueList2 != null) return false;
        return history != null ? history.equals(that.history) : that.history == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (itemList != null ? itemList.hashCode() : 0);
        result = 31 * result + (numPiecesRequiedForSetBonusTiers != null ? numPiecesRequiedForSetBonusTiers.hashCode() : 0);
        result = 31 * result + (abilityCodes != null ? abilityCodes.hashCode() : 0);
        result = 31 * result + (showDesc != null ? showDesc.hashCode() : 0);
        result = 31 * result + (valueList != null ? valueList.hashCode() : 0);
        result = 31 * result + (valueList1 != null ? valueList1.hashCode() : 0);
        result = 31 * result + (valueList2 != null ? valueList2.hashCode() : 0);
        result = 31 * result + (history != null ? history.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ArtifactSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", itemList=" + itemList +
                ", numPiecesRequiedForSetBonusTiers=" + numPiecesRequiedForSetBonusTiers +
                ", abilityCodes=" + abilityCodes +
                ", showDesc=" + showDesc +
                ", valueList=" + valueList +
                ", valueList1=" + valueList1 +
                ", valueList2=" + valueList2 +
                ", history='" + history + '\'' +
                '}';
    }
}
