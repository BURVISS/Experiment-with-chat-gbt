/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.common.capabilities.ICapabilityProvider
 *  net.minecraftforge.common.util.LazyOptional
 *  net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
 *  net.minecraftforge.items.IItemHandlerModifiable
 */
package com.meteor.extrabotany.common.core;

import com.meteor.extrabotany.ExtraBotany;
import com.meteor.extrabotany.common.core.CurioIntegration;
import java.util.function.Predicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.items.IItemHandlerModifiable;

public abstract class EquipmentHandler {
    public static EquipmentHandler instance;

    public static void init() {
        if (ExtraBotany.curiosLoaded) {
            instance = new CurioIntegration();
            FMLJavaModLoadingContext.get().getModEventBus().addListener(CurioIntegration::sendImc);
        } else {
            InventoryEquipmentHandler handler = new InventoryEquipmentHandler();
            instance = handler;
        }
    }

    public static LazyOptional<IItemHandlerModifiable> getAllWorn(LivingEntity living) {
        return instance.getAllWornItems(living);
    }

    public static ItemStack findOrEmpty(Item item, LivingEntity living) {
        return instance.findItem(item, living);
    }

    public static ItemStack findOrEmpty(Predicate<ItemStack> pred, LivingEntity living) {
        return instance.findItem(pred, living);
    }

    public static ICapabilityProvider initBaubleCap(ItemStack stack) {
        if (instance != null) {
            return instance.initCap(stack);
        }
        return null;
    }

    protected abstract LazyOptional<IItemHandlerModifiable> getAllWornItems(LivingEntity var1);

    protected abstract ItemStack findItem(Item var1, LivingEntity var2);

    protected abstract ItemStack findItem(Predicate<ItemStack> var1, LivingEntity var2);

    protected abstract ICapabilityProvider initCap(ItemStack var1);

    static class InventoryEquipmentHandler
    extends EquipmentHandler {
        InventoryEquipmentHandler() {
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
}
