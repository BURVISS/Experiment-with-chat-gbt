/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  com.mojang.blaze3d.vertex.IVertexBuilder
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

import com.meteor.extrabotany.client.model.ModelUfo;
import com.meteor.extrabotany.common.entities.mountable.EntityUfo;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
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
public class RenderUfo
extends EntityRenderer<EntityUfo> {
    private EntityModel<EntityUfo> ufoModel = new ModelUfo();

    public RenderUfo(EntityRendererManager renderManager) {
        super(renderManager);
    }

    public void render(EntityUfo entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.func_227860_a_();
        matrixStackIn.func_227861_a_(0.0, 2.5, 0.0);
        matrixStackIn.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(180.0f - entityYaw));
        matrixStackIn.func_227863_a_(Vector3f.field_229183_f_.func_229187_a_(entityIn.getRotation()));
        matrixStackIn.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(entityIn.getPitch()));
        this.ufoModel.func_225597_a_((Entity)entityIn, partialTicks, 0.0f, -0.1f, 0.0f, 0.0f);
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.ufoModel.func_228282_a_(this.getEntityTexture(entityIn)));
        matrixStackIn.func_227862_a_(-1.0f, -1.0f, 1.0f);
        float s = 1.35f;
        matrixStackIn.func_227862_a_(s, s, s);
        this.ufoModel.func_225598_a_(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
        matrixStackIn.func_227862_a_(1.0f / s, 1.0f / s, 1.0f / s);
        matrixStackIn.func_227865_b_();
        super.func_225623_a_((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public ResourceLocation getEntityTexture(EntityUfo entity) {
        return new ResourceLocation("extrabotany", "textures/entity/ufo.png");
    }
}
