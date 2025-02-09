/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.nbt.INBT
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.Hand
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.SoundEvents
 *  net.minecraft.world.World
 *  net.minecraftforge.items.ItemStackHandler
 */
package com.meteor.extrabotany.common.items;

import com.meteor.extrabotany.common.items.ModItems;
import java.util.ArrayList;
import java.util.Collections;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;

public class ItemRewardBagLimitedEdition
extends Item {
    private static final String TAG_HAS_POOL = "has_pool";
    private static final String TAG_LIMITED_POOL = "limited_pool";

    public ItemRewardBagLimitedEdition(Item.Properties properties) {
        super(properties);
    }

    public ActionResult<ItemStack> func_77659_a(World worldIn, PlayerEntity player, Hand handIn) {
        ItemStack itemstack = player.func_184586_b(handIn);
        if (worldIn.field_72995_K) {
            return ActionResult.func_226251_d_((Object)itemstack);
        }
        CompoundNBT data = player.getPersistentData();
        if (!data.func_74764_b("PlayerPersisted")) {
            data.func_218657_a("PlayerPersisted", (INBT)new CompoundNBT());
        }
        if (data.func_74764_b("PlayerPersisted")) {
            int i;
            ItemStackHandler handler;
            CompoundNBT cmp = data.func_74775_l("PlayerPersisted");
            if (!cmp.func_74764_b(TAG_HAS_POOL)) {
                cmp.func_74757_a(TAG_HAS_POOL, true);
                handler = new ItemStackHandler(100);
                ArrayList<ItemStack> stacks = new ArrayList<ItemStack>();
                for (i = 0; i < 30; ++i) {
                    stacks.add(new ItemStack((IItemProvider)ModItems.rewardbagb, 6));
                }
                for (i = 0; i < 20; ++i) {
                    stacks.add(new ItemStack((IItemProvider)ModItems.rewardbagc, 4));
                }
                for (i = 0; i < 20; ++i) {
                    stacks.add(new ItemStack((IItemProvider)ModItems.rewardbagd, 4));
                }
                for (i = 0; i < 10; ++i) {
                    stacks.add(new ItemStack((IItemProvider)ModItems.heromedal));
                }
                for (i = 0; i < 4; ++i) {
                    stacks.add(new ItemStack((IItemProvider)ModItems.lenssupercondutor));
                }
                stacks.add(new ItemStack((IItemProvider)ModItems.friggaapple));
                Collections.shuffle(stacks, player.field_70170_p.field_73012_v);
                for (i = 0; i < stacks.size(); ++i) {
                    handler.setStackInSlot(i, (ItemStack)stacks.get(i));
                }
                cmp.func_218657_a(TAG_LIMITED_POOL, (INBT)handler.serializeNBT());
            }
            if (cmp.func_74767_n(TAG_HAS_POOL)) {
                handler = new ItemStackHandler();
                handler.deserializeNBT(cmp.func_74775_l(TAG_LIMITED_POOL));
                ItemStack reward = ItemStack.field_190927_a;
                for (i = 0; i < handler.getSlots(); ++i) {
                    if (handler.getStackInSlot(i).func_190926_b()) continue;
                    reward = handler.getStackInSlot(i).func_77946_l();
                    handler.setStackInSlot(i, ItemStack.field_190927_a);
                    break;
                }
                cmp.func_218657_a(TAG_LIMITED_POOL, (INBT)handler.serializeNBT());
                if (reward.func_190926_b()) {
                    reward = new ItemStack((IItemProvider)Items.field_151166_bC, 2);
                }
                worldIn.func_184148_a(null, player.func_226277_ct_(), player.func_226278_cu_(), player.func_226281_cx_(), SoundEvents.field_187737_v, SoundCategory.PLAYERS, 0.5f, 0.4f / (worldIn.field_73012_v.nextFloat() * 0.4f + 0.8f));
                player.func_199701_a_(reward).func_174868_q();
                if (!player.field_71075_bZ.field_75098_d) {
                    itemstack.func_190918_g(1);
                }
                return ActionResult.func_226248_a_((Object)itemstack);
            }
        }
        return ActionResult.func_226251_d_((Object)itemstack);
    }
}
