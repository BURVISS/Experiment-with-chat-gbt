/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.text.TranslationTextComponent
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.event.entity.player.ItemTooltipEvent
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  vazkii.botania.api.mana.IManaItem
 */
package com.meteor.extrabotany.common.handler;

import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import vazkii.botania.api.mana.IManaItem;

@Mod.EventBusSubscriber
public final class EventHandler {
    @OnlyIn(value=Dist.CLIENT)
    @SubscribeEvent
    public static void tooltipEvent(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.func_77973_b() instanceof IManaItem) {
            IManaItem item = (IManaItem)stack.func_77973_b();
            event.getToolTip().add(new TranslationTextComponent("Mana:" + item.getMana(stack) + "/" + item.getMaxMana(stack)));
        }
    }
}
