/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  com.mojang.blaze3d.vertex.IVertexBuilder
 *  net.minecraft.client.renderer.entity.model.EntityModel
 *  net.minecraft.client.renderer.model.Model
 *  net.minecraft.client.renderer.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package com.meteor.extrabotany.client.model;

import com.meteor.extrabotany.client.handler.ClientTickHandler;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelUfo
extends EntityModel {
    private final ModelRenderer body;
    private final ModelRenderer cube_r1;
    private final ModelRenderer glow;

    public ModelUfo() {
        this.field_78090_t = 256;
        this.field_78089_u = 256;
        this.body = new ModelRenderer((Model)this);
        this.body.func_78793_a(6.0f, 24.0f, -6.0f);
        this.body.func_78784_a(112, 0).func_228303_a_(-24.0f, 0.0f, -8.0f, 32.0f, 2.0f, 32.0f, 0.0f, false);
        this.body.func_78784_a(80, 38).func_228303_a_(-19.0f, -7.0f, -3.0f, 4.0f, 5.0f, 22.0f, 0.0f, false);
        this.body.func_78784_a(0, 86).func_228303_a_(-15.0f, -9.0f, 15.0f, 14.0f, 7.0f, 4.0f, 0.0f, false);
        this.body.func_78784_a(80, 65).func_228303_a_(-15.0f, -7.0f, -3.0f, 14.0f, 5.0f, 4.0f, 0.0f, false);
        this.body.func_78784_a(132, 38).func_228303_a_(-1.0f, -7.0f, -3.0f, 4.0f, 5.0f, 22.0f, 0.0f, false);
        this.body.func_78784_a(0, 62).func_228303_a_(-12.0f, -5.0f, -5.0f, 8.0f, 3.0f, 2.0f, 0.0f, false);
        this.body.func_78784_a(1, 82).func_228303_a_(-18.0f, -8.0f, 6.0f, 2.0f, 1.0f, 2.0f, 0.0f, false);
        this.body.func_78784_a(1, 83).func_228303_a_(0.0f, -8.0f, 6.0f, 2.0f, 1.0f, 2.0f, 0.0f, false);
        this.body.func_78784_a(184, 53).func_228303_a_(-13.0f, -4.0f, 3.0f, 10.0f, 2.0f, 10.0f, 0.0f, false);
        this.cube_r1 = new ModelRenderer((Model)this);
        this.cube_r1.func_78793_a(-7.0f, -8.0f, 7.0f);
        this.body.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.0f, -0.7854f, 0.0f);
        this.cube_r1.func_78784_a(0, 0).func_228303_a_(-19.0f, 6.0f, -17.0f, 36.0f, 2.0f, 36.0f, 0.0f, false);
        this.glow = new ModelRenderer((Model)this);
        this.glow.func_78793_a(6.0f, 24.0f, -6.0f);
        this.glow.func_78784_a(0, 67).func_228303_a_(-2.0f, -6.0f, -4.0f, 6.0f, 4.0f, 6.0f, 0.0f, false);
        this.glow.func_78784_a(0, 77).func_228303_a_(-1.0f, -13.0f, 5.0f, 4.0f, 5.0f, 4.0f, 0.0f, false);
        this.glow.func_78784_a(16, 77).func_228303_a_(-19.0f, -13.0f, 5.0f, 4.0f, 5.0f, 4.0f, 0.0f, false);
        this.glow.func_78784_a(24, 67).func_228303_a_(-20.0f, -6.0f, -4.0f, 6.0f, 4.0f, 6.0f, 0.0f, false);
        this.glow.func_78784_a(0, 38).func_228303_a_(-18.0f, 2.0f, -2.0f, 20.0f, 4.0f, 20.0f, 0.0f, false);
        this.glow.func_78784_a(36, 89).func_228303_a_(3.0f, 2.0f, 5.0f, 3.0f, 2.0f, 6.0f, 0.0f, false);
        this.glow.func_78784_a(54, 89).func_228303_a_(-22.0f, 2.0f, 5.0f, 3.0f, 2.0f, 6.0f, 0.0f, false);
        this.glow.func_78784_a(0, 0).func_228303_a_(-9.0f, -4.0f, -6.0f, 2.0f, 2.0f, 1.0f, 0.0f, false);
        this.glow.func_78784_a(6, 12).func_228303_a_(4.0f, -10.0f, 6.0f, 1.0f, 8.0f, 1.0f, 0.0f, false);
        this.glow.func_78784_a(4, 9).func_228303_a_(3.0f, -10.0f, 6.0f, 1.0f, 1.0f, 1.0f, 0.0f, false);
        this.glow.func_78784_a(0, 14).func_228303_a_(-20.0f, -10.0f, 6.0f, 1.0f, 1.0f, 1.0f, 0.0f, false);
        this.glow.func_78784_a(4, 12).func_228303_a_(-21.0f, -10.0f, 6.0f, 1.0f, 8.0f, 1.0f, 0.0f, false);
    }

    public void func_225597_a_(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public void func_225598_a_(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.body.func_228308_a_(matrixStack, buffer, packedLight, packedOverlay);
        int light = (int)(1.5728784E7 + 96.0 * Math.sin((float)ClientTickHandler.ticksInGame * 0.15f));
        this.glow.func_228308_a_(matrixStack, buffer, light, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
