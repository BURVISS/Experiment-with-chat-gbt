/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.CompoundNBT
 */
package com.meteor.extrabotany.common.capability;

import com.meteor.extrabotany.common.capability.IHerrscherEnergy;
import net.minecraft.nbt.CompoundNBT;

public class HerrscherEnergyCapability
implements IHerrscherEnergy {
    private int energy;
    private boolean isDirty;

    public HerrscherEnergyCapability(int energy) {
        this.energy = energy;
        this.isDirty = false;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public void markDirty(boolean dirty) {
        this.isDirty = dirty;
    }

    @Override
    public boolean isDirty() {
        return this.isDirty;
    }

    public CompoundNBT serializeNBT() {
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.func_74768_a("energy", this.energy);
        return compoundNBT;
    }

    public void deserializeNBT(CompoundNBT nbt) {
        this.energy = nbt.func_74762_e("energy");
    }
}
