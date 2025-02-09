/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.IItemTier
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemTier
 */
package com.meteor.extrabotany.common.items;

import com.meteor.extrabotany.common.items.relic.ItemSwordRelic;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;

public class ItemSpearSubspace
extends ItemSwordRelic {
    public ItemSpearSubspace(Item.Properties prop) {
        super((IItemTier)ItemTier.DIAMOND, 3, -2.0f, prop);
    }
}
