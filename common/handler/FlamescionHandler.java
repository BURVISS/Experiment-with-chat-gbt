/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.player.ClientPlayerEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.util.DamageSource
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.client.event.InputEvent$KeyInputEvent
 *  net.minecraftforge.common.util.LazyOptional
 *  net.minecraftforge.event.TickEvent$Phase
 *  net.minecraftforge.event.TickEvent$PlayerTickEvent
 *  net.minecraftforge.event.entity.living.LivingAttackEvent
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.network.PacketDistributor
 */
package com.meteor.extrabotany.common.handler;

import com.meteor.extrabotany.common.capability.CapabilityHandler;
import com.meteor.extrabotany.common.entities.EntityFlamescionSlash;
import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.network.NetworkHandler;
import com.meteor.extrabotany.common.network.flamescion.FlamescionQPack;
import com.meteor.extrabotany.common.network.flamescion.FlamescionShiftPack;
import com.meteor.extrabotany.common.network.flamescion.FlamescionStateUpdatePack;
import com.meteor.extrabotany.common.potions.ModPotions;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.PacketDistributor;

@Mod.EventBusSubscriber
public class FlamescionHandler {
    public static final int MAX_FLAMESCION_ENERGY = 600;

    @OnlyIn(value=Dist.CLIENT)
    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        ClientPlayerEntity p = Minecraft.func_71410_x().field_71439_g;
        if (p == null) {
            return;
        }
        if (FlamescionHandler.isFlamescionMode((PlayerEntity)p)) {
            if (!p.func_184811_cZ().func_185141_a(FlamescionHandler.getFlamescionWeapon()) && event.getAction() == 1 && event.getKey() == 340) {
                NetworkHandler.INSTANCE.sendToServer((Object)new FlamescionShiftPack());
            }
            if (event.getAction() == 1 && event.getKey() == 82) {
                NetworkHandler.INSTANCE.sendToServer((Object)new FlamescionQPack());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerAttack(LivingAttackEvent event) {
        PlayerEntity player;
        if (event.getSource().func_76346_g() instanceof PlayerEntity && FlamescionHandler.isFlamescionMode(player = (PlayerEntity)event.getSource().func_76346_g())) {
            EntityFlamescionSlash slash = new EntityFlamescionSlash(player.field_70170_p, player);
            slash.func_70107_b(event.getEntityLiving().func_226277_ct_(), event.getEntityLiving().func_226278_cu_() + 1.0, event.getEntityLiving().func_226281_cx_());
            if (!player.field_70170_p.field_72995_K) {
                player.field_70170_p.func_217376_c((Entity)slash);
            }
            player.func_195064_c(new EffectInstance(ModPotions.incandescence, 30));
            event.getEntityLiving().func_195064_c(new EffectInstance(ModPotions.timelock, 30));
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        LazyOptional cap = event.player.getCapability(CapabilityHandler.FLAMESCION_CAPABILITY);
        PlayerEntity player = event.player;
        if (event.phase == TickEvent.Phase.END) {
            cap.ifPresent(c -> {
                int energy = c.getEnergy();
                if (FlamescionHandler.isFlamescionMode(player)) {
                    if (energy < 600) {
                        c.setEnergy(Math.min(600, energy + 2));
                    } else {
                        c.setOverloaded(true);
                    }
                    c.markDirty(true);
                }
                if (c.isOverloaded()) {
                    if (energy > 0) {
                        c.setEnergy(Math.max(0, energy - 3));
                    } else {
                        c.setOverloaded(false);
                    }
                    c.markDirty(true);
                }
            });
            if (!event.player.field_70170_p.field_72995_K) {
                FlamescionHandler.sync(event.player);
            }
        }
    }

    public static void sync(PlayerEntity player) {
        LazyOptional cap = player.getCapability(CapabilityHandler.FLAMESCION_CAPABILITY);
        if (!player.field_70170_p.field_72995_K) {
            cap.ifPresent(c -> {
                if (c.isDirty()) {
                    NetworkHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity)player), (Object)new FlamescionStateUpdatePack(c.getEnergy(), c.isOverloaded()));
                    c.markDirty(false);
                }
            });
        }
    }

    public static boolean isFlamescionMode(PlayerEntity player) {
        return !player.func_233570_aj_() && player.func_184614_ca() != null && player.func_184614_ca().func_77973_b() == FlamescionHandler.getFlamescionWeapon() && player.func_70644_a(ModPotions.incandescence) && !FlamescionHandler.isOverloaded(player);
    }

    public static boolean isOverloaded(PlayerEntity player) {
        LazyOptional cap = player.getCapability(CapabilityHandler.FLAMESCION_CAPABILITY);
        AtomicBoolean overloaded = new AtomicBoolean(false);
        cap.ifPresent(c -> overloaded.set(c.isOverloaded()));
        return overloaded.get();
    }

    public static Item getFlamescionWeapon() {
        return ModItems.flamescionweapon;
    }

    public static DamageSource flameSource() {
        return new DamageSource("hoi-flame").func_76348_h().func_151518_m().func_82726_p();
    }
}
