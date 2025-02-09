/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashMultimap
 *  com.google.common.collect.Multimap
 *  javax.annotation.Nonnull
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.ai.attributes.Attribute
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.entity.ai.attributes.Attributes
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.inventory.EquipmentSlotType
 *  net.minecraft.item.IItemTier
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemTier
 *  net.minecraft.item.Rarity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult$Type
 */
package com.meteor.extrabotany.common.items.relic;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.meteor.extrabotany.ExtraBotany;
import com.meteor.extrabotany.common.entities.projectile.EntityPhantomSword;
import com.meteor.extrabotany.common.handler.IAdvancementRequirement;
import com.meteor.extrabotany.common.items.relic.ItemSwordRelic;
import java.util.UUID;
import javax.annotation.Nonnull;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;

public class ItemFirstFractal
extends ItemSwordRelic
implements IAdvancementRequirement {
    public ItemFirstFractal() {
        super((IItemTier)ItemTier.NETHERITE, 10, -1.6f, new Item.Properties().func_200916_a(ExtraBotany.itemGroup).func_208103_a(Rarity.EPIC).func_200917_a(1).setNoRepair());
    }

    @Nonnull
    public Multimap<Attribute, AttributeModifier> func_111205_h(@Nonnull EquipmentSlotType slot) {
        Multimap ret = super.func_111205_h(slot);
        if (slot == EquipmentSlotType.MAINHAND) {
            ret = HashMultimap.create((Multimap)ret);
            ret.put((Object)Attributes.field_233821_d_, (Object)new AttributeModifier(UUID.fromString("995829fa-94c0-41bd-b046-0468c509a488"), "Fractal modifier", 0.3, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        return ret;
    }

    public void attackEntity(LivingEntity player, Entity target) {
        double z;
        double y;
        double x;
        double k;
        BlockPos targetpos;
        BlockPos blockPos = targetpos = target == null ? ItemFirstFractal.raytraceFromEntity((Entity)player, 80.0, true).func_216350_a().func_177982_a(0, 1, 0) : target.func_233580_cy_().func_177982_a(0, 1, 0);
        if (ItemFirstFractal.raytraceFromEntity((Entity)player, 80.0, true).func_216346_c() == RayTraceResult.Type.MISS) {
            targetpos = new BlockPos(player.func_213303_ch().func_178787_e(player.func_70040_Z().func_186678_a(12.0)));
        }
        double range = 13.0;
        double j = -Math.PI + Math.PI * 2 * Math.random();
        for (int i = 0; i < 3; ++i) {
            EntityPhantomSword sword = new EntityPhantomSword(player.field_70170_p, player, targetpos);
            sword.setDelay(5 + 5 * i);
            k = 0.376991110004367 * Math.random() + 0.8796459467502123;
            x = (double)targetpos.func_177958_n() + range * Math.sin(k) * Math.cos(j);
            y = (double)targetpos.func_177956_o() + range * Math.cos(k);
            z = (double)targetpos.func_177952_p() + range * Math.sin(k) * Math.sin(j);
            j += Math.PI * 2 * Math.random() * (double)0.08f + 1.0681415134557406;
            sword.func_70107_b(x, y, z);
            sword.faceTarget(1.05f);
            player.field_70170_p.func_217376_c((Entity)sword);
        }
        EntityPhantomSword sword2 = new EntityPhantomSword(player.field_70170_p, player, targetpos);
        k = 0.376991110004367 * Math.random() + 0.8796459467502123;
        x = (double)targetpos.func_177958_n() + range * Math.sin(k) * Math.cos(j);
        y = (double)targetpos.func_177956_o() + range * Math.cos(k);
        z = (double)targetpos.func_177952_p() + range * Math.sin(k) * Math.sin(j);
        sword2.func_70107_b(x, y, z);
        sword2.faceTarget(1.05f);
        sword2.setVariety(9);
        player.field_70170_p.func_217376_c((Entity)sword2);
    }

    @Override
    public void onLeftClick(PlayerEntity player, Entity target) {
        if (!player.field_70170_p.field_72995_K && !player.func_184614_ca().func_190926_b() && player.func_184614_ca().func_77973_b() == this && player.func_184825_o(0.0f) == 1.0f) {
            this.attackEntity((LivingEntity)player, target);
        }
    }

    @Override
    public String getAdvancementName() {
        return "egodefeat";
    }
}
