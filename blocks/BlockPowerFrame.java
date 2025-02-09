/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 *  net.minecraft.block.AbstractBlock$Properties
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.ITileEntityProvider
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.InventoryHelper
 *  net.minecraft.item.ItemStack
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.ActionResultType
 *  net.minecraft.util.Hand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockRayTraceResult
 *  net.minecraft.world.IBlockReader
 *  net.minecraft.world.World
 *  vazkii.botania.api.internal.VanillaPacketDispatcher
 *  vazkii.botania.api.mana.IManaItem
 *  vazkii.botania.common.block.BlockMod
 *  vazkii.botania.common.block.tile.TileSimpleInventory
 *  vazkii.botania.common.core.helper.InventoryHelper
 */
package com.meteor.extrabotany.common.blocks;

import com.meteor.extrabotany.common.blocks.tile.TilePowerFrame;
import com.meteor.extrabotany.common.items.ModItems;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import vazkii.botania.api.internal.VanillaPacketDispatcher;
import vazkii.botania.api.mana.IManaItem;
import vazkii.botania.common.block.BlockMod;
import vazkii.botania.common.block.tile.TileSimpleInventory;

public class BlockPowerFrame
extends BlockMod
implements ITileEntityProvider {
    public BlockPowerFrame(AbstractBlock.Properties builder) {
        super(builder);
    }

    public ActionResultType func_225533_a_(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (world.field_72995_K) {
            return ActionResultType.SUCCESS;
        }
        TilePowerFrame frame = (TilePowerFrame)world.func_175625_s(pos);
        ItemStack stack = player.func_184586_b(hand);
        if (player.func_225608_bj_()) {
            vazkii.botania.common.core.helper.InventoryHelper.withdrawFromInventory((TileSimpleInventory)frame, (PlayerEntity)player);
            VanillaPacketDispatcher.dispatchTEToNearbyPlayers((TileEntity)frame);
            return ActionResultType.SUCCESS;
        }
        if (!stack.func_190926_b() && stack.func_77973_b() instanceof IManaItem || stack.func_77973_b() == ModItems.natureorb) {
            boolean result = frame.addItem(player, stack, hand);
            VanillaPacketDispatcher.dispatchTEToNearbyPlayers((TileEntity)frame);
            return result ? ActionResultType.SUCCESS : ActionResultType.PASS;
        }
        return ActionResultType.PASS;
    }

    @Nullable
    public TileEntity func_196283_a_(IBlockReader iBlockReader) {
        return new TilePowerFrame();
    }

    public void func_196243_a(@Nonnull BlockState state, @Nonnull World world, @Nonnull BlockPos pos, @Nonnull BlockState newState, boolean isMoving) {
        if (state.func_177230_c() != newState.func_177230_c()) {
            TileEntity te = world.func_175625_s(pos);
            if (te instanceof TileSimpleInventory) {
                InventoryHelper.func_180175_a((World)world, (BlockPos)pos, (IInventory)((TileSimpleInventory)te).getItemHandler());
            }
            super.func_196243_a(state, world, pos, newState, isMoving);
        }
    }
}
