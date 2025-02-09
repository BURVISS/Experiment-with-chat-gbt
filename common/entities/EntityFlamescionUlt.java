/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.network.IPacket
 *  net.minecraft.particles.IParticleData
 *  net.minecraft.particles.ParticleTypes
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.network.NetworkHooks
 */
package com.meteor.extrabotany.common.entities;

import com.meteor.extrabotany.common.core.ModSounds;
import com.meteor.extrabotany.common.entities.ModEntities;
import com.meteor.extrabotany.common.handler.FlamescionHandler;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityFlamescionUlt
extends Entity {
    private PlayerEntity owner;
    private float damage = 12.0f;

    public EntityFlamescionUlt(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    public EntityFlamescionUlt(World worldIn, PlayerEntity owner) {
        super(ModEntities.ULT, worldIn);
        this.owner = owner;
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70173_aa == 1 && !this.field_70170_p.field_72995_K) {
            this.func_184185_a(ModSounds.flamescionult, 1.0f, 1.0f);
        }
        if (this.field_70173_aa == 10 || this.field_70173_aa == 35 || this.field_70173_aa == 60) {
            this.damageAllAround(this.damage);
        }
        if (this.field_70173_aa >= 40 && this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197627_t, this.func_226277_ct_() - 2.0 + Math.random() * 4.0, this.func_226278_cu_() - 2.0 + Math.random() * 4.0, this.func_226281_cx_() - 2.0 + Math.random() * 4.0, 0.0, 0.0, 0.0);
        }
        if (this.field_70173_aa >= 85) {
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
        float range = 8.0f;
        return this.field_70170_p.func_217357_a(LivingEntity.class, new AxisAlignedBB((double)source.func_177958_n() + 0.5 - (double)range, (double)source.func_177956_o() + 0.5 - (double)range, (double)source.func_177952_p() + 0.5 - (double)range, (double)source.func_177958_n() + 0.5 + (double)range, (double)source.func_177956_o() + 0.5 + (double)range, (double)source.func_177952_p() + 0.5 + (double)range));
    }

    protected void func_70088_a() {
    }

    protected void func_70037_a(CompoundNBT compound) {
    }

    protected void func_213281_b(CompoundNBT compound) {
    }

    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
