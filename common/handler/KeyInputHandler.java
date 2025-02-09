/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.player.ClientPlayerEntity
 *  net.minecraft.client.gui.screen.ChatScreen
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.inventory.ContainerScreen
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Hand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockRayTraceResult
 *  net.minecraft.util.math.EntityRayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.client.event.InputEvent$KeyInputEvent
 *  net.minecraftforge.common.ForgeHooks
 *  net.minecraftforge.event.TickEvent$ClientTickEvent
 *  net.minecraftforge.event.TickEvent$Phase
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  vazkii.botania.common.core.handler.EquipmentHandler
 */
package com.meteor.extrabotany.common.handler;

import com.meteor.extrabotany.ExtraBotany;
import com.meteor.extrabotany.api.items.IMountableAccessory;
import com.meteor.extrabotany.client.ClientProxy;
import com.meteor.extrabotany.common.entities.mountable.EntityMountable;
import com.meteor.extrabotany.common.entities.mountable.EntityUfo;
import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.items.relic.ItemBuddhistrelics;
import com.meteor.extrabotany.common.network.BuddhistChangePack;
import com.meteor.extrabotany.common.network.MountPack;
import com.meteor.extrabotany.common.network.MountableUpdatePack;
import com.meteor.extrabotany.common.network.NetworkHandler;
import com.meteor.extrabotany.common.network.UfoCatchPack;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import vazkii.botania.common.core.handler.EquipmentHandler;

@Mod.EventBusSubscriber
public class KeyInputHandler {
    @OnlyIn(value=Dist.CLIENT)
    @SubscribeEvent
    public static void tick(TickEvent.ClientTickEvent e) {
        Minecraft mc = Minecraft.func_71410_x();
        if (e.phase == TickEvent.Phase.END && mc.field_71439_g != null && mc.field_71439_g.func_184825_o(0.0f) == 1.0f && mc.field_71474_y.field_74312_F.func_151470_d() && !EquipmentHandler.findOrEmpty((Item)ModItems.powerglove, (LivingEntity)mc.field_71439_g).func_190926_b()) {
            if (mc.field_71476_x.func_216346_c() == RayTraceResult.Type.ENTITY) {
                EntityRayTraceResult result = (EntityRayTraceResult)mc.field_71476_x;
                Entity entity = result.func_216348_a();
                mc.field_71442_b.func_78764_a((PlayerEntity)mc.field_71439_g, entity);
            } else if (mc.field_71476_x.func_216346_c() == RayTraceResult.Type.BLOCK) {
                BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult)mc.field_71476_x;
                BlockPos blockpos = blockraytraceresult.func_216350_a();
                if (!mc.field_71439_g.field_70170_p.func_175623_d(blockpos)) {
                    mc.field_71442_b.func_180511_b(blockpos, blockraytraceresult.func_216354_b());
                }
            } else if (mc.field_71476_x.func_216346_c() == RayTraceResult.Type.MISS) {
                mc.field_71439_g.func_184821_cY();
                ForgeHooks.onEmptyLeftClick((PlayerEntity)mc.field_71439_g);
                mc.field_71439_g.func_184609_a(Hand.MAIN_HAND);
            }
        }
    }

    @OnlyIn(value=Dist.CLIENT)
    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        EntityMountable steerable;
        ItemStack mountable;
        Entity riding;
        Minecraft mc = Minecraft.func_71410_x();
        ClientPlayerEntity p = mc.field_71439_g;
        Predicate<Screen> guiFilter = gui -> gui instanceof ContainerScreen || gui instanceof ChatScreen;
        if (p == null || mc.field_71441_e == null || guiFilter.test(mc.field_71462_r)) {
            return;
        }
        if (event.getAction() == 1 && event.getKey() == ClientProxy.BUDDHIST_SHIFT.getKey().func_197937_c() && !ItemBuddhistrelics.relicShift(p.func_184614_ca()).func_190926_b()) {
            NetworkHandler.INSTANCE.sendToServer((Object)new BuddhistChangePack());
        }
        if ((riding = p.func_184187_bx()) == null && event.getAction() == 1 && event.getKey() == ClientProxy.MOUNT_SUMMON.getKey().func_197937_c() && !(mountable = EquipmentHandler.findOrEmpty(stack -> stack.func_77973_b() instanceof IMountableAccessory, (LivingEntity)p)).func_190926_b()) {
            NetworkHandler.INSTANCE.sendToServer((Object)new MountPack(mountable));
            return;
        }
        if (riding instanceof EntityMountable) {
            steerable = (EntityMountable)riding;
            steerable.updateInput(ExtraBotany.keyFlight.func_151470_d(), ExtraBotany.keyUp.func_151470_d());
            NetworkHandler.INSTANCE.sendToServer((Object)new MountableUpdatePack(ExtraBotany.keyFlight.func_151470_d(), ExtraBotany.keyUp.func_151470_d()));
        }
        if (riding instanceof EntityUfo) {
            steerable = (EntityUfo)riding;
            if (event.getAction() == 1 && event.getKey() == ClientProxy.UFO_CATCH.getKey().func_197937_c()) {
                if (((EntityUfo)steerable).getCatchedID() != -1) {
                    ((EntityUfo)steerable).setCatchedID(-1);
                    NetworkHandler.INSTANCE.sendToServer((Object)new UfoCatchPack(-1));
                    return;
                }
                List<LivingEntity> entities = ((EntityUfo)steerable).getEntitiesBelow();
                if (entities.size() > 0) {
                    int id = -1;
                    float distance = 16.0f;
                    for (Entity entity : entities) {
                        if (entity == p || !(entity.func_70032_d((Entity)steerable) < distance)) continue;
                        distance = entity.func_70032_d((Entity)steerable);
                        id = entity.func_145782_y();
                    }
                    ((EntityUfo)steerable).setCatchedID(id);
                    NetworkHandler.INSTANCE.sendToServer((Object)new UfoCatchPack(id));
                }
            }
        }
    }
}
