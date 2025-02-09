/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.projectile.ThrowableEntity
 *  net.minecraft.network.IPacket
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.network.NetworkHooks
 */
package com.meteor.extrabotany.common.entities.herrscher;

import com.meteor.extrabotany.common.entities.projectile.EntityProjectileBase;
import javax.annotation.Nonnull;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityHSpear
extends EntityProjectileBase {
    public EntityHSpear(EntityType<? extends ThrowableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    @Nonnull
    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
