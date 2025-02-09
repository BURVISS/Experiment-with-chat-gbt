/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.inventory.EquipmentSlotType
 *  net.minecraft.item.BowItem
 *  net.minecraft.item.Item$Properties
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.living.LivingEntityUseItemEvent
 *  net.minecraftforge.event.entity.living.LivingHealEvent
 *  net.minecraftforge.event.entity.living.LivingHurtEvent
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 */
package com.meteor.extrabotany.common.items.armor.shootingguardian;

import com.meteor.extrabotany.common.items.armor.shootingguardian.ItemShootingGuardianArmor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ItemShootingGuardianHelm
extends ItemShootingGuardianArmor {
    public ItemShootingGuardianHelm(Item.Properties props) {
        super(EquipmentSlotType.HEAD, props);
        MinecraftForge.EVENT_BUS.addListener(this::onPlayerAttack);
        MinecraftForge.EVENT_BUS.addListener(this::onPlayerUseBow);
        MinecraftForge.EVENT_BUS.addListener(this::onPlayerHeal);
    }

    @SubscribeEvent
    public void onPlayerAttack(LivingHurtEvent event) {
        PlayerEntity player;
        if (event.getSource().func_76346_g() instanceof PlayerEntity && this.hasArmorSet(player = (PlayerEntity)event.getSource().func_76346_g())) {
            event.getSource().func_76348_h();
            player.func_70606_j(Math.min(player.func_110138_aP(), player.func_110143_aJ() + event.getAmount() * 0.2f));
        }
    }

    @SubscribeEvent
    public void onPlayerUseBow(LivingEntityUseItemEvent event) {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)event.getEntityLiving();
            if (event.getItem().func_77973_b() instanceof BowItem && this.hasArmorSet(player)) {
                event.setDuration(event.getDuration() - 1);
            }
        }
    }

    @SubscribeEvent
    public void onPlayerHeal(LivingHealEvent event) {
        PlayerEntity player;
        if (event.getEntityLiving() instanceof PlayerEntity && this.hasArmorSet(player = (PlayerEntity)event.getEntityLiving())) {
            event.setAmount(event.getAmount() * 0.2f);
        }
    }
}
