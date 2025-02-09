/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.IRenderTypeBuffer
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererManager
 *  net.minecraft.client.renderer.texture.AtlasTexture
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package com.meteor.extrabotany.client.renderer.entity;

import com.meteor.extrabotany.common.entities.EntityJudahOath;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class RenderJudahOath
extends EntityRenderer<EntityJudahOath> {
    protected RenderJudahOath(EntityRendererManager renderManager) {
        super(renderManager);
    }

    public void render(EntityJudahOath weapon, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        Minecraft mc = Minecraft.func_71410_x();
    }

    public ResourceLocation getEntityTexture(EntityJudahOath entity) {
        return AtlasTexture.field_110575_b;
    }
}
