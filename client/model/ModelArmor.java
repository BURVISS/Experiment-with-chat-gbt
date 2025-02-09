/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.model.BipedModel
 *  net.minecraft.client.renderer.model.ModelRenderer
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.item.ArmorStandEntity
 *  net.minecraft.inventory.EquipmentSlotType
 */
package com.meteor.extrabotany.client.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.inventory.EquipmentSlotType;

public class ModelArmor
extends BipedModel<LivingEntity> {
    protected final EquipmentSlotType slot;

    public ModelArmor(EquipmentSlotType slot) {
        super(1.0f);
        this.slot = slot;
    }

    public void func_225597_a_(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!(entity instanceof ArmorStandEntity)) {
            super.func_225597_a_(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            return;
        }
        ArmorStandEntity entityIn = (ArmorStandEntity)entity;
        this.field_78116_c.field_78795_f = (float)Math.PI / 180 * entityIn.func_175418_s().func_179415_b();
        this.field_78116_c.field_78796_g = (float)Math.PI / 180 * entityIn.func_175418_s().func_179416_c();
        this.field_78116_c.field_78808_h = (float)Math.PI / 180 * entityIn.func_175418_s().func_179413_d();
        this.field_78116_c.func_78793_a(0.0f, 1.0f, 0.0f);
        this.field_78115_e.field_78795_f = (float)Math.PI / 180 * entityIn.func_175408_t().func_179415_b();
        this.field_78115_e.field_78796_g = (float)Math.PI / 180 * entityIn.func_175408_t().func_179416_c();
        this.field_78115_e.field_78808_h = (float)Math.PI / 180 * entityIn.func_175408_t().func_179413_d();
        this.field_178724_i.field_78795_f = (float)Math.PI / 180 * entityIn.func_175404_u().func_179415_b();
        this.field_178724_i.field_78796_g = (float)Math.PI / 180 * entityIn.func_175404_u().func_179416_c();
        this.field_178724_i.field_78808_h = (float)Math.PI / 180 * entityIn.func_175404_u().func_179413_d();
        this.field_178723_h.field_78795_f = (float)Math.PI / 180 * entityIn.func_175411_v().func_179415_b();
        this.field_178723_h.field_78796_g = (float)Math.PI / 180 * entityIn.func_175411_v().func_179416_c();
        this.field_178723_h.field_78808_h = (float)Math.PI / 180 * entityIn.func_175411_v().func_179413_d();
        this.field_178722_k.field_78795_f = (float)Math.PI / 180 * entityIn.func_175403_w().func_179415_b();
        this.field_178722_k.field_78796_g = (float)Math.PI / 180 * entityIn.func_175403_w().func_179416_c();
        this.field_178722_k.field_78808_h = (float)Math.PI / 180 * entityIn.func_175403_w().func_179413_d();
        this.field_178722_k.func_78793_a(1.9f, 11.0f, 0.0f);
        this.field_178721_j.field_78795_f = (float)Math.PI / 180 * entityIn.func_175407_x().func_179415_b();
        this.field_178721_j.field_78796_g = (float)Math.PI / 180 * entityIn.func_175407_x().func_179416_c();
        this.field_178721_j.field_78808_h = (float)Math.PI / 180 * entityIn.func_175407_x().func_179413_d();
        this.field_178721_j.func_78793_a(-1.9f, 11.0f, 0.0f);
        this.field_178720_f.func_217177_a(this.field_78116_c);
    }

    protected void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
