/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.nbt.INBT
 *  net.minecraft.util.Direction
 *  net.minecraftforge.common.capabilities.Capability
 *  net.minecraftforge.common.capabilities.Capability$IStorage
 *  net.minecraftforge.common.capabilities.CapabilityInject
 *  net.minecraftforge.common.capabilities.CapabilityManager
 */
package com.meteor.extrabotany.common.capability;

import com.meteor.extrabotany.common.capability.IFlamescion;
import com.meteor.extrabotany.common.capability.IHerrscherEnergy;
import javax.annotation.Nullable;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CapabilityHandler {
    @CapabilityInject(value=IHerrscherEnergy.class)
    public static Capability<IHerrscherEnergy> HERRSCHERENERGY_CAPABILITY;
    @CapabilityInject(value=IFlamescion.class)
    public static Capability<IFlamescion> FLAMESCION_CAPABILITY;

    public static void register() {
        CapabilityManager.INSTANCE.register(IHerrscherEnergy.class, (Capability.IStorage)new Capability.IStorage<IHerrscherEnergy>(){

            @Nullable
            public INBT writeNBT(Capability<IHerrscherEnergy> capability, IHerrscherEnergy instance, Direction side) {
                return null;
            }

            public void readNBT(Capability<IHerrscherEnergy> capability, IHerrscherEnergy instance, Direction side, INBT nbt) {
            }
        }, () -> null);
        CapabilityManager.INSTANCE.register(IFlamescion.class, (Capability.IStorage)new Capability.IStorage<IFlamescion>(){

            @Nullable
            public INBT writeNBT(Capability<IFlamescion> capability, IFlamescion instance, Direction side) {
                return null;
            }

            public void readNBT(Capability<IFlamescion> capability, IFlamescion instance, Direction side, INBT nbt) {
            }
        }, () -> null);
    }
}
