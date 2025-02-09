/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockState
 *  net.minecraft.entity.projectile.ThrowableEntity
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.crafting.IRecipe
 *  net.minecraft.item.crafting.IRecipeType
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockRayTraceResult
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.world.IBlockReader
 *  net.minecraft.world.World
 *  vazkii.botania.api.internal.IManaBurst
 *  vazkii.botania.api.mana.IManaBlock
 *  vazkii.botania.common.core.handler.ConfigHandler
 *  vazkii.botania.common.item.ModItems
 *  vazkii.botania.common.item.lens.ItemLens
 *  vazkii.botania.common.item.lens.Lens
 */
package com.meteor.extrabotany.common.items.lens;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import vazkii.botania.api.internal.IManaBurst;
import vazkii.botania.api.mana.IManaBlock;
import vazkii.botania.common.core.handler.ConfigHandler;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.item.lens.ItemLens;
import vazkii.botania.common.item.lens.Lens;

public class LensSmelt
extends Lens {
    public boolean collideBurst(IManaBurst burst, RayTraceResult rtr, boolean isManaBlock, boolean dead, ItemStack stack) {
        ThrowableEntity entity = burst.entity();
        World world = entity.field_70170_p;
        if (world.field_72995_K || rtr.func_216346_c() != RayTraceResult.Type.BLOCK) {
            return false;
        }
        BlockPos collidePos = ((BlockRayTraceResult)rtr).func_216350_a();
        BlockState state = world.func_180495_p(collidePos);
        Block block = state.func_177230_c();
        ItemStack composite = ((ItemLens)stack.func_77973_b()).getCompositeLens(stack);
        boolean warp = !composite.func_190926_b() && composite.func_77973_b() == ModItems.lensWarp;
        int harvestLevel = (Integer)ConfigHandler.COMMON.harvestLevelBore.get();
        TileEntity tile = world.func_175625_s(collidePos);
        float hardness = state.func_185887_b((IBlockReader)world, collidePos);
        int neededHarvestLevel = block.getHarvestLevel(state);
        int mana = burst.getMana();
        BlockPos source = burst.getBurstSourceBlockPos();
        if (!source.equals((Object)collidePos) && !(tile instanceof IManaBlock) && neededHarvestLevel <= harvestLevel && hardness != -1.0f && hardness < 50.0f && (burst.isFake() || mana >= 24)) {
            IRecipe irecipe;
            if (!(burst.hasAlreadyCollidedAt(collidePos) || burst.isFake() || (irecipe = (IRecipe)world.func_199532_z().func_215371_a(IRecipeType.field_222150_b, (IInventory)new Inventory(new ItemStack[]{new ItemStack((IItemProvider)block)}), world).orElse(null)).func_77571_b().func_190926_b())) {
                world.func_217377_a(collidePos, false);
                if (((Boolean)ConfigHandler.COMMON.blockBreakParticles.get()).booleanValue()) {
                    world.func_217379_c(2001, collidePos, Block.func_196246_j((BlockState)state));
                }
                boolean offBounds = source.func_177956_o() < 0;
                boolean doWarp = warp && !offBounds;
                BlockPos dropCoord = doWarp ? source : collidePos;
                Block.func_180635_a((World)world, (BlockPos)dropCoord, (ItemStack)irecipe.func_77571_b().func_77946_l());
                burst.setMana(mana - 40);
            }
            dead = false;
        }
        return dead;
    }
}
