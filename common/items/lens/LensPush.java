/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.projectile.ThrowableEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.AxisAlignedBB
 *  vazkii.botania.api.internal.IManaBurst
 *  vazkii.botania.common.item.lens.Lens
 */
package com.meteor.extrabotany.common.items.lens;

import java.util.List;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import vazkii.botania.api.internal.IManaBurst;
import vazkii.botania.common.item.lens.Lens;

public class LensPush
extends Lens {
    public void updateBurst(IManaBurst burst, ItemStack stack) {
        ThrowableEntity entity = burst.entity();
        AxisAlignedBB axis = new AxisAlignedBB(entity.func_226277_ct_(), entity.func_226278_cu_(), entity.func_226281_cx_(), entity.field_70142_S, entity.field_70137_T, entity.field_70136_U);
        List entities = entity.field_70170_p.func_217357_a(LivingEntity.class, axis);
        if (!burst.isFake()) {
            for (LivingEntity living : entities) {
                living.func_213317_d(entity.func_213322_ci());
            }
        }
    }
}
