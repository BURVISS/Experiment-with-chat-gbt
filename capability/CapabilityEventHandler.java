/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.common.capabilities.ICapabilityProvider
 *  net.minecraftforge.common.util.LazyOptional
 *  net.minecraftforge.event.AttachCapabilitiesEvent
 *  net.minecraftforge.event.entity.player.PlayerEvent$Clone
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 */
package com.meteor.extrabotany.common.capability;

import com.meteor.extrabotany.common.capability.CapabilityHandler;
import com.meteor.extrabotany.common.capability.FlamescionProvider;
import com.meteor.extrabotany.common.capability.HerrscherEnergyProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CapabilityEventHandler {
    @SubscribeEvent
    public static void onAttachCapabilityEvent(AttachCapabilitiesEvent<Entity> event) {
        Entity entity = (Entity)event.getObject();
        if (entity instanceof PlayerEntity) {
            event.addCapability(new ResourceLocation("extrabotany", "thunderenergy"), (ICapabilityProvider)new HerrscherEnergyProvider());
            event.addCapability(new ResourceLocation("extrabotany", "flamescion"), (ICapabilityProvider)new FlamescionProvider());
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (!event.isWasDeath()) {
            LazyOptional oldSpeedCap = event.getOriginal().getCapability(CapabilityHandler.HERRSCHERENERGY_CAPABILITY);
            LazyOptional newSpeedCap = event.getPlayer().getCapability(CapabilityHandler.HERRSCHERENERGY_CAPABILITY);
            if (oldSpeedCap.isPresent() && newSpeedCap.isPresent()) {
                newSpeedCap.ifPresent(newCap -> oldSpeedCap.ifPresent(oldCap -> newCap.deserializeNBT(oldCap.serializeNBT())));
            }
            LazyOptional oldFlamescionCap = event.getOriginal().getCapability(CapabilityHandler.FLAMESCION_CAPABILITY);
            LazyOptional newFlamescionCap = event.getPlayer().getCapability(CapabilityHandler.FLAMESCION_CAPABILITY);
            if (oldFlamescionCap.isPresent() && newFlamescionCap.isPresent()) {
                newFlamescionCap.ifPresent(newCap -> oldFlamescionCap.ifPresent(oldCap -> newCap.deserializeNBT(oldCap.serializeNBT())));
            }
        }
    }
}
