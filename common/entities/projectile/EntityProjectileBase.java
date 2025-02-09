/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 *  net.minecraft.client.renderer.model.IBakedModel
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.projectile.ThrowableEntity
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.network.IPacket
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.network.datasync.IDataSerializer
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.vector.Vector3d
 *  net.minecraft.world.World
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.fml.network.NetworkHooks
 */
package com.meteor.extrabotany.common.entities.projectile;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.IDataSerializer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityProjectileBase
extends ThrowableEntity {
    private static final String TAG_ROTATION = "rotation";
    private static final String TAG_PITCH = "pitch";
    private static final String TAG_TARGETPOS = "targetpos";
    private static final String TAG_TARGETPOSX = "targetposx";
    private static final String TAG_TARGETPOSY = "targetposy";
    private static final String TAG_TARGETPOSZ = "targetposz";
    private static final DataParameter<Float> ROTATION = EntityDataManager.func_187226_a(EntityProjectileBase.class, (IDataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> PITCH = EntityDataManager.func_187226_a(EntityProjectileBase.class, (IDataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<BlockPos> TARGET_POS = EntityDataManager.func_187226_a(EntityProjectileBase.class, (IDataSerializer)DataSerializers.field_187200_j);
    private static final DataParameter<Float> TARGET_POS_X = EntityDataManager.func_187226_a(EntityProjectileBase.class, (IDataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> TARGET_POS_Y = EntityDataManager.func_187226_a(EntityProjectileBase.class, (IDataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> TARGET_POS_Z = EntityDataManager.func_187226_a(EntityProjectileBase.class, (IDataSerializer)DataSerializers.field_187193_c);
    private LivingEntity thrower;

    public EntityProjectileBase(EntityType<? extends ThrowableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public EntityProjectileBase(EntityType<? extends ThrowableEntity> type, World worldIn, LivingEntity thrower) {
        super(type, worldIn);
        this.thrower = thrower;
        this.func_189654_d(true);
    }

    @Nullable
    public LivingEntity getThrower() {
        return this.thrower;
    }

    public void func_70088_a() {
        this.field_70180_af.func_187214_a(ROTATION, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(PITCH, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET_POS, (Object)BlockPos.field_177992_a);
        this.field_70180_af.func_187214_a(TARGET_POS_X, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET_POS_Y, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET_POS_Z, (Object)Float.valueOf(0.0f));
    }

    public void faceTargetAccurately(float modifier) {
        this.faceEntity(this.getTargetPosX(), this.getTargetPosY(), this.getTargetPosZ());
        Vector3d vec = new Vector3d((double)this.getTargetPosX() - this.func_226277_ct_(), (double)this.getTargetPosY() - this.func_226278_cu_(), (double)this.getTargetPosZ() - this.func_226281_cx_()).func_72432_b();
        this.func_213293_j(vec.field_72450_a * (double)modifier, vec.field_72448_b * (double)modifier, vec.field_72449_c * (double)modifier);
    }

    public void faceTarget(float modifier) {
        this.faceEntity(this.getTargetPos());
        Vector3d vec = new Vector3d((double)this.getTargetPos().func_177958_n() - this.func_226277_ct_(), (double)this.getTargetPos().func_177956_o() - this.func_226278_cu_(), (double)this.getTargetPos().func_177952_p() - this.func_226281_cx_()).func_72432_b();
        this.func_213293_j(vec.field_72450_a * (double)modifier, vec.field_72448_b * (double)modifier, vec.field_72449_c * (double)modifier);
    }

    public void setTargetPos(Vector3d vec) {
        this.setTargetPosX((float)vec.field_72450_a);
        this.setTargetPosY((float)vec.field_72448_b);
        this.setTargetPosZ((float)vec.field_72449_c);
        this.setTargetPos(new BlockPos(vec));
    }

    public void faceEntity(float vx, float vy, float vz) {
        double d0 = (double)vx - this.func_226277_ct_();
        double d2 = (double)vz - this.func_226281_cx_();
        double d1 = (double)vy - this.func_226278_cu_();
        double d3 = MathHelper.func_76133_a((double)(d0 * d0 + d2 * d2));
        float f = (float)(MathHelper.func_181159_b((double)d2, (double)d0) * 57.29577951308232) - 90.0f;
        float f1 = (float)(-(MathHelper.func_181159_b((double)d1, (double)d3) * 57.29577951308232));
        this.field_70125_A = this.updateRotation(this.field_70125_A, f1, 360.0f);
        this.field_70177_z = this.updateRotation(this.field_70177_z, f, 360.0f);
        this.setPitch(-this.field_70125_A);
        this.setRotation(MathHelper.func_76142_g((float)(-this.field_70177_z + 180.0f)));
    }

    public void faceEntity(BlockPos target) {
        double d0 = (double)target.func_177958_n() - this.func_226277_ct_();
        double d2 = (double)target.func_177952_p() - this.func_226281_cx_();
        double d1 = (double)target.func_177956_o() - this.func_226278_cu_();
        double d3 = MathHelper.func_76133_a((double)(d0 * d0 + d2 * d2));
        float f = (float)(MathHelper.func_181159_b((double)d2, (double)d0) * 57.29577951308232) - 90.0f;
        float f1 = (float)(-(MathHelper.func_181159_b((double)d1, (double)d3) * 57.29577951308232));
        this.field_70125_A = this.updateRotation(this.field_70125_A, f1, 360.0f);
        this.field_70177_z = this.updateRotation(this.field_70177_z, f, 360.0f);
        this.setPitch(-this.field_70125_A);
        this.setRotation(MathHelper.func_76142_g((float)(-this.field_70177_z + 180.0f)));
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

    public void func_213281_b(CompoundNBT cmp) {
        super.func_213281_b(cmp);
        cmp.func_74776_a(TAG_ROTATION, this.getRotation());
        cmp.func_74776_a(TAG_PITCH, this.getPitch());
        cmp.func_74772_a(TAG_TARGETPOS, this.getTargetPos().func_218275_a());
        cmp.func_74776_a(TAG_TARGETPOSX, this.getTargetPosX());
        cmp.func_74776_a(TAG_TARGETPOSY, this.getTargetPosY());
        cmp.func_74776_a(TAG_TARGETPOSZ, this.getTargetPosZ());
    }

    public void func_70037_a(CompoundNBT cmp) {
        super.func_70037_a(cmp);
        this.setRotation(cmp.func_74760_g(TAG_ROTATION));
        this.setPitch(cmp.func_74760_g(TAG_PITCH));
        this.setTargetPos(BlockPos.func_218283_e((long)cmp.func_74763_f(TAG_TARGETPOS)));
        this.setTargetPosX(cmp.func_74760_g(TAG_TARGETPOSX));
        this.setTargetPosY(cmp.func_74760_g(TAG_TARGETPOSY));
        this.setTargetPosZ(cmp.func_74760_g(TAG_TARGETPOSZ));
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

    public BlockPos getTargetPos() {
        return (BlockPos)this.field_70180_af.func_187225_a(TARGET_POS);
    }

    public void setTargetPos(BlockPos pos) {
        this.field_70180_af.func_187227_b(TARGET_POS, (Object)pos);
    }

    public float getTargetPosX() {
        return ((Float)this.field_70180_af.func_187225_a(TARGET_POS_X)).floatValue();
    }

    public void setTargetPosX(float f) {
        this.field_70180_af.func_187227_b(TARGET_POS_X, (Object)Float.valueOf(f));
    }

    public float getTargetPosY() {
        return ((Float)this.field_70180_af.func_187225_a(TARGET_POS_Y)).floatValue();
    }

    public void setTargetPosY(float f) {
        this.field_70180_af.func_187227_b(TARGET_POS_Y, (Object)Float.valueOf(f));
    }

    public float getTargetPosZ() {
        return ((Float)this.field_70180_af.func_187225_a(TARGET_POS_Z)).floatValue();
    }

    public void setTargetPosZ(float f) {
        this.field_70180_af.func_187227_b(TARGET_POS_Z, (Object)Float.valueOf(f));
    }

    public boolean func_70067_L() {
        return false;
    }

    public boolean func_70104_M() {
        return false;
    }

    public boolean func_70090_H() {
        return false;
    }

    public boolean func_96092_aw() {
        return false;
    }

    public boolean func_180427_aV() {
        return true;
    }

    public float func_70185_h() {
        return 0.0f;
    }

    @Nonnull
    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }

    @OnlyIn(value=Dist.CLIENT)
    public IBakedModel getIcon() {
        return null;
    }
}
