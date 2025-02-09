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
package com.meteor.extrabotany.client.model.armor;

import com.meteor.extrabotany.client.model.ModelArmor;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.inventory.EquipmentSlotType;

public class ModelShootingGuardianHelmet
extends ModelArmor {
    private final ModelRenderer helmet;
    private final ModelRenderer bone233;
    private final ModelRenderer bone244;
    private final ModelRenderer bone344;
    private final ModelRenderer bone544;
    private final ModelRenderer bone444;
    private final ModelRenderer bone611;
    private final ModelRenderer bone1322;
    private final ModelRenderer bone1111;
    private final ModelRenderer bone1923;
    private final ModelRenderer bone2034;
    private final ModelRenderer bone1733;
    private final ModelRenderer bone1821;
    private final ModelRenderer bone721;
    private final ModelRenderer bone1021;
    private final ModelRenderer bone1221;
    private final ModelRenderer bone834;
    private final ModelRenderer bone1555;
    private final ModelRenderer bone966;
    private final ModelRenderer bone1477;
    private final ModelRenderer bone1688;

    public ModelShootingGuardianHelmet(EquipmentSlotType slot) {
        super(slot);
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.helmet = new ModelRenderer((Model)this);
        this.helmet.func_78793_a(0.0f, 24.0f, 0.0f);
        this.bone1688 = new ModelRenderer((Model)this);
        this.bone1688.func_78793_a(0.0f, -6.0f, -4.5f);
        this.helmet.func_78792_a(this.bone1688);
        this.setRotationAngle(this.bone1688, 0.0f, 0.0f, -0.7854f);
        this.bone1688.func_78784_a(0, 28).func_228303_a_(-1.5f, -4.5f, -0.01f, 6.0f, 6.0f, 0.0f, 0.0f, false);
        this.bone1477 = new ModelRenderer((Model)this);
        this.bone1477.func_78793_a(5.8f, -5.0f, 0.0f);
        this.helmet.func_78792_a(this.bone1477);
        this.bone1477.func_78784_a(30, 18).func_228303_a_(-10.8f, -4.0f, -4.5f, 10.0f, 2.0f, 0.0f, 0.0f, false);
        this.bone966 = new ModelRenderer((Model)this);
        this.bone966.func_78793_a(5.8f, -5.0f, 0.0f);
        this.helmet.func_78792_a(this.bone966);
        this.bone966.func_78784_a(30, 0).func_228303_a_(-10.8f, -4.0f, 3.5f, 10.0f, 8.0f, 1.0f, 0.0f, false);
        this.bone1555 = new ModelRenderer((Model)this);
        this.bone1555.func_78793_a(2.5f, -8.5f, 0.02f);
        this.helmet.func_78792_a(this.bone1555);
        this.setRotationAngle(this.bone1555, 0.0f, 0.0f, 0.2618f);
        this.bone1555.func_78784_a(0, 0).func_228303_a_(-2.7f, -0.5f, -4.5f, 5.0f, 1.0f, 9.0f, 0.0f, false);
        this.bone834 = new ModelRenderer((Model)this);
        this.bone834.func_78793_a(-2.5f, -8.5f, 0.02f);
        this.helmet.func_78792_a(this.bone834);
        this.setRotationAngle(this.bone834, 0.0f, 0.0f, -0.2618f);
        this.bone834.func_78784_a(0, 10).func_228303_a_(-2.3f, -0.5f, -4.5f, 5.0f, 1.0f, 9.0f, 0.0f, false);
        this.bone1221 = new ModelRenderer((Model)this);
        this.bone1221.func_78793_a(5.8f, -5.0f, 0.0f);
        this.helmet.func_78792_a(this.bone1221);
        this.setRotationAngle(this.bone1221, 0.0f, 0.0f, -0.1745f);
        this.bone1221.func_78784_a(0, 10).func_228303_a_(-3.5f, -4.0f, -4.48f, 3.0f, 8.0f, 0.0f, 0.0f, false);
        this.bone1021 = new ModelRenderer((Model)this);
        this.bone1021.func_78793_a(5.8f, -5.0f, 0.0f);
        this.helmet.func_78792_a(this.bone1021);
        this.setRotationAngle(this.bone1021, 0.0f, 0.0f, -0.1745f);
        this.bone1021.func_78784_a(6, 0).func_228303_a_(-1.5f, -4.0f, 4.49f, 1.0f, 8.0f, 0.0f, 0.0f, false);
        this.bone721 = new ModelRenderer((Model)this);
        this.bone721.func_78793_a(5.8f, -5.0f, 0.0f);
        this.helmet.func_78792_a(this.bone721);
        this.setRotationAngle(this.bone721, 0.0f, 0.0f, -0.1745f);
        this.bone721.func_78784_a(19, 1).func_228303_a_(-1.5f, -4.0f, -4.49f, 1.0f, 8.0f, 9.0f, 0.0f, false);
        this.bone1821 = new ModelRenderer((Model)this);
        this.bone1821.func_78793_a(5.1f, -5.0f, -1.5f);
        this.helmet.func_78792_a(this.bone1821);
        this.setRotationAngle(this.bone1821, -0.6981f, 0.0f, -0.1745f);
        this.bone1821.func_78784_a(32, 24).func_228303_a_(-0.5f, -1.0f, -1.0f, 1.0f, 2.0f, 2.0f, 0.0f, false);
        this.bone1733 = new ModelRenderer((Model)this);
        this.bone1733.func_78793_a(-5.1f, -5.0f, -1.5f);
        this.helmet.func_78792_a(this.bone1733);
        this.setRotationAngle(this.bone1733, -0.6981f, 0.0f, 0.1745f);
        this.bone1733.func_78784_a(0, 34).func_228303_a_(-0.5f, -1.0f, -1.0f, 1.0f, 2.0f, 2.0f, 0.0f, false);
        this.bone2034 = new ModelRenderer((Model)this);
        this.bone2034.func_78793_a(5.8f, -5.0f, 0.0f);
        this.helmet.func_78792_a(this.bone2034);
        this.setRotationAngle(this.bone2034, 0.0f, 0.7854f, -0.1745f);
        this.bone2034.func_78784_a(12, 28).func_228303_a_(-0.1f, -1.1f, -2.19f, 1.0f, 5.0f, 1.0f, 0.0f, false);
        this.bone1923 = new ModelRenderer((Model)this);
        this.bone1923.func_78793_a(-5.8f, -5.0f, 0.0f);
        this.helmet.func_78792_a(this.bone1923);
        this.setRotationAngle(this.bone1923, 0.0f, -0.7854f, 0.1745f);
        this.bone1923.func_78784_a(30, 20).func_228303_a_(-0.9f, -1.1f, -2.19f, 1.0f, 5.0f, 1.0f, 0.0f, false);
        this.bone1111 = new ModelRenderer((Model)this);
        this.bone1111.func_78793_a(-5.8f, -5.0f, 0.0f);
        this.helmet.func_78792_a(this.bone1111);
        this.setRotationAngle(this.bone1111, 0.0f, 0.0f, 0.1745f);
        this.bone1111.func_78784_a(19, 19).func_228303_a_(0.5f, -4.0f, -4.49f, 1.0f, 8.0f, 9.0f, 0.0f, false);
        this.bone1322 = new ModelRenderer((Model)this);
        this.bone1322.func_78793_a(-5.8f, -5.0f, 0.0f);
        this.helmet.func_78792_a(this.bone1322);
        this.setRotationAngle(this.bone1322, 0.0f, 0.0f, 0.1745f);
        this.bone1322.func_78784_a(0, 0).func_228303_a_(0.5f, -4.0f, -4.48f, 3.0f, 8.0f, 0.0f, 0.0f, false);
        this.bone611 = new ModelRenderer((Model)this);
        this.bone611.func_78793_a(-5.8f, -5.0f, 0.0f);
        this.helmet.func_78792_a(this.bone611);
        this.setRotationAngle(this.bone611, 0.0f, 0.0f, 0.1745f);
        this.bone611.func_78784_a(6, 10).func_228303_a_(0.5f, -4.0f, 4.49f, 1.0f, 8.0f, 0.0f, 0.0f, false);
        this.bone444 = new ModelRenderer((Model)this);
        this.bone444.func_78793_a(0.0f, 23.0f, 0.0f);
        this.helmet.func_78792_a(this.bone444);
        this.bone444.func_78784_a(22, 17).func_228303_a_(-5.0f, -29.0f, -4.5f, 0.0f, 5.0f, 3.0f, 0.0f, false);
        this.bone544 = new ModelRenderer((Model)this);
        this.bone544.func_78793_a(0.0f, 23.0f, 0.0f);
        this.helmet.func_78792_a(this.bone544);
        this.bone544.func_78784_a(19, 0).func_228303_a_(5.0f, -29.0f, -4.5f, 0.0f, 5.0f, 3.0f, 0.0f, false);
        this.bone344 = new ModelRenderer((Model)this);
        this.bone344.func_78793_a(0.0f, 23.0f, 0.0f);
        this.helmet.func_78792_a(this.bone344);
        this.bone344.func_78784_a(0, 20).func_228303_a_(-5.0f, -31.0f, -4.3f, 10.0f, 7.0f, 1.0f, 0.0f, false);
        this.bone244 = new ModelRenderer((Model)this);
        this.bone244.func_78793_a(0.0f, -1.0f, -5.0f);
        this.helmet.func_78792_a(this.bone244);
        this.setRotationAngle(this.bone244, 0.0f, -0.2618f, 0.0f);
        this.bone244.func_78784_a(19, 0).func_228303_a_(0.0f, -2.5f, 0.0f, 3.0f, 3.0f, 0.0f, 0.0f, false);
        this.bone233 = new ModelRenderer((Model)this);
        this.bone233.func_78793_a(0.0f, -1.0f, -5.0f);
        this.helmet.func_78792_a(this.bone233);
        this.setRotationAngle(this.bone233, 0.0f, 0.2618f, 0.0f);
        this.bone233.func_78784_a(22, 25).func_228303_a_(-3.0f, -2.5f, 0.0f, 3.0f, 3.0f, 0.0f, 0.0f, false);
    }

    public void func_225598_a_(MatrixStack ms, IVertexBuilder buffer, int light, int overlay, float r, float g, float b, float a) {
        this.field_178720_f.field_78806_j = false;
        this.helmet.field_78806_j = this.slot == EquipmentSlotType.HEAD;
        this.field_78116_c = this.helmet;
        super.func_225598_a_(ms, buffer, light, overlay, r, g, b, a);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
