/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.UseAction
 *  net.minecraft.stats.Stats
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.world.World
 */
package com.meteor.extrabotany.common.items;

import com.meteor.extrabotany.common.items.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.IItemProvider;
import net.minecraft.world.World;

public class ItemManaDrink
extends Item {
    public ItemManaDrink(Item.Properties properties) {
        super(properties);
    }

    public ItemStack func_77654_b(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        PlayerEntity playerentity;
        PlayerEntity playerEntity = playerentity = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;
        if (playerentity != null) {
            playerentity.func_71029_a(Stats.field_75929_E.func_199076_b((Object)this));
            if (!playerentity.field_71075_bZ.field_75098_d) {
                stack.func_190918_g(1);
            }
        }
        if (playerentity == null || !playerentity.field_71075_bZ.field_75098_d) {
            if (stack.func_190926_b()) {
                return new ItemStack((IItemProvider)ModItems.emptybottle);
            }
            if (playerentity != null) {
                playerentity.field_71071_by.func_70441_a(new ItemStack((IItemProvider)ModItems.emptybottle));
            }
        }
        return stack;
    }

    public UseAction func_77661_b(ItemStack stack) {
        return UseAction.DRINK;
    }
}
