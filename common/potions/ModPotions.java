/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.potion.Effect
 *  net.minecraftforge.event.RegistryEvent$Register
 *  net.minecraftforge.registries.IForgeRegistry
 */
package com.meteor.extrabotany.common.potions;

import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.potions.PotionBloodTempation;
import com.meteor.extrabotany.common.potions.PotionFlamescion;
import com.meteor.extrabotany.common.potions.PotionIncandescence;
import com.meteor.extrabotany.common.potions.PotionTimeLock;
import net.minecraft.potion.Effect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ModPotions {
    public static final Effect incandescence = new PotionIncandescence();
    public static final Effect timelock = new PotionTimeLock();
    public static final Effect flamescion = new PotionFlamescion();
    public static final Effect bloodtemptation = new PotionBloodTempation();

    public static void registerPotions(RegistryEvent.Register<Effect> evt) {
        IForgeRegistry r = evt.getRegistry();
        ModItems.register(r, "incandescence", incandescence);
        ModItems.register(r, "timelock", timelock);
        ModItems.register(r, "flamescion", flamescion);
        ModItems.register(r, "bloodtemptation", bloodtemptation);
    }
}
