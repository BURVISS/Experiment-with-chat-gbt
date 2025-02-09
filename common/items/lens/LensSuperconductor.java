/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.projectile.ThrowableEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.world.World
 *  vazkii.botania.api.internal.IManaBurst
 *  vazkii.botania.api.mana.BurstProperties
 *  vazkii.botania.common.item.lens.Lens
 */
package com.meteor.extrabotany.common.items.lens;

import com.meteor.extrabotany.common.handler.DamageHandler;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import vazkii.botania.api.internal.IManaBurst;
import vazkii.botania.api.mana.BurstProperties;
import vazkii.botania.common.item.lens.Lens;

public class LensSuperconductor
extends Lens {
    public void apply(ItemStack stack, BurstProperties props) {
        props.maxMana = (int)((float)props.maxMana * 8.0f);
        props.motionModifier *= 1.5f;
        props.manaLossPerTick *= 16.0f;
        props.ticksBeforeManaLoss = (int)((float)props.ticksBeforeManaLoss * 0.8f);
    }

    public void updateBurst(IManaBurst burst, ItemStack stack) {
        ThrowableEntity entity = burst.entity();
        if (entity.field_70170_p.field_72995_K) {
            return;
        }
        World world = entity.field_70170_p;
        AxisAlignedBB axis = new AxisAlignedBB(entity.func_226277_ct_() - 0.5, entity.func_226278_cu_() - 0.5, entity.func_226281_cx_() - 0.5, entity.field_70142_S + 0.5, entity.field_70137_T + 0.5, entity.field_70136_U + 0.5).func_186662_g(1.0);
        List entities = entity.field_70170_p.func_217357_a(LivingEntity.class, axis);
        for (LivingEntity living : entities) {
            if (burst.isFake()) continue;
            DamageHandler.INSTANCE.dmg((Entity)living, null, living instanceof PlayerEntity ? 25.0f : 8.0f, DamageHandler.INSTANCE.MAGIC_PIERCING);
        }
    }
}
