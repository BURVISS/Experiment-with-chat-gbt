/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.item.SwordItem
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.Hand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.common.util.LazyOptional
 *  net.minecraftforge.event.TickEvent$PlayerTickEvent
 *  net.minecraftforge.event.entity.living.LivingAttackEvent
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent$LeftClickEmpty
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.network.PacketDistributor
 */
package com.meteor.extrabotany.common.handler;

import com.meteor.extrabotany.common.capability.CapabilityHandler;
import com.meteor.extrabotany.common.core.EquipmentHandler;
import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.network.HerrscherEnergyUpdatePack;
import com.meteor.extrabotany.common.network.HerrscherSkillPack;
import com.meteor.extrabotany.common.network.NetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.SwordItem;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.PacketDistributor;

@Mod.EventBusSubscriber
public class HerrscherHandler {
    @SubscribeEvent
    public static void onHerrscherAttacked(LivingAttackEvent event) {
        PlayerEntity player;
        if (event.getSource().func_76364_f() != null && event.getEntityLiving() instanceof PlayerEntity && HerrscherHandler.isHerrscherOfThunder(player = (PlayerEntity)event.getEntityLiving())) {
            LazyOptional cap = player.getCapability(CapabilityHandler.HERRSCHERENERGY_CAPABILITY);
            cap.ifPresent(c -> {
                if ((c.getEnergy() >= 200 || player.func_184812_l_()) && !player.field_82175_bq && player.func_184614_ca().func_77973_b() instanceof SwordItem) {
                    player.func_226292_a_(Hand.MAIN_HAND, true);
                    player.func_71059_n(event.getSource().func_76364_f());
                    c.setEnergy(c.getEnergy() - 200);
                    c.markDirty(true);
                    HerrscherHandler.sync(player);
                    event.setCanceled(true);
                }
            });
        }
    }

    @OnlyIn(value=Dist.CLIENT)
    @SubscribeEvent
    public static void onPlayerLeftClick(PlayerInteractEvent.LeftClickEmpty event) {
        PlayerEntity player = event.getPlayer();
        Minecraft mc = Minecraft.func_71410_x();
        RayTraceResult pos = mc.field_71476_x;
        if (HerrscherHandler.isHerrscherOfThunder(player) && !event.getItemStack().func_190926_b() && event.getItemStack().func_77973_b() instanceof SwordItem) {
            LazyOptional cap = player.getCapability(CapabilityHandler.HERRSCHERENERGY_CAPABILITY);
            cap.ifPresent(c -> {
                int energy = c.getEnergy();
                if (pos != null) {
                    BlockPos p = new BlockPos(pos.func_216347_e());
                    if ((energy == 600 || player.func_184812_l_()) && mc.field_71474_y.field_151444_V.func_151470_d()) {
                        c.setEnergy(0);
                        c.markDirty(true);
                        NetworkHandler.INSTANCE.sendToServer((Object)new HerrscherSkillPack(p.func_177982_a(0, 2, 0)));
                    }
                }
            });
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (!HerrscherHandler.isHerrscherOfThunder(event.player)) {
            return;
        }
        LazyOptional cap = event.player.getCapability(CapabilityHandler.HERRSCHERENERGY_CAPABILITY);
        cap.ifPresent(c -> {
            int energy = c.getEnergy();
            if (energy < 600) {
                c.setEnergy(Math.min(600, energy + 2));
                c.markDirty(true);
            }
        });
        if (!event.player.field_70170_p.field_72995_K) {
            HerrscherHandler.sync(event.player);
        }
    }

    public static void sync(PlayerEntity player) {
        LazyOptional cap = player.getCapability(CapabilityHandler.HERRSCHERENERGY_CAPABILITY);
        if (!player.field_70170_p.field_72995_K) {
            cap.ifPresent(c -> {
                if (c.isDirty()) {
                    NetworkHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity)player), (Object)new HerrscherEnergyUpdatePack(c.getEnergy()));
                    c.markDirty(false);
                }
            });
        }
    }

    public static DamageSource damageSource() {
        return new DamageSource("hoi-thunder").func_76348_h().func_151518_m().func_82726_p();
    }

    public static DamageSource iceSource() {
        return new DamageSource("hoi-ice").func_76348_h().func_151518_m().func_82726_p();
    }

    public static void thunderAttack(Entity target, PlayerEntity player, float dmg) {
        target.func_70097_a(HerrscherHandler.damageSource(), dmg);
    }

    public static void iceAttack(Entity target, PlayerEntity player, float dmg) {
        target.func_70097_a(HerrscherHandler.iceSource(), dmg);
    }

    public static boolean isHerrscherOfThunder(PlayerEntity player) {
        return !EquipmentHandler.findOrEmpty(ModItems.gemofconquest, (LivingEntity)player).func_190926_b();
    }
}
