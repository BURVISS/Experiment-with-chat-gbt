/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.network.IPacket
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.network.datasync.IDataSerializer
 *  net.minecraft.particles.IParticleData
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.potion.Effects
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.vector.Vector3d
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.network.NetworkHooks
 *  vazkii.botania.client.fx.WispParticleData
 *  vazkii.botania.common.core.handler.ModSounds
 */
package com.meteor.extrabotany.common.entities.ego;

import com.meteor.extrabotany.common.core.Helper;
import com.meteor.extrabotany.common.entities.ModEntities;
import com.meteor.extrabotany.common.entities.ego.EntityEGO;
import com.meteor.extrabotany.common.handler.DamageHandler;
import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.IDataSerializer;
import net.minecraft.particles.IParticleData;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import vazkii.botania.client.fx.WispParticleData;
import vazkii.botania.common.core.handler.ModSounds;

public class EntityEGOLandmine
extends Entity {
    public EntityEGO summoner;
    private static final String TAG_TYPE = "type";
    private static final DataParameter<Integer> TYPE = EntityDataManager.func_187226_a(EntityEGOLandmine.class, (IDataSerializer)DataSerializers.field_187192_b);

    public EntityEGOLandmine(EntityType<EntityEGOLandmine> type, World world) {
        super(type, world);
    }

    public EntityEGOLandmine(World world) {
        super(ModEntities.EGOLANDMINE, world);
    }

    public static void spawnLandmine(int wave, World world, BlockPos source, EntityEGO ego) {
        Vector3d vecSource = Helper.PosToVec(source);
        Vector3d unit = new Vector3d(2.0, 0.0, 0.0);
        if (!world.field_72995_K) {
            switch (wave) {
                case 0: {
                    for (int i = 0; i < 8; ++i) {
                        unit = unit.func_178785_b((float)(0.7853981633974483 * (double)i));
                        for (int j = 0; j < 8; ++j) {
                            Vector3d end = vecSource.func_178787_e(unit.func_216372_d((double)(j + 1), (double)(j + 1), (double)(j + 1)));
                            int k = j % 4 == 0 ? 2 : 0;
                            EntityEGOLandmine landmine = new EntityEGOLandmine(world);
                            landmine.summoner = ego;
                            landmine.func_70107_b(end.field_72450_a, end.field_72448_b, end.field_72449_c);
                            landmine.setLandmineType(k);
                            world.func_217376_c((Entity)landmine);
                        }
                    }
                    break;
                }
                case 1: {
                    for (int i = 0; i < 5; ++i) {
                        for (int j = 0; j < 16; ++j) {
                            Vector3d u = unit.func_178787_e(new Vector3d(3.0, 0.0, 0.0).func_216372_d((double)i, 0.0, 0.0));
                            u = u.func_178785_b((float)(0.39269908169872414 * (double)j));
                            Vector3d end = vecSource.func_178787_e(u);
                            int k = i % 3;
                            EntityEGOLandmine landmine = new EntityEGOLandmine(world);
                            landmine.summoner = ego;
                            landmine.func_70107_b(end.field_72450_a, end.field_72448_b, end.field_72449_c);
                            landmine.setLandmineType(k);
                            world.func_217376_c((Entity)landmine);
                        }
                    }
                    break;
                }
                case 2: {
                    for (int i = 0; i < 72; ++i) {
                        double p = (double)i * Math.PI / 12.0;
                        double r = 1.0 + 1.0 * p;
                        double x = r * Math.cos(p);
                        double z = r * Math.sin(p);
                        double y = vecSource.field_72448_b;
                        int k = i % 5 == 0 ? 2 : 0;
                        EntityEGOLandmine landmine = new EntityEGOLandmine(world);
                        landmine.summoner = ego;
                        landmine.func_70107_b(vecSource.field_72450_a + x, y, vecSource.field_72449_c + z);
                        landmine.setLandmineType(k);
                        world.func_217376_c((Entity)landmine);
                    }
                    break;
                }
                case 3: {
                    for (int i = 0; i < 80; ++i) {
                        double p = (double)i * Math.PI / 80.0;
                        double r = 24.0 * Math.sin(5.0 * p);
                        double x = r * Math.cos(p);
                        double z = r * Math.sin(p);
                        double y = vecSource.field_72448_b;
                        int k = i % 4 == 0 ? 2 : 0;
                        EntityEGOLandmine landmine = new EntityEGOLandmine(world);
                        landmine.summoner = ego;
                        landmine.func_70107_b(vecSource.field_72450_a + x, y, vecSource.field_72449_c + z);
                        landmine.setLandmineType(k);
                        world.func_217376_c((Entity)landmine);
                    }
                    break;
                }
                case 4: {
                    for (int i = 0; i < 8; ++i) {
                        for (int j = 0; j < 16; ++j) {
                            Vector3d u = unit.func_216372_d(3.0, 0.0, 3.0);
                            u = u.func_178785_b((float)(0.39269908169872414 * (double)j));
                            Vector3d end = vecSource.func_178787_e(unit.func_216372_d(6.0, 0.0, 6.0).func_178785_b((float)(0.7853981633974483 * (double)i))).func_178787_e(u);
                            int k = i % 3;
                            EntityEGOLandmine landmine = new EntityEGOLandmine(world);
                            landmine.summoner = ego;
                            landmine.func_70107_b(end.field_72450_a, end.field_72448_b, end.field_72449_c);
                            landmine.setLandmineType(k);
                            world.func_217376_c((Entity)landmine);
                        }
                    }
                    break;
                }
                case 5: {
                    for (int i = 0; i < 6; ++i) {
                        Vector3d mp = vecSource.func_178787_e(unit.func_216372_d(5.0, 0.0, 5.0).func_178785_b((float)(1.0471975511965976 * (double)i)));
                        EntityEGOLandmine mid = new EntityEGOLandmine(world);
                        mid.summoner = ego;
                        mid.func_70107_b(mp.field_72450_a, mp.field_72448_b, mp.field_72449_c);
                        mid.setLandmineType(0);
                        world.func_217376_c((Entity)mid);
                        for (int j = 0; j < 16; ++j) {
                            Vector3d u = unit.func_216372_d(2.0, 0.0, 2.0).func_178785_b((float)(0.39269908169872414 * (double)j));
                            Vector3d end = mp.func_178787_e(u);
                            EntityEGOLandmine landmine = new EntityEGOLandmine(world);
                            landmine.summoner = ego;
                            landmine.func_70107_b(end.field_72450_a, end.field_72448_b, end.field_72449_c);
                            landmine.setLandmineType(2);
                            world.func_217376_c((Entity)landmine);
                        }
                    }
                    break;
                }
                case 6: {
                    for (int i = 0; i < 72; ++i) {
                        Vector3d mp = vecSource.func_178787_e(unit.func_216372_d(7.0, 0.0, 7.0).func_178785_b((float)(0.08726646259971647 * (double)i)));
                        EntityEGOLandmine mid = new EntityEGOLandmine(world);
                        mid.summoner = ego;
                        mid.func_70107_b(mp.field_72450_a, mp.field_72448_b, mp.field_72449_c);
                        mid.setLandmineType(2);
                        world.func_217376_c((Entity)mid);
                        if (i % 5 != 0) continue;
                        for (int j = 0; j < 12; ++j) {
                            Vector3d u = unit.func_216372_d(4.0, 0.0, 4.0).func_178785_b((float)(0.5235987755982988 * (double)j));
                            Vector3d end = mp.func_178787_e(u);
                            EntityEGOLandmine landmine = new EntityEGOLandmine(world);
                            landmine.summoner = ego;
                            landmine.func_70107_b(end.field_72450_a, end.field_72448_b, end.field_72449_c);
                            landmine.setLandmineType(i % 2);
                            world.func_217376_c((Entity)landmine);
                        }
                    }
                    break;
                }
                case 7: {
                    for (int i = 0; i < 6; ++i) {
                        for (int l1 = 0; l1 < 11; ++l1) {
                            Vector3d mp = vecSource.func_178787_e(unit.func_216372_d((double)l1, 0.0, (double)l1).func_178785_b((float)(1.0471975511965976 * (double)i)));
                            EntityEGOLandmine mid = new EntityEGOLandmine(world);
                            mid.summoner = ego;
                            mid.func_70107_b(mp.field_72450_a, mp.field_72448_b, mp.field_72449_c);
                            mid.setLandmineType(1);
                            world.func_217376_c((Entity)mid);
                            if (l1 != 5) continue;
                            for (int j = 0; j < 6; ++j) {
                                for (int l2 = 0; l2 < 7; ++l2) {
                                    Vector3d end = mp.func_178787_e(unit.func_216372_d((double)((float)l2 * 0.6f), 0.0, (double)((float)l2 * 0.6f)).func_178785_b((float)(1.0471975511965976 * (double)j + 0.5235987755982988)));
                                    EntityEGOLandmine landmine = new EntityEGOLandmine(world);
                                    landmine.summoner = ego;
                                    landmine.func_70107_b(end.field_72450_a, end.field_72448_b, end.field_72449_c);
                                    landmine.setLandmineType(j % 3);
                                    world.func_217376_c((Entity)landmine);
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }
    }

    public void func_70071_h_() {
        this.func_213317_d(Vector3d.field_186680_a);
        super.func_70071_h_();
        float range = this.func_213311_cf() / 2.0f;
        float r = 0.0f;
        float g = 0.0f;
        float b = 0.0f;
        switch (this.getLandmineType()) {
            case 0: {
                b = 1.0f;
                break;
            }
            case 1: {
                g = 1.0f;
                break;
            }
            case 2: {
                r = 1.0f;
            }
        }
        if (this.field_70173_aa % 2 == 0) {
            for (int i = 0; i < 2; ++i) {
                WispParticleData data = WispParticleData.wisp((float)0.4f, (float)r, (float)g, (float)b, (float)1.0f);
                this.field_70170_p.func_195594_a((IParticleData)data, this.func_226277_ct_() - (double)range + Math.random() * (double)range * 2.0, this.func_226278_cu_(), this.func_226281_cx_() - (double)range + Math.random() * (double)range * 2.0, 0.0, (double)0.015f, 0.0);
            }
        }
        if (this.field_70173_aa >= 50) {
            this.field_70170_p.func_184148_a(null, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), ModSounds.gaiaTrap, SoundCategory.NEUTRAL, 0.3f, 1.0f);
            float m = 0.35f;
            for (int i = 0; i < 4; ++i) {
                WispParticleData data = WispParticleData.wisp((float)0.5f, (float)r, (float)g, (float)b);
                this.field_70170_p.func_195594_a((IParticleData)data, this.func_226277_ct_(), this.func_226278_cu_() + 1.0, this.func_226281_cx_(), (double)((float)(Math.random() - 0.5) * m), (double)((float)(Math.random() - 0.5) * m), (double)((float)(Math.random() - 0.5) * m));
            }
            if (!this.field_70170_p.field_72995_K) {
                List players = this.field_70170_p.func_217357_a(PlayerEntity.class, this.func_174813_aQ().func_72314_b(0.0, 12.0, 0.0));
                for (PlayerEntity player : players) {
                    DamageHandler.INSTANCE.dmg((Entity)player, (Entity)this.summoner, 5.0f, DamageHandler.INSTANCE.LIFE_LOSING);
                    player.func_70097_a(DamageSource.func_76354_b((Entity)this, (Entity)this.summoner), 10.0f);
                    player.func_195064_c(new EffectInstance(Effects.field_76440_q, 25, 0));
                    EffectInstance wither = new EffectInstance(Effects.field_82731_v, 120, 2);
                    wither.getCurativeItems().clear();
                    player.func_195064_c(wither);
                    switch (this.getLandmineType()) {
                        case 1: {
                            player.func_225609_n_(true);
                            break;
                        }
                        case 2: {
                            DamageHandler.INSTANCE.dmg((Entity)player, (Entity)this.summoner, 10.0f, DamageHandler.INSTANCE.LIFE_LOSING);
                        }
                    }
                }
            }
            this.func_70106_y();
        }
    }

    protected void func_70088_a() {
        this.field_70180_af.func_187214_a(TYPE, (Object)0);
    }

    protected void func_70037_a(@Nonnull CompoundNBT var1) {
        this.setLandmineType(var1.func_74762_e(TAG_TYPE));
    }

    protected void func_213281_b(@Nonnull CompoundNBT var1) {
        var1.func_74768_a(TAG_TYPE, this.getLandmineType());
    }

    public int getLandmineType() {
        return (Integer)this.field_70180_af.func_187225_a(TYPE);
    }

    public void setLandmineType(int i) {
        this.field_70180_af.func_187227_b(TYPE, (Object)i);
    }

    @Nonnull
    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
