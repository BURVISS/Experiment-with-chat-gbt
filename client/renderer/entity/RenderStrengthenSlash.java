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
 *  net.minecraft.client.renderer.texture.AtlasTexture
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.vector.Vector3f
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package com.meteor.extrabotany.client.renderer.entity;

import com.meteor.extrabotany.client.RenderHelper;
import com.meteor.extrabotany.client.handler.MiscellaneousIcons;
import com.meteor.extrabotany.common.entities.EntityStrengthenSlash;
import com.meteor.extrabotany.common.items.ModItems;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class RenderStrengthenSlash
extends EntityRenderer<EntityStrengthenSlash> {
    public RenderStrengthenSlash(EntityRendererManager renderManager) {
        super(renderManager);
    }

    public ResourceLocation getEntityTexture(EntityStrengthenSlash entity) {
        return AtlasTexture.field_110575_b;
    }

    public void render(EntityStrengthenSlash weapon, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        Minecraft mc = Minecraft.func_71410_x();
        matrixStackIn.func_227860_a_();
        matrixStackIn.func_227860_a_();
        float s = 3.5f;
        matrixStackIn.func_227862_a_(s, s, s);
        matrixStackIn.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(weapon.getRotation() + 90.0f));
        matrixStackIn.func_227863_a_(Vector3f.field_229183_f_.func_229187_a_(weapon.getPitch()));
        matrixStackIn.func_227863_a_(Vector3f.field_229183_f_.func_229187_a_(30.0f));
        float alpha = 0.8f;
        IBakedModel model = MiscellaneousIcons.INSTANCE.strengthenSlashModel[0];
        int color = 0xFFFFFF | (int)(alpha * 255.0f) << 24;
        RenderHelper.renderItemCustomColor((LivingEntity)mc.field_71439_g, new ItemStack((IItemProvider)ModItems.firstfractal), color, matrixStackIn, bufferIn, 0xF000F0, OverlayTexture.field_229196_a_, model);
        matrixStackIn.func_227862_a_(1.0f / s, 1.0f / s, 1.0f / s);
        matrixStackIn.func_227865_b_();
        matrixStackIn.func_227865_b_();
        super.func_225623_a_((Entity)weapon, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
}
