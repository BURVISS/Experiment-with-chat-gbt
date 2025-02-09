/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.projectile.ThrowableEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.RayTraceResult
 *  vazkii.botania.api.brew.Brew
 *  vazkii.botania.api.internal.IManaBurst
 *  vazkii.botania.api.mana.BurstProperties
 *  vazkii.botania.common.item.lens.Lens
 */
package com.meteor.extrabotany.common.items.lens;

import com.meteor.extrabotany.common.items.lens.ItemLens;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import vazkii.botania.api.brew.Brew;
import vazkii.botania.api.internal.IManaBurst;
import vazkii.botania.api.mana.BurstProperties;
import vazkii.botania.common.item.lens.Lens;

public class LensPotion
extends Lens {
    public void apply(ItemStack stack, BurstProperties props) {
        props.motionModifier *= 0.9f;
        props.maxMana *= 4;
        props.manaLossPerTick *= 4.0f;
    }

    public boolean collideBurst(IManaBurst burst, RayTraceResult pos, boolean isManaBlock, boolean dead, ItemStack stack) {
        ThrowableEntity entity = burst.entity();
        AxisAlignedBB axis = new AxisAlignedBB(entity.func_226277_ct_(), entity.func_226278_cu_(), entity.func_226281_cx_(), entity.field_70142_S, entity.field_70137_T, entity.field_70136_U).func_186662_g(1.0);
        List entities = entity.field_70170_p.func_217357_a(LivingEntity.class, axis);
        if (stack.func_77973_b() instanceof ItemLens) {
            ItemLens lens = (ItemLens)stack.func_77973_b();
            Brew brew = lens.getBrew(stack);
            for (LivingEntity living : entities) {
                if (burst.isFake() || entity.field_70170_p.field_72995_K) continue;
                for (EffectInstance effect : brew.getPotionEffects(stack)) {
                    EffectInstance newEffect = new EffectInstance(effect.func_188419_a(), effect.func_76459_b() / 3, effect.func_76458_c(), true, true);
                    if (effect.func_188419_a().func_76403_b()) {
                        effect.func_188419_a().func_180793_a((Entity)living, (Entity)living, living, newEffect.func_76458_c(), 1.0);
                        continue;
                    }
                    living.func_195064_c(newEffect);
                }
                dead = true;
            }
        }
        return dead;
    }
}
