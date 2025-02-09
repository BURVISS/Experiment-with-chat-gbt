/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.AbstractGui
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.common.util.LazyOptional
 */
package com.meteor.extrabotany.client.handler;

import com.meteor.extrabotany.common.capability.CapabilityHandler;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.LazyOptional;

public class HerrscherGUI
extends AbstractGui {
    private final int width;
    private final int height;
    private final Minecraft minecraft;
    private final ResourceLocation HUD = new ResourceLocation("extrabotany", "textures/gui/hud.png");
    private MatrixStack ms;
    private int offset;

    public HerrscherGUI(MatrixStack ms, int offset) {
        this.offset = offset;
        this.ms = ms;
        this.width = Minecraft.func_71410_x().func_228018_at_().func_198107_o();
        this.height = Minecraft.func_71410_x().func_228018_at_().func_198087_p();
        this.minecraft = Minecraft.func_71410_x();
    }

    public void render() {
        RenderSystem.color4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.minecraft.func_110434_K().func_110577_a(this.HUD);
        LazyOptional cap = this.minecraft.field_71439_g.getCapability(CapabilityHandler.HERRSCHERENERGY_CAPABILITY);
        cap.ifPresent(c -> {
            int energy = c.getEnergy();
            this.renderBar(energy);
        });
    }

    private void renderBar(int energy) {
        Minecraft mc = Minecraft.func_71410_x();
        int width = 64;
        int x = mc.func_228018_at_().func_198107_o() / 2 - width / 2;
        int y = mc.func_228018_at_().func_198087_p() - 56 - this.offset;
        width = (int)((double)width * ((double)energy / 600.0));
        mc.field_71446_o.func_110577_a(this.HUD);
        RenderSystem.enableBlend();
        RenderSystem.blendFunc((int)770, (int)771);
        this.func_238474_b_(this.ms, x, y, 0, 0, 64, 6);
        if (energy < 600) {
            this.func_238474_b_(this.ms, x, y, 0, 6, width, 6);
        } else {
            this.func_238474_b_(this.ms, x, y, 0, 11, 64, 6);
        }
        RenderSystem.disableBlend();
        RenderSystem.color4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }
}
