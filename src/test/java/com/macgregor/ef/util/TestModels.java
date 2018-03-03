package com.macgregor.ef.util;

import com.macgregor.ef.model.*;

public final class TestModels {

    public static Unit getUnit() {
        Unit unit = new Unit();
        unit.setId(2021);
        unit.setTribe(5);
        unit.setClassName("Mamon");
        unit.setName("지옥의 군주 마몬");
        unit.setCost(0);
        unit.setShopGem(-1);
        unit.setEvolveGem(-1);
        unit.setCoin(0);
        unit.setRare(10);
        unit.setSize(4);
        unit.setEvolKindNum(-1);
        unit.setAttackType("melee");
        unit.setIsAirUnit("N");
        unit.setDamageType("magical");
        unit.setHasSkill("Y");
        unit.setSkillAttackType("N");
        unit.setSkillDamageType("N");
        unit.setInitHp(9380.0);
        unit.setIncHp(938.0);
        unit.setInitDamage(5.0);
        unit.setIncDamage(0.5);
        unit.setInitPhyDef(20.0);
        unit.setIncPhyDef(2.0);
        unit.setInitMagDef(20.0);
        unit.setIncMagDef(2.0);
        unit.setNumUnitBlock(0);
        unit.setMoveSpeed(0.97);
        unit.setAttackSpeed(95);
        unit.setSkillSpeed(120);
        unit.setAttackRange(620);
        unit.setSkillRange(400);
        unit.setEvadePercent(0.1);
        unit.setBlockPercent(0.1);
        unit.setCriticalPercent(0.2);
        unit.setCriticalDamage(0.5);
        unit.setSplashRange(0);
        unit.setSplashDamage(0.0);
        unit.setSpecialSkill(1);
        unit.setPassiveSkill(0);
        unit.setReviveTime(1500);
        unit.setBloody("Y");
        unit.setExplodeDie("N");
        unit.setDes("AA");
        unit.setMessage("BB");
        unit.setSkillList("0");
        unit.setPowerList("0");
        unit.setRank(6);
        unit.setSex("N");
        unit.setOrthoGrade("N");
        unit.setShop(0);
        unit.setShowBook("N");
        unit.setRatingPosition(0);
        unit.setTrans(0);
        unit.setMaterial1("0");
        unit.setMaterial2("0");
        unit.setMaterial3("0");
        unit.setStarBuff(0);
        unit.setJewelBuff(0);
        unit.setGroundAir("N");
        unit.setOfflineSpeed(0.0);
        unit.setOfflineTime(0);
        unit.setHasHeart("N");
        unit.setCanDetect("N");
        unit.setCloaking("N");
        unit.setStarBuffFromPet(0);
        unit.setIsHonor(0);
        unit.setHonorNumber(0);

        return unit;
    }

    public static Tribe getTribe(){
        Tribe tribe = new Tribe();
        tribe.setId(1);
        tribe.setName("human");
        return tribe;
    }

    public static Pet getPet(){
        Pet pet = new Pet();
        pet.setId(1);
        pet.setClassName("Mambo");
        pet.setName("맘보");
        pet.setTribe(1);
        pet.setType("ground");
        pet.setRank(1);
        pet.setSkill1(1);
        pet.setValue1("300|800|3000|8000|15000");
        pet.setSkill2(102);
        pet.setValue2("3|6|9|12|15");
        pet.setValue3("0|0|0|0|0");
        pet.setMasterSkill(291);
        pet.setCouple(14);
        pet.setIncGoldLevel("2|4|6|8|10");
        pet.setTreasure(0);
        pet.setIsPercent("Y");
        pet.setIsAlpha("N");

        return pet;
    }

    public static PetSkill getPetSkill(){
        PetSkill petSkill = new PetSkill();
        petSkill.setId(514);
        petSkill.setNamedId("OFR");
        petSkill.setName("Orc FriendShip Up");
        petSkill.setType("SUPPORT");
        petSkill.setDesc("오크종족의 우호도 증가");
        petSkill.setSub("");
        petSkill.setMisc("");

        return petSkill;
    }

    public static Artifact getArtifact(){
        Artifact artifact = new Artifact();
        artifact.setId(29);
        artifact.setName("늑대가죽 부츠");
        artifact.setMainCode("S");
        artifact.setSubCode(2);
        artifact.setGrade(3);
        artifact.setMaxLv(20);
        artifact.setDesc("언데드,오크 병사출진 시간감소|던전보스 체력감소|");
        artifact.setOpenCost("10000|10000|0|0|0");
        artifact.setSkillCode1("unitBattleTime_UO");
        artifact.setAbility1(77);
        artifact.setAbility11(0);
        artifact.setAbility21(0);
        artifact.setSkillCode2("dungeonBossHp_A");
        artifact.setAbility2(77);
        artifact.setAbility12(0);
        artifact.setAbility22(0);
        artifact.setSkillCode3("");
        artifact.setAbility3(0);
        artifact.setUpgradeCostType(3);
        artifact.setShowDesc("Y");
        artifact.setSortId(29);

        return artifact;
    }

    public static ArtifactSet getArtifactSet(){
        ArtifactSet artifactSet = new ArtifactSet();
        artifactSet.setId(1);
        artifactSet.setTitle("음양 정령도 세트");
        artifactSet.setItemList("47|48");
        artifactSet.setNumSetList("2");
        artifactSet.setSkillList("questGoldGain_A#attackSpeed_A");
        artifactSet.setValueList("3725#6");
        artifactSet.setValueList1("2880000#7");
        artifactSet.setValueList2("4425000#8");
        artifactSet.setDesc("퀘스트 골드획득 증가#공격속도 증가");
        artifactSet.setHistory("");
        artifactSet.setShowDesc("Y");

        return artifactSet;
    }

    public static UnitSkill getUnitSkill(){
        UnitSkill unitSkill = new UnitSkill();
        unitSkill.setId(11);
        unitSkill.setSkillCode("THU");
        unitSkill.setImgIndex(9);
        unitSkill.setBaseValue(1);
        unitSkill.setDesc("자기종족 체력 증가");

        return unitSkill;
    }

    public static Translation getTranslation(){
        Translation translation = new Translation();
        translation.setId("ACHIEVE_DESC_2");
        translation.setValue("Maximum Unit Number");

        return translation;
    }
}
