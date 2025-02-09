/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.stats.Stats
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.world.World
 */
package com.meteor.extrabotany.common.items;

import com.meteor.extrabotany.common.handler.AdvancementHandler;
import com.meteor.extrabotany.common.items.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.IItemProvider;
import net.minecraft.world.World;

public class ItemNightmareFuel
extends Item {
    public ItemNightmareFuel(Item.Properties prop) {
        super(prop);
    }

    public ItemStack func_77654_b(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        PlayerEntity playerentity;
        PlayerEntity playerEntity = playerentity = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;
        if (playerentity != null) {
            playerentity.func_71029_a(Stats.field_75929_E.func_199076_b((Object)this));
            if (!playerentity.field_71075_bZ.field_75098_d) {
                stack.func_190918_g(1);
            }
            if (entityLiving instanceof ServerPlayerEntity) {
                AdvancementHandler.INSTANCE.grantAdvancement((ServerPlayerEntity)playerentity, "nightmarefueleat");
            }
        }
        if (playerentity == null || !playerentity.field_71075_bZ.field_75098_d) {
            if (stack.func_190926_b()) {
                return new ItemStack((IItemProvider)ModItems.spiritfuel);
            }
            if (playerentity != null) {
                playerentity.field_71071_by.func_70441_a(new ItemStack((IItemProvider)ModItems.spiritfuel));
            }
        }
        return stack;
    }

    public int getBurnTime(ItemStack stack) {
        return 2400;
    }
}
