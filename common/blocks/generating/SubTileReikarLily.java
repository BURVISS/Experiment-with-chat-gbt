/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.effect.LightningBoltEntity
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.particles.IParticleData
 *  net.minecraft.util.math.AxisAlignedBB
 *  vazkii.botania.api.subtile.RadiusDescriptor
 *  vazkii.botania.api.subtile.RadiusDescriptor$Square
 *  vazkii.botania.api.subtile.TileEntityGeneratingFlower
 *  vazkii.botania.client.fx.WispParticleData
 */
package com.meteor.extrabotany.common.blocks.generating;

import com.meteor.extrabotany.common.blocks.ModSubtiles;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.math.AxisAlignedBB;
import vazkii.botania.api.subtile.RadiusDescriptor;
import vazkii.botania.api.subtile.TileEntityGeneratingFlower;
import vazkii.botania.client.fx.WispParticleData;

public class SubTileReikarLily
extends TileEntityGeneratingFlower {
    private static final String TAG_BURN_TIME = "burnTime";
    private static final String TAG_COOLDOWN = "cooldown";
    private static final String TAG_CD = "cd";
    private static final int RANGE = 5;
    int burnTime = 0;
    int cooldown = 0;
    int cd = 0;

    public SubTileReikarLily() {
        super(ModSubtiles.REIKARLILY);
    }

    public void tickFlower() {
        int baseY;
        super.tickFlower();
        if (this.func_145831_w().func_72896_J() && this.func_145831_w().func_226660_f_(this.field_174879_c) && this.cd == 0 && this.func_145831_w().field_73012_v.nextInt(4000 * (baseY = 64) / this.field_174879_c.func_177956_o()) == 1) {
            LightningBoltEntity bolt = new LightningBoltEntity(EntityType.field_200728_aG, this.func_145831_w());
            bolt.func_70107_b((double)this.getEffectivePos().func_177958_n(), (double)this.getEffectivePos().func_177956_o(), (double)this.getEffectivePos().func_177952_p());
            if (!this.func_145831_w().field_72995_K) {
                this.func_145831_w().func_217376_c((Entity)bolt);
            }
            this.cd += this.getCooldown();
            if (this.cooldown == 0) {
                this.burnTime += 1500;
                if (this.getMana() < this.getMaxMana()) {
                    this.addMana(this.getMaxMana());
                }
                this.cooldown = this.getCooldown();
            }
        }
        for (LightningBoltEntity bolt : this.func_145831_w().func_217357_a(LightningBoltEntity.class, new AxisAlignedBB(this.getEffectivePos().func_177982_a(-5, -5, -5), this.getEffectivePos().func_177982_a(6, 6, 6)))) {
            if (bolt.field_70128_L || this.cooldown != 0) continue;
            this.burnTime += 1500;
            if (this.getMana() < this.getMaxMana()) {
                this.addMana(this.getMaxMana());
            }
            this.cooldown = this.getCooldown();
            bolt.func_70106_y();
            break;
        }
        if (this.cooldown > 0) {
            --this.cooldown;
            for (int i = 0; i < 3; ++i) {
                WispParticleData data = WispParticleData.wisp((float)((float)Math.random() / 6.0f), (float)0.1f, (float)0.1f, (float)0.1f, (float)1.0f);
                this.field_145850_b.func_195594_a((IParticleData)data, (double)this.getEffectivePos().func_177958_n() + 0.5 + Math.random() * 0.2 - 0.1, (double)this.getEffectivePos().func_177956_o() + 0.5 + Math.random() * 0.2 - 0.1, (double)this.getEffectivePos().func_177952_p() + 0.5 + Math.random() * 0.2 - 0.1, 0.0, (double)((float)Math.random() / 30.0f), 0.0);
            }
        }
        if (this.cd > 0) {
            --this.cd;
        }
        if (this.burnTime > 0) {
            --this.burnTime;
        }
    }

    public int getMaxMana() {
        return 12000;
    }

    public int getColor() {
        return 205;
    }

    public void writeToPacketNBT(CompoundNBT cmp) {
        super.writeToPacketNBT(cmp);
        cmp.func_74768_a(TAG_BURN_TIME, this.burnTime);
        cmp.func_74768_a(TAG_COOLDOWN, this.cooldown);
        cmp.func_74768_a(TAG_CD, this.cd);
    }

    public void readFromPacketNBT(CompoundNBT cmp) {
        super.readFromPacketNBT(cmp);
        this.burnTime = cmp.func_74762_e(TAG_BURN_TIME);
        this.cooldown = cmp.func_74762_e(TAG_COOLDOWN);
        this.cd = cmp.func_74762_e(TAG_CD);
    }

    public RadiusDescriptor getRadius() {
        return new RadiusDescriptor.Square(this.getEffectivePos(), 5);
    }

    public boolean canGeneratePassively() {
        return this.burnTime > 0;
    }

    public int getValueForPassiveGeneration() {
        return 45;
    }

    public int getCooldown() {
        return 3600;
    }
}
