/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  com.mojang.blaze3d.matrix.MatrixStack$Entry
 *  com.mojang.blaze3d.vertex.IVertexBuilder
 *  javax.annotation.Nullable
 *  net.minecraft.block.BlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.IRenderTypeBuffer
 *  net.minecraft.client.renderer.ItemRenderer
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.RenderTypeLookup
 *  net.minecraft.client.renderer.model.BakedQuad
 *  net.minecraft.client.renderer.model.IBakedModel
 *  net.minecraft.client.renderer.model.ItemCameraTransforms$TransformType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.util.Direction
 *  net.minecraftforge.client.ForgeHooksClient
 */
package com.meteor.extrabotany.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Direction;
import net.minecraftforge.client.ForgeHooksClient;

public class RenderHelper {
    public static void renderItemCustomColor(LivingEntity entity, ItemStack stack, int color, MatrixStack ms, IRenderTypeBuffer buffers, int light, int overlay, @Nullable IBakedModel model) {
        ms.func_227860_a_();
        if (model == null) {
            model = Minecraft.func_71410_x().func_175599_af().func_184393_a(stack, entity.field_70170_p, entity);
        }
        model = ForgeHooksClient.handleCameraTransforms((MatrixStack)ms, (IBakedModel)model, (ItemCameraTransforms.TransformType)ItemCameraTransforms.TransformType.NONE, (boolean)false);
        ms.func_227861_a_(-0.5, -0.5, -0.5);
        if (!model.func_188618_c() && stack.func_77973_b() != Items.field_203184_eO) {
            RenderType rendertype = RenderTypeLookup.func_239219_a_((ItemStack)stack, (boolean)true);
            IVertexBuilder ivertexbuilder = ItemRenderer.func_239391_c_((IRenderTypeBuffer)buffers, (RenderType)rendertype, (boolean)true, (boolean)stack.func_77962_s());
            RenderHelper.renderBakedItemModel(model, stack, color, light, overlay, ms, ivertexbuilder);
        } else {
            stack.func_77973_b().getItemStackTileEntityRenderer().func_239207_a_(stack, ItemCameraTransforms.TransformType.NONE, ms, buffers, light, overlay);
        }
        ms.func_227865_b_();
    }

    public static void renderItemCustomColor(LivingEntity entity, ItemStack stack, int color, MatrixStack ms, IRenderTypeBuffer buffers, int light, int overlay) {
        RenderHelper.renderItemCustomColor(entity, stack, color, ms, buffers, light, overlay, null);
    }

    private static void renderBakedItemModel(IBakedModel model, ItemStack stack, int color, int light, int overlay, MatrixStack ms, IVertexBuilder buffer) {
        Random random = new Random();
        long i = 42L;
        for (Direction direction : Direction.values()) {
            random.setSeed(42L);
            RenderHelper.renderBakedItemQuads(ms, buffer, color, model.func_200117_a((BlockState)null, direction, random), stack, light, overlay);
        }
        random.setSeed(42L);
        RenderHelper.renderBakedItemQuads(ms, buffer, color, model.func_200117_a((BlockState)null, (Direction)null, random), stack, light, overlay);
    }

    private static void renderBakedItemQuads(MatrixStack ms, IVertexBuilder buffer, int color, List<BakedQuad> quads, ItemStack stack, int light, int overlay) {
        MatrixStack.Entry matrixstack$entry = ms.func_227866_c_();
        for (BakedQuad bakedquad : quads) {
            int i = color;
            float f = (float)(i >> 16 & 0xFF) / 255.0f;
            float f1 = (float)(i >> 8 & 0xFF) / 255.0f;
            float f2 = (float)(i & 0xFF) / 255.0f;
            float alpha = (float)(color >> 24 & 0xFF) / 255.0f;
            buffer.addVertexData(matrixstack$entry, bakedquad, f, f1, f2, alpha, light, overlay, true);
        }
    }
}
