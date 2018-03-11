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
@Table(name = "unit")
@ApiModel(value="Unit", description="Model describing units in Endless Frontier (e.g. infantry, Ice Spirit, Sword Dancer, etc.). This also contains the data on non-shop units like dungeon bosses, guild raid bosses, outland battle, etc. Also of note, Senior units seem to be distinct entities, e.g. Lich is id 128 and senior Lich is 129.")
public class Unit {

    @Id
    @Column(name="id", nullable = false)
    @NotNull
    @JsonProperty
    private Integer id;

    @Column(name = "tribe", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Id of unit tribe", allowableValues = "1 (human), 2 (elf), 3 (undead), 4 (orc), 5 (dungeon")
    private Integer tribe;

    @Column(name = "name", nullable = false)
    @NotBlank
    @JsonProperty
    @ApiModelProperty(value="Display name translated from Korean. Not guaranteed to be in english, there are cases where no translation is provided.")
    private String name;

    @Column(name = "message", nullable = false, length = 5000)
    @NotBlank
    @JsonProperty
    @ApiModelProperty(value="Display message translated from Korean. Not guaranteed to be in english, there are cases where no translation is provided.", allowEmptyValue = true)
    private String message;

    @Column(name = "rank", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Represented as stars (*) in game, e.g. Priest is rank 5, Sr. Priest is rank 6.", allowableValues = "1,2,3,4,5,6")
    private Integer rank;

    @Column(name = "sex", nullable = false)
    @NotBlank
    @JsonProperty
    @ApiModelProperty(value="Sex of unit: male, female or neutral.", allowableValues = "M,F,N")
    private String sex;

    @Column(name = "unit_shop_medal_cost", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Medal cost to buy unit from unit shop or time shop. Cost of 0 indicates it is not purchaseable", allowableValues = "20000, 15000, 8000, 4000, 1600, 1200, 900, 700, 400, 300, 80, 0")
    private Integer unitShopMedalCost;

    @Column(name = "unit_shop_gem_cost", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Gem cost of the unit in the unit shop. Values of 0 and -1 indicate unit isnt available to purchase with gems.", allowableValues = "-1, 0, 700, 3000, 5700")
    private Integer unitShopGemCost;

    @Column(name = "evolve_gem_cost", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Gem cost to upgrade unit. A value of -1 indicates unit cannot be evolved.", allowableValues = "-1, 200, 300, 500, 2000, 2800")
    private Integer evolveGemCost;

    @Column(name = "honor_shop_coin_cost", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Honor coin cose to purchase unit from honor shop.", allowableValues = "0, 4400")
    private Integer honorShopCoinCost;

    @Column(name = "evolution_unit_id", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Unit.id that this unit will evolve into. A value of -1 indicates no evolution is available.")
    private Integer evolutionUnitId;

    @Column(name = "is_air_unit", nullable = false)
    @NotNull
    @JsonProperty
    private Boolean isAirUnit;

    @Column(name = "ground_air", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="I think this indicates if an air unit can attack ground units.")
    private Boolean groundAir;

    @Column(name = "can_detect_cloaked", nullable = false)
    @NotNull
    @JsonProperty
    private Boolean canDetectCloaked;

    @Column(name = "is_cloaking", nullable = false)
    @NotNull
    @JsonProperty
    private Boolean isCloaking;

    @Column(name = "is_honor", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Whether the unit is currently, or ever was, an honor shop unit.")
    private Boolean isHonor;

    @Column(name = "honor_rotation_number", nullable = false)
    @NotNull
    @JsonProperty
    private Integer honorRotationNumber;

    @Column(name = "max_trans_level", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Number or trans levels available to unit, either 0 (cannot trans) or 3.", allowableValues = "0,3")
    private Integer maxTransLevel;

    @Column(name = "show_book", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Whether or not to show the unit in the unit book. Set to false to unreleased units and dungeon units.")
    private Boolean showBook;

    @Column(name = "init_hp", nullable = false)
    @NotNull
    @JsonProperty
    private Float initHp;

    @Column(name = "inc_hp", nullable = false)
    @NotNull
    @JsonProperty
    private Float incHp;

    @Column(name = "init_damage", nullable = false)
    @NotNull
    @JsonProperty
    private Float initDamage;

    @Column(name = "inc_damage", nullable = false)
    @NotNull
    @JsonProperty
    private Float incDamage;

    @Column(name = "init_phy_def", nullable = false)
    @NotNull
    @JsonProperty
    private Float initPhyDef;

    @Column(name = "inc_phy_def", nullable = false)
    @NotNull
    @JsonProperty
    private Float incPhyDef;

    @Column(name = "init_mag_def", nullable = false)
    @NotNull
    @JsonProperty
    private Float initMagDef;

    @Column(name = "inc_mag_def", nullable = false)
    @NotNull
    @JsonProperty
    private Float incMagDef;

    @Column(name = "move_speed", nullable = false)
    @NotNull
    @JsonProperty
    private Float moveSpeed;

    @Column(name = "revive_time", nullable = false)
    @NotNull
    @JsonProperty
    private Integer reviveTime;

    @Column(name = "evade_percent", nullable = false)
    @NotNull
    @JsonProperty
    private Float evadePercent;

    @Column(name = "block_percent", nullable = false)
    @NotNull
    @JsonProperty
    private Float blockPercent;

    @Column(name = "num_unit_block", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Exact meaning unclear, seems to range from 0 to 3, with Sr. Golem and Sr. Bigfoot having the most at 3", allowableValues = "0,1,2,3")
    private Integer numUnitBlock;

    @Column(name = "critical_percent", nullable = false)
    @NotNull
    @JsonProperty
    private Float criticalPercent;

    @Column(name = "critical_damage", nullable = false)
    @NotNull
    @JsonProperty
    private Float criticalDamage;

    @Column(name = "splash_range", nullable = false)
    @NotNull
    @JsonProperty
    private Integer splashRange;

    @Column(name = "splash_damage", nullable = false)
    @NotNull
    @JsonProperty
    private Float splashDamage;

    @Column(name = "basic_attack_type", nullable = false)
    @NotBlank
    @JsonProperty
    @ApiModelProperty(allowableValues = "melee, range, rangeGround")
    private String basicAttackType;

    @Column(name = "basic_attack_damage_type", nullable = false)
    @NotBlank
    @JsonProperty
    @ApiModelProperty(allowableValues = "magical, physical")
    private String basicAttackDamageType;

    @Column(name = "basic_attack_speed", nullable = false)
    @NotNull
    @JsonProperty
    private Integer basicAttackSpeed;

    @Column(name = "basic_attack_range", nullable = false)
    @NotNull
    @JsonProperty
    private Integer basicAttackRange;

    @Column(name = "skill_attack_type", nullable = false)
    @NotBlank
    @JsonProperty
    @ApiModelProperty(allowableValues = "N, melee, range, rangeGround")
    private String skillAttackType;

    @Column(name = "skill_attack_damage_type", nullable = false)
    @NotBlank
    @JsonProperty
    @ApiModelProperty(allowableValues = "N, magical, physical")
    private String skillAttackDamageType;

    @Column(name = "skill_attack_range", nullable = false)
    @NotNull
    @JsonProperty
    private Integer skillAttackRange;

    @Column(name = "skill_attack_speed", nullable = false)
    @NotNull
    @JsonProperty
    private Integer skillAttackSpeed;

    @ElementCollection
    @CollectionTable
    @Column(name = "unit_skill_list", nullable = false)
    @NotEmpty
    @JsonProperty
    @ApiModelProperty(value="List of UnitSkill.id that make up the skills listed under \"Unit Skill\" ")
    private List<Integer> unitSkillList;

    @ElementCollection
    @CollectionTable
    @Column(name = "unit_skill_list_modifiers", nullable = false)
    @NotEmpty
    @JsonProperty
    @ApiModelProperty(value="Modifiers for skillList. Shows as the percentage increase under \"Unit Skill\", e.g. skillList [60], powerList[24] will show as \"Quest Gold Increase: 24%\"")
    private List<Integer> unitSkillListModifiers;

    @ElementCollection
    @CollectionTable
    @Column(name = "trans_material_t1", nullable = false)
    @NotEmpty
    @JsonProperty
    @ApiModelProperty(value="Unit materials required for transing from Sr to t1. List of Unit.id. Or, a list of size 1 with the only element being 0 for units ineligible for transing.")
    private List<Integer> transMaterialT1;

    @ElementCollection
    @CollectionTable
    @Column(name = "trans_material_t2", nullable = false)
    @NotEmpty
    @JsonProperty
    @ApiModelProperty(value="Unit materials required for transing from t1 to t2. List of Unit.id. Or, a list of size 1 with the only element being 0 for units ineligible for transing.")
    private List<Integer> transMaterialT2;

    @ElementCollection
    @CollectionTable
    @Column(name = "trans_material_t3", nullable = false)
    @NotEmpty
    @JsonProperty
    @ApiModelProperty(value="Unit materials required for transing from t2 to t3. List of Unit.id. Or, a list of size 1 with the only element being 0 for units ineligible for transing.")
    private List<Integer> transMaterialT3;

    @Column(name = "medal_buff", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Revive medal buff percentage provided by unit, i.e. \"Increase medals earned at the time of revival by 5%.\"")
    private Integer medalBuff;

    @Column(name = "offline_march_speed_buff", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Offline march speed provided by unit, i.e. \"Increase of offline march speed by 5%.\"")
    private Float offlineMarchSpeedBuff;

    /***********************************************************
     *  Fields with unknown or unclear meaning below
     ***********************************************************/
    @Column(name = "class_name", nullable = false)
    @NotBlank
    @JsonProperty
    @ApiModelProperty(value="This is not the name of the unit, though it is close, sometimes identical. Not sure exactly what it is for.")
    private String className;

    @Column(name = "rare", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Meaning unknown.")
    private Integer rare;

    @Column(name = "size", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Meaning unknown.", allowableValues = "1,2,3,4")
    private Integer size;

    @Column(name = "special_skill", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="I think this is supposed to be \"Skill Attack\" under \"Unit Details\" but data is missing from my source files.", allowableValues = "1")
    private Integer specialSkill;

    @Column(name = "passive_skill", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="I think this is supposed to be \"Special Ability\" under \"Unit Details\" but data is missing from my source files.", allowableValues = "0, 1, 2, 3, 4, 5, 6, 7")
    private Integer passiveSkill;

    @Column(name = "bloody", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Probably something to do with graphics on death. Almost always true except for  subset of undead.")
    private Boolean bloody;

    @Column(name = "explode_die", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Probably something to do with graphics on death. Always seems to but true.")
    private Boolean explodeDie;

    @Column(name = "has_skill", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Seems to almost always be true, there are some dungeon units and Skeleton unit who have it set to false.")
    private Boolean hasSkill;

    @Column(name = "des", nullable = false)
    @NotBlank
    @JsonProperty
    @ApiModelProperty(value="Meaning unknown. Always seems to be \"AA\"", allowableValues = "AA")
    private String des;

    @Column(name = "ortho_grade", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Meaning unknown.")
    private Boolean orthoGrade;

    @Column(name = "shop", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Meaning unclear. Might have something to do with what shop (or what section of a shop) the unit appears in. 0 = no hop, 2 = current honor shop units, 4 = previous honor shop units, 1 = everything else. However it also includes Sr. Units which are never purchaseable.", allowableValues = "0, 1, 2, 4")
    private Integer shop;

    @Column(name = "rating_position", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Meaning unknown.")
    private Integer ratingPosition;

    @Column(name = "jewel_buff", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Meaning unknown. Always set to 0", allowableValues = "0")
    private Integer jewelBuff;

    @Column(name = "offline_time", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Meaning unclear. Seems to be unique to Sr. Succubus.")
    private Integer offlineTime;

    @Column(name = "has_heart", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Meaning unknown. Probably determines if some skill effects a unit.")
    private Boolean hasHeart;

    @Column(name = "medal_buff_from_pet", nullable = false)
    @NotNull
    @JsonProperty
    @ApiModelProperty(value="Meaning unknown. Appears to be unused, all units have it set to 0.")
    private Integer medalBuffFromPet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTribe() {
        return tribe;
    }

    public void setTribe(Integer tribe) {
        this.tribe = tribe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getUnitShopMedalCost() {
        return unitShopMedalCost;
    }

    public void setUnitShopMedalCost(Integer unitShopMedalCost) {
        this.unitShopMedalCost = unitShopMedalCost;
    }

    public Integer getUnitShopGemCost() {
        return unitShopGemCost;
    }

    public void setUnitShopGemCost(Integer unitShopGemCost) {
        this.unitShopGemCost = unitShopGemCost;
    }

    public Integer getEvolveGemCost() {
        return evolveGemCost;
    }

    public void setEvolveGemCost(Integer evolveGemCost) {
        this.evolveGemCost = evolveGemCost;
    }

    public Integer getHonorShopCoinCost() {
        return honorShopCoinCost;
    }

    public void setHonorShopCoinCost(Integer honorShopCoinCost) {
        this.honorShopCoinCost = honorShopCoinCost;
    }

    public Integer getEvolutionUnitId() {
        return evolutionUnitId;
    }

    public void setEvolutionUnitId(Integer evolutionUnitId) {
        this.evolutionUnitId = evolutionUnitId;
    }

    public Boolean getAirUnit() {
        return isAirUnit;
    }

    public void setAirUnit(Boolean airUnit) {
        isAirUnit = airUnit;
    }

    public Boolean getGroundAir() {
        return groundAir;
    }

    public void setGroundAir(Boolean groundAir) {
        this.groundAir = groundAir;
    }

    public Boolean getCanDetectCloaked() {
        return canDetectCloaked;
    }

    public void setCanDetectCloaked(Boolean canDetectCloaked) {
        this.canDetectCloaked = canDetectCloaked;
    }

    public Boolean getCloaking() {
        return isCloaking;
    }

    public void setCloaking(Boolean cloaking) {
        isCloaking = cloaking;
    }

    public Boolean getHonor() {
        return isHonor;
    }

    public void setHonor(Boolean honor) {
        isHonor = honor;
    }

    public Integer getHonorRotationNumber() {
        return honorRotationNumber;
    }

    public void setHonorRotationNumber(Integer honorRotationNumber) {
        this.honorRotationNumber = honorRotationNumber;
    }

    public Integer getMaxTransLevel() {
        return maxTransLevel;
    }

    public void setMaxTransLevel(Integer maxTransLevel) {
        this.maxTransLevel = maxTransLevel;
    }

    public Boolean getShowBook() {
        return showBook;
    }

    public void setShowBook(Boolean showBook) {
        this.showBook = showBook;
    }

    public Float getInitHp() {
        return initHp;
    }

    public void setInitHp(Float initHp) {
        this.initHp = initHp;
    }

    public Float getIncHp() {
        return incHp;
    }

    public void setIncHp(Float incHp) {
        this.incHp = incHp;
    }

    public Float getInitDamage() {
        return initDamage;
    }

    public void setInitDamage(Float initDamage) {
        this.initDamage = initDamage;
    }

    public Float getIncDamage() {
        return incDamage;
    }

    public void setIncDamage(Float incDamage) {
        this.incDamage = incDamage;
    }

    public Float getInitPhyDef() {
        return initPhyDef;
    }

    public void setInitPhyDef(Float initPhyDef) {
        this.initPhyDef = initPhyDef;
    }

    public Float getIncPhyDef() {
        return incPhyDef;
    }

    public void setIncPhyDef(Float incPhyDef) {
        this.incPhyDef = incPhyDef;
    }

    public Float getInitMagDef() {
        return initMagDef;
    }

    public void setInitMagDef(Float initMagDef) {
        this.initMagDef = initMagDef;
    }

    public Float getIncMagDef() {
        return incMagDef;
    }

    public void setIncMagDef(Float incMagDef) {
        this.incMagDef = incMagDef;
    }

    public Float getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(Float moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public Integer getReviveTime() {
        return reviveTime;
    }

    public void setReviveTime(Integer reviveTime) {
        this.reviveTime = reviveTime;
    }

    public Float getEvadePercent() {
        return evadePercent;
    }

    public void setEvadePercent(Float evadePercent) {
        this.evadePercent = evadePercent;
    }

    public Float getBlockPercent() {
        return blockPercent;
    }

    public void setBlockPercent(Float blockPercent) {
        this.blockPercent = blockPercent;
    }

    public Integer getNumUnitBlock() {
        return numUnitBlock;
    }

    public void setNumUnitBlock(Integer numUnitBlock) {
        this.numUnitBlock = numUnitBlock;
    }

    public Float getCriticalPercent() {
        return criticalPercent;
    }

    public void setCriticalPercent(Float criticalPercent) {
        this.criticalPercent = criticalPercent;
    }

    public Float getCriticalDamage() {
        return criticalDamage;
    }

    public void setCriticalDamage(Float criticalDamage) {
        this.criticalDamage = criticalDamage;
    }

    public Integer getSplashRange() {
        return splashRange;
    }

    public void setSplashRange(Integer splashRange) {
        this.splashRange = splashRange;
    }

    public Float getSplashDamage() {
        return splashDamage;
    }

    public void setSplashDamage(Float splashDamage) {
        this.splashDamage = splashDamage;
    }

    public String getBasicAttackType() {
        return basicAttackType;
    }

    public void setBasicAttackType(String basicAttackType) {
        this.basicAttackType = basicAttackType;
    }

    public String getBasicAttackDamageType() {
        return basicAttackDamageType;
    }

    public void setBasicAttackDamageType(String basicAttackDamageType) {
        this.basicAttackDamageType = basicAttackDamageType;
    }

    public Integer getBasicAttackSpeed() {
        return basicAttackSpeed;
    }

    public void setBasicAttackSpeed(Integer basicAttackSpeed) {
        this.basicAttackSpeed = basicAttackSpeed;
    }

    public Integer getBasicAttackRange() {
        return basicAttackRange;
    }

    public void setBasicAttackRange(Integer basicAttackRange) {
        this.basicAttackRange = basicAttackRange;
    }

    public String getSkillAttackType() {
        return skillAttackType;
    }

    public void setSkillAttackType(String skillAttackType) {
        this.skillAttackType = skillAttackType;
    }

    public String getSkillAttackDamageType() {
        return skillAttackDamageType;
    }

    public void setSkillAttackDamageType(String skillAttackDamageType) {
        this.skillAttackDamageType = skillAttackDamageType;
    }

    public Integer getSkillAttackRange() {
        return skillAttackRange;
    }

    public void setSkillAttackRange(Integer skillAttackRange) {
        this.skillAttackRange = skillAttackRange;
    }

    public Integer getSkillAttackSpeed() {
        return skillAttackSpeed;
    }

    public void setSkillAttackSpeed(Integer skillAttackSpeed) {
        this.skillAttackSpeed = skillAttackSpeed;
    }

    public List<Integer> getUnitSkillList() {
        return unitSkillList;
    }

    public void setUnitSkillList(List<Integer> unitSkillList) {
        this.unitSkillList = unitSkillList;
    }

    public List<Integer> getUnitSkillListModifiers() {
        return unitSkillListModifiers;
    }

    public void setUnitSkillListModifiers(List<Integer> unitSkillListModifiers) {
        this.unitSkillListModifiers = unitSkillListModifiers;
    }

    public List<Integer> getTransMaterialT1() {
        return transMaterialT1;
    }

    public void setTransMaterialT1(List<Integer> transMaterialT1) {
        this.transMaterialT1 = transMaterialT1;
    }

    public List<Integer> getTransMaterialT2() {
        return transMaterialT2;
    }

    public void setTransMaterialT2(List<Integer> transMaterialT2) {
        this.transMaterialT2 = transMaterialT2;
    }

    public List<Integer> getTransMaterialT3() {
        return transMaterialT3;
    }

    public void setTransMaterialT3(List<Integer> transMaterialT3) {
        this.transMaterialT3 = transMaterialT3;
    }

    public Integer getMedalBuff() {
        return medalBuff;
    }

    public void setMedalBuff(Integer medalBuff) {
        this.medalBuff = medalBuff;
    }

    public Float getOfflineMarchSpeedBuff() {
        return offlineMarchSpeedBuff;
    }

    public void setOfflineMarchSpeedBuff(Float offlineMarchSpeedBuff) {
        this.offlineMarchSpeedBuff = offlineMarchSpeedBuff;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getRare() {
        return rare;
    }

    public void setRare(Integer rare) {
        this.rare = rare;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getSpecialSkill() {
        return specialSkill;
    }

    public void setSpecialSkill(Integer specialSkill) {
        this.specialSkill = specialSkill;
    }

    public Integer getPassiveSkill() {
        return passiveSkill;
    }

    public void setPassiveSkill(Integer passiveSkill) {
        this.passiveSkill = passiveSkill;
    }

    public Boolean getBloody() {
        return bloody;
    }

    public void setBloody(Boolean bloody) {
        this.bloody = bloody;
    }

    public Boolean getExplodeDie() {
        return explodeDie;
    }

    public void setExplodeDie(Boolean explodeDie) {
        this.explodeDie = explodeDie;
    }

    public Boolean getHasSkill() {
        return hasSkill;
    }

    public void setHasSkill(Boolean hasSkill) {
        this.hasSkill = hasSkill;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Boolean getOrthoGrade() {
        return orthoGrade;
    }

    public void setOrthoGrade(Boolean orthoGrade) {
        this.orthoGrade = orthoGrade;
    }

    public Integer getShop() {
        return shop;
    }

    public void setShop(Integer shop) {
        this.shop = shop;
    }

    public Integer getRatingPosition() {
        return ratingPosition;
    }

    public void setRatingPosition(Integer ratingPosition) {
        this.ratingPosition = ratingPosition;
    }

    public Integer getJewelBuff() {
        return jewelBuff;
    }

    public void setJewelBuff(Integer jewelBuff) {
        this.jewelBuff = jewelBuff;
    }

    public Integer getOfflineTime() {
        return offlineTime;
    }

    public void setOfflineTime(Integer offlineTime) {
        this.offlineTime = offlineTime;
    }

    public Boolean getHasHeart() {
        return hasHeart;
    }

    public void setHasHeart(Boolean hasHeart) {
        this.hasHeart = hasHeart;
    }

    public Integer getMedalBuffFromPet() {
        return medalBuffFromPet;
    }

    public void setMedalBuffFromPet(Integer medalBuffFromPet) {
        this.medalBuffFromPet = medalBuffFromPet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit unit = (Unit) o;

        if (id != null ? !id.equals(unit.id) : unit.id != null) return false;
        if (tribe != null ? !tribe.equals(unit.tribe) : unit.tribe != null) return false;
        if (name != null ? !name.equals(unit.name) : unit.name != null) return false;
        if (message != null ? !message.equals(unit.message) : unit.message != null) return false;
        if (rank != null ? !rank.equals(unit.rank) : unit.rank != null) return false;
        if (sex != null ? !sex.equals(unit.sex) : unit.sex != null) return false;
        if (unitShopMedalCost != null ? !unitShopMedalCost.equals(unit.unitShopMedalCost) : unit.unitShopMedalCost != null)
            return false;
        if (unitShopGemCost != null ? !unitShopGemCost.equals(unit.unitShopGemCost) : unit.unitShopGemCost != null)
            return false;
        if (evolveGemCost != null ? !evolveGemCost.equals(unit.evolveGemCost) : unit.evolveGemCost != null)
            return false;
        if (honorShopCoinCost != null ? !honorShopCoinCost.equals(unit.honorShopCoinCost) : unit.honorShopCoinCost != null)
            return false;
        if (evolutionUnitId != null ? !evolutionUnitId.equals(unit.evolutionUnitId) : unit.evolutionUnitId != null)
            return false;
        if (isAirUnit != null ? !isAirUnit.equals(unit.isAirUnit) : unit.isAirUnit != null) return false;
        if (groundAir != null ? !groundAir.equals(unit.groundAir) : unit.groundAir != null) return false;
        if (canDetectCloaked != null ? !canDetectCloaked.equals(unit.canDetectCloaked) : unit.canDetectCloaked != null)
            return false;
        if (isCloaking != null ? !isCloaking.equals(unit.isCloaking) : unit.isCloaking != null) return false;
        if (isHonor != null ? !isHonor.equals(unit.isHonor) : unit.isHonor != null) return false;
        if (honorRotationNumber != null ? !honorRotationNumber.equals(unit.honorRotationNumber) : unit.honorRotationNumber != null)
            return false;
        if (maxTransLevel != null ? !maxTransLevel.equals(unit.maxTransLevel) : unit.maxTransLevel != null)
            return false;
        if (showBook != null ? !showBook.equals(unit.showBook) : unit.showBook != null) return false;
        if (initHp != null ? !initHp.equals(unit.initHp) : unit.initHp != null) return false;
        if (incHp != null ? !incHp.equals(unit.incHp) : unit.incHp != null) return false;
        if (initDamage != null ? !initDamage.equals(unit.initDamage) : unit.initDamage != null) return false;
        if (incDamage != null ? !incDamage.equals(unit.incDamage) : unit.incDamage != null) return false;
        if (initPhyDef != null ? !initPhyDef.equals(unit.initPhyDef) : unit.initPhyDef != null) return false;
        if (incPhyDef != null ? !incPhyDef.equals(unit.incPhyDef) : unit.incPhyDef != null) return false;
        if (initMagDef != null ? !initMagDef.equals(unit.initMagDef) : unit.initMagDef != null) return false;
        if (incMagDef != null ? !incMagDef.equals(unit.incMagDef) : unit.incMagDef != null) return false;
        if (moveSpeed != null ? !moveSpeed.equals(unit.moveSpeed) : unit.moveSpeed != null) return false;
        if (reviveTime != null ? !reviveTime.equals(unit.reviveTime) : unit.reviveTime != null) return false;
        if (evadePercent != null ? !evadePercent.equals(unit.evadePercent) : unit.evadePercent != null) return false;
        if (blockPercent != null ? !blockPercent.equals(unit.blockPercent) : unit.blockPercent != null) return false;
        if (numUnitBlock != null ? !numUnitBlock.equals(unit.numUnitBlock) : unit.numUnitBlock != null) return false;
        if (criticalPercent != null ? !criticalPercent.equals(unit.criticalPercent) : unit.criticalPercent != null)
            return false;
        if (criticalDamage != null ? !criticalDamage.equals(unit.criticalDamage) : unit.criticalDamage != null)
            return false;
        if (splashRange != null ? !splashRange.equals(unit.splashRange) : unit.splashRange != null) return false;
        if (splashDamage != null ? !splashDamage.equals(unit.splashDamage) : unit.splashDamage != null) return false;
        if (basicAttackType != null ? !basicAttackType.equals(unit.basicAttackType) : unit.basicAttackType != null)
            return false;
        if (basicAttackDamageType != null ? !basicAttackDamageType.equals(unit.basicAttackDamageType) : unit.basicAttackDamageType != null)
            return false;
        if (basicAttackSpeed != null ? !basicAttackSpeed.equals(unit.basicAttackSpeed) : unit.basicAttackSpeed != null)
            return false;
        if (basicAttackRange != null ? !basicAttackRange.equals(unit.basicAttackRange) : unit.basicAttackRange != null)
            return false;
        if (skillAttackType != null ? !skillAttackType.equals(unit.skillAttackType) : unit.skillAttackType != null)
            return false;
        if (skillAttackDamageType != null ? !skillAttackDamageType.equals(unit.skillAttackDamageType) : unit.skillAttackDamageType != null)
            return false;
        if (skillAttackRange != null ? !skillAttackRange.equals(unit.skillAttackRange) : unit.skillAttackRange != null)
            return false;
        if (skillAttackSpeed != null ? !skillAttackSpeed.equals(unit.skillAttackSpeed) : unit.skillAttackSpeed != null)
            return false;
        if (unitSkillList != null ? !unitSkillList.equals(unit.unitSkillList) : unit.unitSkillList != null)
            return false;
        if (unitSkillListModifiers != null ? !unitSkillListModifiers.equals(unit.unitSkillListModifiers) : unit.unitSkillListModifiers != null)
            return false;
        if (transMaterialT1 != null ? !transMaterialT1.equals(unit.transMaterialT1) : unit.transMaterialT1 != null)
            return false;
        if (transMaterialT2 != null ? !transMaterialT2.equals(unit.transMaterialT2) : unit.transMaterialT2 != null)
            return false;
        if (transMaterialT3 != null ? !transMaterialT3.equals(unit.transMaterialT3) : unit.transMaterialT3 != null)
            return false;
        if (medalBuff != null ? !medalBuff.equals(unit.medalBuff) : unit.medalBuff != null) return false;
        if (offlineMarchSpeedBuff != null ? !offlineMarchSpeedBuff.equals(unit.offlineMarchSpeedBuff) : unit.offlineMarchSpeedBuff != null)
            return false;
        if (className != null ? !className.equals(unit.className) : unit.className != null) return false;
        if (rare != null ? !rare.equals(unit.rare) : unit.rare != null) return false;
        if (size != null ? !size.equals(unit.size) : unit.size != null) return false;
        if (specialSkill != null ? !specialSkill.equals(unit.specialSkill) : unit.specialSkill != null) return false;
        if (passiveSkill != null ? !passiveSkill.equals(unit.passiveSkill) : unit.passiveSkill != null) return false;
        if (bloody != null ? !bloody.equals(unit.bloody) : unit.bloody != null) return false;
        if (explodeDie != null ? !explodeDie.equals(unit.explodeDie) : unit.explodeDie != null) return false;
        if (hasSkill != null ? !hasSkill.equals(unit.hasSkill) : unit.hasSkill != null) return false;
        if (des != null ? !des.equals(unit.des) : unit.des != null) return false;
        if (orthoGrade != null ? !orthoGrade.equals(unit.orthoGrade) : unit.orthoGrade != null) return false;
        if (shop != null ? !shop.equals(unit.shop) : unit.shop != null) return false;
        if (ratingPosition != null ? !ratingPosition.equals(unit.ratingPosition) : unit.ratingPosition != null)
            return false;
        if (jewelBuff != null ? !jewelBuff.equals(unit.jewelBuff) : unit.jewelBuff != null) return false;
        if (offlineTime != null ? !offlineTime.equals(unit.offlineTime) : unit.offlineTime != null) return false;
        if (hasHeart != null ? !hasHeart.equals(unit.hasHeart) : unit.hasHeart != null) return false;
        return medalBuffFromPet != null ? medalBuffFromPet.equals(unit.medalBuffFromPet) : unit.medalBuffFromPet == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tribe != null ? tribe.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (unitShopMedalCost != null ? unitShopMedalCost.hashCode() : 0);
        result = 31 * result + (unitShopGemCost != null ? unitShopGemCost.hashCode() : 0);
        result = 31 * result + (evolveGemCost != null ? evolveGemCost.hashCode() : 0);
        result = 31 * result + (honorShopCoinCost != null ? honorShopCoinCost.hashCode() : 0);
        result = 31 * result + (evolutionUnitId != null ? evolutionUnitId.hashCode() : 0);
        result = 31 * result + (isAirUnit != null ? isAirUnit.hashCode() : 0);
        result = 31 * result + (groundAir != null ? groundAir.hashCode() : 0);
        result = 31 * result + (canDetectCloaked != null ? canDetectCloaked.hashCode() : 0);
        result = 31 * result + (isCloaking != null ? isCloaking.hashCode() : 0);
        result = 31 * result + (isHonor != null ? isHonor.hashCode() : 0);
        result = 31 * result + (honorRotationNumber != null ? honorRotationNumber.hashCode() : 0);
        result = 31 * result + (maxTransLevel != null ? maxTransLevel.hashCode() : 0);
        result = 31 * result + (showBook != null ? showBook.hashCode() : 0);
        result = 31 * result + (initHp != null ? initHp.hashCode() : 0);
        result = 31 * result + (incHp != null ? incHp.hashCode() : 0);
        result = 31 * result + (initDamage != null ? initDamage.hashCode() : 0);
        result = 31 * result + (incDamage != null ? incDamage.hashCode() : 0);
        result = 31 * result + (initPhyDef != null ? initPhyDef.hashCode() : 0);
        result = 31 * result + (incPhyDef != null ? incPhyDef.hashCode() : 0);
        result = 31 * result + (initMagDef != null ? initMagDef.hashCode() : 0);
        result = 31 * result + (incMagDef != null ? incMagDef.hashCode() : 0);
        result = 31 * result + (moveSpeed != null ? moveSpeed.hashCode() : 0);
        result = 31 * result + (reviveTime != null ? reviveTime.hashCode() : 0);
        result = 31 * result + (evadePercent != null ? evadePercent.hashCode() : 0);
        result = 31 * result + (blockPercent != null ? blockPercent.hashCode() : 0);
        result = 31 * result + (numUnitBlock != null ? numUnitBlock.hashCode() : 0);
        result = 31 * result + (criticalPercent != null ? criticalPercent.hashCode() : 0);
        result = 31 * result + (criticalDamage != null ? criticalDamage.hashCode() : 0);
        result = 31 * result + (splashRange != null ? splashRange.hashCode() : 0);
        result = 31 * result + (splashDamage != null ? splashDamage.hashCode() : 0);
        result = 31 * result + (basicAttackType != null ? basicAttackType.hashCode() : 0);
        result = 31 * result + (basicAttackDamageType != null ? basicAttackDamageType.hashCode() : 0);
        result = 31 * result + (basicAttackSpeed != null ? basicAttackSpeed.hashCode() : 0);
        result = 31 * result + (basicAttackRange != null ? basicAttackRange.hashCode() : 0);
        result = 31 * result + (skillAttackType != null ? skillAttackType.hashCode() : 0);
        result = 31 * result + (skillAttackDamageType != null ? skillAttackDamageType.hashCode() : 0);
        result = 31 * result + (skillAttackRange != null ? skillAttackRange.hashCode() : 0);
        result = 31 * result + (skillAttackSpeed != null ? skillAttackSpeed.hashCode() : 0);
        result = 31 * result + (unitSkillList != null ? unitSkillList.hashCode() : 0);
        result = 31 * result + (unitSkillListModifiers != null ? unitSkillListModifiers.hashCode() : 0);
        result = 31 * result + (transMaterialT1 != null ? transMaterialT1.hashCode() : 0);
        result = 31 * result + (transMaterialT2 != null ? transMaterialT2.hashCode() : 0);
        result = 31 * result + (transMaterialT3 != null ? transMaterialT3.hashCode() : 0);
        result = 31 * result + (medalBuff != null ? medalBuff.hashCode() : 0);
        result = 31 * result + (offlineMarchSpeedBuff != null ? offlineMarchSpeedBuff.hashCode() : 0);
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (rare != null ? rare.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (specialSkill != null ? specialSkill.hashCode() : 0);
        result = 31 * result + (passiveSkill != null ? passiveSkill.hashCode() : 0);
        result = 31 * result + (bloody != null ? bloody.hashCode() : 0);
        result = 31 * result + (explodeDie != null ? explodeDie.hashCode() : 0);
        result = 31 * result + (hasSkill != null ? hasSkill.hashCode() : 0);
        result = 31 * result + (des != null ? des.hashCode() : 0);
        result = 31 * result + (orthoGrade != null ? orthoGrade.hashCode() : 0);
        result = 31 * result + (shop != null ? shop.hashCode() : 0);
        result = 31 * result + (ratingPosition != null ? ratingPosition.hashCode() : 0);
        result = 31 * result + (jewelBuff != null ? jewelBuff.hashCode() : 0);
        result = 31 * result + (offlineTime != null ? offlineTime.hashCode() : 0);
        result = 31 * result + (hasHeart != null ? hasHeart.hashCode() : 0);
        result = 31 * result + (medalBuffFromPet != null ? medalBuffFromPet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", tribe=" + tribe +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", rank=" + rank +
                ", sex='" + sex + '\'' +
                ", unitShopMedalCost=" + unitShopMedalCost +
                ", unitShopGemCost=" + unitShopGemCost +
                ", evolveGemCost=" + evolveGemCost +
                ", honorShopCoinCost=" + honorShopCoinCost +
                ", evolutionUnitId=" + evolutionUnitId +
                ", isAirUnit=" + isAirUnit +
                ", groundAir=" + groundAir +
                ", canDetectCloaked=" + canDetectCloaked +
                ", isCloaking=" + isCloaking +
                ", isHonor=" + isHonor +
                ", honorRotationNumber=" + honorRotationNumber +
                ", maxTransLevel=" + maxTransLevel +
                ", showBook=" + showBook +
                ", initHp=" + initHp +
                ", incHp=" + incHp +
                ", initDamage=" + initDamage +
                ", incDamage=" + incDamage +
                ", initPhyDef=" + initPhyDef +
                ", incPhyDef=" + incPhyDef +
                ", initMagDef=" + initMagDef +
                ", incMagDef=" + incMagDef +
                ", moveSpeed=" + moveSpeed +
                ", reviveTime=" + reviveTime +
                ", evadePercent=" + evadePercent +
                ", blockPercent=" + blockPercent +
                ", numUnitBlock=" + numUnitBlock +
                ", criticalPercent=" + criticalPercent +
                ", criticalDamage=" + criticalDamage +
                ", splashRange=" + splashRange +
                ", splashDamage=" + splashDamage +
                ", basicAttackType='" + basicAttackType + '\'' +
                ", basicAttackDamageType='" + basicAttackDamageType + '\'' +
                ", basicAttackSpeed=" + basicAttackSpeed +
                ", basicAttackRange=" + basicAttackRange +
                ", skillAttackType='" + skillAttackType + '\'' +
                ", skillAttackDamageType='" + skillAttackDamageType + '\'' +
                ", skillAttackRange=" + skillAttackRange +
                ", skillAttackSpeed=" + skillAttackSpeed +
                ", unitSkillList=" + unitSkillList +
                ", unitSkillListModifiers=" + unitSkillListModifiers +
                ", transMaterialT1=" + transMaterialT1 +
                ", transMaterialT2=" + transMaterialT2 +
                ", transMaterialT3=" + transMaterialT3 +
                ", medalBuff=" + medalBuff +
                ", offlineMarchSpeedBuff=" + offlineMarchSpeedBuff +
                ", className='" + className + '\'' +
                ", rare=" + rare +
                ", size=" + size +
                ", specialSkill=" + specialSkill +
                ", passiveSkill=" + passiveSkill +
                ", bloody=" + bloody +
                ", explodeDie=" + explodeDie +
                ", hasSkill=" + hasSkill +
                ", des='" + des + '\'' +
                ", orthoGrade=" + orthoGrade +
                ", shop=" + shop +
                ", ratingPosition=" + ratingPosition +
                ", jewelBuff=" + jewelBuff +
                ", offlineTime=" + offlineTime +
                ", hasHeart=" + hasHeart +
                ", medalBuffFromPet=" + medalBuffFromPet +
                '}';
    }
}
