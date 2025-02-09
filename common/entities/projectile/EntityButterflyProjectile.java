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
 *  net.minecraft.util.math.EntityRayTraceResult
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.network.NetworkHooks
 */
package com.meteor.extrabotany.common.entities.projectile;

import com.meteor.extrabotany.common.entities.ModEntities;
import com.meteor.extrabotany.common.entities.projectile.EntityProjectileBase;
import javax.annotation.Nonnull;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityButterflyProjectile
extends EntityProjectileBase {
    public EntityButterflyProjectile(EntityType<? extends ThrowableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public EntityButterflyProjectile(World worldIn, LivingEntity thrower) {
        super(ModEntities.BUTTERFLY, worldIn, thrower);
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70173_aa > 100) {
            this.func_241204_bJ_();
        }
    }

    public void func_213868_a(EntityRayTraceResult result) {
        if (this.getThrower() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)this.getThrower();
            if (result.func_216348_a() != player) {
                // empty if block
            }
        }
    }

    @Override
    @Nonnull
    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
