/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 *  net.minecraft.util.Direction
 *  net.minecraftforge.common.capabilities.Capability
 *  net.minecraftforge.common.capabilities.ICapabilityProvider
 *  net.minecraftforge.common.util.LazyOptional
 */
package com.meteor.extrabotany.common.capability;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

public class SimpleCapProvider<C>
implements ICapabilityProvider {
    private final C capInstance;
    private final LazyOptional<C> capOptional;
    private final Capability<C> capability;

    public SimpleCapProvider(Capability<C> capability, C capInstance) {
        this.capability = capability;
        this.capInstance = capInstance;
        this.capOptional = LazyOptional.of(() -> this.capInstance);
    }

    @Nonnull
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return this.capability.orEmpty(cap, this.capOptional);
    }
}
