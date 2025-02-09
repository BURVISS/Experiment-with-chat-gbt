/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.client.renderer.model.IBakedModel
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
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
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.fml.network.NetworkHooks
 *  vazkii.botania.client.fx.WispParticleData
 *  vazkii.botania.common.Botania
 */
package com.meteor.extrabotany.common.entities.projectile;

import com.meteor.extrabotany.client.handler.MiscellaneousIcons;
import com.meteor.extrabotany.common.entities.ModEntities;
import com.meteor.extrabotany.common.entities.projectile.EntityProjectileBase;
import com.meteor.extrabotany.common.handler.DamageHandler;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;
import vazkii.botania.client.fx.WispParticleData;
import vazkii.botania.common.Botania;

public class EntityInfluxWaverProjectile
extends EntityProjectileBase {
    public static final int LIVE_TICKS = 60;
    private static final String TAG_STRIKE_TIMES = "strike_times";
    private static final String TAG_NEXT = "next";
    private static final DataParameter<Integer> STRIKE_TIMES = EntityDataManager.func_187226_a(EntityInfluxWaverProjectile.class, (IDataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<BlockPos> NEXT = EntityDataManager.func_187226_a(EntityInfluxWaverProjectile.class, (IDataSerializer)DataSerializers.field_187200_j);
    private int removeFlag = -1;

    public EntityInfluxWaverProjectile(EntityType<? extends EntityProjectileBase> type, World worldIn) {
        super(type, worldIn);
    }

    public EntityInfluxWaverProjectile(World worldIn, LivingEntity thrower) {
        super(ModEntities.INFLUXWAVER, worldIn, thrower);
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(STRIKE_TIMES, (Object)0);
        this.field_70180_af.func_187214_a(NEXT, (Object)BlockPos.field_177992_a);
    }

    public void func_70071_h_() {
        block10: {
            List others;
            List<LivingEntity> olist;
            Iterator<LivingEntity> iterator;
            if (this.removeFlag != -1 && this.field_70173_aa >= this.removeFlag + 4 && !this.field_70170_p.field_72995_K && !this.getNext().equals((Object)BlockPos.field_177992_a)) {
                EntityInfluxWaverProjectile proj = this.make(this.getNext());
                this.field_70170_p.func_217376_c((Entity)proj);
                this.func_70106_y();
            }
            if (this.field_70173_aa >= 60) {
                this.func_70106_y();
            }
            if (!this.field_70170_p.field_72995_K && (this.getThrower() == null || this.getThrower().field_70128_L)) {
                this.func_70106_y();
                return;
            }
            super.func_70071_h_();
            if (this.removeFlag != -1) {
                return;
            }
            if (this.field_70170_p.field_72995_K && this.field_70173_aa % 2 == 0) {
                WispParticleData data = WispParticleData.wisp((float)0.3f, (float)0.1f, (float)0.1f, (float)0.85f, (float)1.0f);
                Botania.proxy.addParticleForce(this.field_70170_p, (IParticleData)data, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), 0.0, 0.0, 0.0);
            }
            if (this.field_70170_p.field_72995_K) break block10;
            AxisAlignedBB axis = new AxisAlignedBB(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), this.field_70142_S, this.field_70137_T, this.field_70136_U).func_186662_g(2.0);
            List entities = this.field_70170_p.func_217357_a(LivingEntity.class, axis);
            boolean flag = false;
            List<LivingEntity> list = DamageHandler.INSTANCE.getFilteredEntities(entities, (Entity)this.getThrower());
            for (LivingEntity living : list) {
                if (living.field_70128_L) continue;
                living.func_195064_c(new EffectInstance(Effects.field_76421_d, 60, 1));
                if (this.getThrower() instanceof PlayerEntity) {
                    DamageHandler.INSTANCE.dmg((Entity)living, (Entity)this.getThrower(), 12.0f, DamageHandler.INSTANCE.NETURAL);
                } else {
                    if (living.field_70172_ad == 0) {
                        DamageHandler.INSTANCE.dmg((Entity)living, (Entity)this.getThrower(), 2.5f, DamageHandler.INSTANCE.LIFE_LOSING);
                    }
                    DamageHandler.INSTANCE.dmg((Entity)living, (Entity)this.getThrower(), 7.0f, DamageHandler.INSTANCE.MAGIC);
                }
                flag = living.field_70128_L;
                if (this.getStrikeTimes() <= 0 || flag) break;
                this.setNext(living.func_233580_cy_().func_177982_a(0, 1, 0));
                this.removeFlag = this.field_70173_aa;
                break;
            }
            if (this.getStrikeTimes() > 0 && flag && (iterator = (olist = DamageHandler.INSTANCE.getFilteredEntities(others = this.field_70170_p.func_217357_a(LivingEntity.class, axis = axis.func_186662_g(5.0)), (Entity)this.getThrower())).iterator()).hasNext()) {
                LivingEntity living = iterator.next();
                this.setNext(living.func_233580_cy_().func_177982_a(0, 1, 0));
                this.removeFlag = this.field_70173_aa;
            }
        }
    }

    public EntityInfluxWaverProjectile make(BlockPos targetpos) {
        EntityInfluxWaverProjectile proj = new EntityInfluxWaverProjectile(this.field_70170_p, this.getThrower());
        float range = 6.0f;
        double j = -Math.PI + Math.PI * 2 * Math.random();
        double k = 0.376991110004367 * Math.random() + 0.8796459467502123;
        double x = (double)targetpos.func_177958_n() + (double)range * Math.sin(k) * Math.cos(j);
        double y = (double)targetpos.func_177956_o() + (double)range * Math.cos(k);
        double z = (double)targetpos.func_177952_p() + (double)range * Math.sin(k) * Math.sin(j);
        proj.func_70107_b(x, y, z);
        proj.setTargetPos(targetpos);
        proj.faceTarget(0.8f);
        proj.setStrikeTimes(this.getStrikeTimes() - 1);
        return proj;
    }

    @Override
    public void func_213281_b(CompoundNBT cmp) {
        super.func_213281_b(cmp);
        cmp.func_74768_a(TAG_STRIKE_TIMES, this.getStrikeTimes());
        cmp.func_74772_a(TAG_NEXT, this.getNext().func_218275_a());
    }

    @Override
    public void func_70037_a(CompoundNBT cmp) {
        super.func_70037_a(cmp);
        this.setStrikeTimes(cmp.func_74762_e(TAG_STRIKE_TIMES));
        this.setNext(BlockPos.func_218283_e((long)cmp.func_74763_f(TAG_NEXT)));
    }

    public int getStrikeTimes() {
        return (Integer)this.field_70180_af.func_187225_a(STRIKE_TIMES);
    }

    public void setStrikeTimes(int i) {
        this.field_70180_af.func_187227_b(STRIKE_TIMES, (Object)i);
    }

    public BlockPos getNext() {
        return (BlockPos)this.field_70180_af.func_187225_a(NEXT);
    }

    public void setNext(BlockPos pos) {
        this.field_70180_af.func_187227_b(NEXT, (Object)pos);
    }

    @Override
    @Nonnull
    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }

    @Override
    @OnlyIn(value=Dist.CLIENT)
    public IBakedModel getIcon() {
        return MiscellaneousIcons.INSTANCE.influxwaverprojectileModel[0];
    }
}
