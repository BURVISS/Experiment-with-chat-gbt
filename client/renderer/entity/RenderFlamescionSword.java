/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.IRenderTypeBuffer
 *  net.minecraft.client.renderer.culling.ClippingHelper
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererManager
 *  net.minecraft.client.renderer.texture.AtlasTexture
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraft.util.text.TranslationTextComponent
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package com.meteor.extrabotany.client.renderer.entity;

import com.meteor.extrabotany.common.entities.EntityFlamescionSword;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class RenderFlamescionSword
extends EntityRenderer<EntityFlamescionSword> {
    public RenderFlamescionSword(EntityRendererManager renderManager) {
        super(renderManager);
    }

    public void render(EntityFlamescionSword entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        Minecraft mc = Minecraft.func_71410_x();
        matrixStackIn.func_227860_a_();
        matrixStackIn.func_227863_a_(mc.func_175598_ae().func_229098_b_());
        float f1 = 0.116666675f;
        matrixStackIn.func_227862_a_(-f1, -f1, f1);
        TranslationTextComponent text = new TranslationTextComponent("mri.sword");
        int halfWidth = mc.field_71466_p.func_78256_a(text.getString()) / 2;
        mc.field_71466_p.func_243247_a((ITextComponent)text.func_240699_a_(TextFormatting.RED), (float)(-halfWidth), 0.0f, -1, false, matrixStackIn.func_227866_c_().func_227870_a_(), bufferIn, false, 0, packedLightIn);
        matrixStackIn.func_227865_b_();
        super.func_225623_a_((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public ResourceLocation getEntityTexture(EntityFlamescionSword entity) {
        return AtlasTexture.field_110575_b;
    }

    public boolean shouldRender(EntityFlamescionSword entity, ClippingHelper camera, double camX, double camY, double camZ) {
        return true;
    }
}
