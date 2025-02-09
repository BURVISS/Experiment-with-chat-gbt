/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.tileentity.TileEntityType
 *  vazkii.botania.api.subtile.RadiusDescriptor
 *  vazkii.botania.api.subtile.RadiusDescriptor$Square
 *  vazkii.botania.api.subtile.TileEntityGeneratingFlower
 */
package com.meteor.extrabotany.common.blocks.generating;

import com.meteor.extrabotany.common.blocks.ModSubtiles;
import net.minecraft.tileentity.TileEntityType;
import vazkii.botania.api.subtile.RadiusDescriptor;
import vazkii.botania.api.subtile.TileEntityGeneratingFlower;

public class SubTileSunBless
extends TileEntityGeneratingFlower {
    private static final int RANGE = 2;

    public SubTileSunBless(TileEntityType<?> type) {
        super(type);
    }

    public SubTileSunBless() {
        this(ModSubtiles.SUNBLESS);
    }

    public int getMaxMana() {
        return 200;
    }

    public int getValueForPassiveGeneration() {
        return 1;
    }

    public int getColor() {
        return 16753920;
    }

    public RadiusDescriptor getRadius() {
        return new RadiusDescriptor.Square(this.getEffectivePos(), 2);
    }

    public boolean canGeneratePassively() {
        return this.func_145831_w().func_72935_r() && this.ticksExisted % 2 == 0;
    }

    public int getDelayBetweenPassiveGeneration() {
        return 2;
    }

    public boolean isPassiveFlower() {
        return true;
    }
}
