/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.player.ClientPlayerEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraftforge.client.event.RenderGameOverlayEvent
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 */
package com.meteor.extrabotany.client.handler;

import com.meteor.extrabotany.client.handler.FlamescionGUI;
import com.meteor.extrabotany.client.handler.HerrscherGUI;
import com.meteor.extrabotany.client.handler.MotorGUI;
import com.meteor.extrabotany.common.entities.mountable.EntityMotor;
import com.meteor.extrabotany.common.handler.FlamescionHandler;
import com.meteor.extrabotany.common.handler.HerrscherHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class HUDHandler {
    public static void onOverlayRender(RenderGameOverlayEvent event) {
        Entity riding;
        int offset = 0;
        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        ClientPlayerEntity player = Minecraft.func_71410_x().field_71439_g;
        if (player == null) {
            return;
        }
        if (HerrscherHandler.isHerrscherOfThunder((PlayerEntity)player)) {
            HerrscherGUI gui = new HerrscherGUI(event.getMatrixStack(), offset);
            gui.render();
            offset += 7;
        }
        if ((riding = player.func_184187_bx()) != null && riding instanceof EntityMotor) {
            MotorGUI motorGui = new MotorGUI(event.getMatrixStack(), offset);
            motorGui.render();
            offset += 7;
        }
        if (riding == null && player.func_184614_ca() != null && player.func_184614_ca().func_77973_b() == FlamescionHandler.getFlamescionWeapon()) {
            FlamescionGUI flamescionGUI = new FlamescionGUI(event.getMatrixStack(), offset);
            flamescionGUI.render();
            offset += 7;
        }
    }
}
