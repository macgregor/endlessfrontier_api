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
@Table(name = "pet")
@ApiModel(value="Pet", description="Model describing pets in Endless Frontier (e.g. Mambo, Lime, etc.)")
public class Pet {

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

    @Column(name = "class_name", nullable = false)
    @NotBlank
    @JsonProperty
    @ApiModelProperty(value="This is not the name of the pet, though it is close, sometimes identical. Not sure exactly what it is for.")
    private String className;

    @Column(name = "tribe", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Id of pet tribe", allowableValues = "1 (human), 2 (elf), 3 (undead), 4 (orc)")
    private Integer tribe;

    @Column(name = "type", nullable = false)
    @NotBlank
    @JsonProperty
    @ApiModelProperty(value="Type of pet, doesnt seem to be viewable in game.", allowableValues="fire,neutral,wind,light,ground,dark,water")
    private String type;

    @Column(name = "rank", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Represented as stars (*) in app.", allowableValues = "1,2,3,4,5")
    private Integer rank;

    @Column(name = "skill1", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="PetSkill.id of pets first skill.")
    private Integer skill1;

    @ElementCollection
    @CollectionTable
    @Column(name = "value1", nullable = false)
    @NotEmpty
    @JsonProperty
    @ApiModelProperty(value="Modifier increasing skill1 effectiveness for each pet rank, e.g. value1[0] is the modifier at rank 1, value1[1] is rank 2 and so on.")
    private List<Float> value1;

    @Column(name = "skill2", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="PetSkill.id of pets second skill unlocked at rank 3.")
    private Integer skill2;

    @ElementCollection
    @CollectionTable
    @Column(name = "value2", nullable = false)
    @NotEmpty
    @JsonProperty
    @ApiModelProperty(value="Modifier increasing skill2 effectiveness for each pet rank, e.g. value2[0] is the modifier at rank 1, value2[1] is rank 2 and so on.")
    private List<Integer> value2;

    @Column(name = "master_skill", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="PetSkill.id of pets master skill unlocked at rank 5.")
    private Integer masterSkill;

    @ElementCollection
    @CollectionTable
    @Column(name = "value3", nullable = false)
    @NotEmpty
    @JsonProperty
    @ApiModelProperty(value="Modifier increasing master_skill effectiveness. Interestingly most of the time this is all 0's except for certain pure medal pets (e.g. Hallokin) and the outland battle pets.")
    private List<Integer> value3;

    @Column(name = "couple", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Unit.id of the hero couple of the pet. A value of -1 indicates there is no couple.")
    private Integer couple;

    @ElementCollection
    @CollectionTable
    @Column(name = "pet_points_per_rank", nullable = false)
    @NotEmpty
    @JsonProperty
    @ApiModelProperty(value="Referred to as Pet Points in game.")
    private List<Integer> petPointsPerRank;

    @Column(name = "treasure", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Artifact.id unlocked when pet reaches rank 5. A value of 0 indicates no artifact is associated with this pet.")
    private Integer treasure;


    /***********************************************************
     *  Fields with unknown or unclear meaning below
     ***********************************************************/
    @Column(name = "is_percent", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Meaning unknown. Currently almost every pet has a value of true except for Black Tortoise, Flame Sorceress, Forest Sorceress and some unreleased pets.")
    private Boolean isPercent;

    @Column(name = "is_alpha", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Meaning unknown. Currently almost every pet has a value of false except for Cleo, Artemis, Demeter and some unreleased pets.")
    private Boolean isAlpha;

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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public List<Float> getValue1() {
        return value1;
    }

    public void setValue1(List<Float> value1) {
        this.value1 = value1;
    }

    public Integer getSkill2() {
        return skill2;
    }

    public void setSkill2(Integer skill2) {
        this.skill2 = skill2;
    }

    public List<Integer> getValue2() {
        return value2;
    }

    public void setValue2(List<Integer> value2) {
        this.value2 = value2;
    }

    public Integer getMasterSkill() {
        return masterSkill;
    }

    public void setMasterSkill(Integer masterSkill) {
        this.masterSkill = masterSkill;
    }

    public List<Integer> getValue3() {
        return value3;
    }

    public void setValue3(List<Integer> value3) {
        this.value3 = value3;
    }

    public Integer getCouple() {
        return couple;
    }

    public void setCouple(Integer couple) {
        this.couple = couple;
    }

    public List<Integer> getPetPointsPerRank() {
        return petPointsPerRank;
    }

    public void setPetPointsPerRank(List<Integer> petPointsPerRank) {
        this.petPointsPerRank = petPointsPerRank;
    }

    public Integer getTreasure() {
        return treasure;
    }

    public void setTreasure(Integer treasure) {
        this.treasure = treasure;
    }

    public Boolean getPercent() {
        return isPercent;
    }

    public void setPercent(Boolean percent) {
        isPercent = percent;
    }

    public Boolean getAlpha() {
        return isAlpha;
    }

    public void setAlpha(Boolean alpha) {
        isAlpha = alpha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        if (id != null ? !id.equals(pet.id) : pet.id != null) return false;
        if (name != null ? !name.equals(pet.name) : pet.name != null) return false;
        if (className != null ? !className.equals(pet.className) : pet.className != null) return false;
        if (tribe != null ? !tribe.equals(pet.tribe) : pet.tribe != null) return false;
        if (type != null ? !type.equals(pet.type) : pet.type != null) return false;
        if (rank != null ? !rank.equals(pet.rank) : pet.rank != null) return false;
        if (skill1 != null ? !skill1.equals(pet.skill1) : pet.skill1 != null) return false;
        if (value1 != null ? !value1.equals(pet.value1) : pet.value1 != null) return false;
        if (skill2 != null ? !skill2.equals(pet.skill2) : pet.skill2 != null) return false;
        if (value2 != null ? !value2.equals(pet.value2) : pet.value2 != null) return false;
        if (masterSkill != null ? !masterSkill.equals(pet.masterSkill) : pet.masterSkill != null) return false;
        if (value3 != null ? !value3.equals(pet.value3) : pet.value3 != null) return false;
        if (couple != null ? !couple.equals(pet.couple) : pet.couple != null) return false;
        if (petPointsPerRank != null ? !petPointsPerRank.equals(pet.petPointsPerRank) : pet.petPointsPerRank != null)
            return false;
        if (treasure != null ? !treasure.equals(pet.treasure) : pet.treasure != null) return false;
        if (isPercent != null ? !isPercent.equals(pet.isPercent) : pet.isPercent != null) return false;
        return isAlpha != null ? isAlpha.equals(pet.isAlpha) : pet.isAlpha == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (tribe != null ? tribe.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (skill1 != null ? skill1.hashCode() : 0);
        result = 31 * result + (value1 != null ? value1.hashCode() : 0);
        result = 31 * result + (skill2 != null ? skill2.hashCode() : 0);
        result = 31 * result + (value2 != null ? value2.hashCode() : 0);
        result = 31 * result + (masterSkill != null ? masterSkill.hashCode() : 0);
        result = 31 * result + (value3 != null ? value3.hashCode() : 0);
        result = 31 * result + (couple != null ? couple.hashCode() : 0);
        result = 31 * result + (petPointsPerRank != null ? petPointsPerRank.hashCode() : 0);
        result = 31 * result + (treasure != null ? treasure.hashCode() : 0);
        result = 31 * result + (isPercent != null ? isPercent.hashCode() : 0);
        result = 31 * result + (isAlpha != null ? isAlpha.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", tribe=" + tribe +
                ", type='" + type + '\'' +
                ", rank=" + rank +
                ", skill1=" + skill1 +
                ", value1=" + value1 +
                ", skill2=" + skill2 +
                ", value2=" + value2 +
                ", masterSkill=" + masterSkill +
                ", value3=" + value3 +
                ", couple=" + couple +
                ", petPointsPeRRank=" + petPointsPerRank +
                ", treasure=" + treasure +
                ", isPercent=" + isPercent +
                ", isAlpha=" + isAlpha +
                '}';
    }
}
