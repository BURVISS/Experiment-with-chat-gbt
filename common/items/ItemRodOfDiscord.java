/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.potion.Effects
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.Hand
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.SoundEvents
 *  net.minecraft.util.math.BlockRayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.vector.Vector3d
 *  net.minecraft.world.World
 *  vazkii.botania.api.mana.ManaItemHandler
 */
package com.meteor.extrabotany.common.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import vazkii.botania.api.mana.ManaItemHandler;

public class ItemRodOfDiscord
extends Item {
    private static final int MANA_PER_DAMAGE = 2000;

    public ItemRodOfDiscord(Item.Properties properties) {
        super(properties.func_200918_c(81));
    }

    public ActionResult<ItemStack> func_77659_a(World worldIn, PlayerEntity player, Hand handIn) {
        ItemStack itemstack = player.func_184586_b(handIn);
        BlockRayTraceResult rtr = (BlockRayTraceResult)player.func_213324_a(64.0, 1.0f, false);
        if (rtr.func_216346_c() != RayTraceResult.Type.MISS && ManaItemHandler.instance().requestManaExactForTool(itemstack, player, 2000, true)) {
            Vector3d end = rtr.func_216347_e();
            player.func_70634_a(end.field_72450_a, end.field_72448_b + 1.0, end.field_72449_c);
            if (!worldIn.field_72995_K) {
                worldIn.func_184148_a(null, player.func_226277_ct_(), player.func_226278_cu_(), player.func_226281_cx_(), SoundEvents.field_187534_aX, SoundCategory.PLAYERS, 1.0f, 3.0f);
            }
            player.func_195064_c(new EffectInstance(Effects.field_76431_k, 100));
            if (itemstack.func_77952_i() > 0) {
                float health = Math.max(1.0f, player.func_110143_aJ() - player.func_110138_aP() / 6.0f);
                player.func_70606_j(health);
            }
            itemstack.func_196085_b(itemstack.func_77958_k() - 1);
        }
        return ActionResult.func_226250_c_((Object)itemstack);
    }

    public void func_77663_a(ItemStack stack, World world, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!world.field_72995_K && stack.func_77952_i() > 0) {
            stack.func_196085_b(stack.func_77952_i() - 1);
        }
    }
}
