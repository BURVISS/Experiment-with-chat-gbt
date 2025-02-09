/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.AbstractBlock$Properties
 *  net.minecraft.potion.Effect
 *  vazkii.botania.api.subtile.TileEntitySpecialFlower
 *  vazkii.botania.common.block.BlockSpecialFlower
 */
package com.meteor.extrabotany.common.blocks;

import java.util.function.Supplier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.potion.Effect;
import vazkii.botania.api.subtile.TileEntitySpecialFlower;

public class BlockSpecialFlower
extends vazkii.botania.common.block.BlockSpecialFlower {
    public BlockSpecialFlower(Effect stewEffect, int stewDuration, AbstractBlock.Properties props, Supplier<? extends TileEntitySpecialFlower> teProvider) {
        super(stewEffect, stewDuration, props, teProvider);
    }
}
