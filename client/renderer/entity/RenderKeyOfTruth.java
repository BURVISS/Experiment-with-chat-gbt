/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  com.mojang.blaze3d.matrix.MatrixStack$Entry
 *  com.mojang.blaze3d.vertex.IVertexBuilder
 *  net.minecraft.client.renderer.IRenderTypeBuffer
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererManager
 *  net.minecraft.client.renderer.entity.model.EntityModel
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.vector.Matrix3f
 *  net.minecraft.util.math.vector.Matrix4f
 *  net.minecraft.util.math.vector.Vector3d
 *  net.minecraft.util.math.vector.Vector3f
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package com.meteor.extrabotany.client.renderer.entity;

import com.meteor.extrabotany.client.model.ModelKeyOfTruth;
import com.meteor.extrabotany.common.entities.EntityKeyOfTruth;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class RenderKeyOfTruth
extends EntityRenderer<EntityKeyOfTruth> {
    private EntityModel<EntityKeyOfTruth> motorModel = new ModelKeyOfTruth();
    private static final ResourceLocation GUARDIAN_BEAM_TEXTURE = new ResourceLocation("extrabotany", "textures/entity/energybeam.png");
    private static final RenderType field_229107_h_ = RenderType.func_228640_c_((ResourceLocation)GUARDIAN_BEAM_TEXTURE);

    public RenderKeyOfTruth(EntityRendererManager renderManager) {
        super(renderManager);
    }

    public ResourceLocation getEntityTexture(EntityKeyOfTruth entity) {
        return new ResourceLocation("extrabotany", "textures/entity/keyoftruth.png");
    }

    public void render(EntityKeyOfTruth entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        Entity livingentity;
        matrixStackIn.func_227860_a_();
        matrixStackIn.func_227861_a_(0.0, 1.375, 0.0);
        matrixStackIn.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(entityIn.getRotation()));
        matrixStackIn.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(entityIn.getPitch()));
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.motorModel.func_228282_a_(this.getEntityTexture(entityIn)));
        matrixStackIn.func_227862_a_(1.0f, -1.0f, -1.0f);
        this.motorModel.func_225598_a_(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 0.65f);
        matrixStackIn.func_227862_a_(1.0f, -1.0f, -1.0f);
        matrixStackIn.func_227865_b_();
        if (entityIn.getTarget() != -1 && entityIn.getShoot() && (livingentity = entityIn.field_70170_p.func_73045_a(entityIn.getTarget())) != null && livingentity.func_203003_aK()) {
            float f = 0.5f;
            float f1 = (float)entityIn.field_70170_p.func_82737_E() + partialTicks;
            float f2 = f1 * 0.5f % 1.0f;
            float f3 = entityIn.func_70047_e();
            matrixStackIn.func_227860_a_();
            matrixStackIn.func_227861_a_(0.0, (double)f3, 0.0);
            Vector3d vec3d = this.getPosition(livingentity, (double)livingentity.func_213302_cg() * 0.5, partialTicks);
            Vector3d vec3d1 = this.getPosition(entityIn, f3, partialTicks);
            Vector3d vec3d2 = vec3d.func_178788_d(vec3d1);
            float f4 = (float)(vec3d2.func_72433_c() + 1.0);
            vec3d2 = vec3d2.func_72432_b();
            float f5 = (float)Math.acos(vec3d2.field_72448_b);
            float f6 = (float)Math.atan2(vec3d2.field_72449_c, vec3d2.field_72450_a);
            matrixStackIn.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_((1.5707964f - f6) * 57.295776f));
            matrixStackIn.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(f5 * 57.295776f));
            boolean i = true;
            float f7 = f1 * 0.05f * -1.5f;
            float f8 = f * f;
            int j = 10;
            int k = 229;
            int l = 238;
            float f9 = 0.2f;
            float f10 = 0.282f;
            float f11 = MathHelper.func_76134_b((float)(f7 + 2.3561945f)) * 0.282f;
            float f12 = MathHelper.func_76126_a((float)(f7 + 2.3561945f)) * 0.282f;
            float f13 = MathHelper.func_76134_b((float)(f7 + 0.7853982f)) * 0.282f;
            float f14 = MathHelper.func_76126_a((float)(f7 + 0.7853982f)) * 0.282f;
            float f15 = MathHelper.func_76134_b((float)(f7 + 3.926991f)) * 0.282f;
            float f16 = MathHelper.func_76126_a((float)(f7 + 3.926991f)) * 0.282f;
            float f17 = MathHelper.func_76134_b((float)(f7 + 5.4977875f)) * 0.282f;
            float f18 = MathHelper.func_76126_a((float)(f7 + 5.4977875f)) * 0.282f;
            float f19 = MathHelper.func_76134_b((float)(f7 + (float)Math.PI)) * 0.2f;
            float f20 = MathHelper.func_76126_a((float)(f7 + (float)Math.PI)) * 0.2f;
            float f21 = MathHelper.func_76134_b((float)(f7 + 0.0f)) * 0.2f;
            float f22 = MathHelper.func_76126_a((float)(f7 + 0.0f)) * 0.2f;
            float f23 = MathHelper.func_76134_b((float)(f7 + 1.5707964f)) * 0.2f;
            float f24 = MathHelper.func_76126_a((float)(f7 + 1.5707964f)) * 0.2f;
            float f25 = MathHelper.func_76134_b((float)(f7 + 4.712389f)) * 0.2f;
            float f26 = MathHelper.func_76126_a((float)(f7 + 4.712389f)) * 0.2f;
            float f27 = 0.0f;
            float f28 = 0.4999f;
            float f29 = -1.0f + f2;
            float f30 = f4 * 2.5f + f29;
            IVertexBuilder ivertexbuilder2 = bufferIn.getBuffer(field_229107_h_);
            MatrixStack.Entry matrixstack$entry = matrixStackIn.func_227866_c_();
            Matrix4f matrix4f = matrixstack$entry.func_227870_a_();
            Matrix3f matrix3f = matrixstack$entry.func_227872_b_();
            RenderKeyOfTruth.func_229108_a_(ivertexbuilder2, matrix4f, matrix3f, f19, f4, f20, j, k, l, 0.4999f, f30);
            RenderKeyOfTruth.func_229108_a_(ivertexbuilder2, matrix4f, matrix3f, f19, 0.0f, f20, j, k, l, 0.4999f, f29);
            RenderKeyOfTruth.func_229108_a_(ivertexbuilder2, matrix4f, matrix3f, f21, 0.0f, f22, j, k, l, 0.0f, f29);
            RenderKeyOfTruth.func_229108_a_(ivertexbuilder2, matrix4f, matrix3f, f21, f4, f22, j, k, l, 0.0f, f30);
            RenderKeyOfTruth.func_229108_a_(ivertexbuilder2, matrix4f, matrix3f, f23, f4, f24, j, k, l, 0.4999f, f30);
            RenderKeyOfTruth.func_229108_a_(ivertexbuilder2, matrix4f, matrix3f, f23, 0.0f, f24, j, k, l, 0.4999f, f29);
            RenderKeyOfTruth.func_229108_a_(ivertexbuilder2, matrix4f, matrix3f, f25, 0.0f, f26, j, k, l, 0.0f, f29);
            RenderKeyOfTruth.func_229108_a_(ivertexbuilder2, matrix4f, matrix3f, f25, f4, f26, j, k, l, 0.0f, f30);
            float f31 = 0.0f;
            RenderKeyOfTruth.func_229108_a_(ivertexbuilder2, matrix4f, matrix3f, f11, f4, f12, j, k, l, 0.5f, f31 + 0.5f);
            RenderKeyOfTruth.func_229108_a_(ivertexbuilder2, matrix4f, matrix3f, f13, f4, f14, j, k, l, 1.0f, f31 + 0.5f);
            RenderKeyOfTruth.func_229108_a_(ivertexbuilder2, matrix4f, matrix3f, f17, f4, f18, j, k, l, 1.0f, f31);
            RenderKeyOfTruth.func_229108_a_(ivertexbuilder2, matrix4f, matrix3f, f15, f4, f16, j, k, l, 0.5f, f31);
            matrixStackIn.func_227865_b_();
        }
        super.func_225623_a_((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    private Vector3d getPosition(Entity entityLivingBaseIn, double p_177110_2_, float p_177110_4_) {
        double d0 = MathHelper.func_219803_d((double)p_177110_4_, (double)entityLivingBaseIn.field_70142_S, (double)entityLivingBaseIn.func_226277_ct_());
        double d1 = MathHelper.func_219803_d((double)p_177110_4_, (double)entityLivingBaseIn.field_70137_T, (double)entityLivingBaseIn.func_226278_cu_()) + p_177110_2_;
        double d2 = MathHelper.func_219803_d((double)p_177110_4_, (double)entityLivingBaseIn.field_70136_U, (double)entityLivingBaseIn.func_226281_cx_());
        return new Vector3d(d0, d1, d2);
    }

    private static void func_229108_a_(IVertexBuilder p_229108_0_, Matrix4f p_229108_1_, Matrix3f p_229108_2_, float p_229108_3_, float p_229108_4_, float p_229108_5_, int p_229108_6_, int p_229108_7_, int p_229108_8_, float p_229108_9_, float p_229108_10_) {
        p_229108_0_.func_227888_a_(p_229108_1_, p_229108_3_, p_229108_4_, p_229108_5_).func_225586_a_(p_229108_6_, p_229108_7_, p_229108_8_, 255).func_225583_a_(p_229108_9_, p_229108_10_).func_227891_b_(OverlayTexture.field_229196_a_).func_227886_a_(0xF000F0).func_227887_a_(p_229108_2_, 0.0f, 1.0f, 0.0f).func_181675_d();
    }
}
