/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.CompoundNBT
 */
package com.meteor.extrabotany.common.capability;

import com.meteor.extrabotany.common.capability.IFlamescion;
import net.minecraft.nbt.CompoundNBT;

public class FlamescionCapability
implements IFlamescion {
    private int energy;
    private boolean overloaded;
    private boolean isDirty;

    public FlamescionCapability(int energy, boolean overloaded) {
        this.energy = energy;
        this.overloaded = overloaded;
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
    public boolean isOverloaded() {
        return this.overloaded;
    }

    @Override
    public void setOverloaded(boolean overloaded) {
        this.overloaded = overloaded;
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
        compoundNBT.func_74768_a("flamescion", this.energy);
        compoundNBT.func_74757_a("overloaded", this.overloaded);
        return compoundNBT;
    }

    public void deserializeNBT(CompoundNBT nbt) {
        this.energy = nbt.func_74762_e("flamescion");
        this.overloaded = nbt.func_74767_n("overloaded");
    }
}
