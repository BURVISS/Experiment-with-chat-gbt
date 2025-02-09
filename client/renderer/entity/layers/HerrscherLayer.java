/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  net.minecraft.client.renderer.IRenderTypeBuffer
 *  net.minecraft.client.renderer.entity.IEntityRenderer
 *  net.minecraft.client.renderer.entity.layers.LayerRenderer
 *  net.minecraft.client.renderer.entity.model.BipedModel
 *  net.minecraft.client.renderer.model.IBakedModel
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IItemProvider
 */
package com.meteor.extrabotany.client.renderer.entity.layers;

import com.meteor.extrabotany.client.handler.MiscellaneousIcons;
import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.items.bauble.ItemCoreGod;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;

public class HerrscherLayer<T extends LivingEntity, M extends BipedModel<T>>
extends LayerRenderer<T, M> {
    public HerrscherLayer(IEntityRenderer<T, M> entityRendererIn) {
        super(entityRendererIn);
    }

    public void render(MatrixStack ms, IRenderTypeBuffer buffers, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ms.func_227860_a_();
        IBakedModel model = MiscellaneousIcons.INSTANCE.coregodWingsModel[0];
        float flap = 12.0f + (float)((Math.sin((double)(ageInTicks + partialTicks) * (double)0.12f) + (double)0.4f) * 5.0);
        ItemCoreGod.renderHerrscher((BipedModel)this.func_215332_c(), model, new ItemStack((IItemProvider)ModItems.coregod), ms, buffers, flap);
        ms.func_227865_b_();
    }
}
