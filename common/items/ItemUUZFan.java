/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.Hand
 *  net.minecraft.world.World
 */
package com.meteor.extrabotany.common.items;

import com.meteor.extrabotany.common.entities.projectile.EntityButterflyProjectile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemUUZFan
extends Item {
    public ItemUUZFan(Item.Properties properties) {
        super(properties);
    }

    public ActionResult<ItemStack> func_77659_a(World worldIn, PlayerEntity player, Hand handIn) {
        ItemStack itemstack = player.func_184586_b(handIn);
        player.func_184811_cZ().func_185145_a((Item)this, 10);
        if (!worldIn.field_72995_K) {
            for (int i = -1; i < 2; ++i) {
                EntityButterflyProjectile proj = new EntityButterflyProjectile(worldIn, (LivingEntity)player);
                proj.func_70107_b(player.func_226277_ct_(), player.func_226278_cu_(), player.func_226281_cx_());
                proj.func_234612_a_((Entity)player, player.field_70125_A, player.field_70177_z + 25.0f * (float)i, 0.0f, 0.5f, 1.0f);
                worldIn.func_217376_c((Entity)proj);
            }
        }
        return ActionResult.func_226250_c_((Object)itemstack);
    }
}
