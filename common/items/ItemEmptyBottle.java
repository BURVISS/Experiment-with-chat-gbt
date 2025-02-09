/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemUseContext
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.ActionResultType
 *  net.minecraft.util.IItemProvider
 *  vazkii.botania.common.block.tile.mana.TilePool
 */
package com.meteor.extrabotany.common.items;

import com.meteor.extrabotany.common.items.ModItems;
import javax.annotation.Nonnull;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.IItemProvider;
import vazkii.botania.common.block.tile.mana.TilePool;

public class ItemEmptyBottle
extends Item {
    public ItemEmptyBottle(Item.Properties properties) {
        super(properties);
    }

    @Nonnull
    public ActionResultType func_195939_a(ItemUseContext ctx) {
        ItemStack stack = ctx.func_195996_i();
        TileEntity tile = ctx.func_195991_k().func_175625_s(ctx.func_195995_a());
        if (tile instanceof TilePool) {
            TilePool pool = (TilePool)tile;
            if (!ctx.func_195991_k().field_72995_K && pool.getCurrentMana() >= 25000) {
                pool.receiveMana(-25000);
                if (!ctx.func_195999_j().field_71075_bZ.field_75098_d) {
                    stack.func_190918_g(1);
                }
                if (stack.func_190926_b()) {
                    ctx.func_195999_j().func_184611_a(ctx.func_221531_n(), new ItemStack((IItemProvider)ModItems.manadrink));
                } else {
                    ctx.func_195999_j().func_191521_c(new ItemStack((IItemProvider)ModItems.manadrink));
                }
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.PASS;
    }
}
