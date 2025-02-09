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

import com.meteor.extrabotany.common.capability.IHerrscherEnergy;
import javax.annotation.Nullable;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

static final class CapabilityHandler.1
implements Capability.IStorage<IHerrscherEnergy> {
    CapabilityHandler.1() {
    }

    @Nullable
    public INBT writeNBT(Capability<IHerrscherEnergy> capability, IHerrscherEnergy instance, Direction side) {
        return null;
    }

    public void readNBT(Capability<IHerrscherEnergy> capability, IHerrscherEnergy instance, Direction side, INBT nbt) {
    }
}
