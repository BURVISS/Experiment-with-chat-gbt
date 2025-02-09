/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.IRenderTypeBuffer
 *  net.minecraft.client.renderer.model.ItemCameraTransforms$TransformType
 *  net.minecraft.client.renderer.tileentity.TileEntityRenderer
 *  net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.vector.Vector3f
 */
package com.meteor.extrabotany.client.renderer.tile;

import com.meteor.extrabotany.client.handler.ClientTickHandler;
import com.meteor.extrabotany.common.blocks.tile.TilePowerFrame;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3f;

public class RenderPowerFrame
extends TileEntityRenderer<TilePowerFrame> {
    public RenderPowerFrame(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    public void render(TilePowerFrame tile, float partialTicks, MatrixStack ms, IRenderTypeBuffer buffers, int light, int overlay) {
        boolean hasItem;
        ms.func_227860_a_();
        ms.func_227861_a_(0.5, 0.5, 0.5);
        boolean bl = hasItem = !tile.getItemHandler().func_191420_l();
        if (hasItem) {
            ms.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_((float)ClientTickHandler.ticksInGame * 0.5f));
            ItemStack stack = tile.getItemHandler().func_70301_a(0);
            Minecraft.func_71410_x().func_175599_af().func_229110_a_(stack, ItemCameraTransforms.TransformType.GROUND, light, overlay, ms, buffers);
        }
        ms.func_227865_b_();
    }
}
