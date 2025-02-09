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

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKeyOfTruth
extends EntityModel {
    private final ModelRenderer bone;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer bone4;
    private final ModelRenderer bone5;

    public ModelKeyOfTruth() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.bone = new ModelRenderer((Model)this);
        this.bone.func_78793_a(0.0f, 19.0f, -1.0f);
        this.bone.func_78784_a(0, 0).func_228303_a_(-4.0f, -1.0f, 1.0f, 4.0f, 6.0f, 2.0f, 0.0f, false);
        this.bone.func_78784_a(28, 27).func_228303_a_(-5.0f, 3.0f, 1.0f, 6.0f, 1.0f, 3.0f, 0.0f, false);
        this.bone.func_78784_a(16, 13).func_228303_a_(-4.0f, 3.0f, 4.0f, 4.0f, 1.0f, 9.0f, 0.0f, false);
        this.bone.func_78784_a(28, 23).func_228303_a_(-5.0f, -2.0f, 1.0f, 6.0f, 1.0f, 3.0f, 0.0f, false);
        this.bone.func_78784_a(0, 0).func_228303_a_(-4.0f, -2.0f, 4.0f, 4.0f, 1.0f, 12.0f, 0.0f, false);
        this.bone.func_78784_a(33, 9).func_228303_a_(-3.5f, -0.5f, 3.0f, 3.0f, 3.0f, 3.0f, 0.0f, false);
        this.bone.func_78784_a(20, 0).func_228303_a_(-3.53f, -1.14f, 2.96f, 3.0f, 4.0f, 1.0f, 0.0f, false);
        this.bone.func_78784_a(0, 10).func_228303_a_(-4.0f, -1.0f, 8.0f, 4.0f, 1.0f, 1.0f, 0.0f, false);
        this.bone.func_78784_a(0, 24).func_228303_a_(-1.0f, -1.0f, 8.0f, 1.0f, 4.0f, 1.0f, 0.0f, false);
        this.bone.func_78784_a(0, 8).func_228303_a_(-4.0f, 2.0f, 8.0f, 4.0f, 1.0f, 1.0f, 0.0f, false);
        this.bone.func_78784_a(21, 13).func_228303_a_(-4.0f, -1.0f, 8.0f, 1.0f, 4.0f, 1.0f, 0.0f, false);
        this.bone.func_78784_a(0, 13).func_228303_a_(-3.5f, -2.5f, 1.0f, 3.0f, 1.0f, 10.0f, 0.0f, false);
        this.bone.func_78784_a(10, 24).func_228303_a_(-4.0f, 0.0f, -6.0f, 4.0f, 1.0f, 4.0f, 0.0f, false);
        this.bone.func_78784_a(0, 24).func_228303_a_(0.0f, 0.0f, -7.3f, 1.0f, 2.0f, 8.0f, 0.0f, false);
        this.bone.func_78784_a(18, 23).func_228303_a_(-5.0f, 0.0f, -7.3f, 1.0f, 2.0f, 8.0f, 0.0f, false);
        this.bone2 = new ModelRenderer((Model)this);
        this.bone2.func_78793_a(0.0f, 1.0f, 1.0f);
        this.bone.func_78792_a(this.bone2);
        this.setRotationAngle(this.bone2, 0.4363f, 0.0f, 0.0f);
        this.bone2.func_78784_a(32, 32).func_228303_a_(-4.04f, -2.6285f, -3.0258f, 4.0f, 6.0f, 4.0f, 0.0f, false);
        this.bone2.func_78784_a(15, 33).func_228303_a_(-3.5f, -5.7332f, -2.0606f, 3.0f, 4.0f, 3.0f, 0.0f, false);
        this.bone3 = new ModelRenderer((Model)this);
        this.bone3.func_78793_a(2.0f, 5.0f, -3.3f);
        this.bone.func_78792_a(this.bone3);
        this.setRotationAngle(this.bone3, -0.6109f, 0.0f, 0.0f);
        this.bone3.func_78784_a(20, 0).func_228303_a_(-6.0f, -2.4752f, -5.1498f, 4.0f, 1.0f, 8.0f, 0.0f, false);
        this.bone4 = new ModelRenderer((Model)this);
        this.bone4.func_78793_a(0.0f, 6.5f, -4.0f);
        this.bone.func_78792_a(this.bone4);
        this.setRotationAngle(this.bone4, -0.7854f, 0.0f, 0.0f);
        this.bone4.func_78784_a(16, 16).func_228303_a_(0.1f, -9.1213f, -1.4645f, 1.0f, 3.0f, 3.0f, 0.0f, false);
        this.bone5 = new ModelRenderer((Model)this);
        this.bone5.func_78793_a(-5.0f, 6.5f, -4.0f);
        this.bone.func_78792_a(this.bone5);
        this.setRotationAngle(this.bone5, -0.7854f, 0.0f, 0.0f);
        this.bone5.func_78784_a(0, 13).func_228303_a_(-0.1f, -9.1213f, -1.4645f, 1.0f, 3.0f, 3.0f, 0.0f, false);
    }

    public void func_225597_a_(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public void func_225598_a_(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.bone.func_228308_a_(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
