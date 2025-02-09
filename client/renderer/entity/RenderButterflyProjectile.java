/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.IRenderTypeBuffer
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererManager
 *  net.minecraft.client.renderer.model.IBakedModel
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package com.meteor.extrabotany.client.renderer.entity;

import com.meteor.extrabotany.client.RenderHelper;
import com.meteor.extrabotany.client.handler.MiscellaneousIcons;
import com.meteor.extrabotany.common.entities.projectile.EntityButterflyProjectile;
import com.meteor.extrabotany.common.items.ModItems;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class RenderButterflyProjectile
extends EntityRenderer<EntityButterflyProjectile> {
    public RenderButterflyProjectile(EntityRendererManager renderManager) {
        super(renderManager);
    }

    public void render(EntityButterflyProjectile entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        Minecraft mc = Minecraft.func_71410_x();
        matrixStackIn.func_227860_a_();
        matrixStackIn.func_227863_a_(mc.func_175598_ae().func_229098_b_());
        float alpha = 0.9f;
        IBakedModel model = MiscellaneousIcons.INSTANCE.butterflyprojectileModel[0];
        int color = 0xFFFFFF | (int)(alpha * 255.0f) << 24;
        RenderHelper.renderItemCustomColor((LivingEntity)mc.field_71439_g, new ItemStack((IItemProvider)ModItems.uuzfan), color, matrixStackIn, bufferIn, 0xF000F0, OverlayTexture.field_229196_a_, model);
        matrixStackIn.func_227865_b_();
        super.func_225623_a_((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public ResourceLocation getEntityTexture(EntityButterflyProjectile entity) {
        return new ResourceLocation("extrabotany", "textures/entity/proj_butterfly.png");
    }
}
