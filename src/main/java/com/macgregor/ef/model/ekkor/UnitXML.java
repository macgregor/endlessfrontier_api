package com.macgregor.ef.model.ekkor;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.macgregor.ef.dataload.annotations.*;
import com.macgregor.ef.model.canonical.Unit;

import javax.validation.constraints.NotNull;

@JacksonXmlRootElement(localName = "unit")
@CanonicalModel(type=Unit.class)
public class UnitXML extends AbstractXMLModel {

    @JacksonXmlProperty(localName = "kindNum")
    @CanonicalField
    private Integer id;

    @JacksonXmlProperty(localName = "tribe")
    @CanonicalField
    private Integer tribe;

    @JacksonXmlProperty(localName = "className")
    @CanonicalField
    private String className;

    @JacksonXmlProperty(localName = "name")
    @CanonicalField
    @Translate(key="UNIT_NAME_{id}")
    private String name;

    @JacksonXmlProperty(localName = "cost")
    @CanonicalField(mapsTo = "unitShopMedalCost")
    private Integer cost;

    @JacksonXmlProperty(localName = "shopGem")
    @CanonicalField(mapsTo = "unitShopGemCost")
    private Integer shopGem;

    @JacksonXmlProperty(localName = "evolveGem")
    @CanonicalField(mapsTo = "evolveGemCost")
    private Integer evolveGem;

    @JacksonXmlProperty(localName = "coin")
    @CanonicalField(mapsTo = "honorShopCoinCost")
    private Integer coin;

    @JacksonXmlProperty(localName = "rare")
    @CanonicalField
    private Integer rare;

    @JacksonXmlProperty(localName = "size")
    @CanonicalField
    private Integer size;

    @JacksonXmlProperty(localName = "evolKindNum")
    @CanonicalField(mapsTo = "evolutionUnitId")
    private Integer evolKindNum;

    @JacksonXmlProperty(localName = "attackType")
    @CanonicalField(mapsTo = "basicAttackType")
    private String attackType;

    @JacksonXmlProperty(localName = "isAirUnit")
    @CanonicalField
    private String isAirUnit;

    @JacksonXmlProperty(localName = "damageType")
    @CanonicalField(mapsTo = "basicAttackDamageType")
    private String damageType;

    @JacksonXmlProperty(localName = "hasSkill")
    @CanonicalField
    private String hasSkill;

    @JacksonXmlProperty(localName = "skillAttackType")
    @CanonicalField
    private String skillAttackType;

    @JacksonXmlProperty(localName = "skillDamageType")
    @CanonicalField(mapsTo = "skillAttackDamageType")
    private String skillDamageType;

    @JacksonXmlProperty(localName = "initHp")
    @CanonicalField
    private Float initHp;

    @JacksonXmlProperty(localName = "incHp")
    @CanonicalField
    private Float incHp;

    @JacksonXmlProperty(localName = "initDamage")
    @CanonicalField
    private Float initDamage;

    @JacksonXmlProperty(localName = "incDamage")
    @CanonicalField
    private Float incDamage;

    @JacksonXmlProperty(localName = "initPhyDef")
    @CanonicalField
    private Float initPhyDef;

    @JacksonXmlProperty(localName = "incPhyDef")
    @CanonicalField
    private Float incPhyDef;

    @JacksonXmlProperty(localName = "initMagDef")
    @CanonicalField
    private Float initMagDef;

    @NotNull
    @JacksonXmlProperty(localName = "incMagDef")
    @CanonicalField
    private Float incMagDef;

    @JacksonXmlProperty(localName = "numUnitBlock")
    @CanonicalField
    private Integer numUnitBlock;

    @JacksonXmlProperty(localName = "moveSpeed")
    @CanonicalField
    private Float moveSpeed;

    @JacksonXmlProperty(localName = "attackSpeed")
    @CanonicalField(mapsTo = "basicAttackSpeed")
    private Integer attackSpeed;

    @JacksonXmlProperty(localName = "skillSpeed")
    @CanonicalField(mapsTo = "skillAttackSpeed")
    private Integer skillSpeed;

    @JacksonXmlProperty(localName = "attackRange")
    @CanonicalField(mapsTo = "basicAttackRange")
    private Integer attackRange;

    @JacksonXmlProperty(localName = "skillRange")
    @CanonicalField(mapsTo = "skillAttackRange")
    private Integer skillRange;

    @JacksonXmlProperty(localName = "evadePercent")
    @CanonicalField
    private Float evadePercent;

    @JacksonXmlProperty(localName = "blockPercent")
    @CanonicalField
    private Float blockPercent;

    @JacksonXmlProperty(localName = "criticalPercent")
    @CanonicalField
    private Float criticalPercent;

    @JacksonXmlProperty(localName = "criticalDamage")
    @CanonicalField
    private Float criticalDamage;

    @JacksonXmlProperty(localName = "splashRange")
    @CanonicalField
    private Integer splashRange;

    @JacksonXmlProperty(localName = "splashDamage")
    @CanonicalField
    private Float splashDamage;

    @JacksonXmlProperty(localName = "specialSkill")
    @CanonicalField
    private Integer specialSkill;

    @JacksonXmlProperty(localName = "passiveSkill")
    @CanonicalField
    private Integer passiveSkill;

    @JacksonXmlProperty(localName = "reviveTime")
    @CanonicalField
    private Integer reviveTime;

    @JacksonXmlProperty(localName = "bloody")
    @CanonicalField
    private String bloody;

    @JacksonXmlProperty(localName = "explodeDie")
    @CanonicalField
    private String explodeDie;

    @JacksonXmlProperty(localName = "des")
    @CanonicalField
    private String des;

    @JacksonXmlProperty(localName = "message")
    @CanonicalField
    @Translate(key="UNIT_DESC_{id}")
    private String message;

    @JacksonXmlProperty(localName = "skillList")
    @CanonicalField(mapsTo = "unitSkillList")
    private String skillList;

    @JacksonXmlProperty(localName = "powerList")
    @CanonicalField(mapsTo = "unitSkillListModifiers")
    private String powerList;

    @JacksonXmlProperty(localName = "rank")
    @CanonicalField
    private Integer rank;

    @JacksonXmlProperty(localName = "sex")
    @CanonicalField
    private String sex;

    @JacksonXmlProperty(localName = "orthoGrade")
    @CanonicalField
    private String orthoGrade;

    @JacksonXmlProperty(localName = "shop")
    @CanonicalField
    private Integer shop;

    @JacksonXmlProperty(localName = "showBook")
    @CanonicalField
    private String showBook;

    @JacksonXmlProperty(localName = "ratingPosition")
    @CanonicalField
    private Integer ratingPosition;

    @JacksonXmlProperty(localName = "trans")
    @CanonicalField(mapsTo = "maxTransLevel")
    private Integer trans;

    @JacksonXmlProperty(localName = "material1")
    @CanonicalField(mapsTo = "transMaterialT1")
    private String material1;

    @JacksonXmlProperty(localName = "material2")
    @CanonicalField(mapsTo = "transMaterialT2")
    private String material2;

    @JacksonXmlProperty(localName = "material3")
    @CanonicalField(mapsTo = "transMaterialT3")
    private String material3;

    @JacksonXmlProperty(localName = "starBuff")
    @CanonicalField(mapsTo = "medalBuff")
    private Integer starBuff;

    @JacksonXmlProperty(localName = "jewelBuff")
    @CanonicalField
    private Integer jewelBuff;

    @JacksonXmlProperty(localName = "groundAir")
    @CanonicalField
    private String groundAir;

    @JacksonXmlProperty(localName = "offlineSpeed")
    @CanonicalField(mapsTo = "offlineMarchSpeedBuff")
    private Float offlineSpeed;

    @JacksonXmlProperty(localName = "offlineTime")
    @CanonicalField
    private Integer offlineTime;

    @JacksonXmlProperty(localName = "hasHeart")
    @CanonicalField
    private String hasHeart;

    @JacksonXmlProperty(localName = "canDetect")
    @CanonicalField(mapsTo = "canDetectCloaked")
    private String canDetect;

    @JacksonXmlProperty(localName = "cloaking")
    @CanonicalField(mapsTo = "isCloaking")
    private String cloaking;

    @JacksonXmlProperty(localName = "starBuffFromPet")
    @CanonicalField(mapsTo = "medalBuffFromPet")
    private Integer starBuffFromPet;

    @JacksonXmlProperty(localName = "isHonor")
    @CanonicalField
    private Integer isHonor;

    @JacksonXmlProperty(localName = "honorNumber")
    @CanonicalField(mapsTo = "honorRotationNumber")
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

    public Integer getNumUnitBlock() {
        return numUnitBlock;
    }

    public void setNumUnitBlock(Integer numUnitBlock) {
        this.numUnitBlock = numUnitBlock;
    }

    public Float getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(Float moveSpeed) {
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

    public Float getOfflineSpeed() {
        return offlineSpeed;
    }

    public void setOfflineSpeed(Float offlineSpeed) {
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
        if (numUnitBlock != null ? !numUnitBlock.equals(unitXML.numUnitBlock) : unitXML.numUnitBlock != null)
            return false;
        if (moveSpeed != null ? !moveSpeed.equals(unitXML.moveSpeed) : unitXML.moveSpeed != null) return false;
        if (attackSpeed != null ? !attackSpeed.equals(unitXML.attackSpeed) : unitXML.attackSpeed != null) return false;
        if (skillSpeed != null ? !skillSpeed.equals(unitXML.skillSpeed) : unitXML.skillSpeed != null) return false;
        if (attackRange != null ? !attackRange.equals(unitXML.attackRange) : unitXML.attackRange != null) return false;
        if (skillRange != null ? !skillRange.equals(unitXML.skillRange) : unitXML.skillRange != null) return false;
        if (evadePercent != null ? !evadePercent.equals(unitXML.evadePercent) : unitXML.evadePercent != null)
            return false;
        if (blockPercent != null ? !blockPercent.equals(unitXML.blockPercent) : unitXML.blockPercent != null)
            return false;
        if (criticalPercent != null ? !criticalPercent.equals(unitXML.criticalPercent) : unitXML.criticalPercent != null)
            return false;
        if (criticalDamage != null ? !criticalDamage.equals(unitXML.criticalDamage) : unitXML.criticalDamage != null)
            return false;
        if (splashRange != null ? !splashRange.equals(unitXML.splashRange) : unitXML.splashRange != null) return false;
        if (splashDamage != null ? !splashDamage.equals(unitXML.splashDamage) : unitXML.splashDamage != null)
            return false;
        if (specialSkill != null ? !specialSkill.equals(unitXML.specialSkill) : unitXML.specialSkill != null)
            return false;
        if (passiveSkill != null ? !passiveSkill.equals(unitXML.passiveSkill) : unitXML.passiveSkill != null)
            return false;
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
        if (offlineSpeed != null ? !offlineSpeed.equals(unitXML.offlineSpeed) : unitXML.offlineSpeed != null)
            return false;
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
}
