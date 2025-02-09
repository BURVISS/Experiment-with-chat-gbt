/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  javax.annotation.Nonnull
 *  net.minecraft.client.renderer.IRenderTypeBuffer
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererManager
 *  net.minecraft.client.renderer.texture.AtlasTexture
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  vazkii.botania.client.core.handler.ClientTickHandler
 *  vazkii.botania.client.render.tile.RenderTileSpecialFlower
 */
package com.meteor.extrabotany.client.renderer.entity;

import com.meteor.extrabotany.common.entities.ego.EntityEGOLandmine;
import com.mojang.blaze3d.matrix.MatrixStack;
import javax.annotation.Nonnull;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import vazkii.botania.client.core.handler.ClientTickHandler;
import vazkii.botania.client.render.tile.RenderTileSpecialFlower;

public class RenderEGOLandmine
extends EntityRenderer<EntityEGOLandmine> {
    private static final double INITIAL_OFFSET = -0.0575;
    public static double offY = -0.0575;

    public RenderEGOLandmine(EntityRendererManager renderManager) {
        super(renderManager);
    }

    public static void onWorldRenderLast(RenderWorldLastEvent evt) {
        offY = -0.0575;
    }

    public void render(EntityEGOLandmine e, float entityYaw, float partialTicks, MatrixStack ms, IRenderTypeBuffer buffers, int light) {
        super.func_225623_a_((Entity)e, entityYaw, partialTicks, ms, buffers, light);
        ms.func_227860_a_();
        AxisAlignedBB aabb = e.func_174813_aQ().func_191194_a(e.func_213303_ch().func_186678_a(-1.0));
        float gs = (float)(Math.sin(ClientTickHandler.total / 20.0f) + 1.0) * 0.2f + 0.6f;
        int r = 0;
        int g = 0;
        int b = 0;
        switch (e.getLandmineType()) {
            case 0: {
                b = 240;
                break;
            }
            case 1: {
                g = 240;
                break;
            }
            case 2: {
                r = 240;
            }
        }
        r = (int)((float)r * gs);
        g = (int)((float)g * gs);
        b = (int)((float)b * gs);
        int color = r << 16 | g << 8 | b;
        int alpha = 32;
        if (e.field_70173_aa < 8) {
            alpha = (int)((float)alpha * Math.min(((float)e.field_70173_aa + partialTicks) / 8.0f, 1.0f));
        } else if (e.field_70173_aa > 47) {
            alpha = (int)((float)alpha * Math.min(1.0f - ((float)(e.field_70173_aa - 47) + partialTicks) / 8.0f, 1.0f));
        }
        RenderTileSpecialFlower.renderRectangle((MatrixStack)ms, (IRenderTypeBuffer)buffers, (AxisAlignedBB)aabb, (boolean)false, (Integer)color, (byte)((byte)alpha));
        offY += 0.001;
        ms.func_227865_b_();
    }

    @Nonnull
    public ResourceLocation getEntityTexture(@Nonnull EntityEGOLandmine entity) {
        return AtlasTexture.field_110575_b;
    }
}
