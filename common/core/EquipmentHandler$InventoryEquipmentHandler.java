/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.common.capabilities.ICapabilityProvider
 *  net.minecraftforge.common.util.LazyOptional
 *  net.minecraftforge.items.IItemHandlerModifiable
 */
package com.meteor.extrabotany.common.core;

import com.meteor.extrabotany.common.core.EquipmentHandler;
import java.util.function.Predicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;

static class EquipmentHandler.InventoryEquipmentHandler
extends EquipmentHandler {
    EquipmentHandler.InventoryEquipmentHandler() {
    }

    @Override
    protected LazyOptional<IItemHandlerModifiable> getAllWornItems(LivingEntity living) {
        return LazyOptional.empty();
    }

    @Override
    protected ItemStack findItem(Item item, LivingEntity living) {
        return ItemStack.field_190927_a;
    }

    @Override
    protected ItemStack findItem(Predicate<ItemStack> pred, LivingEntity living) {
        return ItemStack.field_190927_a;
    }

    @Override
    protected ICapabilityProvider initCap(ItemStack stack) {
        return null;
    }
}
