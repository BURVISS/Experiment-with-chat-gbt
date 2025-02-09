/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 */
package com.meteor.extrabotany.common.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSpiritFuel
extends Item {
    public ItemSpiritFuel(Item.Properties properties) {
        super(properties);
    }

    public int getBurnTime(ItemStack stack) {
        return 3600;
    }
}
