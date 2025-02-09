/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.color.BlockColors
 *  net.minecraft.client.renderer.color.ItemColors
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.math.MathHelper
 *  vazkii.botania.api.brew.Brew
 *  vazkii.botania.api.brew.IBrewItem
 *  vazkii.botania.client.core.handler.ClientTickHandler
 *  vazkii.botania.common.brew.ModBrews
 */
package com.meteor.extrabotany.client.handler;

import com.meteor.extrabotany.common.items.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.MathHelper;
import vazkii.botania.api.brew.Brew;
import vazkii.botania.api.brew.IBrewItem;
import vazkii.botania.client.core.handler.ClientTickHandler;
import vazkii.botania.common.brew.ModBrews;

public final class ColorHandler {
    public static void init() {
        BlockColors blocks = Minecraft.func_71410_x().func_184125_al();
        ItemColors items = Minecraft.func_71410_x().getItemColors();
        items.func_199877_a((s, t) -> {
            if (t != 1) {
                return -1;
            }
            Brew brew = ((IBrewItem)s.func_77973_b()).getBrew(s);
            if (brew == ModBrews.fallbackBrew) {
                return 0x989898;
            }
            int color = brew.getColor(s);
            double speed = 0.1;
            int add = (int)(Math.sin((double)ClientTickHandler.ticksInGame * speed) * 24.0);
            int r = Math.max(0, Math.min(255, (color >> 16 & 0xFF) + add));
            int g = Math.max(0, Math.min(255, (color >> 8 & 0xFF) + add));
            int b = Math.max(0, Math.min(255, (color & 0xFF) + add));
            return r << 16 | g << 8 | b;
        }, new IItemProvider[]{ModItems.infinitewine, ModItems.splashgrenade, ModItems.cocktail});
        items.func_199877_a((s, t) -> {
            if (t != 0) {
                return -1;
            }
            return MathHelper.func_181758_c((float)((float)(ClientTickHandler.ticksInGame * 2 % 360) / 360.0f), (float)0.25f, (float)1.0f);
        }, new IItemProvider[]{ModItems.universalpetal});
    }
}
