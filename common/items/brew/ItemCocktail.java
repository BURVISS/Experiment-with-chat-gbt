/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item$Properties
 */
package com.meteor.extrabotany.common.items.brew;

import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.items.brew.ItemBrewBase;
import net.minecraft.item.Item;

public class ItemCocktail
extends ItemBrewBase {
    public ItemCocktail(Item.Properties builder) {
        super(builder, 8, 20, 1.3f, 0, () -> ModItems.emptybottle);
    }
}
