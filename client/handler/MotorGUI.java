/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.player.ClientPlayerEntity
 *  net.minecraft.client.gui.AbstractGui
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 */
package com.meteor.extrabotany.client.handler;

import com.meteor.extrabotany.common.entities.mountable.EntityMotor;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class MotorGUI
extends AbstractGui {
    private final int width;
    private final int height;
    private final Minecraft minecraft;
    private final ResourceLocation HUD = new ResourceLocation("extrabotany", "textures/gui/motorhud.png");
    private MatrixStack ms;
    private int offset;

    public MotorGUI(MatrixStack ms, int offset) {
        this.offset = offset;
        this.ms = ms;
        this.width = Minecraft.func_71410_x().func_228018_at_().func_198107_o();
        this.height = Minecraft.func_71410_x().func_228018_at_().func_198087_p();
        this.minecraft = Minecraft.func_71410_x();
    }

    public void render() {
        RenderSystem.color4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.minecraft.func_110434_K().func_110577_a(this.HUD);
        ClientPlayerEntity player = this.minecraft.field_71439_g;
        Entity riding = player.func_184187_bx();
        if (riding != null && riding instanceof EntityMotor) {
            EntityMotor motor = (EntityMotor)riding;
            this.renderBar(motor.getTectonicEnergy());
        }
    }

    private void renderBar(int energy) {
        Minecraft mc = Minecraft.func_71410_x();
        int width = 64;
        int x = mc.func_228018_at_().func_198107_o() / 2 - width / 2;
        int y = mc.func_228018_at_().func_198087_p() - 56 - this.offset;
        width = (int)((double)width * ((double)energy / 800.0));
        mc.field_71446_o.func_110577_a(this.HUD);
        RenderSystem.enableBlend();
        RenderSystem.blendFunc((int)770, (int)771);
        this.func_238474_b_(this.ms, x, y, 0, 0, 64, 6);
        this.func_238474_b_(this.ms, x, y, 0, 6, width, 6);
        RenderSystem.disableBlend();
        RenderSystem.color4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }
}
