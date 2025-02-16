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

public class ModelShadowWarriorArmor
extends ModelArmor {
    private final ModelRenderer helmAnchor;
    private final ModelRenderer bodyAnchor;
    private final ModelRenderer body;
    private final ModelRenderer armLAnchor;
    private final ModelRenderer armRAnchor;
    private final ModelRenderer pantsAnchor;
    private final ModelRenderer legL;
    private final ModelRenderer legR;
    private final ModelRenderer bootL;
    private final ModelRenderer bootR;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer top;
    ModelRenderer back;
    ModelRenderer front1;
    ModelRenderer front2;
    ModelRenderer right2;
    ModelRenderer front;
    ModelRenderer right1;
    ModelRenderer medal;
    ModelRenderer right3;
    ModelRenderer left2;
    ModelRenderer left3;
    ModelRenderer left1;
    ModelRenderer a1;
    ModelRenderer a2;
    ModelRenderer a3;
    ModelRenderer b1;
    ModelRenderer b2;
    ModelRenderer b3;
    ModelRenderer c1;
    ModelRenderer c2;
    ModelRenderer c3;
    ModelRenderer d1;
    ModelRenderer d2;
    ModelRenderer d3;
    ModelRenderer e1;
    ModelRenderer e2;
    ModelRenderer e3;
    ModelRenderer f1;
    ModelRenderer f2;
    ModelRenderer f3;
    ModelRenderer fronter;
    ModelRenderer larm1;
    ModelRenderer book;
    ModelRenderer backer;
    ModelRenderer larm4;
    ModelRenderer larm3;
    ModelRenderer larm2;
    ModelRenderer rarm1;
    ModelRenderer rarm2;
    ModelRenderer rarm3;
    ModelRenderer rarm4;
    ModelRenderer boot1;
    ModelRenderer boot2;
    ModelRenderer fb1;
    ModelRenderer fb2;

    public ModelShadowWarriorArmor(EquipmentSlotType slot) {
        super(slot);
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        float s = 0.01f;
        this.helmAnchor = new ModelRenderer((Model)this, 0, 0);
        this.helmAnchor.func_78793_a(0.0f, 0.0f, 0.0f);
        this.helmAnchor.func_228301_a_(-1.0f, -2.0f, 0.0f, 2.0f, 2.0f, 2.0f, s);
        this.bodyAnchor = new ModelRenderer((Model)this, 0, 0);
        this.bodyAnchor.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bodyAnchor.func_228301_a_(-1.0f, 0.0f, -1.0f, 2.0f, 2.0f, 2.0f, s);
        this.body = new ModelRenderer((Model)this, 16, 16);
        this.body.func_228300_a_(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78787_b(64, 32);
        this.body.field_78809_i = true;
        this.setRotateAngle(this.body, 0.0f, 0.0f, 0.0f);
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
        this.legR = new ModelRenderer((Model)this, 0, 16);
        this.legR.func_228301_a_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, s);
        this.legR.func_78793_a(-2.0f, 12.0f, 0.0f);
        this.legR.func_78787_b(64, 32);
        this.legR.field_78809_i = true;
        this.setRotateAngle(this.legR, 0.0f, 0.0f, 0.0f);
        this.legL = new ModelRenderer((Model)this, 0, 16);
        this.legL.func_228301_a_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, s);
        this.legL.func_78793_a(2.0f, 12.0f, 0.0f);
        this.legL.func_78787_b(64, 32);
        this.legL.field_78809_i = true;
        this.setRotateAngle(this.legL, 0.0f, 0.0f, 0.0f);
        this.bootL = new ModelRenderer((Model)this, 0, 0);
        this.bootL.field_78809_i = true;
        this.bootL.func_78793_a(1.9f, 12.0f, 0.0f);
        this.bootL.func_228301_a_(-2.39f, 8.5f, -2.49f, 2.0f, 2.0f, 2.0f, s);
        this.bootR = new ModelRenderer((Model)this, 0, 0);
        this.bootR.func_78793_a(-2.0f, 12.0f, 0.0f);
        this.bootR.func_228301_a_(-2.5f, 8.5f, -2.51f, 2.0f, 2.0f, 2.0f, s);
        this.rightarm = new ModelRenderer((Model)this, 40, 16);
        this.rightarm.func_228300_a_(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        this.rightarm.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.rightarm.func_78787_b(64, 32);
        this.rightarm.field_78809_i = true;
        this.setRotateAngle(this.rightarm, 0.0f, 0.0f, 0.0f);
        this.leftarm = new ModelRenderer((Model)this, 40, 16);
        this.leftarm.func_228300_a_(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        this.leftarm.func_78793_a(5.0f, 2.0f, 0.0f);
        this.leftarm.func_78787_b(64, 32);
        this.leftarm.field_78809_i = true;
        this.setRotateAngle(this.leftarm, 0.0f, 0.0f, 0.0f);
        this.rightleg = new ModelRenderer((Model)this, 0, 16);
        this.rightleg.func_228300_a_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        this.rightleg.func_78793_a(-2.0f, 12.0f, 0.0f);
        this.rightleg.func_78787_b(64, 32);
        this.rightleg.field_78809_i = true;
        this.setRotateAngle(this.rightleg, 0.0f, 0.0f, 0.0f);
        this.leftleg = new ModelRenderer((Model)this, 0, 16);
        this.leftleg.func_228300_a_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        this.leftleg.func_78793_a(2.0f, 12.0f, 0.0f);
        this.leftleg.func_78787_b(64, 32);
        this.leftleg.field_78809_i = true;
        this.setRotateAngle(this.leftleg, 0.0f, 0.0f, 0.0f);
        this.top = new ModelRenderer((Model)this, 0, 33);
        this.top.func_228301_a_(0.0f, 0.0f, 0.0f, 9.0f, 3.0f, 9.0f, s);
        this.top.func_78793_a(-4.5f, -8.5f, -4.5f);
        this.top.func_78787_b(64, 32);
        this.top.field_78809_i = true;
        this.setRotateAngle(this.top, 0.0f, 0.0f, 0.0f);
        this.back = new ModelRenderer((Model)this, 37, 33);
        this.back.func_228300_a_(0.0f, 0.0f, 0.0f, 9.0f, 7.0f, 1.0f);
        this.back.func_78793_a(-4.5f, -8.0f, 3.0f);
        this.back.func_78787_b(64, 32);
        this.back.field_78809_i = true;
        this.setRotateAngle(this.back, 0.2617994f, 0.0f, 0.0f);
        this.front1 = new ModelRenderer((Model)this, 58, 33);
        this.front1.func_228300_a_(0.0f, 0.0f, 0.0f, 3.0f, 5.0f, 1.0f);
        this.front1.func_78793_a(-5.7f, -6.0f, -1.9f);
        this.front1.func_78787_b(64, 32);
        this.front1.field_78809_i = true;
        this.setRotateAngle(this.front1, 0.0f, 0.9948377f, 0.0f);
        this.front2 = new ModelRenderer((Model)this, 67, 33);
        this.front2.func_228300_a_(0.0f, 0.0f, 0.0f, 3.0f, 5.0f, 1.0f);
        this.front2.func_78793_a(3.7f, -6.0f, -4.5f);
        this.front2.func_78787_b(64, 32);
        this.front2.field_78809_i = true;
        this.setRotateAngle(this.front2, 0.0f, -0.9948377f, 0.0f);
        this.right2 = new ModelRenderer((Model)this, 76, 33);
        this.right2.func_228301_a_(0.0f, 0.0f, 0.0f, 1.0f, 6.0f, 9.0f, s);
        this.right2.func_78793_a(-4.0f, -8.0f, -4.5f);
        this.right2.func_78787_b(64, 32);
        this.right2.field_78809_i = true;
        this.setRotateAngle(this.right2, 0.0f, 0.0f, 0.3316126f);
        this.front = new ModelRenderer((Model)this, 97, 33);
        this.front.func_228301_a_(0.0f, 0.0f, 0.0f, 6.0f, 2.0f, 1.0f, s);
        this.front.func_78793_a(-3.0f, -8.0f, -5.1f);
        this.front.func_78787_b(64, 32);
        this.front.field_78809_i = true;
        this.setRotateAngle(this.front, 0.0f, 0.0f, 0.0f);
        this.right1 = new ModelRenderer((Model)this, 0, 50);
        this.right1.func_228301_a_(0.0f, 0.0f, 0.0f, 2.0f, 6.0f, 1.0f, s);
        this.right1.func_78793_a(-5.0f, -13.0f, -4.9f);
        this.right1.func_78787_b(64, 32);
        this.right1.field_78809_i = true;
        this.setRotateAngle(this.right1, 0.0872665f, 0.0872665f, -0.2617994f);
        this.medal = new ModelRenderer((Model)this, 7, 50);
        this.medal.func_228301_a_(0.0f, 0.0f, 0.0f, 2.0f, 4.0f, 1.0f, s);
        this.medal.func_78793_a(-1.0f, -11.5f, -5.0f);
        this.medal.func_78787_b(64, 32);
        this.medal.field_78809_i = true;
        this.setRotateAngle(this.medal, 0.0f, 0.0f, 0.0f);
        this.right3 = new ModelRenderer((Model)this, 14, 50);
        this.right3.func_228300_a_(0.0f, 0.0f, 0.0f, 3.0f, 4.0f, 1.0f);
        this.right3.func_78793_a(-7.0f, -7.2f, -4.3f);
        this.right3.func_78787_b(64, 32);
        this.right3.field_78809_i = true;
        this.setRotateAngle(this.right3, 0.0f, 0.0f, 0.3316126f);
        this.left2 = new ModelRenderer((Model)this, 23, 50);
        this.left2.func_228300_a_(0.0f, 0.0f, 0.0f, 1.0f, 6.0f, 9.0f);
        this.left2.func_78793_a(3.0f, -8.0f, -4.5f);
        this.left2.func_78787_b(64, 32);
        this.left2.field_78809_i = true;
        this.setRotateAngle(this.left2, 0.0f, 0.0f, -0.3316126f);
        this.left3 = new ModelRenderer((Model)this, 44, 50);
        this.left3.func_228300_a_(0.0f, 0.0f, 0.0f, 3.0f, 4.0f, 1.0f);
        this.left3.func_78793_a(3.7f, -6.5f, -4.3f);
        this.left3.func_78787_b(64, 32);
        this.left3.field_78809_i = true;
        this.setRotateAngle(this.left3, 0.0f, 0.0f, -0.3316126f);
        this.left1 = new ModelRenderer((Model)this, 53, 50);
        this.left1.func_228300_a_(0.0f, 0.0f, 0.0f, 2.0f, 6.0f, 1.0f);
        this.left1.func_78793_a(3.0f, -13.5f, -5.0f);
        this.left1.func_78787_b(64, 32);
        this.left1.field_78809_i = true;
        this.setRotateAngle(this.left1, 0.0872665f, -0.0872665f, 0.2617994f);
        this.a1 = new ModelRenderer((Model)this, 0, 67);
        this.a1.func_228300_a_(0.0f, 0.0f, 0.0f, 5.0f, 5.0f, 1.0f);
        this.a1.func_78793_a(-2.5f, 10.0f, -3.0f);
        this.a1.func_78787_b(64, 32);
        this.a1.field_78809_i = true;
        this.setRotateAngle(this.a1, -0.2792527f, 0.0f, 0.0f);
        this.a2 = new ModelRenderer((Model)this, 0, 67);
        this.a2.func_228300_a_(0.0f, 0.0f, 0.0f, 5.0f, 5.0f, 1.0f);
        this.a2.func_78793_a(-2.5f, 12.0f, -3.0f);
        this.a2.func_78787_b(64, 32);
        this.a2.field_78809_i = true;
        this.setRotateAngle(this.a2, -0.2792527f, 0.0f, 0.0f);
        this.a3 = new ModelRenderer((Model)this, 0, 67);
        this.a3.func_228300_a_(0.0f, 0.0f, 0.0f, 5.0f, 5.0f, 1.0f);
        this.a3.func_78793_a(-2.5f, 14.0f, -3.0f);
        this.a3.func_78787_b(64, 32);
        this.a3.field_78809_i = true;
        this.setRotateAngle(this.a3, -0.2792527f, 0.0f, 0.0f);
        this.b1 = new ModelRenderer((Model)this, 13, 67);
        this.b1.func_228300_a_(0.0f, 0.0f, 0.0f, 3.0f, 3.0f, 1.0f);
        this.b1.func_78793_a(-3.5f, -2.0f, -3.0f);
        this.b1.func_78787_b(64, 32);
        this.b1.field_78809_i = true;
        this.setRotateAngle(this.b1, -0.2617994f, 0.0f, 0.0f);
        this.b2 = new ModelRenderer((Model)this, 13, 67);
        this.b2.func_228300_a_(0.0f, 0.0f, 0.0f, 3.0f, 3.0f, 1.0f);
        this.b2.func_78793_a(-3.5f, 0.0f, -3.0f);
        this.b2.func_78787_b(64, 32);
        this.b2.field_78809_i = true;
        this.setRotateAngle(this.b2, -0.2617994f, 0.0f, 0.0f);
        this.b3 = new ModelRenderer((Model)this, 13, 67);
        this.b3.func_228300_a_(0.0f, 0.0f, 0.0f, 3.0f, 3.0f, 1.0f);
        this.b3.func_78793_a(-3.5f, 2.0f, -3.0f);
        this.b3.func_78787_b(64, 32);
        this.b3.field_78809_i = true;
        this.setRotateAngle(this.b3, -0.2617994f, 0.0f, 0.0f);
        this.c1 = new ModelRenderer((Model)this, 22, 67);
        this.c1.func_228300_a_(0.0f, 0.0f, 0.0f, 3.0f, 3.0f, 1.0f);
        this.c1.func_78793_a(0.5f, -2.0f, -3.0f);
        this.c1.func_78787_b(64, 32);
        this.c1.field_78809_i = true;
        this.setRotateAngle(this.c1, -0.2617994f, 0.0f, 0.0f);
        this.c2 = new ModelRenderer((Model)this, 22, 67);
        this.c2.func_228300_a_(0.0f, 0.0f, 0.0f, 3.0f, 3.0f, 1.0f);
        this.c2.func_78793_a(0.5f, 0.0f, -3.0f);
        this.c2.func_78787_b(64, 32);
        this.c2.field_78809_i = true;
        this.setRotateAngle(this.c2, -0.2617994f, 0.0f, 0.0f);
        this.c3 = new ModelRenderer((Model)this, 22, 67);
        this.c3.func_228300_a_(0.0f, 0.0f, 0.0f, 3.0f, 3.0f, 1.0f);
        this.c3.func_78793_a(0.5f, 2.0f, -3.0f);
        this.c3.func_78787_b(64, 32);
        this.c3.field_78809_i = true;
        this.setRotateAngle(this.c3, -0.2617994f, 0.0f, 0.0f);
        this.d1 = new ModelRenderer((Model)this, 0, 74);
        this.d1.func_228300_a_(0.0f, 0.0f, 0.0f, 1.0f, 5.0f, 4.0f);
        this.d1.func_78793_a(3.0f, 10.0f, -2.0f);
        this.d1.func_78787_b(64, 32);
        this.d1.field_78809_i = true;
        this.setRotateAngle(this.d1, 0.0f, 0.0f, -0.2617994f);
        this.d2 = new ModelRenderer((Model)this, 0, 74);
        this.d2.func_228300_a_(0.0f, 0.0f, 0.0f, 1.0f, 5.0f, 4.0f);
        this.d2.func_78793_a(3.0f, 12.0f, -2.0f);
        this.d2.func_78787_b(64, 32);
        this.d2.field_78809_i = true;
        this.setRotateAngle(this.d2, 0.0f, 0.0f, -0.2617994f);
        this.d3 = new ModelRenderer((Model)this, 0, 74);
        this.d3.func_228300_a_(0.0f, 0.0f, 0.0f, 1.0f, 5.0f, 4.0f);
        this.d3.func_78793_a(3.0f, 14.0f, -2.0f);
        this.d3.func_78787_b(64, 32);
        this.d3.field_78809_i = true;
        this.setRotateAngle(this.d3, 0.0f, 0.0f, -0.2617994f);
        this.e1 = new ModelRenderer((Model)this, 0, 74);
        this.e1.func_228300_a_(0.0f, 0.0f, 0.0f, 1.0f, 5.0f, 4.0f);
        this.e1.func_78793_a(-4.2f, 9.8f, -2.0f);
        this.e1.func_78787_b(64, 32);
        this.e1.field_78809_i = true;
        this.setRotateAngle(this.e1, 0.0f, 0.0f, 0.2617994f);
        this.e2 = new ModelRenderer((Model)this, 0, 74);
        this.e2.func_228300_a_(0.0f, 0.0f, 0.0f, 1.0f, 5.0f, 4.0f);
        this.e2.func_78793_a(-4.2f, 11.8f, -2.0f);
        this.e2.func_78787_b(64, 32);
        this.e2.field_78809_i = true;
        this.setRotateAngle(this.e2, 0.0f, 0.0f, 0.2617994f);
        this.e3 = new ModelRenderer((Model)this, 0, 74);
        this.e3.func_228300_a_(0.0f, 0.0f, 0.0f, 1.0f, 5.0f, 4.0f);
        this.e3.func_78793_a(-4.2f, 13.8f, -2.0f);
        this.e3.func_78787_b(64, 32);
        this.e3.field_78809_i = true;
        this.setRotateAngle(this.e3, 0.0f, 0.0f, 0.2617994f);
        this.f1 = new ModelRenderer((Model)this, 11, 74);
        this.f1.func_228300_a_(0.0f, 0.0f, 0.0f, 9.0f, 5.0f, 1.0f);
        this.f1.func_78793_a(-4.5f, 10.0f, 1.8f);
        this.f1.func_78787_b(64, 32);
        this.f1.field_78809_i = true;
        this.setRotateAngle(this.f1, 0.2617994f, 0.0f, 0.0f);
        this.f2 = new ModelRenderer((Model)this, 11, 74);
        this.f2.func_228300_a_(0.0f, 0.0f, 0.0f, 9.0f, 5.0f, 1.0f);
        this.f2.func_78793_a(-4.5f, 12.0f, 1.8f);
        this.f2.func_78787_b(64, 32);
        this.f2.field_78809_i = true;
        this.setRotateAngle(this.f2, 0.2617994f, 0.0f, 0.0f);
        this.f3 = new ModelRenderer((Model)this, 11, 74);
        this.f3.func_228300_a_(0.0f, 0.0f, 0.0f, 9.0f, 5.0f, 1.0f);
        this.f3.func_78793_a(-4.5f, 14.0f, 1.8f);
        this.f3.func_78787_b(64, 32);
        this.f3.field_78809_i = true;
        this.setRotateAngle(this.f3, 0.2617994f, 0.0f, 0.0f);
        this.fronter = new ModelRenderer((Model)this, 0, 84);
        this.fronter.func_228301_a_(0.0f, 0.0f, 0.0f, 6.0f, 7.0f, 1.0f, s);
        this.fronter.func_78793_a(-3.0f, 1.0f, -3.0f);
        this.fronter.func_78787_b(64, 32);
        this.fronter.field_78809_i = true;
        this.setRotateAngle(this.fronter, 0.0f, 0.0f, 0.0f);
        this.larm1 = new ModelRenderer((Model)this, 15, 84);
        this.larm1.func_228301_a_(0.0f, 0.0f, 0.0f, 5.0f, 2.0f, 5.0f, s);
        this.larm1.func_78793_a(-2.0f, -3.0f, -2.5f);
        this.larm1.func_78787_b(64, 32);
        this.larm1.field_78809_i = true;
        this.setRotateAngle(this.larm1, 0.0f, 0.0f, -0.1745329f);
        this.book = new ModelRenderer((Model)this, 0, 93);
        this.book.func_228301_a_(0.0f, 0.0f, 0.0f, 4.0f, 6.0f, 2.0f, s);
        this.book.func_78793_a(1.0f, 1.2f, 2.7f);
        this.book.func_78787_b(64, 32);
        this.book.field_78809_i = true;
        this.setRotateAngle(this.book, 0.0f, 0.0f, 0.7853982f);
        this.backer = new ModelRenderer((Model)this, 0, 102);
        this.backer.func_228301_a_(0.0f, 0.0f, 0.0f, 6.0f, 10.0f, 1.0f, s);
        this.backer.func_78793_a(-3.0f, 1.0f, 1.7f);
        this.backer.func_78787_b(64, 32);
        this.backer.field_78809_i = true;
        this.setRotateAngle(this.backer, 0.0f, 0.0f, 0.0f);
        this.larm4 = new ModelRenderer((Model)this, 36, 84);
        this.larm4.func_228301_a_(0.0f, 0.0f, 0.0f, 2.0f, 5.0f, 4.0f, 0.25f);
        this.larm4.func_78793_a(0.8f, 3.2f, -2.0f);
        this.larm4.func_78787_b(64, 32);
        this.larm4.field_78809_i = true;
        this.setRotateAngle(this.larm4, 0.0f, 0.0f, 0.0f);
        this.larm3 = new ModelRenderer((Model)this, 49, 84);
        this.larm3.func_228301_a_(0.0f, 0.0f, 0.0f, 1.0f, 6.0f, 4.0f, s);
        this.larm3.func_78793_a(1.7f, -1.0f, -2.0f);
        this.larm3.func_78787_b(64, 32);
        this.larm3.field_78809_i = true;
        this.setRotateAngle(this.larm3, 0.0f, 0.0f, -0.1745329f);
        this.larm2 = new ModelRenderer((Model)this, 60, 84);
        this.larm2.func_228301_a_(0.0f, 0.0f, 0.0f, 1.0f, 5.0f, 4.0f, s);
        this.larm2.func_78793_a(1.7f, -2.0f, -2.0f);
        this.larm2.func_78787_b(64, 32);
        this.larm2.field_78809_i = true;
        this.setRotateAngle(this.larm2, 0.0f, 0.0f, -0.3490659f);
        this.rarm1 = new ModelRenderer((Model)this, 15, 96);
        this.rarm1.func_228301_a_(0.0f, 0.0f, 0.0f, 5.0f, 2.0f, 5.0f, s);
        this.rarm1.func_78793_a(-3.0f, -4.0f, -2.5f);
        this.rarm1.func_78787_b(64, 32);
        this.rarm1.field_78809_i = true;
        this.setRotateAngle(this.rarm1, 0.0f, 0.0f, 0.1745329f);
        this.rarm2 = new ModelRenderer((Model)this, 36, 96);
        this.rarm2.func_228301_a_(0.0f, 0.0f, 0.0f, 1.0f, 5.0f, 4.0f, s);
        this.rarm2.func_78793_a(-2.7f, -2.0f, -2.0f);
        this.rarm2.func_78787_b(64, 32);
        this.rarm2.field_78809_i = true;
        this.setRotateAngle(this.rarm2, 0.0f, 0.0f, 0.3490659f);
        this.rarm3 = new ModelRenderer((Model)this, 47, 96);
        this.rarm3.func_228301_a_(0.0f, 0.0f, 0.0f, 1.0f, 6.0f, 4.0f, s);
        this.rarm3.func_78793_a(-2.7f, -1.0f, -2.0f);
        this.rarm3.func_78787_b(64, 32);
        this.rarm3.field_78809_i = true;
        this.setRotateAngle(this.rarm3, 0.0f, 0.0f, 0.1745329f);
        this.rarm4 = new ModelRenderer((Model)this, 58, 96);
        this.rarm4.func_228301_a_(0.0f, 0.0f, 0.0f, 2.0f, 5.0f, 4.0f, 0.25f);
        this.rarm4.func_78793_a(-2.8f, 3.2f, -2.0f);
        this.rarm4.func_78787_b(64, 32);
        this.rarm4.field_78809_i = true;
        this.setRotateAngle(this.rarm4, 0.0f, 0.0f, 0.0f);
        this.boot1 = new ModelRenderer((Model)this, 0, 114);
        this.boot1.func_228301_a_(0.0f, 0.0f, 0.0f, 4.0f, 4.0f, 5.0f, s);
        this.boot1.func_78793_a(-2.0f, 8.0f, -2.5f);
        this.boot1.func_78787_b(128, 128);
        this.boot1.field_78809_i = true;
        this.setRotateAngle(this.boot1, 0.0f, 0.0f, 0.0f);
        this.boot2 = new ModelRenderer((Model)this, 0, 114);
        this.boot2.func_228301_a_(0.0f, 0.0f, 0.0f, 4.0f, 4.0f, 5.0f, s);
        this.boot2.func_78793_a(-2.0f, 8.0f, -2.5f);
        this.boot2.func_78787_b(128, 128);
        this.boot2.field_78809_i = true;
        this.setRotateAngle(this.boot2, 0.0f, 0.0f, 0.0f);
        this.fb1 = new ModelRenderer((Model)this, 19, 114);
        this.fb1.func_228301_a_(0.0f, 0.0f, 0.0f, 3.0f, 3.0f, 1.0f, s);
        this.fb1.func_78793_a(-1.0f, 9.0f, -3.0f);
        this.fb1.func_78787_b(128, 128);
        this.fb1.field_78809_i = true;
        this.setRotateAngle(this.fb1, 0.0f, 0.0f, 0.0f);
        this.fb2 = new ModelRenderer((Model)this, 19, 114);
        this.fb2.func_228301_a_(0.0f, 0.0f, 0.0f, 3.0f, 3.0f, 1.0f, s);
        this.fb2.func_78793_a(-2.0f, 9.0f, -3.0f);
        this.fb2.func_78787_b(128, 128);
        this.fb2.field_78809_i = true;
        this.setRotateAngle(this.fb2, 0.0f, 0.0f, 0.0f);
        this.helmAnchor.func_78792_a(this.top);
        this.helmAnchor.func_78792_a(this.back);
        this.helmAnchor.func_78792_a(this.front1);
        this.helmAnchor.func_78792_a(this.front2);
        this.helmAnchor.func_78792_a(this.right1);
        this.helmAnchor.func_78792_a(this.right2);
        this.helmAnchor.func_78792_a(this.right3);
        this.helmAnchor.func_78792_a(this.left1);
        this.helmAnchor.func_78792_a(this.left2);
        this.helmAnchor.func_78792_a(this.left3);
        this.helmAnchor.func_78792_a(this.medal);
        this.helmAnchor.func_78792_a(this.front);
        this.bodyAnchor.func_78792_a(this.body);
        this.body.func_78792_a(this.fronter);
        this.body.func_78792_a(this.backer);
        this.body.func_78792_a(this.book);
        this.armLAnchor.func_78792_a(this.larm1);
        this.armLAnchor.func_78792_a(this.larm2);
        this.armLAnchor.func_78792_a(this.larm3);
        this.armLAnchor.func_78792_a(this.larm4);
        this.armRAnchor.func_78792_a(this.rarm1);
        this.armRAnchor.func_78792_a(this.rarm2);
        this.armRAnchor.func_78792_a(this.rarm3);
        this.armRAnchor.func_78792_a(this.rarm4);
        this.pantsAnchor.func_78792_a(this.f1);
        this.pantsAnchor.func_78792_a(this.f2);
        this.pantsAnchor.func_78792_a(this.f3);
        this.pantsAnchor.func_78792_a(this.d1);
        this.pantsAnchor.func_78792_a(this.d2);
        this.pantsAnchor.func_78792_a(this.d3);
        this.pantsAnchor.func_78792_a(this.e1);
        this.pantsAnchor.func_78792_a(this.e2);
        this.pantsAnchor.func_78792_a(this.e3);
        this.pantsAnchor.func_78792_a(this.a1);
        this.pantsAnchor.func_78792_a(this.a2);
        this.pantsAnchor.func_78792_a(this.a3);
        this.legR.func_78792_a(this.b1);
        this.legR.func_78792_a(this.b2);
        this.legR.func_78792_a(this.b3);
        this.legL.func_78792_a(this.c1);
        this.legL.func_78792_a(this.c2);
        this.legL.func_78792_a(this.c3);
        this.bootL.func_78792_a(this.boot2);
        this.bootL.func_78792_a(this.fb2);
        this.bootR.func_78792_a(this.boot1);
        this.bootR.func_78792_a(this.fb1);
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
