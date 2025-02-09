/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.nbt.INBT
 *  net.minecraft.util.Direction
 *  net.minecraftforge.common.capabilities.Capability
 *  net.minecraftforge.common.capabilities.Capability$IStorage
 */
package com.meteor.extrabotany.common.capability;

import com.meteor.extrabotany.common.capability.IFlamescion;
import javax.annotation.Nullable;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

static final class CapabilityHandler.2
implements Capability.IStorage<IFlamescion> {
    CapabilityHandler.2() {
    }

    @Nullable
    public INBT writeNBT(Capability<IFlamescion> capability, IFlamescion instance, Direction side) {
        return null;
    }

    public void readNBT(Capability<IFlamescion> capability, IFlamescion instance, Direction side, INBT nbt) {
    }
}
