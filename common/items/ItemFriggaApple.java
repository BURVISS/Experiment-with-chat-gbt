/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.stats.Stats
 *  net.minecraft.world.World
 *  top.theillusivec4.curios.api.CuriosApi
 *  top.theillusivec4.curios.api.SlotTypePreset
 */
package com.meteor.extrabotany.common.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.world.World;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypePreset;

public class ItemFriggaApple
extends Item {
    public ItemFriggaApple(Item.Properties properties) {
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
            if (!worldIn.field_72995_K) {
                CuriosApi.getSlotHelper().growSlotType(SlotTypePreset.RING.getIdentifier(), (LivingEntity)playerentity);
                CuriosApi.getSlotHelper().growSlotType(SlotTypePreset.NECKLACE.getIdentifier(), (LivingEntity)playerentity);
                CuriosApi.getSlotHelper().growSlotType(SlotTypePreset.CHARM.getIdentifier(), (LivingEntity)playerentity);
            }
        }
        return stack;
    }
}
