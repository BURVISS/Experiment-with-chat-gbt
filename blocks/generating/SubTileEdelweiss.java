/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.passive.SnowGolemEntity
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.util.math.AxisAlignedBB
 *  vazkii.botania.api.subtile.RadiusDescriptor
 *  vazkii.botania.api.subtile.RadiusDescriptor$Square
 *  vazkii.botania.api.subtile.TileEntityGeneratingFlower
 */
package com.meteor.extrabotany.common.blocks.generating;

import com.meteor.extrabotany.common.blocks.ModSubtiles;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.AxisAlignedBB;
import vazkii.botania.api.subtile.RadiusDescriptor;
import vazkii.botania.api.subtile.TileEntityGeneratingFlower;

public class SubTileEdelweiss
extends TileEntityGeneratingFlower {
    private static final String TAG_BURN_TIME = "burnTime";
    private static final int RANGE = 1;
    private int burnTime = 0;

    public SubTileEdelweiss() {
        super(ModSubtiles.EDELWEISS);
    }

    public void tickFlower() {
        super.tickFlower();
        if (this.burnTime > 0) {
            --this.burnTime;
        }
        if (this.linkedCollector != null && this.burnTime == 0 && this.getMana() < this.getMaxMana()) {
            for (SnowGolemEntity golem : this.func_145831_w().func_217357_a(SnowGolemEntity.class, new AxisAlignedBB(this.getEffectivePos().func_177982_a(-1, -1, -1), this.getEffectivePos().func_177982_a(2, 2, 2)))) {
                if (golem.field_70128_L) continue;
                golem.func_70106_y();
                this.addMana(1600);
                this.burnTime += 5;
                break;
            }
        }
    }

    public void writeToPacketNBT(CompoundNBT cmp) {
        super.writeToPacketNBT(cmp);
        cmp.func_74768_a(TAG_BURN_TIME, this.burnTime);
    }

    public void readFromPacketNBT(CompoundNBT cmp) {
        super.readFromPacketNBT(cmp);
        this.burnTime = cmp.func_74762_e(TAG_BURN_TIME);
    }

    public RadiusDescriptor getRadius() {
        return new RadiusDescriptor.Square(this.getEffectivePos(), 1);
    }

    public int getColor() {
        return 4286945;
    }
}
