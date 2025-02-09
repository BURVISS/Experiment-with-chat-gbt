/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraftforge.common.capabilities.ICapabilityProvider
 *  vazkii.botania.common.item.equipment.bauble.ItemBauble
 */
package com.meteor.extrabotany.common.items.bauble;

import com.meteor.extrabotany.common.core.EquipmentHandler;
import javax.annotation.Nullable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class ItemBauble
extends vazkii.botania.common.item.equipment.bauble.ItemBauble {
    public ItemBauble(Item.Properties props) {
        super(props);
    }

    @Nullable
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
        return EquipmentHandler.initBaubleCap(stack);
    }
}
