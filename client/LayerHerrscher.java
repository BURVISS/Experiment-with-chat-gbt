/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.vertex.IVertexBuilder
 *  javax.annotation.Nonnull
 *  net.minecraft.client.entity.player.AbstractClientPlayerEntity
 *  net.minecraft.client.renderer.IRenderTypeBuffer
 *  net.minecraft.client.renderer.entity.IEntityRenderer
 *  net.minecraft.client.renderer.entity.layers.LayerRenderer
 *  net.minecraft.client.renderer.entity.model.PlayerModel
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.ResourceLocation
 */
package com.meteor.extrabotany.client;

import com.meteor.extrabotany.client.model.ModelHerrscher;
import com.meteor.extrabotany.common.handler.HerrscherHandler;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import javax.annotation.Nonnull;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;

public class LayerHerrscher
extends LayerRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> {
    private ModelHerrscher layer = new ModelHerrscher();
    private ResourceLocation texture = new ResourceLocation("extrabotany", "textures/entity/herrscher.png");

    public LayerHerrscher(IEntityRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> renderer) {
        super(renderer);
    }

    public void render(@Nonnull MatrixStack ms, @Nonnull IRenderTypeBuffer buffers, int light, AbstractClientPlayerEntity player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (player != null && HerrscherHandler.isHerrscherOfThunder((PlayerEntity)player)) {
            IVertexBuilder buffer = buffers.getBuffer(this.layer.func_228282_a_(this.texture)).func_227886_a_(0xF000F0);
            ms.func_227860_a_();
            ms.func_227861_a_(0.0, (double)-0.4f, 0.0);
            ((PlayerModel)this.func_215332_c()).field_178724_i.func_228307_a_(ms);
            this.layer.renderLeftArm(ms, buffer, light, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
            ms.func_227865_b_();
            ms.func_227860_a_();
            ms.func_227861_a_(0.0, (double)-0.4f, 0.0);
            ((PlayerModel)this.func_215332_c()).field_178723_h.func_228307_a_(ms);
            this.layer.renderRightArm(ms, buffer, light, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
            ms.func_227865_b_();
            ms.func_227860_a_();
            RenderSystem.blendFunc((int)770, (int)771);
            RenderSystem.disableLighting();
            ms.func_227862_a_(1.4f, 1.4f, 1.4f);
            ms.func_227861_a_(0.0, (double)-0.2f, 0.0);
            ((PlayerModel)this.func_215332_c()).field_78115_e.func_228307_a_(ms);
            this.layer.renderStigma(ms, buffer, light, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 0.75f);
            ms.func_227862_a_(0.71428573f, 0.71428573f, 0.71428573f);
            RenderSystem.enableLighting();
            ms.func_227865_b_();
        }
    }
}
