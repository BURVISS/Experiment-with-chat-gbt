/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.particles.IParticleData
 *  net.minecraft.particles.ParticleTypes
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.math.AxisAlignedBB
 *  vazkii.botania.api.subtile.RadiusDescriptor
 *  vazkii.botania.api.subtile.RadiusDescriptor$Square
 *  vazkii.botania.api.subtile.TileEntityGeneratingFlower
 */
package com.meteor.extrabotany.common.blocks.generating;

import com.meteor.extrabotany.api.ExtraBotanyAPI;
import com.meteor.extrabotany.common.blocks.ModSubtiles;
import com.meteor.extrabotany.common.handler.AdvancementHandler;
import com.meteor.extrabotany.common.potions.ModPotions;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import vazkii.botania.api.subtile.RadiusDescriptor;
import vazkii.botania.api.subtile.TileEntityGeneratingFlower;

public class SubTileBloodyEnchantress
extends TileEntityGeneratingFlower {
    private static final String TAG_BURN_TIME = "burnTime";
    private static final int RANGE = 1;
    private static final int START_BURN_EVENT = 0;
    private int burnTime = 0;

    public SubTileBloodyEnchantress() {
        super(ModSubtiles.BLOODY_ENCHANTRESS);
    }

    public void tickFlower() {
        int amp;
        super.tickFlower();
        if (this.burnTime > 0) {
            --this.burnTime;
        }
        int ampall = 0;
        for (LivingEntity living : this.func_145831_w().func_217357_a(LivingEntity.class, new AxisAlignedBB(this.getEffectivePos().func_177982_a(-1, -1, -1), this.getEffectivePos().func_177982_a(2, 2, 2)))) {
            if (living.field_70128_L) continue;
            amp = living.func_70644_a(ModPotions.bloodtemptation) ? living.func_70660_b(ModPotions.bloodtemptation).func_76458_c() : 0;
            ampall += amp;
        }
        if (ampall > 35) {
            return;
        }
        if (this.linkedCollector != null && this.burnTime == 0 && this.getMana() < this.getMaxMana()) {
            for (LivingEntity living : this.func_145831_w().func_217357_a(LivingEntity.class, new AxisAlignedBB(this.getEffectivePos().func_177982_a(-1, -1, -1), this.getEffectivePos().func_177982_a(2, 2, 2)))) {
                if (living.field_70128_L) continue;
                int n = amp = living.func_70644_a(ModPotions.bloodtemptation) ? living.func_70660_b(ModPotions.bloodtemptation).func_76458_c() : 0;
                if (amp > 4 && Math.random() > 0.5) continue;
                if (amp >= 10) break;
                this.addMana((int)(264.0f * (1.0f - 0.04f * (float)amp - 0.02f * (float)ampall)));
                ExtraBotanyAPI.addPotionEffect(living, ModPotions.bloodtemptation, 100, 10, true);
                if (living instanceof ServerPlayerEntity) {
                    AdvancementHandler.INSTANCE.grantAdvancement((ServerPlayerEntity)living, "bloodyenchantressuse");
                }
                living.func_70097_a(DamageSource.field_76376_m.func_151518_m().func_76348_h(), 3.0f);
                living.func_70097_a(DamageSource.field_76376_m, 0.01f);
                this.burnTime += 20;
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

    public boolean func_145842_c(int event, int param) {
        if (event == 0) {
            Entity e = this.func_145831_w().func_73045_a(param);
            if (e != null) {
                e.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197594_E, e.func_226277_ct_(), e.func_226278_cu_() + 0.1, e.func_226281_cx_(), 0.0, 0.0, 0.0);
                e.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197631_x, e.func_226277_ct_(), e.func_226278_cu_(), e.func_226281_cx_(), 0.0, 0.0, 0.0);
            }
            return true;
        }
        return super.func_145842_c(event, param);
    }

    public int getMaxMana() {
        return 800;
    }

    public int getValueForPassiveGeneration() {
        return 22;
    }

    public int getColor() {
        return 0x8B0000;
    }

    public RadiusDescriptor getRadius() {
        return new RadiusDescriptor.Square(this.getEffectivePos(), 1);
    }
}
