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
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.potion.Effects
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.vector.Vector3d
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.network.NetworkHooks
 */
package com.meteor.extrabotany.common.entities;

import com.meteor.extrabotany.common.entities.ModEntities;
import com.meteor.extrabotany.common.handler.FlamescionHandler;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityFlamescionVoid
extends Entity {
    private PlayerEntity owner;
    private float damage = 1.5f;

    public EntityFlamescionVoid(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    public EntityFlamescionVoid(World worldIn, PlayerEntity owner) {
        super(ModEntities.VOID, worldIn);
        this.owner = owner;
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        this.dmg();
    }

    public void dmg() {
        for (LivingEntity entity : this.getEntitiesAround()) {
            if (this.owner == null) continue;
            if (entity instanceof IMob) {
                entity.func_195064_c(new EffectInstance(Effects.field_76421_d, 2, 3));
            }
            if (entity == this.owner) continue;
            Vector3d vec = this.func_213303_ch().func_178788_d(entity.func_213303_ch());
            entity.func_213317_d(vec.func_72432_b().func_186678_a(1.5));
        }
        if (this.field_70173_aa % 15 == 0) {
            this.damageAllAround(this.damage);
        }
        if (this.field_70173_aa >= 40) {
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
        float range = 6.0f;
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
