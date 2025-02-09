/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.potion.Effects
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.MathHelper
 *  vazkii.botania.api.subtile.RadiusDescriptor
 *  vazkii.botania.api.subtile.RadiusDescriptor$Square
 *  vazkii.botania.api.subtile.TileEntityGeneratingFlower
 */
package com.meteor.extrabotany.common.blocks.generating;

import com.meteor.extrabotany.common.blocks.ModSubtiles;
import com.meteor.extrabotany.common.handler.AdvancementHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import vazkii.botania.api.subtile.RadiusDescriptor;
import vazkii.botania.api.subtile.TileEntityGeneratingFlower;

public class SubTileTinkleFlower
extends TileEntityGeneratingFlower {
    private static final int RANGE = 8;
    private static final String TAG_TIME = "time";
    private int time = 0;

    public SubTileTinkleFlower() {
        super(ModSubtiles.TINKLEFLOWER);
    }

    public void tickFlower() {
        super.tickFlower();
        if (!this.field_145850_b.field_72995_K && this.field_145850_b.func_82737_E() % 20L == 0L) {
            int time;
            CompoundNBT tag = this.getTileData();
            int prevTime = time = tag.func_74771_c(TAG_TIME);
            for (PlayerEntity player : this.func_145831_w().func_217357_a(PlayerEntity.class, new AxisAlignedBB(this.getEffectivePos().func_177982_a(-8, -8, -8), this.getEffectivePos().func_177982_a(9, 9, 9)))) {
                double vx = player.func_226277_ct_() - player.field_71094_bP;
                double vy = player.func_226278_cu_() - player.field_71095_bQ;
                double vz = player.func_226281_cx_() - player.field_71085_bR;
                double vel = Math.sqrt(vx * vx + vy * vy + vz * vz);
                if (player.func_70644_a(Effects.field_76424_c)) {
                    vel *= 1.2;
                }
                int limit = 10;
                if ((time += MathHelper.func_76125_a((int)((int)(vel * 10.0)), (int)0, (int)8)) >= 10) {
                    if (this.getMana() < this.getMaxMana()) {
                        this.addMana(30);
                    }
                    player.func_71020_j(0.02f);
                    AdvancementHandler.INSTANCE.grantAdvancement((ServerPlayerEntity)player, "tinkleuse");
                    time %= 10;
                }
                if (time == prevTime) continue;
                tag.func_74774_a(TAG_TIME, (byte)time);
            }
        }
    }

    public int getMaxMana() {
        return 1000;
    }

    public int getColor() {
        return 0xCCFF00;
    }

    public RadiusDescriptor getRadius() {
        return new RadiusDescriptor.Square(this.getEffectivePos(), 8);
    }

    public void writeToPacketNBT(CompoundNBT cmp) {
        super.writeToPacketNBT(cmp);
        cmp.func_74768_a(TAG_TIME, this.time);
    }

    public void readFromPacketNBT(CompoundNBT cmp) {
        super.readFromPacketNBT(cmp);
        this.time = cmp.func_74762_e(TAG_TIME);
    }
}
