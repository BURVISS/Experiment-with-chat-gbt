/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.nbt.INBT
 *  net.minecraft.util.Direction
 *  net.minecraftforge.common.capabilities.Capability
 *  net.minecraftforge.common.capabilities.ICapabilityProvider
 *  net.minecraftforge.common.util.INBTSerializable
 *  net.minecraftforge.common.util.LazyOptional
 */
package com.meteor.extrabotany.common.capability;

import com.meteor.extrabotany.common.capability.CapabilityHandler;
import com.meteor.extrabotany.common.capability.FlamescionCapability;
import com.meteor.extrabotany.common.capability.IFlamescion;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public class FlamescionProvider
implements ICapabilityProvider,
INBTSerializable<CompoundNBT> {
    private IFlamescion flamescionCapability;

    @Nonnull
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == CapabilityHandler.FLAMESCION_CAPABILITY ? LazyOptional.of(() -> this.getOrCreateCapability()).cast() : LazyOptional.empty();
    }

    @Nonnull
    IFlamescion getOrCreateCapability() {
        if (this.flamescionCapability == null) {
            this.flamescionCapability = new FlamescionCapability(0, false);
        }
        return this.flamescionCapability;
    }

    public CompoundNBT serializeNBT() {
        return (CompoundNBT)this.getOrCreateCapability().serializeNBT();
    }

    public void deserializeNBT(CompoundNBT nbt) {
        this.getOrCreateCapability().deserializeNBT((INBT)nbt);
    }
}
