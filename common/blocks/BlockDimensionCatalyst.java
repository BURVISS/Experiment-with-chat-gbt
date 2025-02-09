/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.AbstractBlock$Properties
 *  net.minecraft.block.Block
 *  net.minecraft.client.renderer.texture.TextureAtlasSprite
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  vazkii.botania.api.mana.IPoolOverlayProvider
 */
package com.meteor.extrabotany.common.blocks;

import com.meteor.extrabotany.client.handler.MiscellaneousIcons;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vazkii.botania.api.mana.IPoolOverlayProvider;

public class BlockDimensionCatalyst
extends Block
implements IPoolOverlayProvider {
    public BlockDimensionCatalyst(AbstractBlock.Properties builder) {
        super(builder);
    }

    @OnlyIn(value=Dist.CLIENT)
    public TextureAtlasSprite getIcon(World world, BlockPos pos) {
        return MiscellaneousIcons.INSTANCE.dimensionCatalystOverlay.func_229314_c_();
    }
}
