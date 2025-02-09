/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.potion.Effect
 *  net.minecraft.potion.EffectType
 */
package com.meteor.extrabotany.common.potions;

import com.meteor.extrabotany.common.handler.FlamescionHandler;
import javax.annotation.Nonnull;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class PotionIncandescence
extends Effect {
    public PotionIncandescence() {
        super(EffectType.BENEFICIAL, 14423100);
    }

    public boolean func_76397_a(int duration, int amplifier) {
        return true;
    }

    public void func_76394_a(@Nonnull LivingEntity living, int amplified) {
        if (living.func_213322_ci().field_72448_b < 0.0) {
            living.func_213317_d(living.func_213322_ci().func_216372_d(1.0, 0.05, 1.0));
        }
        if (living instanceof PlayerEntity && !FlamescionHandler.isFlamescionMode((PlayerEntity)living)) {
            living.func_195063_d((Effect)this);
        }
    }
}
