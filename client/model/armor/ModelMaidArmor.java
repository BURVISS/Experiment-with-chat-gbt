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

public class ModelMaidArmor
extends ModelArmor {
    private final ModelRenderer helmAnchor;
    private final ModelRenderer ear1;
    private final ModelRenderer ear2;
    private final ModelRenderer hat;
    private final ModelRenderer bodyAnchor;
    private final ModelRenderer body;
    private final ModelRenderer oupai;
    private final ModelRenderer left;
    private final ModelRenderer right;
    private final ModelRenderer armLAnchor;
    private final ModelRenderer armRAnchor;
    private final ModelRenderer pantsAnchor;
    private final ModelRenderer a1;
    private final ModelRenderer a2;
    private final ModelRenderer a3;
    private final ModelRenderer a4;
    private final ModelRenderer b1;
    private final ModelRenderer b2;
    private final ModelRenderer legL;
    private final ModelRenderer legR;
    private final ModelRenderer legLeft;
    private final ModelRenderer legRight;
    private final ModelRenderer bootL;
    private final ModelRenderer bootR;

    public ModelMaidArmor(EquipmentSlotType slot) {
        super(slot);
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        float s = 0.01f;
        this.helmAnchor = new ModelRenderer((Model)this, 0, 0);
        this.helmAnchor.func_78793_a(0.0f, 0.0f, 0.0f);
        this.helmAnchor.func_228301_a_(-1.0f, -2.0f, 0.0f, 2.0f, 2.0f, 2.0f, s);
        this.ear1 = new ModelRenderer((Model)this, 1, 55);
        this.ear1.func_228301_a_(0.0f, 0.0f, 0.0f, 3.0f, 3.0f, 2.0f, s);
        this.ear1.func_78793_a(-5.0f, -8.5f, -3.0f);
        this.ear1.func_78787_b(64, 32);
        this.ear1.field_78809_i = true;
        this.setRotateAngle(this.ear1, 0.0f, 0.0f, -0.9075712f);
        this.ear2 = new ModelRenderer((Model)this, 12, 55);
        this.ear2.func_228301_a_(0.0f, 0.0f, 0.0f, 3.0f, 3.0f, 2.0f, s);
        this.ear2.func_78793_a(3.0f, -10.8f, -3.0f);
        this.ear2.func_78787_b(64, 32);
        this.ear2.field_78809_i = true;
        this.setRotateAngle(this.ear2, 0.0f, 0.0f, 0.9075712f);
        this.hat = new ModelRenderer((Model)this, 1, 61);
        this.hat.func_228300_a_(0.0f, 0.0f, 0.0f, 10.0f, 4.0f, 1.0f);
        this.hat.func_78793_a(-5.0f, -9.0f, -2.0f);
        this.hat.func_78787_b(64, 32);
        this.hat.field_78809_i = true;
        this.setRotateAngle(this.hat, 0.0f, 0.0f, 0.0f);
        this.bodyAnchor = new ModelRenderer((Model)this, 0, 0);
        this.bodyAnchor.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bodyAnchor.func_228301_a_(-1.0f, 0.0f, -1.0f, 2.0f, 2.0f, 2.0f, s);
        this.body = new ModelRenderer((Model)this, 16, 16);
        this.body.func_228300_a_(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78787_b(64, 32);
        this.body.field_78809_i = true;
        this.setRotateAngle(this.body, 0.0f, 0.0f, 0.0f);
        this.oupai = new ModelRenderer((Model)this, 1, 67);
        this.oupai.func_228300_a_(0.0f, 0.0f, 0.0f, 6.0f, 4.0f, 3.0f);
        this.oupai.func_78793_a(-3.0f, 1.0f, -4.0f);
        this.oupai.func_78787_b(64, 32);
        this.oupai.field_78809_i = true;
        this.setRotateAngle(this.oupai, 0.1745329f, 0.0f, 0.0f);
        this.left = new ModelRenderer((Model)this, 1, 75);
        this.left.func_228301_a_(0.0f, 0.0f, 0.0f, 5.0f, 4.0f, 6.0f, s);
        this.left.func_78793_a(-1.0f, -2.0f, -3.0f);
        this.left.func_78787_b(64, 32);
        this.left.field_78809_i = true;
        this.setRotateAngle(this.left, 0.0f, 0.0f, 0.0f);
        this.right = new ModelRenderer((Model)this, 24, 75);
        this.right.func_228301_a_(0.0f, 0.0f, 0.0f, 5.0f, 4.0f, 6.0f, s);
        this.right.func_78793_a(-4.0f, -2.0f, -3.0f);
        this.right.func_78787_b(64, 32);
        this.right.field_78809_i = true;
        this.setRotateAngle(this.right, 0.0f, 0.0f, 0.0f);
        this.armLAnchor = new ModelRenderer((Model)this, 0, 0);
        this.armLAnchor.field_78809_i = true;
        this.armLAnchor.func_78793_a(4.0f, 2.0f, 0.0f);
        this.armLAnchor.func_228301_a_(0.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f, s);
        this.armRAnchor = new ModelRenderer((Model)this, 0, 0);
        this.armRAnchor.field_78809_i = true;
        this.armRAnchor.func_78793_a(-4.0f, 2.0f, 0.0f);
        this.armRAnchor.func_228301_a_(-2.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f, s);
        this.pantsAnchor = new ModelRenderer((Model)this, 0, 0);
        this.pantsAnchor.func_78793_a(0.0f, 0.0f, 0.0f);
        this.pantsAnchor.func_228301_a_(-1.0f, 0.0f, -1.0f, 2.0f, 2.0f, 2.0f, s);
        this.legR = new ModelRenderer((Model)this, 0, 0);
        this.legR.func_228301_a_(-2.0f, 0.0f, -2.0f, 0.0f, 0.0f, 0.0f, s);
        this.legR.func_78793_a(-2.0f, 12.0f, 0.0f);
        this.legR.func_78787_b(64, 32);
        this.legR.field_78809_i = true;
        this.setRotateAngle(this.legR, 0.0f, 0.0f, 0.0f);
        this.legL = new ModelRenderer((Model)this, 0, 0);
        this.legL.func_228301_a_(-2.0f, 0.0f, -2.0f, 0.0f, 0.0f, 0.0f, s);
        this.legL.func_78793_a(2.0f, 12.0f, 0.0f);
        this.legL.func_78787_b(64, 32);
        this.legL.field_78809_i = true;
        this.setRotateAngle(this.legL, 0.0f, 0.0f, 0.0f);
        this.b2 = new ModelRenderer((Model)this, 1, 32);
        this.b2.func_228300_a_(0.0f, 0.0f, 0.0f, 6.0f, 4.0f, 1.0f);
        this.b2.func_78793_a(-3.0f, 9.0f, -2.0f);
        this.b2.func_78787_b(64, 32);
        this.b2.field_78809_i = true;
        this.setRotateAngle(this.b2, -0.5235988f, 0.0f, 0.0f);
        this.b1 = new ModelRenderer((Model)this, 16, 32);
        this.b1.func_228300_a_(0.0f, 0.0f, 0.0f, 6.0f, 4.0f, 1.0f);
        this.b1.func_78793_a(-3.0f, 9.0f, 1.0f);
        this.b1.func_78787_b(64, 32);
        this.b1.field_78809_i = true;
        this.setRotateAngle(this.b1, 0.5235988f, 0.0f, 0.0f);
        this.a4 = new ModelRenderer((Model)this, 1, 38);
        this.a4.func_228300_a_(0.0f, 0.0f, 0.0f, 1.0f, 5.0f, 4.0f);
        this.a4.func_78793_a(3.0f, 9.0f, -2.0f);
        this.a4.func_78787_b(64, 32);
        this.a4.field_78809_i = true;
        this.setRotateAngle(this.a4, 0.0f, 0.0f, -0.3490659f);
        this.a3 = new ModelRenderer((Model)this, 1, 48);
        this.a3.func_228300_a_(0.0f, 0.0f, 0.0f, 8.0f, 5.0f, 1.0f);
        this.a3.func_78793_a(-4.0f, 9.0f, -2.0f);
        this.a3.func_78787_b(64, 32);
        this.a3.field_78809_i = true;
        this.setRotateAngle(this.a3, -0.3490659f, 0.0f, 0.0f);
        this.a2 = new ModelRenderer((Model)this, 12, 38);
        this.a2.func_228300_a_(0.0f, 0.0f, 0.0f, 1.0f, 5.0f, 4.0f);
        this.a2.func_78793_a(-4.0f, 9.0f, -2.0f);
        this.a2.func_78787_b(64, 32);
        this.a2.field_78809_i = true;
        this.setRotateAngle(this.a2, 0.0f, 0.0f, 0.3490659f);
        this.a1 = new ModelRenderer((Model)this, 20, 48);
        this.a1.func_228300_a_(0.0f, 0.0f, 0.0f, 8.0f, 5.0f, 1.0f);
        this.a1.func_78793_a(-4.0f, 9.0f, 1.0f);
        this.a1.func_78787_b(64, 32);
        this.a1.field_78809_i = true;
        this.setRotateAngle(this.a1, 0.3490659f, 0.0f, 0.0f);
        this.legRight = new ModelRenderer((Model)this, 0, 16);
        this.legRight.func_228301_a_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, s);
        this.legRight.func_78793_a(0.0f, 0.0f, 0.0f);
        this.legRight.func_78787_b(64, 32);
        this.legRight.field_78809_i = true;
        this.setRotateAngle(this.legRight, 0.0f, 0.0f, 0.0f);
        this.legLeft = new ModelRenderer((Model)this, 0, 16);
        this.legLeft.func_228301_a_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, s);
        this.legLeft.func_78793_a(0.0f, 0.0f, 0.0f);
        this.legLeft.func_78787_b(64, 32);
        this.legLeft.field_78809_i = true;
        this.setRotateAngle(this.legLeft, 0.0f, 0.0f, 0.0f);
        this.bootL = new ModelRenderer((Model)this, 0, 0);
        this.bootL.field_78809_i = true;
        this.bootL.func_78793_a(1.9f, 12.0f, 0.0f);
        this.bootL.func_228301_a_(-2.39f, 8.5f, -2.49f, 2.0f, 2.0f, 2.0f, s);
        this.bootR = new ModelRenderer((Model)this, 0, 0);
        this.bootR.func_78793_a(-2.0f, 12.0f, 0.0f);
        this.bootR.func_228301_a_(-2.5f, 8.5f, -2.51f, 2.0f, 2.0f, 2.0f, s);
        this.helmAnchor.func_78792_a(this.hat);
        this.helmAnchor.func_78792_a(this.ear1);
        this.helmAnchor.func_78792_a(this.ear2);
        this.bodyAnchor.func_78792_a(this.body);
        this.body.func_78792_a(this.oupai);
        this.armLAnchor.func_78792_a(this.left);
        this.armRAnchor.func_78792_a(this.right);
        this.pantsAnchor.func_78792_a(this.a1);
        this.pantsAnchor.func_78792_a(this.a2);
        this.pantsAnchor.func_78792_a(this.a3);
        this.pantsAnchor.func_78792_a(this.a4);
        this.pantsAnchor.func_78792_a(this.b1);
        this.pantsAnchor.func_78792_a(this.b2);
        this.bootL.func_78792_a(this.legLeft);
        this.bootR.func_78792_a(this.legRight);
    }

    public void func_225598_a_(MatrixStack ms, IVertexBuilder buffer, int light, int overlay, float r, float g, float b, float a) {
        this.helmAnchor.field_78806_j = this.slot == EquipmentSlotType.HEAD;
        this.bodyAnchor.field_78806_j = this.slot == EquipmentSlotType.CHEST;
        this.armRAnchor.field_78806_j = this.slot == EquipmentSlotType.CHEST;
        this.armLAnchor.field_78806_j = this.slot == EquipmentSlotType.CHEST;
        this.legR.field_78806_j = this.slot == EquipmentSlotType.LEGS;
        this.legL.field_78806_j = this.slot == EquipmentSlotType.LEGS;
        this.bootL.field_78806_j = this.slot == EquipmentSlotType.FEET;
        this.bootR.field_78806_j = this.slot == EquipmentSlotType.FEET;
        this.field_178720_f.field_78806_j = false;
        this.field_78116_c = this.helmAnchor;
        this.field_78115_e = this.bodyAnchor;
        this.field_178723_h = this.armRAnchor;
        this.field_178724_i = this.armLAnchor;
        if (this.slot == EquipmentSlotType.LEGS) {
            this.field_78115_e = this.pantsAnchor;
            this.field_178721_j = this.legR;
            this.field_178722_k = this.legL;
        } else {
            this.field_178721_j = this.bootR;
            this.field_178722_k = this.bootL;
        }
        super.func_225598_a_(ms, buffer, light, overlay, r, g, b, a);
    }
}
