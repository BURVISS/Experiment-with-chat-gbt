/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.tileentity.TileEntityType
 *  net.minecraft.tileentity.TileEntityType$Builder
 *  net.minecraftforge.event.RegistryEvent$Register
 *  net.minecraftforge.registries.IForgeRegistry
 */
package com.meteor.extrabotany.common.blocks.tile;

import com.meteor.extrabotany.common.blocks.ModBlocks;
import com.meteor.extrabotany.common.blocks.tile.TileManaBuffer;
import com.meteor.extrabotany.common.blocks.tile.TilePowerFrame;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ModTiles {
    public static final TileEntityType<TilePowerFrame> POWER_FRAME = TileEntityType.Builder.func_223042_a(TilePowerFrame::new, (Block[])new Block[]{ModBlocks.powerframe}).func_206865_a(null);
    public static final TileEntityType<TileManaBuffer> MANA_BUFFER = TileEntityType.Builder.func_223042_a(TileManaBuffer::new, (Block[])new Block[]{ModBlocks.manabuffer}).func_206865_a(null);

    public static void registerTiles(RegistryEvent.Register<TileEntityType<?>> evt) {
        IForgeRegistry r = evt.getRegistry();
        ModBlocks.register(r, "powerframe", POWER_FRAME);
        ModBlocks.register(r, "manabuffer", MANA_BUFFER);
    }
}
