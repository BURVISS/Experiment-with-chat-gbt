/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemUseContext
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.ActionResultType
 *  net.minecraft.util.Util
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.StringTextComponent
 *  vazkii.botania.api.mana.IManaBlock
 *  vazkii.botania.common.block.tile.mana.TilePool
 */
package com.meteor.extrabotany.common.items;

import javax.annotation.Nonnull;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Util;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import vazkii.botania.api.mana.IManaBlock;
import vazkii.botania.common.block.tile.mana.TilePool;

public class ItemManaReader
extends Item {
    public ItemManaReader(Item.Properties properties) {
        super(properties);
    }

    @Nonnull
    public ActionResultType func_195939_a(ItemUseContext ctx) {
        TileEntity tile = ctx.func_195991_k().func_175625_s(ctx.func_195995_a());
        PlayerEntity player = ctx.func_195999_j();
        int mana = 0;
        if (tile instanceof TilePool) {
            TilePool pool = (TilePool)tile;
            mana = pool.getCurrentMana();
        } else if (tile instanceof IManaBlock) {
            IManaBlock t = (IManaBlock)tile;
            mana = t.getCurrentMana();
        }
        if (!ctx.func_195991_k().field_72995_K) {
            player.func_145747_a((ITextComponent)new StringTextComponent(String.format("Mana:%d", mana)), Util.field_240973_b_);
        }
        return ActionResultType.PASS;
    }
}
