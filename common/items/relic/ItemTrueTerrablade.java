/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.IItemTier
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemTier
 *  net.minecraft.util.math.vector.Vector3d
 *  vazkii.botania.api.mana.ManaItemHandler
 */
package com.meteor.extrabotany.common.items.relic;

import com.meteor.extrabotany.common.entities.projectile.EntityTrueTerrabladeProjectile;
import com.meteor.extrabotany.common.items.relic.ItemSwordRelic;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.util.math.vector.Vector3d;
import vazkii.botania.api.mana.ManaItemHandler;

public class ItemTrueTerrablade
extends ItemSwordRelic {
    public static final int MANA_PER_DAMAGE = 400;

    public ItemTrueTerrablade(Item.Properties prop) {
        super((IItemTier)ItemTier.DIAMOND, 5, -2.0f, prop);
    }

    public void attackEntity(LivingEntity player, Entity target) {
        Vector3d targetpos = target == null ? player.func_213303_ch().func_72441_c(0.0, 1.1, 0.0).func_178787_e(player.func_70040_Z().func_186678_a(5.0)) : target.func_213303_ch().func_72441_c(0.0, 1.0, 0.0);
        EntityTrueTerrabladeProjectile proj = new EntityTrueTerrabladeProjectile(player.field_70170_p, player);
        proj.func_70107_b(player.func_226277_ct_(), player.func_226278_cu_() + 1.1, player.func_226281_cx_());
        proj.setTargetPos(targetpos);
        proj.faceTargetAccurately(0.8f);
        player.field_70170_p.func_217376_c((Entity)proj);
    }

    @Override
    public void onLeftClick(PlayerEntity player, Entity target) {
        if (!player.field_70170_p.field_72995_K && !player.func_184614_ca().func_190926_b() && player.func_184614_ca().func_77973_b() == this && player.func_184825_o(0.0f) == 1.0f && ManaItemHandler.instance().requestManaExactForTool(player.func_184614_ca(), player, 400, true)) {
            this.attackEntity((LivingEntity)player, target);
        }
    }
}
