/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityClassification
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.EntityType$Builder
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.event.RegistryEvent$Register
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.IForgeRegistryEntry
 */
package com.meteor.extrabotany.common.entities;

import com.meteor.extrabotany.common.entities.EntityFlamescionSlash;
import com.meteor.extrabotany.common.entities.EntityFlamescionSword;
import com.meteor.extrabotany.common.entities.EntityFlamescionUlt;
import com.meteor.extrabotany.common.entities.EntityFlamescionVoid;
import com.meteor.extrabotany.common.entities.EntityJudahOath;
import com.meteor.extrabotany.common.entities.EntityKeyOfTruth;
import com.meteor.extrabotany.common.entities.EntitySlash;
import com.meteor.extrabotany.common.entities.EntitySplashGrenade;
import com.meteor.extrabotany.common.entities.EntityStrengthenSlash;
import com.meteor.extrabotany.common.entities.ego.EntityEGO;
import com.meteor.extrabotany.common.entities.ego.EntityEGOBeam;
import com.meteor.extrabotany.common.entities.ego.EntityEGOLandmine;
import com.meteor.extrabotany.common.entities.ego.EntityEGOMinion;
import com.meteor.extrabotany.common.entities.herrscher.EntityHerrscher;
import com.meteor.extrabotany.common.entities.mountable.EntityMotor;
import com.meteor.extrabotany.common.entities.mountable.EntityUfo;
import com.meteor.extrabotany.common.entities.projectile.EntityAuraFire;
import com.meteor.extrabotany.common.entities.projectile.EntityButterflyProjectile;
import com.meteor.extrabotany.common.entities.projectile.EntityInfluxWaverProjectile;
import com.meteor.extrabotany.common.entities.projectile.EntityMagicArrow;
import com.meteor.extrabotany.common.entities.projectile.EntityPhantomSword;
import com.meteor.extrabotany.common.entities.projectile.EntityTrueShadowKatanaProjectile;
import com.meteor.extrabotany.common.entities.projectile.EntityTrueTerrabladeProjectile;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ModEntities {
    public static final EntityType<EntityMotor> MOTOR = EntityType.Builder.func_220322_a(EntityMotor::new, (EntityClassification)EntityClassification.MISC).func_220321_a(1.675f, 1.875f).setUpdateInterval(10).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntityKeyOfTruth> KEY_OF_TRUTH = EntityType.Builder.func_220322_a(EntityKeyOfTruth::new, (EntityClassification)EntityClassification.MISC).func_220321_a(0.1f, 0.1f).setUpdateInterval(10).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntitySlash> SLASH = EntityType.Builder.func_220322_a(EntitySlash::new, (EntityClassification)EntityClassification.MISC).func_220321_a(0.1f, 0.1f).setUpdateInterval(10).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntityUfo> UFO = EntityType.Builder.func_220322_a(EntityUfo::new, (EntityClassification)EntityClassification.MISC).func_220321_a(1.5f, 1.5f).setUpdateInterval(10).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntityPhantomSword> PHANTOMSWORD = EntityType.Builder.func_220322_a(EntityPhantomSword::new, (EntityClassification)EntityClassification.MISC).func_220321_a(0.1f, 0.1f).setUpdateInterval(10).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntityFlamescionSlash> FLAMESCIONSLASH = EntityType.Builder.func_220322_a(EntityFlamescionSlash::new, (EntityClassification)EntityClassification.MISC).func_220321_a(0.1f, 0.1f).setUpdateInterval(10).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntityStrengthenSlash> SRENGTHENSLASH = EntityType.Builder.func_220322_a(EntityStrengthenSlash::new, (EntityClassification)EntityClassification.MISC).func_220321_a(0.1f, 0.1f).setUpdateInterval(10).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntityFlamescionUlt> ULT = EntityType.Builder.func_220322_a(EntityFlamescionUlt::new, (EntityClassification)EntityClassification.MISC).func_220321_a(0.1f, 0.1f).setUpdateInterval(10).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntityFlamescionVoid> VOID = EntityType.Builder.func_220322_a(EntityFlamescionVoid::new, (EntityClassification)EntityClassification.MISC).func_220321_a(0.1f, 0.1f).setUpdateInterval(10).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntityFlamescionSword> SWORD = EntityType.Builder.func_220322_a(EntityFlamescionSword::new, (EntityClassification)EntityClassification.MISC).func_220321_a(0.1f, 0.1f).setUpdateInterval(10).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntityMagicArrow> MAGICARROW = EntityType.Builder.func_220322_a(EntityMagicArrow::new, (EntityClassification)EntityClassification.MISC).func_220321_a(0.05f, 0.05f).setUpdateInterval(5).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntitySplashGrenade> SPLASHGRENADE = EntityType.Builder.func_220322_a(EntitySplashGrenade::new, (EntityClassification)EntityClassification.MISC).func_220321_a(0.05f, 0.05f).setUpdateInterval(10).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntityInfluxWaverProjectile> INFLUXWAVER = EntityType.Builder.func_220322_a(EntityInfluxWaverProjectile::new, (EntityClassification)EntityClassification.MISC).func_220321_a(0.1f, 0.1f).setUpdateInterval(10).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntityTrueTerrabladeProjectile> TRUETERRABLADE = EntityType.Builder.func_220322_a(EntityTrueTerrabladeProjectile::new, (EntityClassification)EntityClassification.MISC).func_220321_a(0.1f, 0.1f).setUpdateInterval(10).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntityTrueShadowKatanaProjectile> TRUESHADOWKATANA = EntityType.Builder.func_220322_a(EntityTrueShadowKatanaProjectile::new, (EntityClassification)EntityClassification.MISC).func_220321_a(0.1f, 0.1f).setUpdateInterval(10).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntityAuraFire> AURAFIRE = EntityType.Builder.func_220322_a(EntityAuraFire::new, (EntityClassification)EntityClassification.MISC).func_220321_a(0.1f, 0.1f).setUpdateInterval(10).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntityJudahOath> JUDAHOATH = EntityType.Builder.func_220322_a(EntityJudahOath::new, (EntityClassification)EntityClassification.MISC).func_220321_a(0.1f, 0.1f).setUpdateInterval(10).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntityEGO> EGO = EntityType.Builder.func_220322_a(EntityEGO::new, (EntityClassification)EntityClassification.CREATURE).func_220321_a(0.6f, 1.8f).setUpdateInterval(2).setTrackingRange(128).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntityEGOMinion> EGOMINION = EntityType.Builder.func_220322_a(EntityEGOMinion::new, (EntityClassification)EntityClassification.CREATURE).func_220321_a(0.6f, 1.8f).setUpdateInterval(2).setTrackingRange(128).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntityEGOLandmine> EGOLANDMINE = EntityType.Builder.func_220322_a(EntityEGOLandmine::new, (EntityClassification)EntityClassification.MISC).func_220321_a(3.0f, 0.1f).setUpdateInterval(2).setTrackingRange(128).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntityButterflyProjectile> BUTTERFLY = EntityType.Builder.func_220322_a(EntityButterflyProjectile::new, (EntityClassification)EntityClassification.MISC).func_220321_a(0.1f, 0.1f).setUpdateInterval(10).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntityEGOBeam> EGOBEAM = EntityType.Builder.func_220322_a(EntityEGOBeam::new, (EntityClassification)EntityClassification.MISC).func_220321_a(0.5f, 2.0f).setUpdateInterval(2).setTrackingRange(128).setShouldReceiveVelocityUpdates(true).func_206830_a("");
    public static final EntityType<EntityHerrscher> HERRSCHER = EntityType.Builder.func_220322_a(EntityHerrscher::new, (EntityClassification)EntityClassification.CREATURE).func_220321_a(0.6f, 1.8f).setUpdateInterval(2).setTrackingRange(128).setShouldReceiveVelocityUpdates(true).func_206830_a("");

    public static void registerEntities(RegistryEvent.Register<EntityType<?>> evt) {
        IForgeRegistry r = evt.getRegistry();
        ModEntities.register(r, "keyoftruth", KEY_OF_TRUTH);
        ModEntities.register(r, "motor", MOTOR);
        ModEntities.register(r, "slash", SLASH);
        ModEntities.register(r, "ufo", UFO);
        ModEntities.register(r, "phantonsword", PHANTOMSWORD);
        ModEntities.register(r, "flamescionslash", FLAMESCIONSLASH);
        ModEntities.register(r, "strengthenslash", SRENGTHENSLASH);
        ModEntities.register(r, "flamescionult", ULT);
        ModEntities.register(r, "flamescionsword", SWORD);
        ModEntities.register(r, "void", VOID);
        ModEntities.register(r, "magicarrow", MAGICARROW);
        ModEntities.register(r, "splashgrenade", SPLASHGRENADE);
        ModEntities.register(r, "ego", EGO);
        ModEntities.register(r, "egominion", EGOMINION);
        ModEntities.register(r, "egolandmine", EGOLANDMINE);
        ModEntities.register(r, "egobeam", EGOBEAM);
        ModEntities.register(r, "herrscher", HERRSCHER);
        ModEntities.register(r, "judahoath", JUDAHOATH);
        ModEntities.register(r, "aurafire", AURAFIRE);
        ModEntities.register(r, "influxwaver_projectile", INFLUXWAVER);
        ModEntities.register(r, "trueterrablade_projectile", TRUETERRABLADE);
        ModEntities.register(r, "trueshadowkatana_projectile", TRUESHADOWKATANA);
        ModEntities.register(r, "butterfly_projectile", BUTTERFLY);
    }

    public static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, ResourceLocation name, IForgeRegistryEntry<V> thing) {
        reg.register((IForgeRegistryEntry)thing.setRegistryName(name));
    }

    public static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, String name, IForgeRegistryEntry<V> thing) {
        ModEntities.register(reg, new ResourceLocation("extrabotany", name), thing);
    }
}
