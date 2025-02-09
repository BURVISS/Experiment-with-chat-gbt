/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.item.ItemStack
 *  vazkii.botania.api.mana.IManaItem
 */
package com.meteor.extrabotany.common.blocks.tile;

import com.meteor.extrabotany.common.items.ModItems;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import vazkii.botania.api.mana.IManaItem;

class TilePowerFrame.1
extends Inventory {
    TilePowerFrame.1(int x0) {
        super(x0);
    }

    public int func_70297_j_() {
        return 1;
    }

    public boolean func_94041_b(int slot, ItemStack stack) {
        return stack.func_77973_b() instanceof IManaItem || stack.func_77973_b() == ModItems.natureorb;
    }
}
