/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  net.minecraft.client.entity.player.AbstractClientPlayerEntity
 *  net.minecraft.client.renderer.IRenderTypeBuffer
 *  net.minecraft.client.renderer.entity.IEntityRenderer
 *  net.minecraft.client.renderer.entity.layers.LayerRenderer
 *  net.minecraft.client.renderer.entity.model.PlayerModel
 *  net.minecraft.client.renderer.model.IBakedModel
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.math.vector.Vector3f
 */
package com.meteor.extrabotany.client;

import com.meteor.extrabotany.client.RenderHelper;
import com.meteor.extrabotany.client.handler.ClientTickHandler;
import com.meteor.extrabotany.client.handler.MiscellaneousIcons;
import com.meteor.extrabotany.common.handler.FlamescionHandler;
import com.meteor.extrabotany.common.items.ModItems;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.vector.Vector3f;

public class LayerFlamescion
extends LayerRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> {
    public LayerFlamescion(IEntityRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> entityRendererIn) {
        super(entityRendererIn);
    }

    public void render(MatrixStack ms, IRenderTypeBuffer buffers, int packedLightIn, AbstractClientPlayerEntity player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (player != null && player.func_184614_ca().func_77973_b() == FlamescionHandler.getFlamescionWeapon()) {
            ms.func_227860_a_();
            ((PlayerModel)this.func_215332_c()).field_78115_e.func_228307_a_(ms);
            float alpha = (float)(0.75 + (double)0.15f * Math.cos((float)ClientTickHandler.ticksInGame / 20.0f));
            int color = 0xFFFFFF | (int)(alpha * 255.0f) << 24;
            IBakedModel model = MiscellaneousIcons.INSTANCE.flamescionringModel[0];
            ms.func_227861_a_((double)-0.6f, (double)-0.6f, 0.0);
            float s = 1.2f;
            ms.func_227862_a_(s, s, s);
            ms.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(-20.0f));
            ms.func_227863_a_(Vector3f.field_229183_f_.func_229187_a_(-40.0f));
            ms.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(100.0f));
            ms.func_227863_a_(Vector3f.field_229182_e_.func_229187_a_((float)ClientTickHandler.ticksInGame / 5.0f));
            int light = (int)(1.5728816E7 + 48.0 * Math.cos((float)ClientTickHandler.ticksInGame / 20.0f));
            RenderHelper.renderItemCustomColor((LivingEntity)player, new ItemStack((IItemProvider)ModItems.flamescionweapon), color, ms, buffers, light, OverlayTexture.field_229196_a_, model);
            ms.func_227862_a_(1.0f / s, 1.0f / s, 1.0f / s);
            ms.func_227865_b_();
        }
    }
}
