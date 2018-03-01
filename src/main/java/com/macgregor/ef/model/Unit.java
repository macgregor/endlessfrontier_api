package com.macgregor.ef.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.swagger.annotations.ApiModel;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "unit")
@JacksonXmlRootElement(localName = "unit")
@ApiModel(value="Unit", description="Unit model describing units in Endless Frontier (e.g. infantry, Ice Spirit, Sword Dancer, etc.)")
public class Unit {

    @Id
    @Column(name="id", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "kindNum")
    private Integer id;

    @Column(name = "tribe", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "tribe")
    private Integer tribe;

    @Column(name = "class_name", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "className")
    private String className;

    @Column(name = "name", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "name")
    private String name; //TODO: needs to be translated to english

    @Column(name = "cost", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "cost")
    private Integer cost;

    @Column(name = "shop_gem", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "shopGem")
    private Integer shopGem;

    @Column(name = "evolve_gem", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "evolveGem")
    private Integer evolveGem;

    @Column(name = "coin", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "coin")
    private Integer coin;

    @Column(name = "rare", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "rare")
    private Integer rare;

    @Column(name = "size", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "size")
    private Integer size;

    @Column(name = "evol_kind_num", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "evolKindNum")
    private Integer evolKindNum;

    @Column(name = "attack_type", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "attackType")
    private String attackType;

    @Column(name = "is_air_unit", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "isAirUnit")
    private String isAirUnit; //TODO: convert to boolean

    @Column(name = "damage_type", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "damageType")
    private String damageType;

    @Column(name = "has_skill", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "hasSkill")
    private String hasSkill; //TODO: convert to boolean

    @Column(name = "skill_attack_type", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "skillAttackType")
    private String skillAttackType; //TODO: convert to boolean

    @Column(name = "skill_damage_type", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "skillDamageType")
    private String skillDamageType; //TODO: convert to boolean

    @Column(name = "init_hp", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "initHp")
    private Double initHp;

    @Column(name = "inc_hp", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "incHp")
    private Double incHp;

    @Column(name = "init_damage", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "initDamage")
    private Double initDamage;

    @Column(name = "inc_damage", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "incDamage")
    private Double incDamage;

    @Column(name = "init_phy_def", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "initPhyDef")
    private Double initPhyDef;

    @Column(name = "inc_phy_def", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "incPhyDef")
    private Double incPhyDef;

    @Column(name = "init_mag_def", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "initMagDef")
    private Double initMagDef;

    @Column(name = "inc_mag_def", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "incMagDef")
    private Double incMagDef;

    @Column(name = "num_unit_block", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "numUnitBlock")
    private Integer numUnitBlock;

    @Column(name = "move_speed", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "moveSpeed")
    private Double moveSpeed;

    @Column(name = "attack_speed", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "attackSpeed")
    private Integer attackSpeed;

    @Column(name = "skill_speed", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "skillSpeed")
    private Integer skillSpeed;

    @Column(name = "attack_range", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "attackRange")
    private Integer attackRange;

    @Column(name = "skill_range", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "skillRange")
    private Integer skillRange;

    @Column(name = "evade_percent", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "evadePercent")
    private Double evadePercent;

    @Column(name = "block_percent", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "blockPercent")
    private Double blockPercent;

    @Column(name = "critical_percent", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "criticalPercent")
    private Double criticalPercent;

    @Column(name = "critical_damage", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "criticalDamage")
    private Double criticalDamage;

    @Column(name = "splash_range", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "splashRange")
    private Integer splashRange;

    @Column(name = "splash_damage", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "splashDamage")
    private Double splashDamage;

    @Column(name = "special_skill", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "specialSkill")
    private Integer specialSkill;

    @Column(name = "passive_skill", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "passiveSkill")
    private Integer passiveSkill;

    @Column(name = "revive_time", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "reviveTime")
    private Integer reviveTime;

    @Column(name = "bloody", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "bloody")
    private String bloody; //TODO: convert to boolean

    @Column(name = "explode_die", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "explodeDie")
    private String explodeDie; //TODO: convert to boolean

    @Column(name = "des", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "des")
    private String des; //TODO: needs to be translated?

    @Column(name = "message", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "message")
    private String message; //TODO: needs to be translated?

    @Column(name = "skill_list", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "skillList")
    private String skillList;

    @Column(name = "power_list", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "powerList")
    private String powerList;

    @Column(name = "rank", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "rank")
    private Integer rank;

    @Column(name = "sex", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "sex")
    private String sex; //TODO: convert to boolean

    @Column(name = "ortho_grade", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "orthoGrade")
    private String orthoGrade; //TODO: convert to boolean

    @Column(name = "shop", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "shop")
    private Integer shop;

    @Column(name = "show_book", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "showBook")
    private String showBook; //TODO: convert to boolean

    @Column(name = "rating_position", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "ratingPosition")
    private Integer ratingPosition;

    @Column(name = "trans", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "trans")
    private Integer trans;

    @Column(name = "material1", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "material1")
    private String material1;

    @Column(name = "material2", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "material2")
    private String material2;

    @Column(name = "material3", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "material3")
    private String material3;

    @Column(name = "star_buff", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "starBuff")
    private Integer starBuff;

    @Column(name = "jewel_buff", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "jewelBuff")
    private Integer jewelBuff;

    @Column(name = "ground_air", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "groundAir")
    private String groundAir; //TODO: convert to boolean

    @Column(name = "offline_speed", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "offlineSpeed")
    private Double offlineSpeed;

    @Column(name = "offline_time", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "offlineTime")
    private Integer offlineTime;

    @Column(name = "has_heart", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "hasHeart")
    private String hasHeart; //TODO: convert to boolean

    @Column(name = "can_detect", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "canDetect")
    private String canDetect; //TODO: convert to boolean

    @Column(name = "cloaking", nullable = false)
    @NotBlank
    @JsonProperty
    @JacksonXmlProperty(localName = "cloaking")
    private String cloaking; //TODO: convert to boolean

    @Column(name = "star_buff_from_pet", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "starBuffFromPet")
    private Integer starBuffFromPet;

    @Column(name = "is_honor", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "isHonor")
    private Integer isHonor;

    @Column(name = "honor_number", nullable = false)
    @NotNull
    @JsonProperty
    @JacksonXmlProperty(localName = "honorNumber")
    private Integer honorNumber;

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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getShopGem() {
        return shopGem;
    }

    public void setShopGem(Integer shopGem) {
        this.shopGem = shopGem;
    }

    public Integer getEvolveGem() {
        return evolveGem;
    }

    public void setEvolveGem(Integer evolveGem) {
        this.evolveGem = evolveGem;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
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

    public Integer getEvolKindNum() {
        return evolKindNum;
    }

    public void setEvolKindNum(Integer evolKindNum) {
        this.evolKindNum = evolKindNum;
    }

    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public String getIsAirUnit() {
        return isAirUnit;
    }

    public void setIsAirUnit(String isAirUnit) {
        this.isAirUnit = isAirUnit;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public String getHasSkill() {
        return hasSkill;
    }

    public void setHasSkill(String hasSkill) {
        this.hasSkill = hasSkill;
    }

    public String getSkillAttackType() {
        return skillAttackType;
    }

    public void setSkillAttackType(String skillAttackType) {
        this.skillAttackType = skillAttackType;
    }

    public String getSkillDamageType() {
        return skillDamageType;
    }

    public void setSkillDamageType(String skillDamageType) {
        this.skillDamageType = skillDamageType;
    }

    public Double getInitHp() {
        return initHp;
    }

    public void setInitHp(Double initHp) {
        this.initHp = initHp;
    }

    public Double getIncHp() {
        return incHp;
    }

    public void setIncHp(Double incHp) {
        this.incHp = incHp;
    }

    public Double getInitDamage() {
        return initDamage;
    }

    public void setInitDamage(Double initDamage) {
        this.initDamage = initDamage;
    }

    public Double getIncDamage() {
        return incDamage;
    }

    public void setIncDamage(Double incDamage) {
        this.incDamage = incDamage;
    }

    public Double getInitPhyDef() {
        return initPhyDef;
    }

    public void setInitPhyDef(Double initPhyDef) {
        this.initPhyDef = initPhyDef;
    }

    public Double getIncPhyDef() {
        return incPhyDef;
    }

    public void setIncPhyDef(Double incPhyDef) {
        this.incPhyDef = incPhyDef;
    }

    public Double getInitMagDef() {
        return initMagDef;
    }

    public void setInitMagDef(Double initMagDef) {
        this.initMagDef = initMagDef;
    }

    public Double getIncMagDef() {
        return incMagDef;
    }

    public void setIncMagDef(Double incMagDef) {
        this.incMagDef = incMagDef;
    }

    public Integer getNumUnitBlock() {
        return numUnitBlock;
    }

    public void setNumUnitBlock(Integer numUnitBlock) {
        this.numUnitBlock = numUnitBlock;
    }

    public Double getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(Double moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public Integer getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(Integer attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public Integer getSkillSpeed() {
        return skillSpeed;
    }

    public void setSkillSpeed(Integer skillSpeed) {
        this.skillSpeed = skillSpeed;
    }

    public Integer getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(Integer attackRange) {
        this.attackRange = attackRange;
    }

    public Integer getSkillRange() {
        return skillRange;
    }

    public void setSkillRange(Integer skillRange) {
        this.skillRange = skillRange;
    }

    public Double getEvadePercent() {
        return evadePercent;
    }

    public void setEvadePercent(Double evadePercent) {
        this.evadePercent = evadePercent;
    }

    public Double getBlockPercent() {
        return blockPercent;
    }

    public void setBlockPercent(Double blockPercent) {
        this.blockPercent = blockPercent;
    }

    public Double getCriticalPercent() {
        return criticalPercent;
    }

    public void setCriticalPercent(Double criticalPercent) {
        this.criticalPercent = criticalPercent;
    }

    public Double getCriticalDamage() {
        return criticalDamage;
    }

    public void setCriticalDamage(Double criticalDamage) {
        this.criticalDamage = criticalDamage;
    }

    public Integer getSplashRange() {
        return splashRange;
    }

    public void setSplashRange(Integer splashRange) {
        this.splashRange = splashRange;
    }

    public Double getSplashDamage() {
        return splashDamage;
    }

    public void setSplashDamage(Double splashDamage) {
        this.splashDamage = splashDamage;
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

    public Integer getReviveTime() {
        return reviveTime;
    }

    public void setReviveTime(Integer reviveTime) {
        this.reviveTime = reviveTime;
    }

    public String getBloody() {
        return bloody;
    }

    public void setBloody(String bloody) {
        this.bloody = bloody;
    }

    public String getExplodeDie() {
        return explodeDie;
    }

    public void setExplodeDie(String explodeDie) {
        this.explodeDie = explodeDie;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSkillList() {
        return skillList;
    }

    public void setSkillList(String skillList) {
        this.skillList = skillList;
    }

    public String getPowerList() {
        return powerList;
    }

    public void setPowerList(String powerList) {
        this.powerList = powerList;
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

    public String getOrthoGrade() {
        return orthoGrade;
    }

    public void setOrthoGrade(String orthoGrade) {
        this.orthoGrade = orthoGrade;
    }

    public Integer getShop() {
        return shop;
    }

    public void setShop(Integer shop) {
        this.shop = shop;
    }

    public String getShowBook() {
        return showBook;
    }

    public void setShowBook(String showBook) {
        this.showBook = showBook;
    }

    public Integer getRatingPosition() {
        return ratingPosition;
    }

    public void setRatingPosition(Integer ratingPosition) {
        this.ratingPosition = ratingPosition;
    }

    public Integer getTrans() {
        return trans;
    }

    public void setTrans(Integer trans) {
        this.trans = trans;
    }

    public String getMaterial1() {
        return material1;
    }

    public void setMaterial1(String material1) {
        this.material1 = material1;
    }

    public String getMaterial2() {
        return material2;
    }

    public void setMaterial2(String material2) {
        this.material2 = material2;
    }

    public String getMaterial3() {
        return material3;
    }

    public void setMaterial3(String material3) {
        this.material3 = material3;
    }

    public Integer getStarBuff() {
        return starBuff;
    }

    public void setStarBuff(Integer starBuff) {
        this.starBuff = starBuff;
    }

    public Integer getJewelBuff() {
        return jewelBuff;
    }

    public void setJewelBuff(Integer jewelBuff) {
        this.jewelBuff = jewelBuff;
    }

    public String getGroundAir() {
        return groundAir;
    }

    public void setGroundAir(String groundAir) {
        this.groundAir = groundAir;
    }

    public Double getOfflineSpeed() {
        return offlineSpeed;
    }

    public void setOfflineSpeed(Double offlineSpeed) {
        this.offlineSpeed = offlineSpeed;
    }

    public Integer getOfflineTime() {
        return offlineTime;
    }

    public void setOfflineTime(Integer offlineTime) {
        this.offlineTime = offlineTime;
    }

    public String getHasHeart() {
        return hasHeart;
    }

    public void setHasHeart(String hasHeart) {
        this.hasHeart = hasHeart;
    }

    public String getCanDetect() {
        return canDetect;
    }

    public void setCanDetect(String canDetect) {
        this.canDetect = canDetect;
    }

    public String getCloaking() {
        return cloaking;
    }

    public void setCloaking(String cloaking) {
        this.cloaking = cloaking;
    }

    public Integer getStarBuffFromPet() {
        return starBuffFromPet;
    }

    public void setStarBuffFromPet(Integer starBuffFromPet) {
        this.starBuffFromPet = starBuffFromPet;
    }

    public Integer getIsHonor() {
        return isHonor;
    }

    public void setIsHonor(Integer isHonor) {
        this.isHonor = isHonor;
    }

    public Integer getHonorNumber() {
        return honorNumber;
    }

    public void setHonorNumber(Integer honorNumber) {
        this.honorNumber = honorNumber;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", tribe=" + tribe +
                ", className='" + className + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", shopGem=" + shopGem +
                ", evolveGem=" + evolveGem +
                ", coin=" + coin +
                ", rare=" + rare +
                ", size=" + size +
                ", evolKindNum=" + evolKindNum +
                ", attackType='" + attackType + '\'' +
                ", isAirUnit='" + isAirUnit + '\'' +
                ", damageType='" + damageType + '\'' +
                ", hasSkill='" + hasSkill + '\'' +
                ", skillAttackType='" + skillAttackType + '\'' +
                ", skillDamageType='" + skillDamageType + '\'' +
                ", initHp=" + initHp +
                ", incHp=" + incHp +
                ", initDamage=" + initDamage +
                ", incDamage=" + incDamage +
                ", initPhyDef=" + initPhyDef +
                ", incPhyDef=" + incPhyDef +
                ", initMagDef=" + initMagDef +
                ", incMagDef=" + incMagDef +
                ", numUnitBlock=" + numUnitBlock +
                ", moveSpeed=" + moveSpeed +
                ", attackSpeed=" + attackSpeed +
                ", skillSpeed=" + skillSpeed +
                ", attackRange=" + attackRange +
                ", skillRange=" + skillRange +
                ", evadePercent=" + evadePercent +
                ", blockPercent=" + blockPercent +
                ", criticalPercent=" + criticalPercent +
                ", criticalDamage=" + criticalDamage +
                ", splashRange=" + splashRange +
                ", splashDamage=" + splashDamage +
                ", specialSkill=" + specialSkill +
                ", passiveSkill=" + passiveSkill +
                ", reviveTime=" + reviveTime +
                ", bloody='" + bloody + '\'' +
                ", explodeDie='" + explodeDie + '\'' +
                ", des='" + des + '\'' +
                ", message='" + message + '\'' +
                ", skillList='" + skillList + '\'' +
                ", powerList='" + powerList + '\'' +
                ", rank=" + rank +
                ", sex='" + sex + '\'' +
                ", orthoGrade='" + orthoGrade + '\'' +
                ", shop=" + shop +
                ", showBook='" + showBook + '\'' +
                ", ratingPosition=" + ratingPosition +
                ", trans=" + trans +
                ", material1='" + material1 + '\'' +
                ", material2='" + material2 + '\'' +
                ", material3='" + material3 + '\'' +
                ", starBuff=" + starBuff +
                ", jewelBuff=" + jewelBuff +
                ", groundAir='" + groundAir + '\'' +
                ", offlineSpeed=" + offlineSpeed +
                ", offlineTime=" + offlineTime +
                ", hasHeart='" + hasHeart + '\'' +
                ", canDetect='" + canDetect + '\'' +
                ", cloaking='" + cloaking + '\'' +
                ", starBuffFromPet=" + starBuffFromPet +
                ", isHonor=" + isHonor +
                ", honorNumber=" + honorNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit unit = (Unit) o;

        if (id != null ? !id.equals(unit.id) : unit.id != null) return false;
        if (tribe != null ? !tribe.equals(unit.tribe) : unit.tribe != null) return false;
        if (className != null ? !className.equals(unit.className) : unit.className != null) return false;
        if (name != null ? !name.equals(unit.name) : unit.name != null) return false;
        if (cost != null ? !cost.equals(unit.cost) : unit.cost != null) return false;
        if (shopGem != null ? !shopGem.equals(unit.shopGem) : unit.shopGem != null) return false;
        if (evolveGem != null ? !evolveGem.equals(unit.evolveGem) : unit.evolveGem != null) return false;
        if (coin != null ? !coin.equals(unit.coin) : unit.coin != null) return false;
        if (rare != null ? !rare.equals(unit.rare) : unit.rare != null) return false;
        if (size != null ? !size.equals(unit.size) : unit.size != null) return false;
        if (evolKindNum != null ? !evolKindNum.equals(unit.evolKindNum) : unit.evolKindNum != null) return false;
        if (attackType != null ? !attackType.equals(unit.attackType) : unit.attackType != null) return false;
        if (isAirUnit != null ? !isAirUnit.equals(unit.isAirUnit) : unit.isAirUnit != null) return false;
        if (damageType != null ? !damageType.equals(unit.damageType) : unit.damageType != null) return false;
        if (hasSkill != null ? !hasSkill.equals(unit.hasSkill) : unit.hasSkill != null) return false;
        if (skillAttackType != null ? !skillAttackType.equals(unit.skillAttackType) : unit.skillAttackType != null)
            return false;
        if (skillDamageType != null ? !skillDamageType.equals(unit.skillDamageType) : unit.skillDamageType != null)
            return false;
        if (initHp != null ? !initHp.equals(unit.initHp) : unit.initHp != null) return false;
        if (incHp != null ? !incHp.equals(unit.incHp) : unit.incHp != null) return false;
        if (initDamage != null ? !initDamage.equals(unit.initDamage) : unit.initDamage != null) return false;
        if (incDamage != null ? !incDamage.equals(unit.incDamage) : unit.incDamage != null) return false;
        if (initPhyDef != null ? !initPhyDef.equals(unit.initPhyDef) : unit.initPhyDef != null) return false;
        if (incPhyDef != null ? !incPhyDef.equals(unit.incPhyDef) : unit.incPhyDef != null) return false;
        if (initMagDef != null ? !initMagDef.equals(unit.initMagDef) : unit.initMagDef != null) return false;
        if (incMagDef != null ? !incMagDef.equals(unit.incMagDef) : unit.incMagDef != null) return false;
        if (numUnitBlock != null ? !numUnitBlock.equals(unit.numUnitBlock) : unit.numUnitBlock != null) return false;
        if (moveSpeed != null ? !moveSpeed.equals(unit.moveSpeed) : unit.moveSpeed != null) return false;
        if (attackSpeed != null ? !attackSpeed.equals(unit.attackSpeed) : unit.attackSpeed != null) return false;
        if (skillSpeed != null ? !skillSpeed.equals(unit.skillSpeed) : unit.skillSpeed != null) return false;
        if (attackRange != null ? !attackRange.equals(unit.attackRange) : unit.attackRange != null) return false;
        if (skillRange != null ? !skillRange.equals(unit.skillRange) : unit.skillRange != null) return false;
        if (evadePercent != null ? !evadePercent.equals(unit.evadePercent) : unit.evadePercent != null) return false;
        if (blockPercent != null ? !blockPercent.equals(unit.blockPercent) : unit.blockPercent != null) return false;
        if (criticalPercent != null ? !criticalPercent.equals(unit.criticalPercent) : unit.criticalPercent != null)
            return false;
        if (criticalDamage != null ? !criticalDamage.equals(unit.criticalDamage) : unit.criticalDamage != null)
            return false;
        if (splashRange != null ? !splashRange.equals(unit.splashRange) : unit.splashRange != null) return false;
        if (splashDamage != null ? !splashDamage.equals(unit.splashDamage) : unit.splashDamage != null) return false;
        if (specialSkill != null ? !specialSkill.equals(unit.specialSkill) : unit.specialSkill != null) return false;
        if (passiveSkill != null ? !passiveSkill.equals(unit.passiveSkill) : unit.passiveSkill != null) return false;
        if (reviveTime != null ? !reviveTime.equals(unit.reviveTime) : unit.reviveTime != null) return false;
        if (bloody != null ? !bloody.equals(unit.bloody) : unit.bloody != null) return false;
        if (explodeDie != null ? !explodeDie.equals(unit.explodeDie) : unit.explodeDie != null) return false;
        if (des != null ? !des.equals(unit.des) : unit.des != null) return false;
        if (message != null ? !message.equals(unit.message) : unit.message != null) return false;
        if (skillList != null ? !skillList.equals(unit.skillList) : unit.skillList != null) return false;
        if (powerList != null ? !powerList.equals(unit.powerList) : unit.powerList != null) return false;
        if (rank != null ? !rank.equals(unit.rank) : unit.rank != null) return false;
        if (sex != null ? !sex.equals(unit.sex) : unit.sex != null) return false;
        if (orthoGrade != null ? !orthoGrade.equals(unit.orthoGrade) : unit.orthoGrade != null) return false;
        if (shop != null ? !shop.equals(unit.shop) : unit.shop != null) return false;
        if (showBook != null ? !showBook.equals(unit.showBook) : unit.showBook != null) return false;
        if (ratingPosition != null ? !ratingPosition.equals(unit.ratingPosition) : unit.ratingPosition != null)
            return false;
        if (trans != null ? !trans.equals(unit.trans) : unit.trans != null) return false;
        if (material1 != null ? !material1.equals(unit.material1) : unit.material1 != null) return false;
        if (material2 != null ? !material2.equals(unit.material2) : unit.material2 != null) return false;
        if (material3 != null ? !material3.equals(unit.material3) : unit.material3 != null) return false;
        if (starBuff != null ? !starBuff.equals(unit.starBuff) : unit.starBuff != null) return false;
        if (jewelBuff != null ? !jewelBuff.equals(unit.jewelBuff) : unit.jewelBuff != null) return false;
        if (groundAir != null ? !groundAir.equals(unit.groundAir) : unit.groundAir != null) return false;
        if (offlineSpeed != null ? !offlineSpeed.equals(unit.offlineSpeed) : unit.offlineSpeed != null) return false;
        if (offlineTime != null ? !offlineTime.equals(unit.offlineTime) : unit.offlineTime != null) return false;
        if (hasHeart != null ? !hasHeart.equals(unit.hasHeart) : unit.hasHeart != null) return false;
        if (canDetect != null ? !canDetect.equals(unit.canDetect) : unit.canDetect != null) return false;
        if (cloaking != null ? !cloaking.equals(unit.cloaking) : unit.cloaking != null) return false;
        if (starBuffFromPet != null ? !starBuffFromPet.equals(unit.starBuffFromPet) : unit.starBuffFromPet != null)
            return false;
        if (isHonor != null ? !isHonor.equals(unit.isHonor) : unit.isHonor != null) return false;
        return honorNumber != null ? honorNumber.equals(unit.honorNumber) : unit.honorNumber == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tribe != null ? tribe.hashCode() : 0);
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (shopGem != null ? shopGem.hashCode() : 0);
        result = 31 * result + (evolveGem != null ? evolveGem.hashCode() : 0);
        result = 31 * result + (coin != null ? coin.hashCode() : 0);
        result = 31 * result + (rare != null ? rare.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (evolKindNum != null ? evolKindNum.hashCode() : 0);
        result = 31 * result + (attackType != null ? attackType.hashCode() : 0);
        result = 31 * result + (isAirUnit != null ? isAirUnit.hashCode() : 0);
        result = 31 * result + (damageType != null ? damageType.hashCode() : 0);
        result = 31 * result + (hasSkill != null ? hasSkill.hashCode() : 0);
        result = 31 * result + (skillAttackType != null ? skillAttackType.hashCode() : 0);
        result = 31 * result + (skillDamageType != null ? skillDamageType.hashCode() : 0);
        result = 31 * result + (initHp != null ? initHp.hashCode() : 0);
        result = 31 * result + (incHp != null ? incHp.hashCode() : 0);
        result = 31 * result + (initDamage != null ? initDamage.hashCode() : 0);
        result = 31 * result + (incDamage != null ? incDamage.hashCode() : 0);
        result = 31 * result + (initPhyDef != null ? initPhyDef.hashCode() : 0);
        result = 31 * result + (incPhyDef != null ? incPhyDef.hashCode() : 0);
        result = 31 * result + (initMagDef != null ? initMagDef.hashCode() : 0);
        result = 31 * result + (incMagDef != null ? incMagDef.hashCode() : 0);
        result = 31 * result + (numUnitBlock != null ? numUnitBlock.hashCode() : 0);
        result = 31 * result + (moveSpeed != null ? moveSpeed.hashCode() : 0);
        result = 31 * result + (attackSpeed != null ? attackSpeed.hashCode() : 0);
        result = 31 * result + (skillSpeed != null ? skillSpeed.hashCode() : 0);
        result = 31 * result + (attackRange != null ? attackRange.hashCode() : 0);
        result = 31 * result + (skillRange != null ? skillRange.hashCode() : 0);
        result = 31 * result + (evadePercent != null ? evadePercent.hashCode() : 0);
        result = 31 * result + (blockPercent != null ? blockPercent.hashCode() : 0);
        result = 31 * result + (criticalPercent != null ? criticalPercent.hashCode() : 0);
        result = 31 * result + (criticalDamage != null ? criticalDamage.hashCode() : 0);
        result = 31 * result + (splashRange != null ? splashRange.hashCode() : 0);
        result = 31 * result + (splashDamage != null ? splashDamage.hashCode() : 0);
        result = 31 * result + (specialSkill != null ? specialSkill.hashCode() : 0);
        result = 31 * result + (passiveSkill != null ? passiveSkill.hashCode() : 0);
        result = 31 * result + (reviveTime != null ? reviveTime.hashCode() : 0);
        result = 31 * result + (bloody != null ? bloody.hashCode() : 0);
        result = 31 * result + (explodeDie != null ? explodeDie.hashCode() : 0);
        result = 31 * result + (des != null ? des.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (skillList != null ? skillList.hashCode() : 0);
        result = 31 * result + (powerList != null ? powerList.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (orthoGrade != null ? orthoGrade.hashCode() : 0);
        result = 31 * result + (shop != null ? shop.hashCode() : 0);
        result = 31 * result + (showBook != null ? showBook.hashCode() : 0);
        result = 31 * result + (ratingPosition != null ? ratingPosition.hashCode() : 0);
        result = 31 * result + (trans != null ? trans.hashCode() : 0);
        result = 31 * result + (material1 != null ? material1.hashCode() : 0);
        result = 31 * result + (material2 != null ? material2.hashCode() : 0);
        result = 31 * result + (material3 != null ? material3.hashCode() : 0);
        result = 31 * result + (starBuff != null ? starBuff.hashCode() : 0);
        result = 31 * result + (jewelBuff != null ? jewelBuff.hashCode() : 0);
        result = 31 * result + (groundAir != null ? groundAir.hashCode() : 0);
        result = 31 * result + (offlineSpeed != null ? offlineSpeed.hashCode() : 0);
        result = 31 * result + (offlineTime != null ? offlineTime.hashCode() : 0);
        result = 31 * result + (hasHeart != null ? hasHeart.hashCode() : 0);
        result = 31 * result + (canDetect != null ? canDetect.hashCode() : 0);
        result = 31 * result + (cloaking != null ? cloaking.hashCode() : 0);
        result = 31 * result + (starBuffFromPet != null ? starBuffFromPet.hashCode() : 0);
        result = 31 * result + (isHonor != null ? isHonor.hashCode() : 0);
        result = 31 * result + (honorNumber != null ? honorNumber.hashCode() : 0);
        return result;
    }
}
