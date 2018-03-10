package com.macgregor.ef.util;

import com.macgregor.ef.model.canonical.*;

import java.util.Arrays;
import java.util.Collections;

public final class CanonicalTestModels {

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
        unit.setAirUnit(false);
        unit.setDamageType("magical");
        unit.setHasSkill(true);
        unit.setSkillAttackType("N");
        unit.setSkillDamageType("N");
        unit.setInitHp(9380.0f);
        unit.setIncHp(938.0f);
        unit.setInitDamage(5.0f);
        unit.setIncDamage(0.5f);
        unit.setInitPhyDef(20.0f);
        unit.setIncPhyDef(2.0f);
        unit.setInitMagDef(20.0f);
        unit.setIncMagDef(2.0f);
        unit.setNumUnitBlock(0);
        unit.setMoveSpeed(0.97f);
        unit.setAttackSpeed(95);
        unit.setSkillSpeed(120);
        unit.setAttackRange(620);
        unit.setSkillRange(400);
        unit.setEvadePercent(0.1f);
        unit.setBlockPercent(0.1f);
        unit.setCriticalPercent(0.2f);
        unit.setCriticalDamage(0.5f);
        unit.setSplashRange(0);
        unit.setSplashDamage(0.0f);
        unit.setSpecialSkill(1);
        unit.setPassiveSkill(0);
        unit.setReviveTime(1500);
        unit.setBloody(true);
        unit.setExplodeDie(false);
        unit.setDes("AA");
        unit.setMessage("BB");
        unit.setSkillList(Collections.singletonList(0));
        unit.setPowerList(Collections.singletonList(0));
        unit.setRank(6);
        unit.setSex("N");
        unit.setOrthoGrade(false);
        unit.setShop(0);
        unit.setShowBook(false);
        unit.setRatingPosition(0);
        unit.setTrans(0);
        unit.setMaterial1(Collections.singletonList(0));
        unit.setMaterial2(Collections.singletonList(0));
        unit.setMaterial3(Collections.singletonList(0));
        unit.setStarBuff(0);
        unit.setJewelBuff(0);
        unit.setGroundAir(false);
        unit.setOfflineSpeed(0.0f);
        unit.setOfflineTime(0);
        unit.setHasHeart(false);
        unit.setCanDetect(false);
        unit.setCloaking(false);
        unit.setStarBuffFromPet(0);
        unit.setHonor(false);
        unit.setHonorNumber(0);

        return unit;
    }

    public static Unit getTranslatedUnit(){
        Unit unit = CanonicalTestModels.getUnit();
        unit.setName("success");
        unit.setMessage("success");
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
        pet.setValue1(Arrays.asList(300f,800f,3000f,8000f,15000f));
        pet.setSkill2(102);
        pet.setValue2(Arrays.asList(3,6,9,12,15));
        pet.setValue3(Arrays.asList(0,0,0,0,0));
        pet.setMasterSkill(291);
        pet.setCouple(14);
        pet.setIncGoldLevel(Arrays.asList(2,4,5,6,10));
        pet.setTreasure(0);
        pet.setPercent(true);
        pet.setAlpha(false);

        return pet;
    }

    public static PetSkill getPetSkill(){
        PetSkill petSkill = new PetSkill();
        petSkill.setId(514);
        petSkill.setNamedId("OFR");
        petSkill.setName("Orc FriendShip Up");
        petSkill.setType("SUPPORT");
        petSkill.setDesc("오크종족의 우호도 증가");
        petSkill.setSub(null);
        petSkill.setMisc(null);

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
        artifact.setOpenCost(Arrays.asList(10000L,10000L,0L,0L,0L));
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
        artifact.setShowDesc(true);
        artifact.setSortId(29);

        return artifact;
    }

    public static Artifact getTranslatedArtifact(){
        Artifact artifact = CanonicalTestModels.getArtifact();
        artifact.setDesc("success");
        artifact.setName("success");
        return artifact;
    }

    public static ArtifactSet getArtifactSet(){
        ArtifactSet artifactSet = new ArtifactSet();
        artifactSet.setId(1);
        artifactSet.setTitle("음양 정령도 세트");
        artifactSet.setItemList(Arrays.asList(47,48));
        artifactSet.setNumSetList(Arrays.asList(2));
        artifactSet.setSkillList(Arrays.asList("questGoldGain_A","attackSpeed_A"));
        artifactSet.setValueList(Arrays.asList(Collections.singletonList(3725),Collections.singletonList(6)));
        artifactSet.setValueList1(Arrays.asList(Collections.singletonList(2880000),Collections.singletonList(7)));
        artifactSet.setValueList2(Arrays.asList(Collections.singletonList(4425000),Collections.singletonList(8)));
        artifactSet.setDesc("퀘스트 골드획득 증가#공격속도 증가");
        artifactSet.setHistory(null);
        artifactSet.setShowDesc(true);

        return artifactSet;
    }

    public static ArtifactSet getTranslatedArtifactSet(){
        ArtifactSet artifactSet = CanonicalTestModels.getArtifactSet();
        artifactSet.setTitle("success");
        artifactSet.setDesc("success");
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

    public static UnitSkill getTranslatedUnitSkill(){
        UnitSkill unitSkill = CanonicalTestModels.getUnitSkill();
        unitSkill.setDesc("success");
        return unitSkill;
    }

    public static Translation getTranslation(){
        Translation translation = new Translation();
        translation.setId("ACHIEVE_DESC_2");
        translation.setValue("Maximum Unit Number");

        return translation;
    }
}
