/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraftforge.event.RegistryEvent$Register
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.IForgeRegistryEntry
 */
package com.meteor.extrabotany.common.core;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ModSounds {
    public static final SoundEvent cyclone = ModSounds.makeSoundEvent("cyclone");
    public static final SoundEvent rideon = ModSounds.makeSoundEvent("rideon");
    public static final SoundEvent shoot = ModSounds.makeSoundEvent("shoot");
    public static final SoundEvent slash = ModSounds.makeSoundEvent("slash");
    public static final SoundEvent flamescionult = ModSounds.makeSoundEvent("flamescionult");
    public static final SoundEvent swordland = ModSounds.makeSoundEvent("music.ego");
    public static final SoundEvent salvation = ModSounds.makeSoundEvent("music.herrscher");

    private static SoundEvent makeSoundEvent(String name) {
        ResourceLocation loc = new ResourceLocation("extrabotany", name);
        return (SoundEvent)new SoundEvent(loc).setRegistryName(loc);
    }

    public static void registerSounds(RegistryEvent.Register<SoundEvent> evt) {
        IForgeRegistry r = evt.getRegistry();
        r.register((IForgeRegistryEntry)cyclone);
        r.register((IForgeRegistryEntry)rideon);
        r.register((IForgeRegistryEntry)shoot);
        r.register((IForgeRegistryEntry)slash);
        r.register((IForgeRegistryEntry)flamescionult);
        r.register((IForgeRegistryEntry)swordland);
        r.register((IForgeRegistryEntry)salvation);
    }

    private ModSounds() {
    }
}
