package com.macgregor.ef.model.ekkor;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.macgregor.ef.dataload.annotations.Translate;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@JacksonXmlRootElement(localName = "unit")
public class UnitXML extends AbstractXMLModel {

    @NotNull
    @JacksonXmlProperty(localName = "kindNum")
    private Integer id;

    @NotNull
    @JacksonXmlProperty(localName = "tribe")
    private Integer tribe;

    @NotBlank
    @JacksonXmlProperty(localName = "className")
    private String className;

    @NotBlank
    @JacksonXmlProperty(localName = "name")
    @Translate(key="UNIT_NAME_{id}")
    private String name;

    @NotNull
    @JacksonXmlProperty(localName = "cost")
    private Integer cost;

    @NotNull
    @JacksonXmlProperty(localName = "shopGem")
    private Integer shopGem;

    @NotNull
    @JacksonXmlProperty(localName = "evolveGem")
    private Integer evolveGem;

    @NotNull
    @JacksonXmlProperty(localName = "coin")
    private Integer coin;

    @NotNull
    @JacksonXmlProperty(localName = "rare")
    private Integer rare;

    @NotNull
    @JacksonXmlProperty(localName = "size")
    private Integer size;

    @NotNull
    @JacksonXmlProperty(localName = "evolKindNum")
    private Integer evolKindNum;

    @NotBlank
    @JacksonXmlProperty(localName = "attackType")
    private String attackType;

    @NotBlank
    @JacksonXmlProperty(localName = "isAirUnit")
    private String isAirUnit; //TODO: convert to boolean

    @NotBlank
    @JacksonXmlProperty(localName = "damageType")
    private String damageType;

    @NotBlank
    @JacksonXmlProperty(localName = "hasSkill")
    private String hasSkill; //TODO: convert to boolean

    @NotBlank
    @JacksonXmlProperty(localName = "skillAttackType")
    private String skillAttackType; //TODO: convert to boolean

    @NotBlank
    @JacksonXmlProperty(localName = "skillDamageType")
    private String skillDamageType; //TODO: convert to boolean

    @NotNull
    @JacksonXmlProperty(localName = "initHp")
    private Double initHp;

    @NotNull
    @JacksonXmlProperty(localName = "incHp")
    private Double incHp;

    @NotNull
    @JacksonXmlProperty(localName = "initDamage")
    private Double initDamage;

    @NotNull
    @JacksonXmlProperty(localName = "incDamage")
    private Double incDamage;

    @NotNull
    @JacksonXmlProperty(localName = "initPhyDef")
    private Double initPhyDef;

    @NotNull
    @JacksonXmlProperty(localName = "incPhyDef")
    private Double incPhyDef;

    @NotNull
    @JacksonXmlProperty(localName = "initMagDef")
    private Double initMagDef;

    @NotNull
    @JacksonXmlProperty(localName = "incMagDef")
    private Double incMagDef;

    @NotNull
    @JacksonXmlProperty(localName = "numUnitBlock")
    private Integer numUnitBlock;

    @NotNull
    @JacksonXmlProperty(localName = "moveSpeed")
    private Double moveSpeed;

    @NotNull
    @JacksonXmlProperty(localName = "attackSpeed")
    private Integer attackSpeed;

    @NotNull
    @JacksonXmlProperty(localName = "skillSpeed")
    private Integer skillSpeed;

    @NotNull
    @JacksonXmlProperty(localName = "attackRange")
    private Integer attackRange;

    @NotNull
    @JacksonXmlProperty(localName = "skillRange")
    private Integer skillRange;

    @NotNull
    @JacksonXmlProperty(localName = "evadePercent")
    private Double evadePercent;

    @NotNull
    @JacksonXmlProperty(localName = "blockPercent")
    private Double blockPercent;

    @NotNull
    @JacksonXmlProperty(localName = "criticalPercent")
    private Double criticalPercent;

    @NotNull
    @JacksonXmlProperty(localName = "criticalDamage")
    private Double criticalDamage;

    @NotNull
    @JacksonXmlProperty(localName = "splashRange")
    private Integer splashRange;

    @NotNull
    @JacksonXmlProperty(localName = "splashDamage")
    private Double splashDamage;

    @NotNull
    @JacksonXmlProperty(localName = "specialSkill")
    private Integer specialSkill;

    @NotNull
    @JacksonXmlProperty(localName = "passiveSkill")
    private Integer passiveSkill;

    @NotNull
    @JacksonXmlProperty(localName = "reviveTime")
    private Integer reviveTime;

    @NotBlank
    @JacksonXmlProperty(localName = "bloody")
    private String bloody; //TODO: convert to boolean

    @NotBlank
    @JacksonXmlProperty(localName = "explodeDie")
    private String explodeDie; //TODO: convert to boolean

    @NotBlank
    @JacksonXmlProperty(localName = "des")
    private String des;

    @NotBlank
    @JacksonXmlProperty(localName = "message")
    @Translate(key="UNIT_DESC_{id}")
    private String message;

    @NotBlank
    @JacksonXmlProperty(localName = "skillList")
    private String skillList;

    @NotBlank
    @JacksonXmlProperty(localName = "powerList")
    private String powerList;

    @NotNull
    @JacksonXmlProperty(localName = "rank")
    private Integer rank;

    @NotBlank
    @JacksonXmlProperty(localName = "sex")
    private String sex; //TODO: convert to boolean

    @NotBlank
    @JacksonXmlProperty(localName = "orthoGrade")
    private String orthoGrade; //TODO: convert to boolean

    @NotNull
    @JacksonXmlProperty(localName = "shop")
    private Integer shop;

    @NotBlank
    @JacksonXmlProperty(localName = "showBook")
    private String showBook; //TODO: convert to boolean

    @NotNull
    @JacksonXmlProperty(localName = "ratingPosition")
    private Integer ratingPosition;

    @NotNull
    @JacksonXmlProperty(localName = "trans")
    private Integer trans;

    @NotBlank
    @JacksonXmlProperty(localName = "material1")
    private String material1;

    @NotBlank
    @JacksonXmlProperty(localName = "material2")
    private String material2;

    @NotBlank
    @JacksonXmlProperty(localName = "material3")
    private String material3;

    @NotNull
    @JacksonXmlProperty(localName = "starBuff")
    private Integer starBuff;

    @NotNull
    @JacksonXmlProperty(localName = "jewelBuff")
    private Integer jewelBuff;

    @NotBlank
    @JacksonXmlProperty(localName = "groundAir")
    private String groundAir; //TODO: convert to boolean

    @NotNull
    @JacksonXmlProperty(localName = "offlineSpeed")
    private Double offlineSpeed;

    @NotNull
    @JacksonXmlProperty(localName = "offlineTime")
    private Integer offlineTime;

    @NotBlank
    @JacksonXmlProperty(localName = "hasHeart")
    private String hasHeart; //TODO: convert to boolean

    @NotBlank
    @JacksonXmlProperty(localName = "canDetect")
    private String canDetect; //TODO: convert to boolean

    @NotBlank
    @JacksonXmlProperty(localName = "cloaking")
    private String cloaking; //TODO: convert to boolean

    @NotNull
    @JacksonXmlProperty(localName = "starBuffFromPet")
    private Integer starBuffFromPet;

    @NotNull
    @JacksonXmlProperty(localName = "isHonor")
    private Integer isHonor;

    @NotNull
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
        return "UnitXML{" +
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

        UnitXML unitXML = (UnitXML) o;

        if (id != null ? !id.equals(unitXML.id) : unitXML.id != null) return false;
        if (tribe != null ? !tribe.equals(unitXML.tribe) : unitXML.tribe != null) return false;
        if (className != null ? !className.equals(unitXML.className) : unitXML.className != null) return false;
        if (name != null ? !name.equals(unitXML.name) : unitXML.name != null) return false;
        if (cost != null ? !cost.equals(unitXML.cost) : unitXML.cost != null) return false;
        if (shopGem != null ? !shopGem.equals(unitXML.shopGem) : unitXML.shopGem != null) return false;
        if (evolveGem != null ? !evolveGem.equals(unitXML.evolveGem) : unitXML.evolveGem != null) return false;
        if (coin != null ? !coin.equals(unitXML.coin) : unitXML.coin != null) return false;
        if (rare != null ? !rare.equals(unitXML.rare) : unitXML.rare != null) return false;
        if (size != null ? !size.equals(unitXML.size) : unitXML.size != null) return false;
        if (evolKindNum != null ? !evolKindNum.equals(unitXML.evolKindNum) : unitXML.evolKindNum != null) return false;
        if (attackType != null ? !attackType.equals(unitXML.attackType) : unitXML.attackType != null) return false;
        if (isAirUnit != null ? !isAirUnit.equals(unitXML.isAirUnit) : unitXML.isAirUnit != null) return false;
        if (damageType != null ? !damageType.equals(unitXML.damageType) : unitXML.damageType != null) return false;
        if (hasSkill != null ? !hasSkill.equals(unitXML.hasSkill) : unitXML.hasSkill != null) return false;
        if (skillAttackType != null ? !skillAttackType.equals(unitXML.skillAttackType) : unitXML.skillAttackType != null)
            return false;
        if (skillDamageType != null ? !skillDamageType.equals(unitXML.skillDamageType) : unitXML.skillDamageType != null)
            return false;
        if (initHp != null ? !initHp.equals(unitXML.initHp) : unitXML.initHp != null) return false;
        if (incHp != null ? !incHp.equals(unitXML.incHp) : unitXML.incHp != null) return false;
        if (initDamage != null ? !initDamage.equals(unitXML.initDamage) : unitXML.initDamage != null) return false;
        if (incDamage != null ? !incDamage.equals(unitXML.incDamage) : unitXML.incDamage != null) return false;
        if (initPhyDef != null ? !initPhyDef.equals(unitXML.initPhyDef) : unitXML.initPhyDef != null) return false;
        if (incPhyDef != null ? !incPhyDef.equals(unitXML.incPhyDef) : unitXML.incPhyDef != null) return false;
        if (initMagDef != null ? !initMagDef.equals(unitXML.initMagDef) : unitXML.initMagDef != null) return false;
        if (incMagDef != null ? !incMagDef.equals(unitXML.incMagDef) : unitXML.incMagDef != null) return false;
        if (numUnitBlock != null ? !numUnitBlock.equals(unitXML.numUnitBlock) : unitXML.numUnitBlock != null) return false;
        if (moveSpeed != null ? !moveSpeed.equals(unitXML.moveSpeed) : unitXML.moveSpeed != null) return false;
        if (attackSpeed != null ? !attackSpeed.equals(unitXML.attackSpeed) : unitXML.attackSpeed != null) return false;
        if (skillSpeed != null ? !skillSpeed.equals(unitXML.skillSpeed) : unitXML.skillSpeed != null) return false;
        if (attackRange != null ? !attackRange.equals(unitXML.attackRange) : unitXML.attackRange != null) return false;
        if (skillRange != null ? !skillRange.equals(unitXML.skillRange) : unitXML.skillRange != null) return false;
        if (evadePercent != null ? !evadePercent.equals(unitXML.evadePercent) : unitXML.evadePercent != null) return false;
        if (blockPercent != null ? !blockPercent.equals(unitXML.blockPercent) : unitXML.blockPercent != null) return false;
        if (criticalPercent != null ? !criticalPercent.equals(unitXML.criticalPercent) : unitXML.criticalPercent != null)
            return false;
        if (criticalDamage != null ? !criticalDamage.equals(unitXML.criticalDamage) : unitXML.criticalDamage != null)
            return false;
        if (splashRange != null ? !splashRange.equals(unitXML.splashRange) : unitXML.splashRange != null) return false;
        if (splashDamage != null ? !splashDamage.equals(unitXML.splashDamage) : unitXML.splashDamage != null) return false;
        if (specialSkill != null ? !specialSkill.equals(unitXML.specialSkill) : unitXML.specialSkill != null) return false;
        if (passiveSkill != null ? !passiveSkill.equals(unitXML.passiveSkill) : unitXML.passiveSkill != null) return false;
        if (reviveTime != null ? !reviveTime.equals(unitXML.reviveTime) : unitXML.reviveTime != null) return false;
        if (bloody != null ? !bloody.equals(unitXML.bloody) : unitXML.bloody != null) return false;
        if (explodeDie != null ? !explodeDie.equals(unitXML.explodeDie) : unitXML.explodeDie != null) return false;
        if (des != null ? !des.equals(unitXML.des) : unitXML.des != null) return false;
        if (message != null ? !message.equals(unitXML.message) : unitXML.message != null) return false;
        if (skillList != null ? !skillList.equals(unitXML.skillList) : unitXML.skillList != null) return false;
        if (powerList != null ? !powerList.equals(unitXML.powerList) : unitXML.powerList != null) return false;
        if (rank != null ? !rank.equals(unitXML.rank) : unitXML.rank != null) return false;
        if (sex != null ? !sex.equals(unitXML.sex) : unitXML.sex != null) return false;
        if (orthoGrade != null ? !orthoGrade.equals(unitXML.orthoGrade) : unitXML.orthoGrade != null) return false;
        if (shop != null ? !shop.equals(unitXML.shop) : unitXML.shop != null) return false;
        if (showBook != null ? !showBook.equals(unitXML.showBook) : unitXML.showBook != null) return false;
        if (ratingPosition != null ? !ratingPosition.equals(unitXML.ratingPosition) : unitXML.ratingPosition != null)
            return false;
        if (trans != null ? !trans.equals(unitXML.trans) : unitXML.trans != null) return false;
        if (material1 != null ? !material1.equals(unitXML.material1) : unitXML.material1 != null) return false;
        if (material2 != null ? !material2.equals(unitXML.material2) : unitXML.material2 != null) return false;
        if (material3 != null ? !material3.equals(unitXML.material3) : unitXML.material3 != null) return false;
        if (starBuff != null ? !starBuff.equals(unitXML.starBuff) : unitXML.starBuff != null) return false;
        if (jewelBuff != null ? !jewelBuff.equals(unitXML.jewelBuff) : unitXML.jewelBuff != null) return false;
        if (groundAir != null ? !groundAir.equals(unitXML.groundAir) : unitXML.groundAir != null) return false;
        if (offlineSpeed != null ? !offlineSpeed.equals(unitXML.offlineSpeed) : unitXML.offlineSpeed != null) return false;
        if (offlineTime != null ? !offlineTime.equals(unitXML.offlineTime) : unitXML.offlineTime != null) return false;
        if (hasHeart != null ? !hasHeart.equals(unitXML.hasHeart) : unitXML.hasHeart != null) return false;
        if (canDetect != null ? !canDetect.equals(unitXML.canDetect) : unitXML.canDetect != null) return false;
        if (cloaking != null ? !cloaking.equals(unitXML.cloaking) : unitXML.cloaking != null) return false;
        if (starBuffFromPet != null ? !starBuffFromPet.equals(unitXML.starBuffFromPet) : unitXML.starBuffFromPet != null)
            return false;
        if (isHonor != null ? !isHonor.equals(unitXML.isHonor) : unitXML.isHonor != null) return false;
        return honorNumber != null ? honorNumber.equals(unitXML.honorNumber) : unitXML.honorNumber == null;
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
