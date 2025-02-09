/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.network.IPacket
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.network.NetworkHooks
 */
package com.meteor.extrabotany.common.entities.herrscher;

import javax.annotation.Nonnull;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityHVoid
extends Entity {
    public EntityHVoid(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    protected void func_70088_a() {
    }

    protected void func_70037_a(CompoundNBT compound) {
    }

    protected void func_213281_b(CompoundNBT compound) {
    }

    @Nonnull
    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
