/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
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
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.network.NetworkHooks
 */
package com.meteor.extrabotany.common.entities.projectile;

import com.meteor.extrabotany.common.entities.ModEntities;
import com.meteor.extrabotany.common.entities.projectile.EntityProjectileBase;
import com.meteor.extrabotany.common.handler.DamageHandler;
import java.util.List;
import javax.annotation.Nonnull;
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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityPhantomSword
extends EntityProjectileBase {
    public static final int LIVE_TICKS = 30;
    private static final String TAG_VARIETY = "variety";
    private static final String TAG_DELAY = "delay";
    private static final String TAG_FAKE = "fake";
    private static final DataParameter<Integer> VARIETY = EntityDataManager.func_187226_a(EntityPhantomSword.class, (IDataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Integer> DELAY = EntityDataManager.func_187226_a(EntityPhantomSword.class, (IDataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Boolean> FAKE = EntityDataManager.func_187226_a(EntityPhantomSword.class, (IDataSerializer)DataSerializers.field_187198_h);
    private static final float[][] rgb = new float[][]{{0.82f, 0.2f, 0.58f}, {0.0f, 0.71f, 0.1f}, {0.74f, 0.07f, 0.32f}, {0.01f, 0.45f, 0.8f}, {0.05f, 0.39f, 0.9f}, {0.38f, 0.34f, 0.42f}, {0.41f, 0.31f, 0.14f}, {0.92f, 0.92f, 0.21f}, {0.61f, 0.92f, 0.98f}, {0.18f, 0.45f, 0.43f}};

    public EntityPhantomSword(EntityType<EntityPhantomSword> type, World worldIn) {
        super(type, worldIn);
    }

    public EntityPhantomSword(World worldIn) {
        super(ModEntities.PHANTOMSWORD, worldIn);
    }

    public EntityPhantomSword(World world, LivingEntity thrower, BlockPos targetpos) {
        super(ModEntities.PHANTOMSWORD, world, thrower);
        this.setTargetPos(targetpos);
        this.setVariety((int)(10.0 * Math.random()));
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(VARIETY, (Object)0);
        this.field_70180_af.func_187214_a(DELAY, (Object)0);
        this.field_70180_af.func_187214_a(FAKE, (Object)false);
    }

    @Override
    public boolean func_180427_aV() {
        return true;
    }

    public void func_70071_h_() {
        if (this.getDelay() > 0) {
            this.setDelay(this.getDelay() - 1);
            return;
        }
        if (this.field_70173_aa >= 30) {
            this.func_70106_y();
        }
        if (this.getFake()) {
            this.func_213293_j(0.0, 0.0, 0.0);
            return;
        }
        if (!(this.getFake() || this.field_70170_p.field_72995_K || this.getThrower() != null && !this.getThrower().field_70128_L)) {
            this.func_70106_y();
            return;
        }
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K && !this.getFake() && this.field_70173_aa % 6 == 0) {
            EntityPhantomSword illusion = new EntityPhantomSword(this.field_70170_p);
            illusion.setFake(true);
            illusion.setRotation(this.getRotation());
            illusion.setPitch(this.getPitch());
            illusion.func_70107_b(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_());
            illusion.setVariety(this.getVariety());
            this.field_70170_p.func_217376_c((Entity)illusion);
        }
        if (!this.field_70170_p.field_72995_K) {
            AxisAlignedBB axis = new AxisAlignedBB(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), this.field_70142_S, this.field_70137_T, this.field_70136_U).func_186662_g(2.0);
            List entities = this.field_70170_p.func_217357_a(LivingEntity.class, axis);
            List<LivingEntity> list = DamageHandler.INSTANCE.getFilteredEntities(entities, (Entity)this.getThrower());
            for (LivingEntity living : list) {
                if (this.getThrower() instanceof PlayerEntity) {
                    DamageHandler.INSTANCE.dmg((Entity)living, (Entity)this.getThrower(), 7.0f, DamageHandler.INSTANCE.MAGIC_PIERCING);
                    continue;
                }
                if (living.field_70172_ad == 0) {
                    DamageHandler.INSTANCE.dmg((Entity)living, (Entity)this.getThrower(), 2.5f, DamageHandler.INSTANCE.LIFE_LOSING);
                }
                DamageHandler.INSTANCE.dmg((Entity)living, (Entity)this.getThrower(), 7.5f, DamageHandler.INSTANCE.MAGIC);
            }
        }
    }

    protected void func_70227_a(RayTraceResult result) {
    }

    @Override
    public void func_213281_b(CompoundNBT cmp) {
        super.func_213281_b(cmp);
        cmp.func_74768_a(TAG_VARIETY, this.getVariety());
        cmp.func_74768_a(TAG_DELAY, this.getDelay());
        cmp.func_74757_a(TAG_FAKE, this.getFake());
    }

    @Override
    public void func_70037_a(CompoundNBT cmp) {
        super.func_70037_a(cmp);
        this.setVariety(cmp.func_74762_e(TAG_VARIETY));
        this.setDelay(cmp.func_74762_e(TAG_DELAY));
        this.setFake(cmp.func_74767_n(TAG_FAKE));
    }

    public int getVariety() {
        return (Integer)this.field_70180_af.func_187225_a(VARIETY);
    }

    public void setVariety(int var) {
        this.field_70180_af.func_187227_b(VARIETY, (Object)var);
    }

    public int getDelay() {
        return (Integer)this.field_70180_af.func_187225_a(DELAY);
    }

    public void setDelay(int var) {
        this.field_70180_af.func_187227_b(DELAY, (Object)var);
    }

    public boolean getFake() {
        return (Boolean)this.field_70180_af.func_187225_a(FAKE);
    }

    public void setFake(boolean rot) {
        this.field_70180_af.func_187227_b(FAKE, (Object)rot);
    }

    @Override
    @Nonnull
    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
