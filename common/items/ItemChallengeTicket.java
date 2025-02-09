/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemUseContext
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.ActionResultType
 *  net.minecraft.util.Hand
 *  net.minecraft.world.World
 */
package com.meteor.extrabotany.common.items;

import com.meteor.extrabotany.common.entities.ego.EntityEGO;
import javax.annotation.Nonnull;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemChallengeTicket
extends Item {
    public ItemChallengeTicket(Item.Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    public ActionResult<ItemStack> func_77659_a(World worldIn, PlayerEntity player, Hand handIn) {
        ItemStack itemstack = player.func_184586_b(handIn);
        return ActionResult.func_226250_c_((Object)itemstack);
    }

    @Nonnull
    public ActionResultType func_195939_a(ItemUseContext ctx) {
        ItemStack stack = ctx.func_195996_i();
        return EntityEGO.spawn(ctx.func_195999_j(), stack, ctx.func_195991_k(), ctx.func_195995_a()) ? ActionResultType.SUCCESS : ActionResultType.FAIL;
    }
}
