/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.FlowingFluidBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.vector.Vector3i
 *  net.minecraft.world.IBlockDisplayReader
 *  net.minecraftforge.fluids.IFluidBlock
 *  vazkii.botania.api.subtile.RadiusDescriptor
 *  vazkii.botania.api.subtile.RadiusDescriptor$Square
 *  vazkii.botania.api.subtile.TileEntityGeneratingFlower
 */
package com.meteor.extrabotany.common.blocks.generating;

import com.meteor.extrabotany.common.blocks.ModSubtiles;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraftforge.fluids.IFluidBlock;
import vazkii.botania.api.subtile.RadiusDescriptor;
import vazkii.botania.api.subtile.TileEntityGeneratingFlower;

public class SubTileGeminiOrchid
extends TileEntityGeneratingFlower {
    private static final BlockPos[] OFFSETS = new BlockPos[]{new BlockPos(0, 0, 1), new BlockPos(0, 0, -1), new BlockPos(1, 0, 0), new BlockPos(-1, 0, 0), new BlockPos(-1, 0, 1), new BlockPos(-1, 0, -1), new BlockPos(1, 0, 1), new BlockPos(1, 0, -1)};
    private static final int RANGE = 1;

    public SubTileGeminiOrchid() {
        super(ModSubtiles.GEMINIORCHID);
    }

    public void tickFlower() {
        super.tickFlower();
        int tempMax = 700;
        int tempMin = 700;
        for (int i = 0; i < OFFSETS.length; ++i) {
            FlowingFluidBlock fluid;
            BlockPos pos = this.getEffectivePos().func_177971_a((Vector3i)OFFSETS[i]);
            Block block = this.func_145831_w().func_180495_p(pos).func_177230_c();
            if (block == null) continue;
            if (block instanceof FlowingFluidBlock) {
                fluid = (FlowingFluidBlock)block;
                tempMax = Math.max(tempMax, fluid.getFluid().getAttributes().getTemperature((IBlockDisplayReader)this.func_145831_w(), pos));
                tempMin = Math.min(tempMin, fluid.getFluid().getAttributes().getTemperature((IBlockDisplayReader)this.func_145831_w(), pos));
                continue;
            }
            if (!(block instanceof IFluidBlock)) continue;
            fluid = (IFluidBlock)block;
            tempMax = Math.max(tempMax, fluid.getFluid().getAttributes().getTemperature((IBlockDisplayReader)this.func_145831_w(), pos));
            tempMin = Math.min(tempMin, fluid.getFluid().getAttributes().getTemperature((IBlockDisplayReader)this.func_145831_w(), pos));
        }
        if (this.getMana() < this.getMaxMana() && this.ticksExisted % 8 == 0) {
            this.addMana((int)((float)Math.abs(tempMax - tempMin) / 100.0f));
        }
    }

    public int getMaxMana() {
        return 1000;
    }

    public boolean isPassiveFlower() {
        return true;
    }

    public RadiusDescriptor getRadius() {
        return new RadiusDescriptor.Square(this.getEffectivePos(), 1);
    }
}
