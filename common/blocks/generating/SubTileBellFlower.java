/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.CompoundNBT
 *  vazkii.botania.api.subtile.RadiusDescriptor
 *  vazkii.botania.api.subtile.RadiusDescriptor$Square
 *  vazkii.botania.api.subtile.TileEntityGeneratingFlower
 */
package com.meteor.extrabotany.common.blocks.generating;

import com.meteor.extrabotany.common.blocks.ModSubtiles;
import net.minecraft.nbt.CompoundNBT;
import vazkii.botania.api.subtile.RadiusDescriptor;
import vazkii.botania.api.subtile.TileEntityGeneratingFlower;

public class SubTileBellFlower
extends TileEntityGeneratingFlower {
    private static final int RANGE = 2;

    public SubTileBellFlower() {
        super(ModSubtiles.BELL_FLOWER);
    }

    public void tickFlower() {
        super.tickFlower();
        int baseGen = 10;
        int baseY = 90;
        int y = this.getEffectivePos().func_177956_o();
        if (this.func_145831_w().func_175710_j(this.getEffectivePos()) && y > baseY) {
            int rain = this.func_145831_w().func_72896_J() ? 3 : 0;
            int gen = (baseGen + rain) * y / baseY;
            if (this.ticksExisted % 10 == 0) {
                this.addMana(gen);
            }
        }
    }

    public int getMaxMana() {
        return 300;
    }

    public int getColor() {
        return 0xFFFF99;
    }

    public RadiusDescriptor getRadius() {
        return new RadiusDescriptor.Square(this.getEffectivePos(), 2);
    }

    public void writeToPacketNBT(CompoundNBT cmp) {
        super.writeToPacketNBT(cmp);
    }

    public void readFromPacketNBT(CompoundNBT cmp) {
        super.readFromPacketNBT(cmp);
    }

    public boolean isPassiveFlower() {
        return true;
    }
}
