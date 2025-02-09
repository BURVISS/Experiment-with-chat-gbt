/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.monster.IMob
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.network.IPacket
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.network.datasync.IDataSerializer
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.network.NetworkHooks
 */
package com.meteor.extrabotany.common.entities;

import com.meteor.extrabotany.common.core.ModSounds;
import com.meteor.extrabotany.common.entities.ModEntities;
import com.meteor.extrabotany.common.handler.HerrscherHandler;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.IDataSerializer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityKeyOfTruth
extends Entity {
    private static final String TAG_ROTATION = "rotation";
    private static final String TAG_DAMAGE = "damage";
    private static final String TAG_PITCH = "pitch";
    private static final String TAG_TARGET = "target";
    private static final String TAG_TYPE = "type";
    private static PlayerEntity owner;
    private int countdown = 5;
    private static final DataParameter<Float> ROTATION;
    private static final DataParameter<Float> DAMAGE;
    private static final DataParameter<Float> PITCH;
    private static final DataParameter<Integer> TARGET;
    private static final DataParameter<Integer> TYPE;
    private static final DataParameter<Boolean> SHOOT;

    public EntityKeyOfTruth(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    public EntityKeyOfTruth(World worldIn, PlayerEntity owner) {
        super(ModEntities.KEY_OF_TRUTH, worldIn);
        EntityKeyOfTruth.owner = owner;
    }

    public void func_70088_a() {
        this.field_70180_af.func_187214_a(ROTATION, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(DAMAGE, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(PITCH, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET, (Object)-1);
        this.field_70180_af.func_187214_a(TYPE, (Object)0);
        this.field_70180_af.func_187214_a(SHOOT, (Object)false);
    }

    public boolean func_180427_aV() {
        return true;
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (owner != null) {
            Entity target;
            if (this.getTarget() == -1) {
                if (owner.func_110144_aD() != null && owner.func_110144_aD().func_70685_l((Entity)owner)) {
                    this.setTarget(owner.func_110144_aD().func_145782_y());
                } else {
                    for (LivingEntity living : this.getEntitiesAround()) {
                        if (living == owner || !(living instanceof IMob)) continue;
                        this.setTarget(living.func_145782_y());
                        break;
                    }
                }
            }
            if ((target = this.field_70170_p.func_73045_a(this.getTarget())) == null) {
                this.func_70106_y();
            }
            if (target != null) {
                this.faceEntity(target, 360.0f, 360.0f);
                this.setRotation(MathHelper.func_76142_g((float)(-this.field_70177_z + 180.0f)));
                this.setPitch(-this.field_70125_A + 360.0f);
                if (this.field_70173_aa % 10 == 0 && !this.getShoot()) {
                    this.field_70170_p.func_184134_a(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), ModSounds.shoot, SoundCategory.PLAYERS, 0.25f, 1.0f, true);
                    this.setShoot(true);
                    this.countdown = 4;
                }
                if (this.countdown > 0) {
                    --this.countdown;
                    if (target != null) {
                        target.func_70097_a(DamageSource.func_76365_a((PlayerEntity)owner), 0.01f);
                        HerrscherHandler.iceAttack(target, owner, 4.0f);
                    }
                }
                if (this.countdown == 0) {
                    this.setShoot(false);
                }
            }
            if (this.field_70173_aa >= 45) {
                this.func_70106_y();
            }
        }
    }

    public List<LivingEntity> getEntitiesAround() {
        BlockPos source = new BlockPos(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_());
        float range = 12.0f;
        return this.field_70170_p.func_217357_a(LivingEntity.class, new AxisAlignedBB((double)source.func_177958_n() + 0.5 - (double)range, (double)source.func_177956_o() + 0.5 - (double)range, (double)source.func_177952_p() + 0.5 - (double)range, (double)source.func_177958_n() + 0.5 + (double)range, (double)source.func_177956_o() + 0.5 + (double)range, (double)source.func_177952_p() + 0.5 + (double)range));
    }

    public void faceEntity(Entity entityIn, float maxYawIncrease, float maxPitchIncrease) {
        double d1;
        double d0 = entityIn.func_226277_ct_() - this.func_226277_ct_();
        double d2 = entityIn.func_226281_cx_() - this.func_226281_cx_();
        if (entityIn instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity)entityIn;
            d1 = livingentity.func_226280_cw_() - this.func_226280_cw_();
        } else {
            d1 = (entityIn.func_174813_aQ().field_72338_b + entityIn.func_174813_aQ().field_72337_e) / 2.0 - this.func_226280_cw_();
        }
        double d3 = MathHelper.func_76133_a((double)(d0 * d0 + d2 * d2));
        float f = (float)(MathHelper.func_181159_b((double)d2, (double)d0) * 57.2957763671875) - 90.0f;
        float f1 = (float)(-(MathHelper.func_181159_b((double)d1, (double)d3) * 57.2957763671875));
        this.field_70125_A = this.updateRotation(this.field_70125_A, f1, maxPitchIncrease);
        this.field_70177_z = this.updateRotation(this.field_70177_z, f, maxYawIncrease);
    }

    private float updateRotation(float angle, float targetAngle, float maxIncrease) {
        float f = MathHelper.func_76142_g((float)(targetAngle - angle));
        if (f > maxIncrease) {
            f = maxIncrease;
        }
        if (f < -maxIncrease) {
            f = -maxIncrease;
        }
        return angle + f;
    }

    public void func_70037_a(CompoundNBT cmp) {
        this.setRotation(cmp.func_74760_g(TAG_ROTATION));
        this.setDamage(cmp.func_74760_g(TAG_DAMAGE));
        this.setPitch(cmp.func_74760_g(TAG_PITCH));
        this.setTarget(cmp.func_74762_e(TAG_TARGET));
        this.setKeyType(cmp.func_74762_e(TAG_TYPE));
        this.setShoot(cmp.func_74767_n("shoot"));
    }

    public void func_213281_b(CompoundNBT cmp) {
        cmp.func_74776_a(TAG_ROTATION, this.getRotation());
        cmp.func_74776_a(TAG_DAMAGE, this.getDamage());
        cmp.func_74776_a(TAG_PITCH, this.getPitch());
        cmp.func_74768_a(TAG_TARGET, this.getTarget());
        cmp.func_74768_a(TAG_TYPE, this.getKeyType());
        cmp.func_74757_a("shoot", this.getShoot());
    }

    public boolean getShoot() {
        return (Boolean)this.field_70180_af.func_187225_a(SHOOT);
    }

    public void setShoot(boolean shoot) {
        this.field_70180_af.func_187227_b(SHOOT, (Object)shoot);
    }

    public int getKeyType() {
        return (Integer)this.field_70180_af.func_187225_a(TYPE);
    }

    public void setKeyType(int rot) {
        this.field_70180_af.func_187227_b(TYPE, (Object)rot);
    }

    public int getTarget() {
        return (Integer)this.field_70180_af.func_187225_a(TARGET);
    }

    public void setTarget(int rot) {
        this.field_70180_af.func_187227_b(TARGET, (Object)rot);
    }

    public float getRotation() {
        return ((Float)this.field_70180_af.func_187225_a(ROTATION)).floatValue();
    }

    public void setRotation(float rot) {
        this.field_70180_af.func_187227_b(ROTATION, (Object)Float.valueOf(rot));
    }

    public float getPitch() {
        return ((Float)this.field_70180_af.func_187225_a(PITCH)).floatValue();
    }

    public void setPitch(float rot) {
        this.field_70180_af.func_187227_b(PITCH, (Object)Float.valueOf(rot));
    }

    public float getDamage() {
        return ((Float)this.field_70180_af.func_187225_a(DAMAGE)).floatValue();
    }

    public void setDamage(float delay) {
        this.field_70180_af.func_187227_b(DAMAGE, (Object)Float.valueOf(delay));
    }

    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }

    static {
        ROTATION = EntityDataManager.func_187226_a(EntityKeyOfTruth.class, (IDataSerializer)DataSerializers.field_187193_c);
        DAMAGE = EntityDataManager.func_187226_a(EntityKeyOfTruth.class, (IDataSerializer)DataSerializers.field_187193_c);
        PITCH = EntityDataManager.func_187226_a(EntityKeyOfTruth.class, (IDataSerializer)DataSerializers.field_187193_c);
        TARGET = EntityDataManager.func_187226_a(EntityKeyOfTruth.class, (IDataSerializer)DataSerializers.field_187192_b);
        TYPE = EntityDataManager.func_187226_a(EntityKeyOfTruth.class, (IDataSerializer)DataSerializers.field_187192_b);
        SHOOT = EntityDataManager.func_187226_a(EntityKeyOfTruth.class, (IDataSerializer)DataSerializers.field_187198_h);
    }
}
