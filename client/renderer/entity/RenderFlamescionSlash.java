/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  com.mojang.blaze3d.vertex.IVertexBuilder
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.IRenderTypeBuffer
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererManager
 *  net.minecraft.client.renderer.entity.model.EntityModel
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.vector.Vector3f
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package com.meteor.extrabotany.client.renderer.entity;

import com.meteor.extrabotany.client.model.ModelSlash;
import com.meteor.extrabotany.common.entities.EntityFlamescionSlash;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class RenderFlamescionSlash
extends EntityRenderer<EntityFlamescionSlash> {
    private EntityModel<Entity> slashModel = new ModelSlash();
    private int frames = 6;

    public RenderFlamescionSlash(EntityRendererManager renderManager) {
        super(renderManager);
    }

    public void render(EntityFlamescionSlash entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        Minecraft mc = Minecraft.func_71410_x();
        matrixStackIn.func_227860_a_();
        matrixStackIn.func_227863_a_(mc.func_175598_ae().func_229098_b_());
        IVertexBuilder buffer = bufferIn.getBuffer(this.slashModel.func_228282_a_(this.getEntityTexture(entityIn))).func_227886_a_(0xF000F0);
        float s = 3.0f;
        matrixStackIn.func_227862_a_(s, s, s);
        matrixStackIn.func_227862_a_(1.0f, -1.0f, -1.0f);
        matrixStackIn.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(entityIn.getPitch()));
        matrixStackIn.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(entityIn.getRotation()));
        this.slashModel.func_225598_a_(matrixStackIn, buffer, 0xF000F0, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
        matrixStackIn.func_227862_a_(1.0f, -1.0f, -1.0f);
        matrixStackIn.func_227862_a_(1.0f / s, 1.0f / s, 1.0f / s);
        matrixStackIn.func_227865_b_();
        super.func_225623_a_((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public ResourceLocation getEntityTexture(EntityFlamescionSlash entity) {
        return new ResourceLocation("extrabotany", "textures/entity/flamescionslash_" + entity.field_70173_aa % this.frames + ".png");
    }
}
