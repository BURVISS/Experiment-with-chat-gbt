/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.projectile.ThrowableEntity
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.network.IPacket
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.network.datasync.IDataSerializer
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.network.NetworkHooks
 */
package com.meteor.extrabotany.common.entities;

import com.meteor.extrabotany.common.entities.ModEntities;
import com.meteor.extrabotany.common.handler.FlamescionHandler;
import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.IDataSerializer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityStrengthenSlash
extends ThrowableEntity {
    private PlayerEntity owner;
    private float damage = 5.0f;
    private static final String TAG_ROTATION = "rotation";
    private static final String TAG_PITCH = "pitch";
    private static final String TAG_TARGETPOS = "targetpos";
    private static final DataParameter<Float> ROTATION = EntityDataManager.func_187226_a(EntityStrengthenSlash.class, (IDataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> PITCH = EntityDataManager.func_187226_a(EntityStrengthenSlash.class, (IDataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<BlockPos> TARGET_POS = EntityDataManager.func_187226_a(EntityStrengthenSlash.class, (IDataSerializer)DataSerializers.field_187200_j);

    public EntityStrengthenSlash(EntityType<? extends EntityStrengthenSlash> type, World worldIn) {
        super(type, worldIn);
    }

    public EntityStrengthenSlash(World worldIn, PlayerEntity owner) {
        super(ModEntities.SRENGTHENSLASH, worldIn);
        this.func_189654_d(true);
        this.func_184224_h(true);
    }

    public void func_70088_a() {
        this.field_70180_af.func_187214_a(ROTATION, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(PITCH, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET_POS, (Object)BlockPos.field_177992_a);
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70173_aa % 2 == 0) {
            this.damageAllAround(this.damage);
        }
        if (this.field_70173_aa >= 15) {
            this.func_70106_y();
        }
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

    public void damageAllAround(float dmg) {
        for (LivingEntity entity : this.getEntitiesAround()) {
            if (this.owner == null || entity == this.owner) continue;
            entity.field_70172_ad = 0;
            entity.func_70097_a(FlamescionHandler.flameSource(), dmg);
        }
    }

    public List<LivingEntity> getEntitiesAround() {
        BlockPos source = new BlockPos(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_());
        float range = 2.5f;
        return this.field_70170_p.func_217357_a(LivingEntity.class, new AxisAlignedBB((double)source.func_177958_n() + 0.5 - (double)range, (double)source.func_177956_o() + 0.5 - (double)range, (double)source.func_177952_p() + 0.5 - (double)range, (double)source.func_177958_n() + 0.5 + (double)range, (double)source.func_177956_o() + 0.5 + (double)range, (double)source.func_177952_p() + 0.5 + (double)range));
    }

    public void func_213281_b(CompoundNBT cmp) {
        super.func_213281_b(cmp);
        cmp.func_74776_a(TAG_ROTATION, this.getRotation());
        cmp.func_74776_a(TAG_PITCH, this.getPitch());
    }

    public void func_70037_a(CompoundNBT cmp) {
        super.func_70037_a(cmp);
        this.setRotation(cmp.func_74760_g(TAG_ROTATION));
        this.setPitch(cmp.func_74760_g(TAG_PITCH));
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

    @Nonnull
    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
