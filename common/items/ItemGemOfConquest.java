/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.Rarity
 */
package com.meteor.extrabotany.common.items;

import com.meteor.extrabotany.ExtraBotany;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class ItemGemOfConquest
extends Item {
    public ItemGemOfConquest() {
        super(new Item.Properties().func_200916_a(ExtraBotany.itemGroup).func_208103_a(Rarity.EPIC).func_200917_a(1).setNoRepair());
    }
}
