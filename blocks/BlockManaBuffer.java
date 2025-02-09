/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.AbstractBlock$Properties
 *  net.minecraft.block.ITileEntityProvider
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.world.IBlockReader
 *  vazkii.botania.common.block.BlockMod
 */
package com.meteor.extrabotany.common.blocks;

import com.meteor.extrabotany.common.blocks.tile.TileManaBuffer;
import javax.annotation.Nullable;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import vazkii.botania.common.block.BlockMod;

public class BlockManaBuffer
extends BlockMod
implements ITileEntityProvider {
    public BlockManaBuffer(AbstractBlock.Properties builder) {
        super(builder);
    }

    @Nullable
    public TileEntity func_196283_a_(IBlockReader iBlockReader) {
        return new TileManaBuffer();
    }
}
