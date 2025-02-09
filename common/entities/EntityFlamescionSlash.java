/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
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
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.potion.Effects
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
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
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.IDataSerializer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityFlamescionSlash
extends Entity {
    private PlayerEntity owner;
    private float damage = 1.0f;
    private static final String TAG_ROTATION = "rotation";
    private static final String TAG_PITCH = "pitch";
    private static final DataParameter<Float> ROTATION = EntityDataManager.func_187226_a(EntityFlamescionSlash.class, (IDataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> PITCH = EntityDataManager.func_187226_a(EntityFlamescionSlash.class, (IDataSerializer)DataSerializers.field_187193_c);

    public EntityFlamescionSlash(EntityType<? extends EntityFlamescionSlash> type, World worldIn) {
        super(type, worldIn);
    }

    public EntityFlamescionSlash(World worldIn, PlayerEntity owner) {
        super(ModEntities.FLAMESCIONSLASH, worldIn);
        this.owner = owner;
        this.setRotation((float)(120.0 * Math.random()) - 60.0f);
        this.setPitch((float)(360.0 * Math.random()));
    }

    public void func_70088_a() {
        this.field_70180_af.func_187214_a(ROTATION, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(PITCH, (Object)Float.valueOf(0.0f));
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        this.dmg();
    }

    public void dmg() {
        for (LivingEntity entity : this.getEntitiesAround()) {
            if (!(entity instanceof IMob)) continue;
            entity.func_195064_c(new EffectInstance(Effects.field_76421_d, 2, 3));
        }
        if (this.field_70173_aa == 2 || this.field_70173_aa == 5) {
            this.damageAllAround(this.damage);
        }
        if (this.field_70173_aa >= 6) {
            this.func_70106_y();
        }
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
        float range = 3.5f;
        return this.field_70170_p.func_217357_a(LivingEntity.class, new AxisAlignedBB((double)source.func_177958_n() + 0.5 - (double)range, (double)source.func_177956_o() + 0.5 - (double)range, (double)source.func_177952_p() + 0.5 - (double)range, (double)source.func_177958_n() + 0.5 + (double)range, (double)source.func_177956_o() + 0.5 + (double)range, (double)source.func_177952_p() + 0.5 + (double)range));
    }

    public void func_213281_b(CompoundNBT cmp) {
        cmp.func_74776_a(TAG_ROTATION, this.getRotation());
        cmp.func_74776_a(TAG_PITCH, this.getPitch());
    }

    public void func_70037_a(CompoundNBT cmp) {
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
