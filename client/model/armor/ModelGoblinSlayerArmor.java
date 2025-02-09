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

public class ModelGoblinSlayerArmor
extends ModelArmor {
    private final ModelRenderer plates;
    private final ModelRenderer bang2;
    private final ModelRenderer bang1;
    private final ModelRenderer ear;
    private final ModelRenderer hair;
    private final ModelRenderer hair2;
    private final ModelRenderer bone;
    private final ModelRenderer bone3;
    private final ModelRenderer bone7;
    private final ModelRenderer bone2;
    private final ModelRenderer bone8;
    private final ModelRenderer bone5;
    private final ModelRenderer handL;
    private final ModelRenderer bone4;
    private final ModelRenderer handR;
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer leftArm;
    private final ModelRenderer rightArm;
    private final ModelRenderer rightLeg;
    private final ModelRenderer leftLeg;
    private final ModelRenderer bootL;
    private final ModelRenderer bootR;

    public ModelGoblinSlayerArmor(EquipmentSlotType slot) {
        super(slot);
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        float s = 0.01f;
        this.head = new ModelRenderer((Model)this);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78784_a(0, 18).func_228303_a_(-2.0f, -1.0f, -5.0f, 4.0f, 2.0f, 2.0f, 0.0f, false);
        this.head.func_78784_a(4, 23).func_228303_a_(-1.5f, -6.0f, -5.0f, 1.0f, 5.0f, 1.0f, 0.0f, false);
        this.head.func_78784_a(8, 23).func_228303_a_(0.5f, -6.0f, -5.0f, 1.0f, 5.0f, 1.0f, 0.0f, false);
        this.head.func_78784_a(0, 0).func_228303_a_(-4.5f, -8.5f, -4.5f, 9.0f, 9.0f, 9.0f, 0.0f, false);
        this.plates = new ModelRenderer((Model)this);
        this.plates.func_78793_a(0.0f, -8.5f, -2.0f);
        this.head.func_78792_a(this.plates);
        this.setRotationAngle(this.plates, 0.0f, 0.7854f, 0.0f);
        this.plates.func_78784_a(0, 49).func_228303_a_(-3.0f, -0.5f, -3.0f, 6.0f, 1.0f, 6.0f, 0.0f, false);
        this.plates.func_78784_a(0, 56).func_228303_a_(-3.0f, -1.5f, -2.0f, 5.0f, 1.0f, 5.0f, 0.0f, false);
        this.plates.func_78784_a(0, 65).func_228303_a_(-1.0f, -2.5f, 1.0f, 2.0f, 1.0f, 3.0f, 0.0f, false);
        this.plates.func_78784_a(0, 74).func_228303_a_(-3.0f, -0.5f, 3.0f, 4.0f, 1.0f, 1.0f, 0.0f, false);
        this.plates.func_78784_a(0, 69).func_228303_a_(-4.0f, -0.5f, -1.0f, 1.0f, 1.0f, 4.0f, 0.0f, false);
        this.plates.func_78784_a(0, 62).func_228303_a_(-4.0f, -2.5f, -1.0f, 5.0f, 1.0f, 2.0f, 0.0f, false);
        this.plates.func_78784_a(0, 35).func_228303_a_(-2.0f, 1.5f, -4.0f, 6.0f, 1.0f, 6.0f, 0.0f, false);
        this.plates.func_78784_a(0, 29).func_228303_a_(-1.5f, 2.5f, -3.5f, 5.0f, 1.0f, 5.0f, 0.0f, false);
        this.plates.func_78784_a(0, 42).func_228303_a_(-2.5f, 0.5f, -3.5f, 6.0f, 1.0f, 6.0f, 0.0f, false);
        this.bang2 = new ModelRenderer((Model)this);
        this.bang2.func_78793_a(-2.0f, 0.0f, -5.0f);
        this.head.func_78792_a(this.bang2);
        this.setRotationAngle(this.bang2, 0.0f, 0.0f, -0.1745f);
        this.bang2.func_78784_a(0, 22).func_228303_a_(-0.75f, -6.25f, 0.0f, 1.0f, 6.0f, 1.0f, 0.0f, false);
        this.bang1 = new ModelRenderer((Model)this);
        this.bang1.func_78793_a(2.0f, 0.0f, -4.0f);
        this.head.func_78792_a(this.bang1);
        this.setRotationAngle(this.bang1, 0.0f, 0.0f, 0.1745f);
        this.bang1.func_78784_a(12, 22).func_228303_a_(-0.25f, -6.25f, -1.0f, 1.0f, 6.0f, 1.0f, 0.0f, false);
        this.ear = new ModelRenderer((Model)this);
        this.ear.func_78793_a(5.5f, -4.0f, 0.0f);
        this.head.func_78792_a(this.ear);
        this.setRotationAngle(this.ear, 0.7854f, 0.0f, 0.0f);
        this.ear.func_78784_a(16, 18).func_228303_a_(-1.0f, -1.0f, -2.0f, 1.0f, 3.0f, 3.0f, 0.0f, false);
        this.ear.func_78784_a(16, 24).func_228303_a_(-11.0f, -1.0f, -2.0f, 1.0f, 3.0f, 3.0f, 0.0f, false);
        this.hair = new ModelRenderer((Model)this);
        this.hair.func_78793_a(0.0f, -9.5f, 2.0f);
        this.head.func_78792_a(this.hair);
        this.setRotationAngle(this.hair, 0.1745f, -0.3491f, 0.0f);
        this.hair.func_78784_a(35, 0).func_228303_a_(-1.5f, -0.5f, 0.25f, 3.0f, 0.0f, 4.0f, 0.0f, false);
        this.hair2 = new ModelRenderer((Model)this);
        this.hair2.func_78793_a(-0.25f, -9.5f, 2.25f);
        this.head.func_78792_a(this.hair2);
        this.setRotationAngle(this.hair2, -0.3491f, 0.2618f, 0.0f);
        this.hair2.func_78784_a(34, 4).func_228303_a_(-1.25f, -0.5f, 0.0f, 3.0f, 0.0f, 5.0f, 0.0f, false);
        this.body = new ModelRenderer((Model)this);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78784_a(100, 0).func_228303_a_(-4.5f, -0.5f, -2.5f, 9.0f, 13.0f, 5.0f, 0.0f, false);
        this.body.func_78784_a(50, 8).func_228303_a_(-5.0f, 6.0f, -3.0f, 10.0f, 1.0f, 6.0f, 0.0f, false);
        this.body.func_78784_a(68, 0).func_228303_a_(-5.0f, 11.0f, -3.0f, 10.0f, 2.0f, 6.0f, 0.0f, false);
        this.body.func_78784_a(110, 18).func_228303_a_(-4.0f, 0.0f, 2.25f, 8.0f, 6.0f, 1.0f, 0.0f, false);
        this.bone = new ModelRenderer((Model)this);
        this.bone.func_78793_a(0.0f, 7.0f, -2.5f);
        this.body.func_78792_a(this.bone);
        this.setRotationAngle(this.bone, 0.0f, 0.0f, -0.7854f);
        this.bone.func_78784_a(50, 0).func_228303_a_(5.5f, -4.0f, -1.0f, 1.0f, 4.0f, 1.0f, 0.0f, false);
        this.bone.func_78784_a(82, 8).func_228303_a_(-1.5f, -2.5f, -1.0f, 4.0f, 4.0f, 1.0f, 0.0f, false);
        this.bone.func_78784_a(54, 0).func_228303_a_(-0.5f, -5.5f, -2.0f, 6.0f, 6.0f, 1.0f, 0.0f, false);
        this.bone.func_78784_a(96, 18).func_228303_a_(-3.5f, -2.5f, 5.0f, 6.0f, 6.0f, 1.0f, 0.0f, false);
        this.bone.func_78784_a(46, 9).func_228303_a_(0.0f, -6.5f, -1.0f, 4.0f, 1.0f, 1.0f, 0.0f, false);
        this.bone.func_78784_a(50, 15).func_228303_a_(0.5f, -4.5f, -3.0f, 4.0f, 2.0f, 1.0f, 0.0f, false);
        this.bone.func_78784_a(60, 15).func_228303_a_(2.5f, -2.5f, -3.0f, 2.0f, 2.0f, 1.0f, 0.0f, false);
        this.bone.func_78784_a(92, 8).func_228303_a_(-5.5f, 2.5f, -2.5f, 3.0f, 3.0f, 1.0f, 0.0f, false);
        this.bone3 = new ModelRenderer((Model)this);
        this.bone3.func_78793_a(0.0f, 12.0f, 0.0f);
        this.body.func_78792_a(this.bone3);
        this.setRotationAngle(this.bone3, 0.0f, 0.0f, 0.2618f);
        this.bone3.func_78784_a(66, 15).func_228303_a_(-5.0f, -1.0f, -4.0f, 5.0f, 2.0f, 1.0f, 0.0f, false);
        this.bone3.func_78784_a(66, 15).func_228303_a_(-5.0f, -1.0f, 3.0f, 5.0f, 2.0f, 1.0f, 0.0f, false);
        this.bone3.func_78784_a(66, 21).func_228303_a_(-6.0f, -1.0f, -3.0f, 1.0f, 2.0f, 6.0f, 0.0f, false);
        this.bone7 = new ModelRenderer((Model)this);
        this.bone7.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bone3.func_78792_a(this.bone7);
        this.setRotationAngle(this.bone7, 0.0f, 0.0f, -0.5236f);
        this.bone7.func_78784_a(66, 18).func_228303_a_(-5.0f, -0.25f, -4.0f, 5.0f, 2.0f, 1.0f, 0.0f, false);
        this.bone7.func_78784_a(66, 18).func_228303_a_(-5.0f, -0.25f, 3.0f, 5.0f, 2.0f, 1.0f, 0.0f, false);
        this.bone7.func_78784_a(80, 21).func_228303_a_(-6.0f, -0.25f, -3.0f, 1.0f, 2.0f, 6.0f, 0.0f, false);
        this.bone2 = new ModelRenderer((Model)this);
        this.bone2.func_78793_a(0.0f, 12.0f, 0.0f);
        this.body.func_78792_a(this.bone2);
        this.setRotationAngle(this.bone2, 0.0f, 0.0f, -0.2618f);
        this.bone2.func_78784_a(78, 15).func_228303_a_(0.0f, -1.0f, -4.0f, 5.0f, 2.0f, 1.0f, 0.0f, false);
        this.bone2.func_78784_a(78, 15).func_228303_a_(0.0f, -1.0f, 3.0f, 5.0f, 2.0f, 1.0f, 0.0f, false);
        this.bone2.func_78784_a(66, 21).func_228303_a_(5.0f, -1.0f, -3.0f, 1.0f, 2.0f, 6.0f, 0.0f, false);
        this.bone8 = new ModelRenderer((Model)this);
        this.bone8.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bone2.func_78792_a(this.bone8);
        this.setRotationAngle(this.bone8, 0.0f, 0.0f, 0.5236f);
        this.bone8.func_78784_a(78, 18).func_228303_a_(0.0f, -0.25f, -4.0f, 5.0f, 2.0f, 1.0f, 0.0f, false);
        this.bone8.func_78784_a(78, 18).func_228303_a_(0.0f, -0.25f, 3.0f, 5.0f, 2.0f, 1.0f, 0.0f, false);
        this.bone8.func_78784_a(80, 21).func_228303_a_(5.0f, -0.25f, -3.0f, 1.0f, 2.0f, 6.0f, 0.0f, false);
        this.leftArm = new ModelRenderer((Model)this);
        this.leftArm.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.leftArm.func_78784_a(108, 48).func_228303_a_(-3.75f, 2.5f, -2.5f, 5.0f, 8.0f, 5.0f, 0.0f, false);
        this.leftArm.func_78784_a(98, 48).func_228303_a_(-4.25f, 3.0f, -2.0f, 1.0f, 6.0f, 4.0f, 0.0f, false);
        this.bone5 = new ModelRenderer((Model)this);
        this.bone5.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leftArm.func_78792_a(this.bone5);
        this.setRotationAngle(this.bone5, 0.0f, 0.0f, 0.3491f);
        this.bone5.func_78784_a(100, 25).func_228303_a_(-5.25f, -4.0f, -3.5f, 7.0f, 5.0f, 7.0f, 0.0f, false);
        this.handL = new ModelRenderer((Model)this);
        this.handL.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leftArm.func_78792_a(this.handL);
        this.setRotationAngle(this.handL, 0.0f, 0.0f, 0.1745f);
        this.handL.func_78784_a(104, 37).func_228303_a_(-4.0f, 0.0f, -3.0f, 6.0f, 4.0f, 6.0f, 0.0f, false);
        this.rightArm = new ModelRenderer((Model)this);
        this.rightArm.func_78793_a(5.0f, 2.0f, 0.0f);
        this.rightArm.func_78784_a(108, 48).func_228303_a_(-1.25f, 2.5f, -2.5f, 5.0f, 8.0f, 5.0f, 0.0f, true);
        this.rightArm.func_78784_a(98, 48).func_228303_a_(3.25f, 3.0f, -2.0f, 1.0f, 6.0f, 4.0f, 0.0f, true);
        this.bone4 = new ModelRenderer((Model)this);
        this.bone4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.rightArm.func_78792_a(this.bone4);
        this.setRotationAngle(this.bone4, 0.0f, 0.0f, -0.3491f);
        this.bone4.func_78784_a(100, 25).func_228303_a_(-1.75f, -4.0f, -3.5f, 7.0f, 5.0f, 7.0f, 0.0f, true);
        this.handR = new ModelRenderer((Model)this);
        this.handR.func_78793_a(0.0f, 0.0f, 0.0f);
        this.rightArm.func_78792_a(this.handR);
        this.setRotationAngle(this.handR, 0.0f, 0.0f, -0.1745f);
        this.handR.func_78784_a(104, 37).func_228303_a_(-2.0f, 0.0f, -3.0f, 6.0f, 4.0f, 6.0f, 0.0f, true);
        this.rightLeg = new ModelRenderer((Model)this);
        this.rightLeg.func_78793_a(1.9f, 12.0f, 0.0f);
        this.rightLeg.func_78784_a(112, 112).func_228303_a_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, 0.0f, true);
        this.rightLeg.func_78784_a(108, 61).func_228303_a_(-2.5f, -0.5f, -2.5f, 5.0f, 13.0f, 5.0f, 0.0f, true);
        this.rightLeg.func_78784_a(98, 61).func_228303_a_(-2.1f, 1.0f, -3.5f, 4.0f, 5.0f, 1.0f, 0.0f, true);
        this.rightLeg.func_78784_a(84, 70).func_228303_a_(-3.1f, 2.0f, -3.0f, 6.0f, 3.0f, 6.0f, 0.0f, true);
        this.leftLeg = new ModelRenderer((Model)this);
        this.leftLeg.func_78793_a(-1.9f, 12.0f, 0.0f);
        this.leftLeg.func_78784_a(112, 112).func_228303_a_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, 0.0f, false);
        this.leftLeg.func_78784_a(108, 61).func_228303_a_(-2.5f, -0.5f, -2.5f, 5.0f, 13.0f, 5.0f, 0.0f, false);
        this.leftLeg.func_78784_a(98, 61).func_228303_a_(-2.0f, 1.0f, -3.5f, 4.0f, 5.0f, 1.0f, 0.0f, false);
        this.leftLeg.func_78784_a(84, 70).func_228303_a_(-3.0f, 2.0f, -3.0f, 6.0f, 3.0f, 6.0f, 0.0f, false);
        this.bootL = new ModelRenderer((Model)this);
        this.bootL.func_78793_a(-1.9f, 12.0f, 0.0f);
        this.bootL.func_78784_a(24, 31).func_228303_a_(-3.0f, 8.0f, -3.0f, 6.0f, 5.0f, 6.0f, 0.0f, false);
        this.bootL.func_78784_a(24, 42).func_228303_a_(-3.0f, 6.0f, 2.0f, 6.0f, 2.0f, 1.0f, 0.0f, false);
        this.bootL.func_78784_a(24, 45).func_228303_a_(2.0f, 6.0f, -1.0f, 1.0f, 2.0f, 3.0f, 0.0f, false);
        this.bootL.func_78784_a(24, 45).func_228303_a_(-3.0f, 6.0f, -1.0f, 1.0f, 2.0f, 3.0f, 0.0f, false);
        this.bootL.func_78784_a(29, 45).func_228303_a_(2.0f, 7.0f, -2.0f, 1.0f, 1.0f, 1.0f, 0.0f, false);
        this.bootL.func_78784_a(29, 45).func_228303_a_(-3.0f, 7.0f, -2.0f, 1.0f, 1.0f, 1.0f, 0.0f, false);
        this.bootL.func_78784_a(24, 27).func_228303_a_(-2.0f, 10.0f, -4.0f, 4.0f, 3.0f, 1.0f, 0.0f, false);
        this.bootL.func_78784_a(21, 33).func_228303_a_(-1.0f, 9.0f, -4.0f, 2.0f, 1.0f, 1.0f, 0.0f, false);
        this.bootR = new ModelRenderer((Model)this);
        this.bootR.func_78793_a(1.9f, 12.0f, 0.0f);
        this.bootR.func_78784_a(24, 31).func_228303_a_(-3.0f, 8.0f, -3.0f, 6.0f, 5.0f, 6.0f, 0.0f, true);
        this.bootR.func_78784_a(24, 42).func_228303_a_(-3.0f, 6.0f, 2.0f, 6.0f, 2.0f, 1.0f, 0.0f, true);
        this.bootR.func_78784_a(24, 45).func_228303_a_(-3.0f, 6.0f, -1.0f, 1.0f, 2.0f, 3.0f, 0.0f, true);
        this.bootR.func_78784_a(24, 45).func_228303_a_(2.0f, 6.0f, -1.0f, 1.0f, 2.0f, 3.0f, 0.0f, true);
        this.bootR.func_78784_a(29, 45).func_228303_a_(-3.0f, 7.0f, -2.0f, 1.0f, 1.0f, 1.0f, 0.0f, true);
        this.bootR.func_78784_a(29, 45).func_228303_a_(2.0f, 7.0f, -2.0f, 1.0f, 1.0f, 1.0f, 0.0f, true);
        this.bootR.func_78784_a(24, 27).func_228303_a_(-2.0f, 10.0f, -4.0f, 4.0f, 3.0f, 1.0f, 0.0f, true);
        this.bootR.func_78784_a(21, 33).func_228303_a_(-1.0f, 9.0f, -4.0f, 2.0f, 1.0f, 1.0f, 0.0f, true);
    }

    public void func_225598_a_(MatrixStack ms, IVertexBuilder buffer, int light, int overlay, float r, float g, float b, float a) {
        this.head.field_78806_j = this.slot == EquipmentSlotType.HEAD;
        this.body.field_78806_j = this.slot == EquipmentSlotType.CHEST;
        this.leftArm.field_78806_j = this.slot == EquipmentSlotType.CHEST;
        this.rightArm.field_78806_j = this.slot == EquipmentSlotType.CHEST;
        this.leftLeg.field_78806_j = this.slot == EquipmentSlotType.LEGS;
        this.rightLeg.field_78806_j = this.slot == EquipmentSlotType.LEGS;
        this.bootL.field_78806_j = this.slot == EquipmentSlotType.FEET;
        this.bootR.field_78806_j = this.slot == EquipmentSlotType.FEET;
        this.field_178720_f.field_78806_j = false;
        this.field_78116_c = this.head;
        this.field_78115_e = this.body;
        this.field_178723_h = this.leftArm;
        this.field_178724_i = this.rightArm;
        if (this.slot == EquipmentSlotType.LEGS) {
            this.field_178721_j = this.leftLeg;
            this.field_178722_k = this.rightLeg;
        } else {
            this.field_178721_j = this.bootL;
            this.field_178722_k = this.bootR;
        }
        super.func_225598_a_(ms, buffer, light, overlay, r, g, b, a);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
