/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.advancements.Advancement
 *  net.minecraft.advancements.AdvancementManager
 *  net.minecraft.advancements.AdvancementProgress
 *  net.minecraft.advancements.PlayerAdvancements
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.player.ClientPlayerEntity
 *  net.minecraft.client.multiplayer.ClientAdvancementManager
 *  net.minecraft.client.network.play.ClientPlayNetHandler
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.inventory.EquipmentSlotType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraft.util.text.TranslationTextComponent
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingUpdateEvent
 *  net.minecraftforge.event.entity.player.ItemTooltipEvent
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent
 *  net.minecraftforge.eventbus.api.EventPriority
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.ObfuscationReflectionHelper
 *  top.theillusivec4.curios.api.CuriosApi
 *  vazkii.botania.common.core.helper.PlayerHelper
 */
package com.meteor.extrabotany.common.handler;

import com.meteor.extrabotany.common.core.ConfigHandler;
import com.meteor.extrabotany.common.handler.IAdvancementRequirement;
import java.util.Map;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementManager;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.multiplayer.ClientAdvancementManager;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import top.theillusivec4.curios.api.CuriosApi;
import vazkii.botania.common.core.helper.PlayerHelper;

@Mod.EventBusSubscriber
public final class AdvancementHandler {
    public static final AdvancementHandler INSTANCE = new AdvancementHandler();

    public void grantAdvancement(ServerPlayerEntity player, String id) {
        PlayerHelper.grantCriterion((ServerPlayerEntity)player, (ResourceLocation)new ResourceLocation("extrabotany", "main/" + id), (String)"code_triggered");
    }

    public static boolean checkAdvancement(PlayerEntity player, String modid, String advancement) {
        ResourceLocation id = ResourceLocation.func_208304_a((String)(modid + ":main/" + advancement));
        if (id != null && player instanceof ServerPlayerEntity) {
            AdvancementManager manager = player.func_184102_h().func_191949_aK();
            PlayerAdvancements advancements = ((ServerPlayerEntity)player).func_192039_O();
            Advancement adv = manager.func_192778_a(id);
            if (adv != null) {
                return advancements.func_192747_a(adv).func_192105_a();
            }
        }
        return false;
    }

    @OnlyIn(value=Dist.CLIENT)
    public static Advancement getSideAdvancement(String modid, String advancement) {
        ResourceLocation id = ResourceLocation.func_208304_a((String)(modid + ":main/" + advancement));
        if (id != null) {
            ClientPlayNetHandler netHandler = Minecraft.func_71410_x().field_71439_g.field_71174_a;
            ClientAdvancementManager manager = netHandler.func_191982_f();
            Advancement adv = manager.func_194229_a().func_192084_a(id);
            return adv;
        }
        return null;
    }

    public static boolean hasDone(String modid, String advancement) {
        ClientAdvancementManager cm;
        Advancement adv;
        ClientPlayNetHandler conn;
        ResourceLocation id = ResourceLocation.func_208304_a((String)(modid + ":main/" + advancement));
        if (id != null && (conn = Minecraft.func_71410_x().func_147114_u()) != null && (adv = (cm = conn.func_191982_f()).func_194229_a().func_192084_a(id)) != null) {
            Map progressMap = (Map)ObfuscationReflectionHelper.getPrivateValue(ClientAdvancementManager.class, (Object)cm, (String)"field_192803_d");
            AdvancementProgress progress = (AdvancementProgress)progressMap.get(adv);
            return progress != null && progress.func_192105_a();
        }
        return false;
    }

    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent event) {
        if (((Boolean)ConfigHandler.COMMON.disableAdvancementCheck.get()).booleanValue()) {
            return;
        }
        if (event.isCancelable() && !event.getPlayer().func_184812_l_() && event.getItemStack().func_77973_b() instanceof IAdvancementRequirement) {
            IAdvancementRequirement r = (IAdvancementRequirement)event.getItemStack().func_77973_b();
            if (!AdvancementHandler.checkAdvancement(event.getPlayer(), "extrabotany", r.getAdvancementName())) {
                event.setCanceled(true);
            }
        }
    }

    @OnlyIn(value=Dist.CLIENT)
    @SubscribeEvent(priority=EventPriority.LOWEST)
    public static void onTooltip(ItemTooltipEvent event) {
        if (((Boolean)ConfigHandler.COMMON.disableAdvancementCheck.get()).booleanValue()) {
            return;
        }
        if (event.getItemStack().func_77973_b() instanceof IAdvancementRequirement) {
            IAdvancementRequirement r = (IAdvancementRequirement)event.getItemStack().func_77973_b();
            ClientPlayerEntity playerSP = Minecraft.func_71410_x().field_71439_g;
            if (playerSP != null && !AdvancementHandler.hasDone("extrabotany", r.getAdvancementName())) {
                event.getToolTip().add(new TranslationTextComponent("extrabotanymisc.description", new Object[]{new TranslationTextComponent("extrabotany." + r.getAdvancementName() + ".title")}).func_240699_a_(TextFormatting.RED));
            }
        }
    }

    @SubscribeEvent
    public static void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (((Boolean)ConfigHandler.COMMON.disableAdvancementCheck.get()).booleanValue()) {
            return;
        }
        if (event.getEntity() instanceof PlayerEntity && !event.getEntityLiving().field_70170_p.field_72995_K) {
            PlayerEntity player = (PlayerEntity)event.getEntityLiving();
            if (player.func_184812_l_()) {
                return;
            }
            CuriosApi.getCuriosHelper().getEquippedCurios((LivingEntity)player).ifPresent(c -> {
                for (int i = 0; i < c.getSlots(); ++i) {
                    IAdvancementRequirement r;
                    ItemStack stack = c.getStackInSlot(i);
                    if (!(stack.func_77973_b() instanceof IAdvancementRequirement) || AdvancementHandler.checkAdvancement(player, "extrabotany", (r = (IAdvancementRequirement)stack.func_77973_b()).getAdvancementName())) continue;
                    c.setStackInSlot(i, ItemStack.field_190927_a);
                    player.func_71019_a(stack, false);
                }
            });
            for (EquipmentSlotType slot : EquipmentSlotType.values()) {
                IAdvancementRequirement r;
                ItemStack stack = player.func_184582_a(slot);
                if (!(stack.func_77973_b() instanceof IAdvancementRequirement) || AdvancementHandler.checkAdvancement(player, "extrabotany", (r = (IAdvancementRequirement)stack.func_77973_b()).getAdvancementName())) continue;
                player.func_184201_a(slot, ItemStack.field_190927_a);
                player.func_71019_a(stack, false);
            }
        }
    }
}
