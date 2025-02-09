/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.Hand
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.world.World
 */
package com.meteor.extrabotany.common.items;

import com.meteor.extrabotany.common.items.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.world.World;

public class ItemTreasureBox
extends Item {
    public ItemTreasureBox(Item.Properties prop) {
        super(prop);
    }

    public ActionResult<ItemStack> func_77659_a(World worldIn, PlayerEntity player, Hand handIn) {
        ItemStack itemstack = player.func_184586_b(handIn);
        if (!worldIn.field_72995_K) {
            player.func_199701_a_(new ItemStack((IItemProvider)ModItems.rewardbaga, 32)).func_174868_q();
            player.func_199701_a_(new ItemStack((IItemProvider)ModItems.rewardbagb, 16)).func_174868_q();
            player.func_199701_a_(new ItemStack((IItemProvider)ModItems.rewardbagc, 10)).func_174868_q();
            player.func_199701_a_(new ItemStack((IItemProvider)ModItems.rewardbagd, 10)).func_174868_q();
            player.func_199701_a_(new ItemStack((IItemProvider)ModItems.heromedal)).func_174868_q();
            if (!player.field_71075_bZ.field_75098_d) {
                itemstack.func_190918_g(1);
            }
        }
        return ActionResult.func_226250_c_((Object)itemstack);
    }
}
