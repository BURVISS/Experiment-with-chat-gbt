/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  com.mojang.blaze3d.vertex.IVertexBuilder
 *  net.minecraft.client.renderer.model.Model
 *  net.minecraft.client.renderer.model.ModelRenderer
 *  net.minecraft.inventory.EquipmentSlotType
 */
package com.meteor.extrabotany.client.model;

import com.meteor.extrabotany.client.model.ModelArmor;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.inventory.EquipmentSlotType;

public class ModelHerrscher
extends ModelArmor {
    private final ModelRenderer rightArm;
    private final ModelRenderer bone2;
    private final ModelRenderer katanaSheath;
    private final ModelRenderer bone4;
    private final ModelRenderer bone3;
    private final ModelRenderer leftArm;
    private final ModelRenderer bone5;
    private final ModelRenderer bone6;
    private final ModelRenderer katana;
    private final ModelRenderer bone7;
    private final ModelRenderer back;

    public ModelHerrscher() {
        super(EquipmentSlotType.CHEST);
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.rightArm = new ModelRenderer((Model)this);
        this.rightArm.func_78793_a(5.75f, 1.0f, 2.75f);
        this.setRotationAngle(this.rightArm, -0.4363f, 0.0f, -0.3491f);
        this.rightArm.func_78784_a(0, 13).func_228303_a_(0.6859f, 1.3201f, -2.6295f, 3.0f, 9.0f, 5.0f, 0.0f, false);
        this.rightArm.func_78784_a(11, 0).func_228303_a_(0.6859f, 2.3201f, -3.6295f, 2.0f, 7.0f, 1.0f, 0.0f, false);
        this.rightArm.func_78784_a(0, 0).func_228303_a_(0.6859f, 2.3201f, 2.3705f, 2.0f, 7.0f, 1.0f, 0.0f, false);
        this.rightArm.func_78784_a(0, 0).func_228303_a_(1.1859f, 3.3201f, -4.6295f, 1.0f, 4.0f, 9.0f, 0.0f, false);
        this.rightArm.func_78784_a(12, 5).func_228303_a_(2.1859f, 3.3201f, -4.1295f, 1.0f, 2.0f, 8.0f, 0.0f, false);
        this.rightArm.func_78784_a(17, 0).func_228303_a_(3.1859f, 1.3201f, -1.6295f, 1.0f, 2.0f, 3.0f, 0.0f, false);
        this.rightArm.func_78784_a(22, 0).func_228303_a_(3.1859f, 3.3201f, -0.6295f, 1.0f, 1.0f, 1.0f, 0.0f, false);
        this.rightArm.func_78784_a(16, 16).func_228303_a_(0.1859f, 10.3201f, -1.1295f, 3.0f, 3.0f, 3.0f, 0.0f, false);
        this.rightArm.func_78784_a(11, 15).func_228303_a_(0.1859f, 10.3201f, -2.1295f, 3.0f, 2.0f, 1.0f, 0.0f, false);
        this.rightArm.func_78784_a(16, 7).func_228303_a_(1.1859f, 4.3201f, 4.3705f, 1.0f, 1.0f, 1.0f, 0.0f, false);
        this.rightArm.func_78784_a(5, 7).func_228303_a_(1.1859f, 4.3201f, -5.6295f, 1.0f, 1.0f, 1.0f, 0.0f, false);
        this.bone2 = new ModelRenderer((Model)this);
        this.bone2.func_78793_a(3.6859f, 1.3201f, -0.1295f);
        this.rightArm.func_78792_a(this.bone2);
        this.setRotationAngle(this.bone2, 0.0f, 0.0f, 0.7854f);
        this.bone2.func_78784_a(0, 13).func_228303_a_(-0.2835f, -2.991f, -0.5f, 1.0f, 4.0f, 1.0f, 0.0f, false);
        this.katanaSheath = new ModelRenderer((Model)this);
        this.katanaSheath.func_78793_a(1.2474f, 13.2096f, 0.6816f);
        this.rightArm.func_78792_a(this.katanaSheath);
        this.setRotationAngle(this.katanaSheath, -0.0873f, 0.0f, -0.0873f);
        this.katanaSheath.func_78784_a(31, 49).func_228303_a_(-0.1555f, -2.0137f, -1.1343f, 1.0f, 2.0f, 13.0f, 0.0f, false);
        this.bone4 = new ModelRenderer((Model)this);
        this.bone4.func_78793_a(0.0f, 0.0f, 13.0f);
        this.katanaSheath.func_78792_a(this.bone4);
        this.setRotationAngle(this.bone4, 0.1745f, 0.0f, 0.0f);
        this.bone4.func_78784_a(46, 52).func_228303_a_(-0.1555f, -2.2105f, -1.1147f, 1.0f, 2.0f, 8.0f, 0.0f, false);
        this.bone3 = new ModelRenderer((Model)this);
        this.bone3.func_78793_a(2.1859f, 0.5701f, 0.3705f);
        this.rightArm.func_78792_a(this.bone3);
        this.setRotationAngle(this.bone3, 0.0f, 0.0f, -0.2618f);
        this.bone3.func_78784_a(16, 22).func_228303_a_(-2.0f, -2.0f, -2.0f, 2.0f, 3.0f, 3.0f, 0.0f, false);
        this.bone3.func_78784_a(22, 2).func_228303_a_(0.0f, -1.0f, -2.0f, 1.0f, 2.0f, 3.0f, 0.0f, false);
        this.leftArm = new ModelRenderer((Model)this);
        this.leftArm.func_78793_a(-8.0f, 3.0f, 2.5f);
        this.setRotationAngle(this.leftArm, -0.4363f, 0.0f, 0.3491f);
        this.leftArm.func_78784_a(30, 0).func_228303_a_(-1.0f, -1.0f, -3.0f, 3.0f, 10.0f, 4.0f, 0.0f, false);
        this.leftArm.func_78784_a(44, 0).func_228303_a_(-2.0f, 1.0f, -2.0f, 1.0f, 4.0f, 2.0f, 0.0f, false);
        this.leftArm.func_78784_a(30, 20).func_228303_a_(-1.0f, -3.0f, -3.0f, 3.0f, 2.0f, 1.0f, 0.0f, false);
        this.leftArm.func_78784_a(30, 23).func_228303_a_(-1.0f, -3.0f, 0.0f, 3.0f, 2.0f, 1.0f, 0.0f, false);
        this.leftArm.func_78784_a(44, 6).func_228303_a_(-1.0f, -4.0f, -2.0f, 3.0f, 1.0f, 2.0f, 0.0f, false);
        this.leftArm.func_78784_a(54, 0).func_228303_a_(-0.6381f, -0.7174f, -4.039f, 2.0f, 5.0f, 1.0f, 0.0f, false);
        this.leftArm.func_78784_a(54, 6).func_228303_a_(-0.4238f, -0.7607f, 0.9059f, 2.0f, 5.0f, 1.0f, 0.0f, false);
        this.bone5 = new ModelRenderer((Model)this);
        this.bone5.func_78793_a(0.0f, 0.0f, -1.0f);
        this.leftArm.func_78792_a(this.bone5);
        this.setRotationAngle(this.bone5, 0.0f, 0.0f, 0.5236f);
        this.bone5.func_78784_a(30, 14).func_228303_a_(-3.1094f, -0.3639f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false);
        this.bone6 = new ModelRenderer((Model)this);
        this.bone6.func_78793_a(-3.9575f, 1.2207f, 0.0f);
        this.bone5.func_78792_a(this.bone6);
        this.setRotationAngle(this.bone6, 0.0f, 0.0f, 0.3491f);
        this.bone6.func_78784_a(30, 18).func_228303_a_(-2.7531f, -1.3651f, -0.5f, 4.0f, 1.0f, 1.0f, 0.0f, false);
        this.katana = new ModelRenderer((Model)this);
        this.katana.func_78793_a(1.0f, 8.0f, -4.0f);
        this.leftArm.func_78792_a(this.katana);
        this.setRotationAngle(this.katana, -0.0873f, 3.0543f, 0.0f);
        this.katana.func_78784_a(31, 13).func_228303_a_(-0.1555f, -2.0137f, -1.1343f, 1.0f, 2.0f, 13.0f, 0.0f, false);
        this.katana.func_78784_a(46, 14).func_228303_a_(-0.1596f, -1.9492f, -7.5283f, 1.0f, 2.0f, 3.0f, 0.0f, false);
        this.katana.func_78784_a(46, 9).func_228303_a_(-1.6025f, -3.4558f, -0.4588f, 4.0f, 5.0f, 0.0f, 0.0f, false);
        this.bone7 = new ModelRenderer((Model)this);
        this.bone7.func_78793_a(0.0f, 0.0f, 13.0f);
        this.katana.func_78792_a(this.bone7);
        this.setRotationAngle(this.bone7, 0.1745f, 0.0f, 0.0f);
        this.bone7.func_78784_a(46, 16).func_228303_a_(-0.1555f, -2.2105f, -1.1147f, 1.0f, 2.0f, 8.0f, 0.0f, false);
        this.back = new ModelRenderer((Model)this);
        this.back.func_78793_a(0.0f, 24.0f, 0.0f);
        this.back.func_78784_a(0, 28).func_228303_a_(-16.0f, -34.0f, 10.0f, 32.0f, 21.0f, 0.0f, 0.0f, false);
    }

    public void renderLeftArm(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.rightArm.func_228308_a_(matrixStack, buffer, 0xF000F0, packedOverlay);
    }

    public void renderRightArm(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.leftArm.func_228308_a_(matrixStack, buffer, 0xF000F0, packedOverlay);
    }

    public void renderStigma(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.back.func_228308_a_(matrixStack, buffer, 0xF000F0, packedOverlay);
    }

    public void func_225598_a_(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
