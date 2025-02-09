/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.projectile.ThrowableEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.AxisAlignedBB
 *  vazkii.botania.api.internal.IManaBurst
 *  vazkii.botania.common.core.helper.Vector3
 *  vazkii.botania.common.item.lens.Lens
 */
package com.meteor.extrabotany.common.items.lens;

import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import vazkii.botania.api.internal.IManaBurst;
import vazkii.botania.common.core.helper.Vector3;
import vazkii.botania.common.item.lens.Lens;

public class LensTrace
extends Lens {
    private static final String TAG_HOME_ID = "homeID";

    public void updateBurst(IManaBurst burst, ItemStack stack) {
        ThrowableEntity entity = burst.entity();
        if (entity.field_70170_p.field_72995_K) {
            return;
        }
        AxisAlignedBB axis = new AxisAlignedBB(entity.func_226277_ct_(), entity.func_226278_cu_(), entity.func_226281_cx_(), entity.field_70142_S, entity.field_70137_T, entity.field_70136_U).func_186662_g(4.0);
        List entities = entity.field_70170_p.func_217357_a(LivingEntity.class, axis);
        int homeID = entity.getPersistentData().func_74762_e(TAG_HOME_ID);
        if (homeID == 0) {
            Iterator iterator = entities.iterator();
            if (iterator.hasNext()) {
                LivingEntity living = (LivingEntity)iterator.next();
                entity.getPersistentData().func_74768_a(TAG_HOME_ID, living.func_145782_y());
            }
        } else {
            Entity result = entity.field_70170_p.func_73045_a(homeID);
            if (result != null && result.func_70032_d((Entity)entity) < 3.0f && !burst.isFake()) {
                Vector3 vecEntity = Vector3.fromEntityCenter((Entity)result);
                Vector3 vecThis = Vector3.fromEntityCenter((Entity)entity);
                Vector3 vecMotion = vecEntity.subtract(vecThis);
                Vector3 vecCurrentMotion = new Vector3(entity.func_213322_ci().field_72450_a, entity.func_213322_ci().field_72448_b, entity.func_213322_ci().field_72449_c);
                vecMotion.normalize().multiply(vecCurrentMotion.mag());
                burst.setBurstMotion(vecMotion.x, vecMotion.y, vecMotion.z);
            }
        }
    }
}
