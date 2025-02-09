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
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntitySlash
extends Entity {
    private PlayerEntity owner;
    private float damage = 3.0f;

    public EntitySlash(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    public EntitySlash(World worldIn, PlayerEntity owner) {
        super(ModEntities.SLASH, worldIn);
        this.owner = owner;
    }

    protected void func_70088_a() {
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70173_aa == 1) {
            this.func_184185_a(ModSounds.slash, 1.2f, 1.0f);
        }
        for (LivingEntity entity : this.getEntitiesAround()) {
            if (!(entity instanceof IMob)) continue;
            entity.func_195064_c(new EffectInstance(Effects.field_76421_d, 2, 3));
        }
        if (this.field_70173_aa == 6 || this.field_70173_aa == 15 || this.field_70173_aa == 23) {
            this.damageAllAround(this.damage);
        }
        if (this.field_70173_aa == 27 || this.field_70173_aa == 34) {
            this.damageAllAround(this.damage * 2.0f);
        }
        if (this.field_70173_aa >= 35) {
            this.func_70106_y();
        }
    }

    public void damageAllAround(float dmg) {
        for (LivingEntity entity : this.getEntitiesAround()) {
            if (this.owner == null || entity == this.owner) continue;
            HerrscherHandler.thunderAttack((Entity)entity, this.owner, dmg);
            entity.field_70172_ad = 0;
        }
    }

    public List<LivingEntity> getEntitiesAround() {
        BlockPos source = new BlockPos(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_());
        float range = 3.5f;
        return this.field_70170_p.func_217357_a(LivingEntity.class, new AxisAlignedBB((double)source.func_177958_n() + 0.5 - (double)range, (double)source.func_177956_o() + 0.5 - (double)range, (double)source.func_177952_p() + 0.5 - (double)range, (double)source.func_177958_n() + 0.5 + (double)range, (double)source.func_177956_o() + 0.5 + (double)range, (double)source.func_177952_p() + 0.5 + (double)range));
    }

    protected void func_70037_a(CompoundNBT compound) {
    }

    protected void func_213281_b(CompoundNBT compound) {
    }

    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
