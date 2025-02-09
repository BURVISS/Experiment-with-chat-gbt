/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraftforge.common.util.INBTSerializable
 */
package com.meteor.extrabotany.common.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public interface IHerrscherEnergy
extends INBTSerializable<CompoundNBT> {
    public int getEnergy();

    public void setEnergy(int var1);

    public void markDirty(boolean var1);

    public boolean isDirty();
}
