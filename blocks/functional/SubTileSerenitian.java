/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.math.BlockPos
 *  vazkii.botania.api.subtile.RadiusDescriptor
 *  vazkii.botania.api.subtile.RadiusDescriptor$Square
 *  vazkii.botania.api.subtile.TileEntityFunctionalFlower
 *  vazkii.botania.api.subtile.TileEntityGeneratingFlower
 */
package com.meteor.extrabotany.common.blocks.functional;

import com.meteor.extrabotany.common.blocks.ModSubtiles;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import vazkii.botania.api.subtile.RadiusDescriptor;
import vazkii.botania.api.subtile.TileEntityFunctionalFlower;
import vazkii.botania.api.subtile.TileEntityGeneratingFlower;

public class SubTileSerenitian
extends TileEntityFunctionalFlower {
    private static final int RANGE = 3;

    public SubTileSerenitian() {
        super(ModSubtiles.SERENITIAN);
    }

    public void tickFlower() {
        super.tickFlower();
        if (this.redstoneSignal > 0) {
            return;
        }
        for (int dx = -3; dx <= 3; ++dx) {
            for (int dz = -3; dz <= 3; ++dz) {
                TileEntityGeneratingFlower flower;
                BlockPos pos = this.getEffectivePos().func_177982_a(dx, 0, dz);
                TileEntity tile = this.field_145850_b.func_175625_s(pos);
                if (!(tile instanceof TileEntityGeneratingFlower) || !(flower = (TileEntityGeneratingFlower)tile).isPassiveFlower()) continue;
                flower.passiveDecayTicks = 0;
            }
        }
    }

    public int getColor() {
        return 0;
    }

    public int getMaxMana() {
        return 1;
    }

    public boolean acceptsRedstone() {
        return true;
    }

    public RadiusDescriptor getRadius() {
        return new RadiusDescriptor.Square(this.getEffectivePos(), 3);
    }
}
