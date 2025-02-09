/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.IRenderTypeBuffer
 *  net.minecraft.client.renderer.entity.model.BipedModel
 *  net.minecraft.client.renderer.model.ItemCameraTransforms$TransformType
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.potion.Effects
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.SoundEvents
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.living.LivingDeathEvent
 *  net.minecraftforge.eventbus.api.EventPriority
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  vazkii.botania.api.mana.ManaItemHandler
 */
package com.meteor.extrabotany.common.items.bauble;

import com.meteor.extrabotany.common.core.EquipmentHandler;
import com.meteor.extrabotany.common.items.bauble.ItemBauble;
import com.meteor.extrabotany.common.network.NetworkHandler;
import com.meteor.extrabotany.common.network.PotatoChipsPack;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import vazkii.botania.api.mana.ManaItemHandler;

public class ItemPotatoChips
extends ItemBauble {
    public static final int MANA_PER_DAMAGE = 3000;

    public ItemPotatoChips(Item.Properties props) {
        super(props);
        MinecraftForge.EVENT_BUS.addListener(this::onPlayerDeath);
    }

    @SubscribeEvent(priority=EventPriority.LOWEST)
    public void onPlayerDeath(LivingDeathEvent event) {
        PlayerEntity player;
        if (!event.isCanceled() && event.getEntityLiving() instanceof PlayerEntity && !EquipmentHandler.findOrEmpty((Item)this, (LivingEntity)(player = (PlayerEntity)event.getEntityLiving())).func_190926_b() && !player.func_184811_cZ().func_185141_a((Item)this) && ManaItemHandler.instance().requestManaExactForTool(new ItemStack((IItemProvider)this), player, 3000, true)) {
            if (!player.field_70170_p.field_72995_K) {
                player.field_70170_p.func_184134_a(player.func_226277_ct_(), player.func_226278_cu_(), player.func_226281_cx_(), SoundEvents.field_191263_gW, player.func_184176_by(), 1.0f, 1.0f, false);
            }
            event.setCanceled(true);
            player.func_70606_j(5.0f);
            player.func_195061_cb();
            player.func_195064_c(new EffectInstance(Effects.field_76428_l, 900, 1));
            player.func_195064_c(new EffectInstance(Effects.field_76444_x, 100, 1));
            player.func_195064_c(new EffectInstance(Effects.field_76426_n, 800, 0));
            int ticks = 600;
            if (event.getSource().func_76346_g() != null && !event.getSource().func_76346_g().func_184222_aU()) {
                ticks = 12000;
            }
            player.func_184811_cZ().func_185145_a((Item)this, ticks);
            if (player instanceof ServerPlayerEntity) {
                NetworkHandler.sendTo((ServerPlayerEntity)player, new PotatoChipsPack());
            }
        }
    }

    public boolean canEquip(ItemStack stack, LivingEntity entity) {
        return EquipmentHandler.findOrEmpty((Item)this, entity).func_190926_b();
    }

    @OnlyIn(value=Dist.CLIENT)
    public void doRender(BipedModel<?> bipedModel, ItemStack stack, LivingEntity player, MatrixStack ms, IRenderTypeBuffer buffers, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ms.func_227860_a_();
        bipedModel.field_78116_c.func_228307_a_(ms);
        ms.func_227861_a_(0.0, -0.3, -0.3);
        ms.func_227862_a_(0.6f, -0.6f, -0.6f);
        ItemPotatoChips.renderItem(stack, ms, buffers, light);
        ms.func_227865_b_();
    }

    public static void renderItem(ItemStack stack, MatrixStack ms, IRenderTypeBuffer buffers, int light) {
        Minecraft.func_71410_x().func_175599_af().func_229110_a_(stack, ItemCameraTransforms.TransformType.NONE, light, OverlayTexture.field_229196_a_, ms, buffers);
    }
}
