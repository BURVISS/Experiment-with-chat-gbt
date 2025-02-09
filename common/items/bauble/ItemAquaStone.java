/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  vazkii.botania.api.mana.ManaDiscountEvent
 */
package com.meteor.extrabotany.common.items.bauble;

import com.meteor.extrabotany.common.core.EquipmentHandler;
import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.items.bauble.ItemBauble;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import vazkii.botania.api.mana.ManaDiscountEvent;

public class ItemAquaStone
extends ItemBauble {
    public ItemAquaStone(Item.Properties props) {
        super(props);
        MinecraftForge.EVENT_BUS.addListener(this::manaDiscount);
    }

    @SubscribeEvent
    public void manaDiscount(ManaDiscountEvent event) {
        PlayerEntity player = event.getEntityPlayer();
        if (!EquipmentHandler.findOrEmpty((Item)this, (LivingEntity)player).func_190926_b() || !EquipmentHandler.findOrEmpty(ModItems.thecommunity, (LivingEntity)player).func_190926_b()) {
            event.setDiscount(event.getDiscount() + 0.1f);
        }
    }

    public boolean canEquip(ItemStack stack, LivingEntity entity) {
        return EquipmentHandler.findOrEmpty((Item)this, entity).func_190926_b() && EquipmentHandler.findOrEmpty(ModItems.thecommunity, entity).func_190926_b();
    }
}
