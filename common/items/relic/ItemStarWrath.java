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
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.vector.Vector3d
 *  net.minecraft.util.math.vector.Vector3i
 *  vazkii.botania.api.mana.ManaItemHandler
 *  vazkii.botania.common.entity.EntityFallingStar
 */
package com.meteor.extrabotany.common.items.relic;

import com.meteor.extrabotany.common.items.relic.ItemSwordRelic;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3i;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.common.entity.EntityFallingStar;

public class ItemStarWrath
extends ItemSwordRelic {
    public static final int MANA_PER_DAMAGE = 500;

    public ItemStarWrath(Item.Properties prop) {
        super((IItemTier)ItemTier.DIAMOND, 6, -1.6f, prop);
    }

    public void attackEntity(LivingEntity player, Entity target) {
        BlockPos targetpos = target == null ? ItemStarWrath.raytraceFromEntity((Entity)player, 64.0, true).func_216350_a().func_177982_a(0, 1, 0) : new BlockPos(target.func_213303_ch()).func_177982_a(0, 1, 0);
        for (int i = 0; i < 5; ++i) {
            Vector3d posVec = Vector3d.func_237491_b_((Vector3i)targetpos).func_72441_c((0.5 - Math.random()) * 6.0, 0.0, (0.5 - Math.random()) * 6.0);
            Vector3d motVec = new Vector3d((0.5 * Math.random() - 0.25) * 18.0, 24.0, (0.5 * Math.random() - 0.25) * 18.0);
            posVec = posVec.func_178787_e(motVec);
            motVec = motVec.func_72432_b().func_216371_e().func_186678_a(1.5);
            EntityFallingStar star = new EntityFallingStar(player, player.field_70170_p);
            star.func_70107_b(posVec.field_72450_a, posVec.field_72448_b, posVec.field_72449_c);
            star.func_213317_d(motVec);
            player.field_70170_p.func_217376_c((Entity)star);
        }
    }

    @Override
    public void onLeftClick(PlayerEntity player, Entity target) {
        if (!player.field_70170_p.field_72995_K && !player.func_184614_ca().func_190926_b() && player.func_184614_ca().func_77973_b() == this && player.func_184825_o(0.0f) == 1.0f && ManaItemHandler.instance().requestManaExactForTool(player.func_184614_ca(), player, 500, true)) {
            this.attackEntity((LivingEntity)player, target);
        }
    }
}
