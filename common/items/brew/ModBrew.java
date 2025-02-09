/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.potion.Effects
 *  net.minecraft.potion.PotionUtils
 *  net.minecraftforge.event.RegistryEvent$Register
 *  net.minecraftforge.registries.IForgeRegistry
 *  vazkii.botania.api.brew.Brew
 */
package com.meteor.extrabotany.common.items.brew;

import com.meteor.extrabotany.common.items.ModItems;
import java.util.Arrays;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import vazkii.botania.api.brew.Brew;

public class ModBrew {
    public static final Brew revolution = ModBrew.make(10000, new EffectInstance(Effects.field_189112_A, 1800, 2), new EffectInstance(Effects.field_76422_e, 1800, 2));
    public static final Brew shell = ModBrew.make(10000, new EffectInstance(Effects.field_76421_d, 1200, 2), new EffectInstance(Effects.field_76429_m, 1200, 2));
    public static final Brew allmighty = ModBrew.make(30000, new EffectInstance(Effects.field_76444_x, 900, 0), new EffectInstance(Effects.field_76426_n, 900, 0), new EffectInstance(Effects.field_76422_e, 900, 0), new EffectInstance(Effects.field_76430_j, 900, 0), new EffectInstance(Effects.field_188425_z, 900, 0), new EffectInstance(Effects.field_76428_l, 900, 0), new EffectInstance(Effects.field_76424_c, 900, 0), new EffectInstance(Effects.field_76420_g, 900, 0));
    public static final Brew deadpool = ModBrew.make(20000, new EffectInstance(Effects.field_82731_v, 300, 1), new EffectInstance(Effects.field_76436_u, 300, 1), new EffectInstance(Effects.field_188423_x, 3600, 2), new EffectInstance(Effects.field_76420_g, 3600, 2));
    public static final Brew floating = ModBrew.make(2000, new EffectInstance(Effects.field_188424_y, 160, 2));

    public static void registerBrews(RegistryEvent.Register<Brew> evt) {
        IForgeRegistry r = evt.getRegistry();
        ModItems.register(r, "revolution", revolution);
        ModItems.register(r, "shell", shell);
        ModItems.register(r, "allmighty", allmighty);
        ModItems.register(r, "deadpool", deadpool);
        ModItems.register(r, "floating", floating);
    }

    private static Brew make(int cost, EffectInstance ... effects) {
        return new Brew(PotionUtils.func_185181_a(Arrays.asList(effects)), cost, effects);
    }
}
