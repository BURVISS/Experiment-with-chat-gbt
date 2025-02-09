/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Multimap
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.IRenderTypeBuffer
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.IEntityRenderer
 *  net.minecraft.client.renderer.entity.model.BipedModel
 *  net.minecraft.client.renderer.entity.model.EntityModel
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.ai.attributes.Attribute
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  top.theillusivec4.curios.api.type.capability.ICurio
 */
package com.meteor.extrabotany.common.core;

import com.google.common.collect.Multimap;
import com.meteor.extrabotany.common.items.bauble.ItemBauble;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.theillusivec4.curios.api.type.capability.ICurio;

public static class CurioIntegration.Wrapper
implements ICurio {
    private final ItemStack stack;

    CurioIntegration.Wrapper(ItemStack stack) {
        this.stack = stack;
    }

    private ItemBauble getItem() {
        return (ItemBauble)this.stack.func_77973_b();
    }

    public void curioTick(String identifier, int index, LivingEntity entity) {
        this.getItem().onWornTick(this.stack, entity);
    }

    public void onEquip(String identifier, int index, LivingEntity entity) {
        this.getItem().onEquipped(this.stack, entity);
    }

    public void onUnequip(String identifier, int index, LivingEntity entity) {
        this.getItem().onUnequipped(this.stack, entity);
    }

    public boolean canEquip(String identifier, LivingEntity entity) {
        return this.getItem().canEquip(this.stack, entity);
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(String identifier) {
        return this.getItem().getEquippedAttributeModifiers(this.stack);
    }

    public boolean canSync(String identifier, int index, LivingEntity livingEntity) {
        return true;
    }

    public void playRightClickEquipSound(LivingEntity entity) {
    }

    public boolean canRightClickEquip() {
        return true;
    }

    public boolean canRender(String identifier, int index, LivingEntity entity) {
        return this.getItem().hasRender(this.stack, entity);
    }

    @OnlyIn(value=Dist.CLIENT)
    public void render(String identifier, int index, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int light, LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        EntityRenderer renderer = Minecraft.func_71410_x().func_175598_ae().func_78713_a((Entity)livingEntity);
        if (!(renderer instanceof IEntityRenderer)) {
            return;
        }
        EntityModel model = ((IEntityRenderer)renderer).func_217764_d();
        if (!(model instanceof BipedModel)) {
            return;
        }
        this.getItem().doRender((BipedModel)model, this.stack, livingEntity, matrixStack, renderTypeBuffer, light, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);
    }
}
