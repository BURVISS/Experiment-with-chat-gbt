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
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.vector.Vector3d
 *  vazkii.botania.api.mana.ManaItemHandler
 *  vazkii.botania.common.core.helper.Vector3
 */
package com.meteor.extrabotany.common.items.relic;

import com.meteor.extrabotany.common.core.Helper;
import com.meteor.extrabotany.common.entities.projectile.EntityTrueShadowKatanaProjectile;
import com.meteor.extrabotany.common.handler.DamageHandler;
import com.meteor.extrabotany.common.items.relic.ItemSwordRelic;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.common.core.helper.Vector3;

public class ItemTrueShadowKatana
extends ItemSwordRelic {
    public static final int MANA_PER_DAMAGE = 800;

    public ItemTrueShadowKatana(Item.Properties prop) {
        super((IItemTier)ItemTier.DIAMOND, 5, -2.0f, prop);
    }

    public void attackEntity(LivingEntity player, Entity target) {
        Vector3d targetpos = Vector3d.field_186680_a;
        float RANGE = 16.0f;
        AxisAlignedBB axis_ = new AxisAlignedBB(player.func_213303_ch().func_72441_c((double)(-RANGE), (double)(-RANGE), (double)(-RANGE)), player.func_213303_ch().func_72441_c((double)(RANGE + 1.0f), (double)(RANGE + 1.0f), (double)(RANGE + 1.0f)));
        List entities = player.field_70170_p.func_217357_a(LivingEntity.class, axis_);
        List<LivingEntity> list = DamageHandler.INSTANCE.getFilteredEntities(entities, (Entity)player);
        if (target != null || list.size() == 0) {
            targetpos = target == null ? Helper.PosToVec(ItemTrueShadowKatana.raytraceFromEntity((Entity)player, 64.0, true).func_216350_a()).func_72441_c(0.0, 1.0, 0.0) : target.func_213303_ch().func_72441_c(0.0, 1.0, 0.0);
        } else if (player.func_110144_aD() != null && entities.contains(player.func_110144_aD())) {
            targetpos = player.func_110144_aD().func_213303_ch();
        } else {
            for (LivingEntity living : entities) {
                if (living == player) continue;
                targetpos = living.func_213303_ch();
                break;
            }
        }
        for (int i = 0; i < 3; ++i) {
            Vector3 look = new Vector3(player.func_70040_Z()).multiply(1.0, 0.0, 1.0);
            double playerRot = Math.toRadians(player.field_70177_z + 90.0f);
            if (look.x == 0.0 && look.z == 0.0) {
                look = new Vector3(Math.cos(playerRot), 0.0, Math.sin(playerRot));
            }
            look = look.normalize().multiply(1.75);
            int div = i / 3;
            int mod = i % 3;
            Vector3 pl = look.add(Vector3.fromEntityCenter((Entity)player)).add(0.0, 0.1, (double)div * 0.1);
            Vector3 axis = look.normalize().crossProduct(new Vector3(-1.0, 0.0, -1.0)).normalize();
            double rot = (double)mod * Math.PI / 4.0 - 0.7853981633974483;
            Vector3 axis1 = axis.multiply((double)div * 2.5 + 2.0).rotate(rot, look);
            if (axis1.y < 0.0) {
                axis1 = axis1.multiply(1.0, -1.0, 1.0);
            }
            Vector3 end = pl.add(axis1);
            EntityTrueShadowKatanaProjectile proj = new EntityTrueShadowKatanaProjectile(player.field_70170_p, player);
            proj.func_70107_b(end.x, end.y, end.z);
            proj.setTargetPos(targetpos);
            proj.faceTargetAccurately(0.75f);
            player.field_70170_p.func_217376_c((Entity)proj);
        }
    }

    @Override
    public void onLeftClick(PlayerEntity player, Entity target) {
        if (!player.field_70170_p.field_72995_K && !player.func_184614_ca().func_190926_b() && player.func_184614_ca().func_77973_b() == this && player.func_184825_o(0.0f) == 1.0f && ManaItemHandler.instance().requestManaExactForTool(player.func_184614_ca(), player, 800, true)) {
            this.attackEntity((LivingEntity)player, target);
        }
    }
}
