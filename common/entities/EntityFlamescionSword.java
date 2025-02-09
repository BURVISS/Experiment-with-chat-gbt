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
 *  net.minecraft.network.IPacket
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
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityFlamescionSword
extends ThrowableEntity {
    private PlayerEntity owner;
    private float damage = 4.0f;

    public EntityFlamescionSword(EntityType<? extends EntityFlamescionSword> type, World worldIn) {
        super(type, worldIn);
    }

    public EntityFlamescionSword(World worldIn, PlayerEntity owner) {
        super(ModEntities.SWORD, worldIn);
        this.func_189654_d(true);
        this.func_184224_h(true);
        this.owner = owner;
    }

    public void func_70088_a() {
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70173_aa % 4 == 0) {
            this.damageAllAround(this.damage);
        }
        if (this.field_70173_aa >= 30) {
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

    @Nonnull
    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
