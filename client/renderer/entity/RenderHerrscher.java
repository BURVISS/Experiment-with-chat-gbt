/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  javax.annotation.Nonnull
 *  net.minecraft.client.renderer.IRenderTypeBuffer
 *  net.minecraft.client.renderer.entity.BipedRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererManager
 *  net.minecraft.client.renderer.entity.model.BipedModel
 *  net.minecraft.client.renderer.entity.model.PlayerModel
 *  net.minecraft.entity.MobEntity
 *  net.minecraft.util.ResourceLocation
 */
package com.meteor.extrabotany.client.renderer.entity;

import com.meteor.extrabotany.client.renderer.entity.layers.HeldFakeItemLayer;
import com.meteor.extrabotany.client.renderer.entity.layers.HerrscherLayer;
import com.mojang.blaze3d.matrix.MatrixStack;
import javax.annotation.Nonnull;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;

public class RenderHerrscher
extends BipedRenderer<MobEntity, BipedModel<MobEntity>> {
    public RenderHerrscher(EntityRendererManager renderManager) {
        super(renderManager, (BipedModel)new PlayerModel(0.0f, false), 0.0f);
        this.func_177094_a(new HeldFakeItemLayer(this));
        this.func_177094_a(new HerrscherLayer(this));
    }

    public void func_225623_a_(@Nonnull MobEntity mob, float yaw, float partialTicks, MatrixStack ms, IRenderTypeBuffer buffers, int light) {
        super.func_225623_a_(mob, yaw, partialTicks, ms, buffers, light);
    }

    @Nonnull
    public ResourceLocation func_110775_a(@Nonnull MobEntity entity) {
        return new ResourceLocation("extrabotany", "textures/entity/voidherrscher.png");
    }
}
