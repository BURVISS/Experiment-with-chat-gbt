/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.IItemTier
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemTier
 *  net.minecraft.item.SwordItem
 */
package com.meteor.extrabotany.common.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;

public class ItemShadowKatana
extends SwordItem {
    public ItemShadowKatana(Item.Properties prop) {
        super((IItemTier)ItemTier.IRON, 3, -2.4f, prop);
    }
}
