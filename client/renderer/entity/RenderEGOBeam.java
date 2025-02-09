/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  com.mojang.blaze3d.matrix.MatrixStack$Entry
 *  com.mojang.blaze3d.vertex.IVertexBuilder
 *  javax.annotation.Nonnull
 *  net.minecraft.client.renderer.IRenderTypeBuffer
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.culling.ClippingHelper
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererManager
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.vector.Matrix3f
 *  net.minecraft.util.math.vector.Matrix4f
 *  net.minecraft.util.math.vector.Vector3f
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package com.meteor.extrabotany.client.renderer.entity;

import com.meteor.extrabotany.common.entities.ego.EntityEGOBeam;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import javax.annotation.Nonnull;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class RenderEGOBeam
extends EntityRenderer<EntityEGOBeam> {
    public static final ResourceLocation TEXTURE_BEACON_BEAM = new ResourceLocation("textures/entity/beacon_beam.png");

    public RenderEGOBeam(EntityRendererManager renderManager) {
        super(renderManager);
    }

    public void render(EntityEGOBeam e, float entityYaw, float partialTicks, MatrixStack ms, IRenderTypeBuffer buffers, int light) {
        super.func_225623_a_((Entity)e, entityYaw, partialTicks, ms, buffers, light);
        ms.func_227860_a_();
        float s = 2.0f;
        ms.func_227862_a_(s, s, s);
        RenderEGOBeam.renderBeamSegment(ms, buffers, partialTicks, e.func_130014_f_().func_82737_E(), 0, 128, e.getBeamColor());
        ms.func_227865_b_();
    }

    private static void renderBeamSegment(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, float partialTicks, long totalWorldTime, int yOffset, int height, float[] colors) {
        RenderEGOBeam.renderBeamSegment(matrixStackIn, bufferIn, TEXTURE_BEACON_BEAM, partialTicks, 1.0f, totalWorldTime, yOffset, height, colors, 0.2f, 0.25f);
    }

    public static void renderBeamSegment(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, ResourceLocation textureLocation, float partialTicks, float textureScale, long totalWorldTime, int yOffset, int height, float[] colors, float beamRadius, float glowRadius) {
        int i = yOffset + height;
        matrixStackIn.func_227860_a_();
        float f = (float)Math.floorMod(totalWorldTime, 40L) + partialTicks;
        float f1 = height < 0 ? f : -f;
        float f2 = MathHelper.func_226164_h_((float)(f1 * 0.2f - (float)MathHelper.func_76141_d((float)(f1 * 0.1f))));
        float f3 = colors[0];
        float f4 = colors[1];
        float f5 = colors[2];
        matrixStackIn.func_227860_a_();
        matrixStackIn.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(f * 2.25f - 45.0f));
        float f6 = 0.0f;
        float f8 = 0.0f;
        float f9 = -beamRadius;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = -beamRadius;
        float f13 = 0.0f;
        float f14 = 1.0f;
        float f15 = -1.0f + f2;
        float f16 = (float)height * textureScale * (0.5f / beamRadius) + f15;
        RenderEGOBeam.renderPart(matrixStackIn, bufferIn.getBuffer(RenderType.func_228637_a_((ResourceLocation)textureLocation, (boolean)false)), f3, f4, f5, 1.0f, yOffset, i, 0.0f, beamRadius, beamRadius, 0.0f, f9, 0.0f, 0.0f, f12, 0.0f, 1.0f, f16, f15);
        matrixStackIn.func_227865_b_();
        f6 = -glowRadius;
        float f7 = -glowRadius;
        f8 = -glowRadius;
        f9 = -glowRadius;
        f13 = 0.0f;
        f14 = 1.0f;
        f15 = -1.0f + f2;
        f16 = (float)height * textureScale + f15;
        RenderEGOBeam.renderPart(matrixStackIn, bufferIn.getBuffer(RenderType.func_228637_a_((ResourceLocation)textureLocation, (boolean)true)), f3, f4, f5, 0.125f, yOffset, i, f6, f7, glowRadius, f8, f9, glowRadius, glowRadius, glowRadius, 0.0f, 1.0f, f16, f15);
        matrixStackIn.func_227865_b_();
    }

    private static void renderPart(MatrixStack matrixStackIn, IVertexBuilder bufferIn, float red, float green, float blue, float alpha, int yMin, int yMax, float p_228840_8_, float p_228840_9_, float p_228840_10_, float p_228840_11_, float p_228840_12_, float p_228840_13_, float p_228840_14_, float p_228840_15_, float u1, float u2, float v1, float v2) {
        MatrixStack.Entry matrixstack$entry = matrixStackIn.func_227866_c_();
        Matrix4f matrix4f = matrixstack$entry.func_227870_a_();
        Matrix3f matrix3f = matrixstack$entry.func_227872_b_();
        RenderEGOBeam.addQuad(matrix4f, matrix3f, bufferIn, red, green, blue, alpha, yMin, yMax, p_228840_8_, p_228840_9_, p_228840_10_, p_228840_11_, u1, u2, v1, v2);
        RenderEGOBeam.addQuad(matrix4f, matrix3f, bufferIn, red, green, blue, alpha, yMin, yMax, p_228840_14_, p_228840_15_, p_228840_12_, p_228840_13_, u1, u2, v1, v2);
        RenderEGOBeam.addQuad(matrix4f, matrix3f, bufferIn, red, green, blue, alpha, yMin, yMax, p_228840_10_, p_228840_11_, p_228840_14_, p_228840_15_, u1, u2, v1, v2);
        RenderEGOBeam.addQuad(matrix4f, matrix3f, bufferIn, red, green, blue, alpha, yMin, yMax, p_228840_12_, p_228840_13_, p_228840_8_, p_228840_9_, u1, u2, v1, v2);
    }

    private static void addQuad(Matrix4f matrixPos, Matrix3f matrixNormal, IVertexBuilder bufferIn, float red, float green, float blue, float alpha, int yMin, int yMax, float x1, float z1, float x2, float z2, float u1, float u2, float v1, float v2) {
        RenderEGOBeam.addVertex(matrixPos, matrixNormal, bufferIn, red, green, blue, alpha, yMax, x1, z1, u2, v1);
        RenderEGOBeam.addVertex(matrixPos, matrixNormal, bufferIn, red, green, blue, alpha, yMin, x1, z1, u2, v2);
        RenderEGOBeam.addVertex(matrixPos, matrixNormal, bufferIn, red, green, blue, alpha, yMin, x2, z2, u1, v2);
        RenderEGOBeam.addVertex(matrixPos, matrixNormal, bufferIn, red, green, blue, alpha, yMax, x2, z2, u1, v1);
    }

    private static void addVertex(Matrix4f matrixPos, Matrix3f matrixNormal, IVertexBuilder bufferIn, float red, float green, float blue, float alpha, int y, float x, float z, float texU, float texV) {
        bufferIn.func_227888_a_(matrixPos, x, (float)y, z).func_227885_a_(red, green, blue, alpha).func_225583_a_(texU, texV).func_227891_b_(OverlayTexture.field_229196_a_).func_227886_a_(0xF000F0).func_227887_a_(matrixNormal, 0.0f, 1.0f, 0.0f).func_181675_d();
    }

    @Nonnull
    public ResourceLocation getEntityTexture(@Nonnull EntityEGOBeam entity) {
        return TEXTURE_BEACON_BEAM;
    }

    public boolean shouldRender(EntityEGOBeam entity, ClippingHelper camera, double camX, double camY, double camZ) {
        return true;
    }
}
